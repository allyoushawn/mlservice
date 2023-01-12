package com.allyoushawn.mlservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;

@RestController
public class SentimentAnalysisServiceController {
    private static final Logger log = LoggerFactory.getLogger(SentimentAnalysisServiceController.class);
    private static final String POST_URL = "http://127.0.0.1:4460/sentiment_analysis";
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    @PostMapping("/sentimentAnalysis")
    MLServiceResponse processSentimentAnalysisRequest(@RequestBody MLServiceRequest request) throws IOException {
        log.info("In processSentimentAnalysisRequest");

        HttpPost httpPost = new HttpPost(POST_URL);
        httpPost.addHeader("Content-Type", "application/json");
        String text = request.getContent();

        StringBuilder json = new StringBuilder();
        json.append("{\"text\":\"");
        json.append(text);
        json.append("\"}");

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

        return new MLServiceResponse("200", request.getRequestId(), response.toString());
    }
}
