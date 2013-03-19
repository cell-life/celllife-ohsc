package org.celllife.ohsc.framework;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.milyn.Smooks;
import org.milyn.payload.StringResult;
import org.milyn.payload.StringSource;

import java.io.InputStream;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 18h56
 */
public class SmooksIntegrationTest {

    @Test
    public void testTransform() throws Exception {

        InputStream inputStream = getClass().getResourceAsStream("/data/CqmUssdSubmissionRequest/0001.json");
        String json = IOUtils.toString(inputStream);

        //Get the data to filter
        StringSource source = new StringSource(json);

        //Create a Smooks instance (cachable)
        Smooks smooks = new Smooks(getClass().getResourceAsStream("/META-INF/smooks/smooks-config.xml"));

        //Create the JavaResult, which will contain the filter result after filtering
        StringResult result = new StringResult();

        //Filter the data from the source, putting the result into the JavaResult
        smooks.filterSource(source, result);

        System.out.println(result.toString());


    }
}
