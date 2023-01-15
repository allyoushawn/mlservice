package com.allyoushawn.mlservice.proto.sentimentanalysis;
import lombok.Data;

@Data
public class SentimentAnalysisServiceResponse {
    private SentimentAnalysisModelRequest request;
    private SentimentAnalysisModelResponse response;
}
