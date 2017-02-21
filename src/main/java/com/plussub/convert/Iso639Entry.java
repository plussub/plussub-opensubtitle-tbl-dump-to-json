package com.plussub.convert;

import com.fasterxml.jackson.annotation.JsonGetter;

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

    //iso639
    //@JsonGetter("iso639")
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Iso639Entry{" +
                "value='" + value + '\'' +
                ", valueAs2Char='" + valueAs2Char + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //iso639_2
    public String getValueAs2Char() {
        return valueAs2Char;
    }

    //iso639Name
    public String getName() {
        return name;
    }
}
