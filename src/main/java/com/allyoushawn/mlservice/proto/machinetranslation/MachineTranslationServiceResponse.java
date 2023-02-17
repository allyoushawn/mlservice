package com.allyoushawn.mlservice.proto.machinetranslation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MachineTranslationServiceResponse {
    @JsonProperty("request")
    private MachineTranslationModelRequest request;
    @JsonProperty("response")
    private MachineTranslationModelResponse response;
}
