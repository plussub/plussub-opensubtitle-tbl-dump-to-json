package com.plussub.convert;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sbreitenstein on 15/02/17.
 */
@Component
public class TblDumpToJsonConverter {

//    @Autowired
//    private TblDumpToJsonLineConverter tblDumpToJsonLineConverter;
//


    public String convert(List<String> perLine){

      return  perLine.stream()
              .map(ConvertFunctions::lineToIso639)
              .map(Iso639Entry::toString)
//              .map(JsonConvertFunctions::writeValueAsStringWithSelfReference);
             .collect(Collectors.joining(","));
    }

}
