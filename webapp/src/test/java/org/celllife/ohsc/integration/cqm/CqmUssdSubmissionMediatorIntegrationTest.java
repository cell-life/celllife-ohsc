package org.celllife.ohsc.integration.cqm;

import junit.framework.Assert;
import org.apache.commons.io.IOUtils;
import org.celllife.ohsc.test.TestConfiguration;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileWriter;
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

    public static final String BASE_DIR = "/data/CqmUssdSubmissionRequest/";

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
    @Ignore("Used for generating test data")
    public void testGenerateCqmUssdSubmissions() throws Exception {

        String path = getClass().getResource(BASE_DIR).getPath();

        for (int i = 0; i < MAX; i++) {

            String nextRandomJson = randomClinicRatingDataGenerator.getNextRandomJson(i);

            String fileName = path + String.format("/%04d.json", i);
            FileWriter fileWriter = new FileWriter(fileName);
            IOUtils.write(nextRandomJson, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        }
    }

    @Test
    public void testHandleCqmUssdSubmission() throws Exception {

        String json = randomClinicRatingDataGenerator.getNextRandomJson(1);

        System.out.println(json);

        final GenericMessage<byte[]> input = new GenericMessage<>(json.getBytes());

        Message<String> result = cqmUssdSubmissionMediator.handleCqmUssdSubmission(input);
        Assert.assertEquals(CqmUssdSubmissionMediator.HAPPY_RESULT, result.getPayload());
    }

    @Test
    public void testHandleCqmUssdSubmissionLoad() throws Exception {

        long start = System.currentTimeMillis();

        for (int i = 0; i < MAX; i++) {

            final int ussdSessionId = i;

            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        String json = randomClinicRatingDataGenerator.getNextRandomJson(ussdSessionId);

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
