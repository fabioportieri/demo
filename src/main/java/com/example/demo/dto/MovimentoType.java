package com.example.demo.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovimentoType {

	/*
	 *  "list": [
	            {
	                "transactionId": "1525686714002",
	                "operationId": "20000056301225",
	                "accountingDate": "2020-03-25",
	                "valueDate": "2020-03-23",
	                "type": {
	                    "enumeration": "GBS_TRANSACTION_TYPE",
	                    "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0039"
	                },
	                "amount": -13.09,
	                "currency": "EUR",
	                "description": "ID INT. LIQUIDAZIONI PREC"
	            }
	        ]
	 */
	
	@JsonProperty(value = "enumeration")
	private String enumeration;
	
	@JsonProperty(value = "value")
	private String value;
	
	@Override
	public String toString() {
		return "MovimentoTypeResponse{" +
				"enumeration='" + enumeration + '\'' +
				", value='" + value + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(enumeration, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoType other = (MovimentoType) obj;
		return Objects.equals(enumeration, other.enumeration) && Objects.equals(value, other.value);
	}

	public String getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
