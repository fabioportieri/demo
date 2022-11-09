package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 *     {
 *         "accountId": "14930637",
 *             "iban": "IT22D3706978430115706240270",
 *             "abiCode": "37069",
 *             "cabCode": "78430",
 *             "countryCode": "IT",
 *             "internationalCin": "22",
 *             "nationalCin": "D",
 *             "account": "115706240270",
 *             "alias": "Company main account",
 *             "productName": "Generic company cash account",
 *             "holderName": "ACME Inc.",
 *             "activatedDate": "2008-12-25",
 *             "currency": "EUR"
 *     }
 */
//@Data
//@NoArgsConstructor 
public class SaldoResponse {


    @JsonProperty(value = "accountId")
    private String accountId;
    
    @JsonProperty(value = "iban")
    private String iban;
    @JsonProperty(value = "abiCode")
    private String abiCode;
    @JsonProperty(value = "cabCode")
    private String cabCode;
    @JsonProperty(value = "countryCode")
    private String countryCode;
    @JsonProperty(value = "internationalCin")
    private String internationalCin;
    @JsonProperty(value = "nationalCin")
    private String nationalCin;
    @JsonProperty(value = "account")
    private String account;

    @JsonProperty(value = "alias")
    private String alias;

    @JsonProperty(value = "productName")
    private String productName;

    @JsonProperty(value = "holderName")
    private String holderName;

    @JsonProperty(value = "activatedDate")
    private String activatedDate;
    
    @JsonProperty(value = "currency")
    private String currency;

    public SaldoResponse() {
    }

    @Override
    public String toString() {
        return "SaldoResponse{" +
                "accountId='" + accountId + '\'' +
                ", iban='" + iban + '\'' +
                ", abiCode='" + abiCode + '\'' +
                ", cabCode='" + cabCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", internationalCin='" + internationalCin + '\'' +
                ", nationalCin='" + nationalCin + '\'' +
                ", account='" + account + '\'' +
                ", alias='" + alias + '\'' +
                ", productName='" + productName + '\'' +
                ", holderName='" + holderName + '\'' +
                ", activatedDate='" + activatedDate + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaldoResponse that = (SaldoResponse) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(iban, that.iban) && Objects.equals(abiCode, that.abiCode) && Objects.equals(cabCode, that.cabCode) && Objects.equals(countryCode, that.countryCode) && Objects.equals(internationalCin, that.internationalCin) && Objects.equals(nationalCin, that.nationalCin) && Objects.equals(account, that.account) && Objects.equals(alias, that.alias) && Objects.equals(productName, that.productName) && Objects.equals(holderName, that.holderName) && Objects.equals(activatedDate, that.activatedDate) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, iban, abiCode, cabCode, countryCode, internationalCin, nationalCin, account, alias, productName, holderName, activatedDate, currency);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAbiCode() {
        return abiCode;
    }

    public void setAbiCode(String abiCode) {
        this.abiCode = abiCode;
    }

    public String getCabCode() {
        return cabCode;
    }

    public void setCabCode(String cabCode) {
        this.cabCode = cabCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getInternationalCin() {
        return internationalCin;
    }

    public void setInternationalCin(String internationalCin) {
        this.internationalCin = internationalCin;
    }

    public String getNationalCin() {
        return nationalCin;
    }

    public void setNationalCin(String nationalCin) {
        this.nationalCin = nationalCin;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(String activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
