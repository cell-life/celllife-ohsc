package org.celllife.ohsc.integration.cqm;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-16
 * Time: 09h09
 */
public class CqmUssdSubmissionMediatorAcceptanceTest {

    public static final String BASE_DIR = "/data/CqmUssdSubmissionRequest/";

    @Test
//    @Ignore("Used for generating test data")
    public void testHandleCqmUssdSubmissionLoad() throws Exception {

        String path = getClass().getResource(BASE_DIR).getPath();

        File baseDir = new File(path);

        for (File file : baseDir.listFiles()) {
            post(IOUtils.toString(new FileInputStream(file)));
        }
    }

    private static void post(String json) throws Exception {

        HttpPost method = new HttpPost("http://localhost:9000/services/cqmUssdSubmission");
        HttpParams params = method.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpConnectionParams.setSoTimeout(params, 10000);

        method.setEntity(new StringEntity(json));
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user@test.cell-life.org", "P@ssw0rd1");
        Header authenticate = BasicScheme.authenticate(credentials, "US-ASCII", false);
        method.addHeader(authenticate);
        method.addHeader(new BasicHeader("Content-Type", "application/json"));

        DefaultHttpClient client = new DefaultHttpClient();

        client.execute(method, (HttpContext) null);
    }
}
