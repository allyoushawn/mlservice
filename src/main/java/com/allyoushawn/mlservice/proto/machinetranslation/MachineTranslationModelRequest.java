package com.allyoushawn.mlservice.proto.machinetranslation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MachineTranslationModelRequest {
    @JsonProperty("text")
    private String text;
}
