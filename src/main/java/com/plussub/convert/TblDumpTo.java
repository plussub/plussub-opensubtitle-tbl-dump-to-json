package com.plussub.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by stefa on 05.03.2017.
 */
public interface TblDumpTo {
    String convert(Stream<String> perLine) throws JsonProcessingException;

    static Iso639Entry lineToIso639(String line){
        List<String> values = Splitter.on("\t").splitToList(line);
        return new Iso639Entry(values.get(0)
                ,values.get(1)
                ,values.get(2));
    }
}
