package com.example.demo.controller;


import com.example.demo.dto.CustomResponseEntity;
import com.example.demo.dto.SaldoResponse;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.*;
/**
 * Integration tests for bank controller
 * run a spring boot process wired up for tests and uses MockMvc for calling the endpoints
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BankControllerTests {

    
    
    @Autowired
    private MockMvc restMockMvc;
    
    private static final String IT_COUNTRY_CODE = "IT";
    private static final String SALDO_URL = "/bank/saldo";
    private static final String SALDO_WRONG_URL = "/bank/saldo/WRONG";

    private static final String MOVIMENTI_URL = "/bank/movimenti";
    @Test
    void getLetturaSaldo() throws Exception {

        MvcResult result = restMockMvc.perform(get(SALDO_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].countryCode").value(IT_COUNTRY_CODE))
                .andExpect(jsonPath("$.[*].accountId").isNotEmpty())
                .andReturn();

        byte[] resBytes = result.getResponse().getContentAsByteArray();
        // TODO : deserialize in the actual object
//        CustomResponseEntity<SaldoResponse> response = TestUtil.convertJsonBytesToGenericObject(resBytes);
        
        // assertion fluent api for additional checks
        assertThat(resBytes).isNotNull();
        
    }
    @Test
    void getLetturaSaldoShouldFail() throws Exception {

        restMockMvc.perform(get(SALDO_WRONG_URL))
                .andExpect(status().is4xxClientError());

    }
    
    @Test
    void getMovimentiInvalidParams() throws Exception {

        restMockMvc.perform(get(MOVIMENTI_URL))
                .andExpect(status().is4xxClientError());

    }
    @Test
    void getMovimentiValidParams() throws Exception {

        String url = MOVIMENTI_URL + "?fromAccountingDate=2022-01-01&toAccountingDate=2022-01-01";
        restMockMvc.perform(get(url))
                .andExpect(status().isOk());

    }
}
