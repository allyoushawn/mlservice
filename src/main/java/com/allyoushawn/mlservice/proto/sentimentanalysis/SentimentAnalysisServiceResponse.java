package com.allyoushawn.mlservice.proto.sentimentanalysis;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SentimentAnalysisServiceResponse {
    @JsonProperty("request")
    private SentimentAnalysisModelRequest request;
    @JsonProperty("response")
    private SentimentAnalysisModelResponse response;
}
