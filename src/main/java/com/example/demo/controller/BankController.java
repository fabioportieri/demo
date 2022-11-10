package com.example.demo.controller;

import com.example.demo.dto.BonificoRequest;
import com.example.demo.dto.BonificoResponse;
import com.example.demo.dto.CustomResponseEntity;
import com.example.demo.dto.MovimentiResponse;
import com.example.demo.dto.MovimentoResponse;
import com.example.demo.dto.SaldoResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/bank") 
public class BankController {
    private static final Logger LOG = LoggerFactory.getLogger(BankController.class);
    
    @Value("${app.endpoints.saldoUrl}")
    private String saldoUrl;
    
    @Value("${app.endpoints.bonificoUrl}")
    private String bonificoUrl;
    
    @Value("${app.endpoints.movimentiUrl}")
    private String movimentiUrl;
    
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/saldo")
    public ResponseEntity<CustomResponseEntity<SaldoResponse>> getLetturaSaldo() {


        LOG.info("/saldo endpoint START, forwarding call to the following url: {}", saldoUrl);
        HttpHeaders headers = new HttpHeaders();
        // set additional headers here other than from the defaults ones already in RestTemplateConfiguration
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CustomResponseEntity<SaldoResponse>> response = restTemplate.exchange(
                saldoUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<CustomResponseEntity<SaldoResponse>>(){});
        
        LOG.info("/saldo endpoint END, response retrieved: {}", response);
        return response;

    }
    
    @GetMapping("/bonifico")
    public ResponseEntity<CustomResponseEntity<BonificoResponse>> getBonifico() {
    	LOG.info("/bonifico endpoint START, forwarding call to the following url: {}", movimentiUrl);

        HttpHeaders headers = new HttpHeaders();
        // set additional headers here other than from the defaults ones already in RestTemplateConfiguration

        BonificoRequest body = new BonificoRequest();
        HttpEntity<?> entity = new HttpEntity<BonificoRequest>(body, headers);

        ResponseEntity<CustomResponseEntity<BonificoResponse>> response = restTemplate.exchange(
                bonificoUrl,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<CustomResponseEntity<BonificoResponse>>(){});
    	
        LOG.info("/bonifico endpoint END, response retrieved: {}", response);
    	return response;
    }
    
    @GetMapping("/movimenti")
    public ResponseEntity<CustomResponseEntity<MovimentiResponse>> getMovimenti(@RequestParam String fromAccountingDate,
    		@RequestParam String toAccountingDate){
    	LOG.info("/movimenti endpoint START, forwarding call to the following url: {}", movimentiUrl);

        HttpHeaders headers = new HttpHeaders();
        // set additional headers here other than from the defaults ones already in RestTemplateConfiguration
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = UriComponentsBuilder.fromHttpUrl(movimentiUrl)
                .queryParam("fromAccountingDate", "{fromAccountingDate}")
                .queryParam("toAccountingDate", "{toAccountingDate}")
                .encode()
                .toUriString();
        
        Map<String, String> params = new HashMap<>();
        params.put("fromAccountingDate", fromAccountingDate);
      	params.put("toAccountingDate", toAccountingDate);
        
        ResponseEntity<CustomResponseEntity<MovimentiResponse>> response = restTemplate.exchange(
        		url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<CustomResponseEntity<MovimentiResponse>>(){},
                params);        
        
        LOG.info("/movimenti endpoint END, response retrieved: {}", response);
        return response;
    }
    
    @GetMapping("/pippo")
    public String getPippo() {
    	return "pippo";
    }

}


