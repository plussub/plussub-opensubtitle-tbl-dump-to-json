package com.plussub;

/**
 * Created by sbreitenstein on 13/02/17.
 */
public class Iso639Entry {
    private final String value;
    private final String valueAs2Char;
    private final String name;

    public Iso639Entry(String value, String valueAs2Char, String name) {
        this.value = value;
        this.valueAs2Char = valueAs2Char;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getValueAs2Char() {
        return valueAs2Char;
    }

    public String getName() {
        return name;
    }
}
