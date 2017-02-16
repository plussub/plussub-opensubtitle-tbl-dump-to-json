package com.plussub.convert;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * Created by sbreitenstein on 13/02/17.
 */
public class TblDumpToJsonLineConverter {


    public static Iso639Entry convert(String line){
        List<String> values = Splitter.on("\t").splitToList(line);
        return new Iso639Entry(values.get(0)
                ,values.get(1)
                ,values.get(2));
    }

}
