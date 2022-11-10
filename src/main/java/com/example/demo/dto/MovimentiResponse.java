package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovimentiResponse {

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @JsonProperty(value = "list")
	private List<MovimentoResponse> movimentoResponse;
	
}
