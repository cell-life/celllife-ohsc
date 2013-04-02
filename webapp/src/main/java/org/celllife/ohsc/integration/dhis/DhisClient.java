package org.celllife.ohsc.integration.dhis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 17h33
 */
@Component
public final class DhisClient {

    @Autowired
    private HttpClient dhisHttpClient;

    @Autowired
    private Header dhisAuthenticationHeader;

    @Autowired
    private ObjectMapper objectMapper;

    public String getString(String url) {
        return get(url);
    }

    public Map<String, ?> getMap(String url) {
        String json = getString(url);

        return toJsonMap(json);
    }

    private Map<String, ?> toJsonMap(String json)  {

        try {
            return objectMapper.reader(Map.class).readValue(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String url) {

        HttpGet method = newHttpGetMethod(url);

        HttpResponse response = execute(method);
        if (response == null) {
            return null;
        }

        HttpEntity responseEntity = response.getEntity();
        if (responseEntity == null) {
            return null;
        }

        return toString(responseEntity);

    }

    private HttpGet newHttpGetMethod(String url) {
        HttpGet method = new HttpGet(url);
        method.addHeader(dhisAuthenticationHeader);
        method.addHeader("Accept", "application/json");

        HttpConnectionParams.setConnectionTimeout(method.getParams(), 10000);
        HttpConnectionParams.setSoTimeout(method.getParams(), 10000);

        return method;
    }

    private String toString(HttpEntity responseEntity)  {
        try {
            return EntityUtils.toString(responseEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpResponse execute(HttpGet method)  {
        try {
            return dhisHttpClient.execute(method, (HttpContext) null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
