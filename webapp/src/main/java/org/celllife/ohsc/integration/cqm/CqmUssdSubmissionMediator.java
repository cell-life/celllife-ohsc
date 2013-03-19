package org.celllife.ohsc.integration.cqm;

import org.celllife.ohsc.application.rating.RatingApplicationService;
import org.celllife.ohsc.domain.rating.Rating;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringSource;
import org.milyn.persistence.util.PersistenceUtil;
import org.milyn.scribe.register.DaoRegister;
import org.milyn.validation.OnFailResult;
import org.milyn.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 21h06
 */
@Service("cqmUssdSubmissionMediator")
public final class CqmUssdSubmissionMediator {

    public static final String HAPPY_RESULT = "{ \"CqmUssdSubmissionResponse\": { \"message\": \"Completed Successfully\" } }";

    public static final String SAD_RESULT = "{ \"CqmUssdSubmissionResponse\": { \"message\": \"Something broke\" } }";

    @Autowired
    private RatingApplicationService ratingApplicationService;

    @Autowired
    private Smooks cqmSmooks;

    @Autowired
    private DaoRegister springRepositoryRegister;

    public Message<String> handleCqmUssdSubmission(Message<byte[]> message) {

        //Get the data to filter
        StringSource source = new StringSource(new String(message.getPayload()));

        //Create the JavaResult, which will contain the filter result after filtering
        JavaResult result = new JavaResult();

        ValidationResult validationResult = new ValidationResult();

        ExecutionContext executionContext = cqmSmooks.createExecutionContext();

        PersistenceUtil.setDAORegister(executionContext, springRepositoryRegister);

        //Filter the data from the source, putting the result into the JavaResult
        this.cqmSmooks.filterSource(executionContext, source, result, validationResult);

        List<OnFailResult> errors = validationResult.getErrors();
        if (errors != null && !errors.isEmpty()) {
            for (OnFailResult error : errors) {
                System.out.println(error);
            }
            return new GenericMessage<String>(SAD_RESULT);
        }

        List<OnFailResult> warnings = validationResult.getWarnings();
        if (warnings != null && !warnings.isEmpty()) {
            for (OnFailResult warning : warnings) {
                System.out.println(warning);
            }
            return new GenericMessage<String>(SAD_RESULT);
        }

        ratingApplicationService.save(result.getBean(Rating.class));

        return new GenericMessage<String>(HAPPY_RESULT);
    }

}
