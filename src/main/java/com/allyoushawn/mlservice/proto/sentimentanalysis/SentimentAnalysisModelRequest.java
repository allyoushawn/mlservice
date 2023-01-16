package com.allyoushawn.mlservice.proto.sentimentanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SentimentAnalysisModelRequest {
    @JsonProperty("text")
    private String text;
}
