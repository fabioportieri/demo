package com.example.demo.controller;

import com.example.demo.dto.CustomResponseEntity;
import com.example.demo.dto.SaldoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bank") 
public class BankController {
    private static final Logger LOG = LoggerFactory.getLogger(BankController.class);
    
    @Value("${app.endpoints.saldoUrl}")
    private String saldoUrl;
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/saldo")
    public ResponseEntity<CustomResponseEntity<SaldoResponse>> getLetturaSaldo() {


        LOG.info("/saldo endpoint START, forwarding call to the following url: {}", saldoUrl);
        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // set additional header here, or configure them in a centralized way (RestTemplateConfiguration)
        HttpEntity<String> entity = new HttpEntity<>(headers);


        ResponseEntity<CustomResponseEntity<SaldoResponse>> response = restTemplate.exchange(
                saldoUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<CustomResponseEntity<SaldoResponse>>(){});
        
        
        LOG.info("/saldo endpoint END, response retrieved: {}", response);
        return response;

    }

}
