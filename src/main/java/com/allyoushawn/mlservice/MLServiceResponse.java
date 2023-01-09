package com.allyoushawn.mlservice;
import lombok.Data;
@Data
public class MLServiceResponse {
    private String status;
    private String requestId;
    private String content;

    MLServiceResponse(String status, String requestId, String content){
        this.status = status;
        this.requestId = requestId;
        this.content = content;
    }

    //@Override
    //public String toString() {
    //    return "Response{" + "status=" + this.status + ", requestId='" + this.requestId + '\'' + ", content='" + this.content + '\'' + '}';
    //}
}
