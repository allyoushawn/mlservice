package com.allyoushawn.mlservice.proto.sentimentanalysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SentimentAnalysisModelResponse {
    @JsonProperty("word_num")
    private String wordNum;
    @JsonProperty("sentiment_score")
    private String sentimentScore;
}
