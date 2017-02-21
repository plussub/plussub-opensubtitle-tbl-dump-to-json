package com.plussub.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.base.Splitter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by sbreitenstein on 13/02/17.
 */
public class ConvertFunctions {
    private ConvertFunctions(){
    }

    public static Iso639Entry lineToIso639(String line){
        List<String> values = Splitter.on("\t").splitToList(line);
        return new Iso639Entry(values.get(0)
                ,values.get(1)
                ,values.get(2));
    }



}
