package org.celllife.ohsc.integration.cqm;

import junit.framework.Assert;
import org.celllife.ohsc.test.TestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-16
 * Time: 09h09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class CqmUssdSubmissionMediatorIntegrationTest {

    public static final int MAX = 10000;

    @Autowired
    private CqmUssdSubmissionMediator cqmUssdSubmissionMediator;

    @Autowired
    private RandomClinicRatingDataGenerator randomClinicRatingDataGenerator;

    private ThreadPoolExecutor threadPoolExecutor;

    @Before
    public void setUp() throws Exception {

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(MAX);

        threadPoolExecutor = new ThreadPoolExecutor(20, 20, 1000L, TimeUnit.SECONDS, workQueue);
    }

    @Test
    public void testHandleCqmUssdSubmission() throws Exception {

        String json = randomClinicRatingDataGenerator.getNextRandomJson();

        System.out.println(json);

        final GenericMessage<byte[]> input = new GenericMessage<>(json.getBytes());

        Message<String> result = cqmUssdSubmissionMediator.handleCqmUssdSubmission(input);
        Assert.assertEquals(CqmUssdSubmissionMediator.HAPPY_RESULT, result.getPayload());
    }

    @Test
    public void testHandleCqmUssdSubmissionLoad() throws Exception {

        long start = System.currentTimeMillis();

        for (int i = 0; i < MAX; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        String json = randomClinicRatingDataGenerator.getNextRandomJson();

                        GenericMessage<byte[]> message = new GenericMessage<>(json.getBytes());

                        Message<String> result = cqmUssdSubmissionMediator.handleCqmUssdSubmission(message);

                        Assert.assertEquals(CqmUssdSubmissionMediator.HAPPY_RESULT, result.getPayload());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        while (threadPoolExecutor.getActiveCount() != 0) {
            Thread.sleep(1000L);
        }

        long stop = System.currentTimeMillis();

        System.out.println((stop - start));
    }

}
