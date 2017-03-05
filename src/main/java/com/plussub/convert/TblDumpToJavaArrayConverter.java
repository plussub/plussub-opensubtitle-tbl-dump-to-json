package com.plussub.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sbreitenstein on 15/02/17.
 */
@Component
public class TblDumpToJavaArrayConverter implements TblDumpTo {

    @Override
    public String convert(Stream<String> perLine) throws JsonProcessingException {
        return perLine
                .map(TblDumpTo::lineToIso639)
                .map(TblDumpToJavaArrayConverter::writeAsJavaInit)
                .collect(TblDumpToJavaArrayConverter.joinAsJavaArrayInit());
    }

    private static Collector<CharSequence, ?, String> joinAsJavaArrayInit() {
        return  Collectors.joining(",", "{", "}");
    }


     static String writeAsJavaInit(Iso639Entry entry){
        return String.format("new Iso639Entry(\"%s\",\"%s\",\"%s\")",entry.getValue(),entry.getValueAs2Char(),entry.getName());
    }

}
