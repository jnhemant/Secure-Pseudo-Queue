package com.pseudo.queue.external.module.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pseudo.queue.external.module.Model.TransactionData;
import com.pseudo.queue.external.module.Rest.Request.DataRequest;
import com.pseudo.queue.external.module.Service.ExternalModuleService;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pseudo-queue")
public class SenderController {

    @Autowired
    private ExternalModuleService externalModuleService;

    @PostMapping
    public Map<String, Object> readExternalData(@RequestBody DataRequest dataRequest) throws JsonProcessingException {
        TransactionData transactionData = new TransactionData();
        BeanUtils.copyProperties(dataRequest,transactionData);
        JSONObject jsonObject = new JSONObject(transactionData);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String transactionDataString = objectMapper.writeValueAsString(transactionData);
//        System.out.println(transactionDataString);
        System.out.println(jsonObject.toString());

        boolean successStatus = externalModuleService.registerTransaction(jsonObject.toString());
        Map<String, Object> response = new HashMap<>();
        if(successStatus){
            response.put("success", "true");
        }
        else{
            response.put("success", "false");
        }
        return response;
    }
}
