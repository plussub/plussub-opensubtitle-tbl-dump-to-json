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

public class JsonWithSelfReference<T> {
    @JsonUnwrapped
    private T inner;
    private String valueField;

    public JsonWithSelfReference(T inner) {
        this.inner = inner;
        try {
            this.valueField = new ObjectMapper().writeValueAsString(inner);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public T getInner() {
        return inner;
    }

    public String getValueField() {
        return valueField;
    }
}

