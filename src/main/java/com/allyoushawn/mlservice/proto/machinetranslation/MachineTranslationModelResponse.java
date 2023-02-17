package com.allyoushawn.mlservice.proto.machinetranslation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MachineTranslationModelResponse {
    @JsonProperty("word_num")
    private String wordNum;
    @JsonProperty("translated_text")
    private String translatedText;
}
