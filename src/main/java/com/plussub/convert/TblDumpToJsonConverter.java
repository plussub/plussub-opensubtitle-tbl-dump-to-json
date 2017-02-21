package com.plussub.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sbreitenstein on 15/02/17.
 */
@Component
public class TblDumpToJsonConverter {

    public String convert(List<String> perLine) throws JsonProcessingException {
        return perLine.stream()
                .map(ConvertFunctions::lineToIso639)
                .map(JsonWithSelfReference::new)
                .map(this::writeAsJson)
                .collect(Collectors.joining(",", "[", "]"));
    }

    private String writeAsJson(JsonWithSelfReference ref){
        try {
            return new ObjectMapper().writeValueAsString(ref);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
