package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Utility class for testing REST controllers.
 */
public final class TestUtil<T> {

    private static final ObjectMapper mapper = createObjectMapper();

    private static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return mapper;
    }

    /**
     * Convert an object to JSON byte array.
     *
     * @param object the object to convert.
     * @return the JSON byte array.
     * @throws IOException
     */
    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        return mapper.writeValueAsBytes(object);
    }

    /**
     * Convert JSON byte array to an object.
     *
     * @param object the object to convert.
     * @return the JSON byte array.
     * @throws IOException
     */
    public static Object convertJsonBytesToObject(byte[] bytes, Class<?> type) throws IOException {
        return mapper.readValue(bytes, type);
    }


//    java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to com.example.demo.dto.CustomResponseEntity
//    at com.example.demo.controller.BankControllerTests.getLetturaSaldo(BankControllerTests.java:50)
    public static <T> T convertJsonBytesToGenericObject(byte[] bytes) throws IOException {
        return mapper.readValue(bytes, new TypeReference<T>() {});
    }


    private TestUtil() {}
}
