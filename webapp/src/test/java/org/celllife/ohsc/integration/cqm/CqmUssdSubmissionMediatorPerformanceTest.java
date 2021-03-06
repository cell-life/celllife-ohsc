package org.celllife.ohsc.integration.cqm;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.junit.Ignore;
import org.junit.Test;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-16
 * Time: 09h09
 */
public class CqmUssdSubmissionMediatorPerformanceTest {

    public static final String BASE_DIR = "/data/CqmUssdSubmissionRequest/";

    @Test
    @Ignore("Integration test")
    public void testHandleCqmUssdSubmissionLoad() throws Exception {

        String path = getClass().getResource(BASE_DIR).getPath();

        File baseDir = new File(path);

        for (File file : baseDir.listFiles()) {
            post(IOUtils.toString(new FileInputStream(file)));
        }
    }

    private static void post(String json) throws Exception {

        HttpPost method = new HttpPost("http://localhost:9000/ohsc/service/cqmUssdSubmission");
        HttpParams params = method.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpConnectionParams.setSoTimeout(params, 10000);

        method.setEntity(new StringEntity(json));
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("internal", "password");
        Header authenticate = BasicScheme.authenticate(credentials, "US-ASCII", false);
        method.addHeader(authenticate);
        method.addHeader(new BasicHeader("Content-Type", "application/json"));

        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse httpResponse = client.execute(method, (HttpContext) null);
        System.out.println();
    }
}
