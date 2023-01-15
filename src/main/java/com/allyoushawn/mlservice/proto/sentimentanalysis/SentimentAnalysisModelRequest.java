package com.allyoushawn.mlservice.proto.sentimentanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SentimentAnalysisModelRequest {
    private String text;

    private SentimentAnalysisModelRequest(@JsonProperty("text") String text){
        // For mapper of SentimentAnalysisController to parse the response from sentiment analysis model service
        this.text = text;
    }
}
