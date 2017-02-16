package com.plussub.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sbreitenstein on 15/02/17.
 */
@Component
public class TblDumpToJsonConverter {

//    @Autowired
//    private TblDumpToJsonLineConverter tblDumpToJsonLineConverter;
//

    public static class JsonUtil{
        public static String addSelf(Iso639Entry iso639Entry){

        }
    }

    public Stream<String> convert(List<String> perLine){

      return  perLine.stream()
              .map(TblDumpToJsonLineConverter::convert)
              .map(JsonUtil::addSelf);

    }

}
