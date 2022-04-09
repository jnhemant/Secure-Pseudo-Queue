package com.pseudo.queue.external.module.Service;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ExternalModuleService {

    @Value("${jasypt.password}")
    private String jasyptPassword;

    @Value("${internal.module.url}")
    private String receiverUrl;

    public boolean registerTransaction(String body){
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(jasyptPassword);

        String encryptedBody = basicTextEncryptor.encrypt(body);
        String decryptedBody = basicTextEncryptor.decrypt(encryptedBody);

        System.out.println(encryptedBody);
        System.out.println(decryptedBody);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseMap;
        responseMap = restTemplate.postForEntity(receiverUrl, encryptedBody, Map.class);
        return true;
    }
}
