package org.celllife.ohsc.integration.cqm;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.language.LanguageRepository;
import org.celllife.ohsc.domain.mno.MobileNetworkOperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 22h02
 */
@Component
public class RandomClinicRatingDataGenerator {

    private final Random random = new Random();

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private MobileNetworkOperatorRepository mobileNetworkOperatorRepository;

    private Configuration configuration;

    private List<String> languageCodes;

    private List<String> clinicCodes;

    private List<String> mobileNetworkOperatorCodes;

    public String getNextRandomJson(int i) {

        Template template = newTemplate("rating.ftl");

        Writer out = new StringWriter();
        try {
            template.process(getNextRandomModel(i), out);
            out.flush();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }

        return out.toString();
    }

    private Template newTemplate(String templateFilename) {

        Configuration configuration = getConfiguration();

        try {
            return configuration.getTemplate(templateFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized Configuration getConfiguration() {

        if (configuration == null) {
            configuration = new Configuration();

            try {
                configuration.setDirectoryForTemplateLoading(new File(getClass().getResource("/ftl").toURI()));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }

            configuration.setObjectWrapper(new DefaultObjectWrapper());
        }

        return configuration;
    }

    public Map<String, String> getNextRandomModel(int i) {

        HashMap<String, String> model = new HashMap<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        model.put("ussdSessionId", String.format("%d", i));
        model.put("startDateTime", simpleDateFormat.format(new Date()));
        model.put("endDateTime", simpleDateFormat.format(new Date()));
        model.put("msisdn", getRandomMsisdn());
        model.put("mno", getRandomMobileNetworkOperatorCode());
        model.put("clinicCode", getRandomClinicCode());
        model.put("languageCode", getRandomLanguageCode());
        model.put("domainRating1", getRandomRating());
        model.put("domainRating2", getRandomRating());
        model.put("domainRating3", getRandomRating());
        model.put("domainRating4", getRandomRating());
        model.put("domainRating5", getRandomRating());
        model.put("domainRating6", getRandomRating());

        return model;
    }

    private String getRandomMsisdn() {

        int randomSuffix = random.nextInt(10000);

        return "+2772123" + String.format("%04d", randomSuffix);
    }

    private String getRandomRating() {
        return Integer.toString(random.nextInt(4) + 1);
    }

    public String getRandomLanguageCode() {

        if (languageCodes == null) {
            languageCodes = languageRepository.findAllCodes();
        }

        int randomIndex = random.nextInt(languageCodes.size());

        return languageCodes.get(randomIndex);
    }

    public String getRandomClinicCode() {

        if (clinicCodes == null) {
            clinicCodes = clinicRepository.findAllCodes();
        }

        int randomIndex = random.nextInt(clinicCodes.size());

        return clinicCodes.get(randomIndex);
    }

    public String getRandomMobileNetworkOperatorCode() {

        if (mobileNetworkOperatorCodes == null) {
            mobileNetworkOperatorCodes = mobileNetworkOperatorRepository.findAllCodes();
        }

        int randomIndex = random.nextInt(mobileNetworkOperatorCodes.size());

        return mobileNetworkOperatorCodes.get(randomIndex);
    }
}
