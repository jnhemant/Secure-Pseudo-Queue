package com.pseudo.queue.internal.processing.module.Controller;

import com.pseudo.queue.internal.processing.module.Service.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Receiver")
public class ReceiverController {
    @Autowired
    private ProcessingService processingService;

    @PostMapping
    public Map<String, Object> receive(@RequestBody String encryptedBody) throws SQLException {
        processingService.processData(encryptedBody);
        Map<String, Object> response = new HashMap<>();
        return response;
    }
}
