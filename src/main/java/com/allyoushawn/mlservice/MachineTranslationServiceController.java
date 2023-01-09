package com.allyoushawn.mlservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.entity.StringEntity;

@RestController
public class MachineTranslationServiceController {
    private static final Logger log = LoggerFactory.getLogger(MachineTranslationServiceController.class);
    private static final String POST_URL = "http://127.0.0.1:4460/sentiment_analysis";
    @PostMapping("/machineTranslation")
    MLServiceResponse processMachineTranslationRequest(@RequestBody MLServiceRequest request) throws IOException {
        log.info("In processMachineTranslationRequest");

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(POST_URL);
        httpPost.addHeader("Content-Type", "application/json");

        StringBuilder json = new StringBuilder();
        json.append("{\"text\":\"This is very good.\"}");

        httpPost.setEntity(new StringEntity(json.toString()));

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        System.out.println("POST Response Status:: "
                + httpResponse.getStatusLine().getStatusCode());

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // print result
        System.out.println(response.toString());
        httpClient.close();

        return new MLServiceResponse("200", request.getRequestId(), response.toString());
    }
}
