package com.allyoushawn.mlservice;

import com.allyoushawn.mlservice.proto.sentimentanalysis.SentimentAnalysisServiceResponse;
import com.allyoushawn.mlservice.proto.machinetranslation.MachineTranslationServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;

@RestController
public class MLServiceController {
    private static final Logger log = LoggerFactory.getLogger(MLServiceController.class);

    @Value("${sentiment_analysis_post_url}")
    private String SENTIMENT_ANALYSIS_POST_URL;
    @Value("${machine_translation_post_url}")
    private String MACHINE_TRANSLATION_POST_URL;
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/machineTranslation")
    MLServiceResponse processMachineTranslationRequest(@RequestBody MLServiceRequest request) throws IOException {
        log.info("In processMachineTranslationRequest");
        log.info("POST_URL: " + MACHINE_TRANSLATION_POST_URL);

        HttpPost httpPost = new HttpPost(MACHINE_TRANSLATION_POST_URL);
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
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("responseString: " + responseString);
        MachineTranslationServiceResponse response = mapper.readValue(responseString, MachineTranslationServiceResponse.class);
        System.out.println(response);

        return new MLServiceResponse("200", request.getRequestId(), response.getResponse().getTranslatedText());
    }
    @PostMapping("/sentimentAnalysis")
    MLServiceResponse processSentimentAnalysisRequest(@RequestBody MLServiceRequest request) throws IOException {
        log.info("In processSentimentAnalysisRequest");
        log.info("POST_URL: " + SENTIMENT_ANALYSIS_POST_URL);

        HttpPost httpPost = new HttpPost(SENTIMENT_ANALYSIS_POST_URL);
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
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("responseString: " + responseString);
        SentimentAnalysisServiceResponse response = mapper.readValue(responseString, SentimentAnalysisServiceResponse.class);
        System.out.println(response);

        return new MLServiceResponse("200", request.getRequestId(), response.getResponse().getSentimentScore());
    }
}
