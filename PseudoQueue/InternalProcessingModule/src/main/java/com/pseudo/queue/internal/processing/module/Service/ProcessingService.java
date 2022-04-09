package com.pseudo.queue.internal.processing.module.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pseudo.queue.internal.processing.module.Dao.TransactionDao;
import com.pseudo.queue.internal.processing.module.Model.TransactionData;
import org.jasypt.util.text.BasicTextEncryptor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Map;

@Service
public class ProcessingService {

    @Value("${jasypt.password}")
    private String jasyptPassword;

    @Autowired
    private TransactionDao transactionDao;

    public void processData(String encryptedData) throws SQLException {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(jasyptPassword);

        String decryptedBody = basicTextEncryptor.decrypt(encryptedData);
        JSONObject jsonObject = new JSONObject(decryptedBody);
//        Map<String, Object> transactionDataMap = objectMapper.convertValue(decryptedBody, Map.class);
        TransactionData transactionData = new TransactionData();
        if(jsonObject.has("accountNumber")){
            transactionData.setAccountNumber(jsonObject.getString("accountNumber"));
        }
        if(jsonObject.has("amount")){
            transactionData.setAmount(jsonObject.getInt("amount"));
        }

        if(jsonObject.has("currency")){
            transactionData.setCurrency(jsonObject.getString("currency"));
        }

        if(jsonObject.has("type")){
            transactionData.setType(jsonObject.getString("type"));
        }

        if(jsonObject.has("accountFrom")) {
            transactionData.setAccountFrom(jsonObject.getString("accountFrom"));
        }

        transactionDao.saveTransactionData(transactionData);
    }
}
