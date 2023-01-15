package com.allyoushawn.mlservice;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class MLServiceResponse {
    private String status;
    private String requestId;
    private String content;
    MLServiceResponse(@JsonProperty("status")String status, @JsonProperty("requestId")String requestId, @JsonProperty("content")String content){
        this.status = status;
        this.requestId = requestId;
        this.content = content;
    }

    //@Override
    //public String toString() {
    //    return "Response{" + "status=" + this.status + ", requestId='" + this.requestId + '\'' + ", content='" + this.content + '\'' + '}';
    //}
}
