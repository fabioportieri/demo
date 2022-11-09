package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

public class CustomResponseEntity<T> {

    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "error")
    private Object[] error;
    @JsonProperty(value = "payload")
    private T payload;

    public CustomResponseEntity(String status, Object[] error, T payload) {
        this.status = status;
        this.error = error;
        this.payload = payload;
    }

    public CustomResponseEntity() {
        
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object[] getError() {
        return error;
    }

    public void setError(Object[] error) {
        this.error = error;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "CustomResponseEntity{" +
                "status='" + status + '\'' +
                ", error=" + Arrays.toString(error) +
                ", payload=" + payload +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomResponseEntity<?> that = (CustomResponseEntity<?>) o;
        return Objects.equals(status, that.status) && Arrays.equals(error, that.error) && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(status, payload);
        result = 31 * result + Arrays.hashCode(error);
        return result;
    }
}
