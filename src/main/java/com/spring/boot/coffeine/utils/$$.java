package com.spring.boot.coffeine.utils;

import com.google.gson.JsonObject;
import com.spring.boot.coffeine.constant.ErrorCode;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class $$ {
    private static final Logger LOGGER = LoggerFactory.getLogger($$.class);

    public static HttpResponse post(HttpRequest httpRequest) {

        Log.write(LOGGER, "HTTP", "REQUEST HEADER", httpRequest.headers.toString());
        Log.write(LOGGER, "HTTP", "REQUEST DATA", httpRequest.data);
        Log.write(LOGGER, "HTTP", "REQUEST END POINT", httpRequest.url);

        HttpResponse response = new HttpResponse();
        try {
            HttpPost post = new HttpPost(httpRequest.url);
            Headers headers = httpRequest.headers;
            headers.getHeaders().forEach((k, v) -> post.addHeader(k, v));

            StringEntity entity = new StringEntity(httpRequest.data);
            post.setEntity(entity);
            HttpClient httpClient = HttpClientBuilder.create().build();
            org.apache.http.HttpResponse httpResponse = httpClient.execute(post);


            byte[] bytes = IOUtils.toByteArray(httpResponse.getEntity().getContent());
            String responseStr = new String(bytes, "UTF-8");

            response.status = httpResponse.getStatusLine().getStatusCode();
            response.data = responseStr;

            Log.write(LOGGER, "HTTP", "RESPONSE DATA", responseStr);
            Log.write(LOGGER, "HTTP", "RESPONSE STATUS", String.valueOf(httpResponse.getStatusLine().getStatusCode()));

        } catch (IOException e) {
            response.status = 500;

            JsonObject xxx = new JsonObject();

            xxx.addProperty("code", 404);
            xxx.addProperty("message", ErrorCode.SERVICE_MAINTENANCE.getMessage());
            response.data = xxx.toString();
        } catch (Exception e) {
            response.status = 500;
            JsonObject xxx = new JsonObject();

            xxx.addProperty("code", 500);
            xxx.addProperty("message",  ErrorCode.SYSTEM_ERROR.getMessage());
            response.data = xxx.toString();
        }
        return response;
    }

    public static HttpResponse get(HttpRequest httpRequest) {
        return null;
    }

}
