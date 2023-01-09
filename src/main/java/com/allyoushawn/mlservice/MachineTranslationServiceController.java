package com.allyoushawn.mlservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MachineTranslationServiceController {
    private static final Logger log = LoggerFactory.getLogger(MachineTranslationServiceController.class);
    @PostMapping("/machineTranslation")
    MLServiceResponse processMachineTranslationRequest(@RequestBody MLServiceRequest request){
        log.info("In processMachineTranslationRequest");
        return new MLServiceResponse("200", request.getRequestId(), request.getContent());
    }
}
