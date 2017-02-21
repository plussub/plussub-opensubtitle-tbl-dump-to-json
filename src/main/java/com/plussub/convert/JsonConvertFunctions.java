package com.plussub.convert;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by sonste on 20.02.2017.
 */
public class JsonConvertFunctions {

    public static class JsonWithSelfReference<T> {
        @JsonUnwrapped
        private T inner;
        private String valueField;

        public JsonWithSelfReference(T inner, String field) {
            this.inner = inner;
            this.valueField = field;
        }

        public T getInner() {
            return inner;
        }

        public String valueField() {
            return valueField;
        }
    }

    public static String writeValueAsStringWithSelfReference(Object objectToSerialize) {
        try {
            Object toSerialize = new JsonWithSelfReference<>(objectToSerialize, new ObjectMapper().writeValueAsString(objectToSerialize));
            return new ObjectMapper().writeValueAsString(toSerialize);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
