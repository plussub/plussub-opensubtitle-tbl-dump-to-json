package com.plussub.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sbreitenstein on 15/02/17.
 */
@Component
public class TblDumpToJsonConverter {

    public String convert(Stream<String> perLine) throws JsonProcessingException {
        return perLine
                .map(TblDumpToJsonConverter::lineToIso639)
                .map(JsonWithSelfReference::new)
                .map(TblDumpToJsonConverter::writeAsJson)
                .collect(TblDumpToJsonConverter.joinAsJsonArray());
    }

    private static Collector<CharSequence, ?, String> joinAsJsonArray() {
        return  Collectors.joining(",", "[", "]");
    }


    static Iso639Entry lineToIso639(String line){
        List<String> values = Splitter.on("\t").splitToList(line);
        return new Iso639Entry(values.get(0)
                ,values.get(1)
                ,values.get(2));
    }


     static String writeAsJson(JsonWithSelfReference ref){
        try {
            return new ObjectMapper().writeValueAsString(ref);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
