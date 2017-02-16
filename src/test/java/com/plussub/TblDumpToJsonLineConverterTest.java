package com.plussub;

import com.plussub.convert.Iso639Entry;
import com.plussub.convert.TblDumpToJsonLineConverter;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created by sbreitenstein on 13/02/17.
 */
public class TblDumpToJsonLineConverterTest {


    @Test
    public void test_line_converter_with_all_properties(){
        TblDumpToJsonLineConverter lineConverter = new TblDumpToJsonLineConverter();
        Iso639Entry iso639Entry = TblDumpToJsonLineConverter.convert("aar\taa\tAfar, afar\t0\t0\n");

        assertThat(iso639Entry.getValue(),is("aar"));
        assertThat(iso639Entry.getValueAs2Char(),is("aa"));
        assertThat(iso639Entry.getName(),is("Afar, afar"));
    }

    @Test
    public void test_line_converter_with_missing_iso639_2_properties(){
        TblDumpToJsonLineConverter lineConverter = new TblDumpToJsonLineConverter();
        Iso639Entry iso639Entry = TblDumpToJsonLineConverter.convert("ace\t\tAchinese\t0\t0\n");

        assertThat(iso639Entry.getValue(),is("ace"));
        assertThat(iso639Entry.getValueAs2Char(),is(""));
        assertThat(iso639Entry.getName(),is("Achinese"));
    }

}