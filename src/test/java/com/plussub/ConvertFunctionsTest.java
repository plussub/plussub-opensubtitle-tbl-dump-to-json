package com.plussub;

import com.plussub.convert.ConvertFunctions;
import com.plussub.convert.Iso639Entry;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created by sbreitenstein on 13/02/17.
 */
public class ConvertFunctionsTest {


    @Test
    public void test_line_converter_with_all_properties(){
        Iso639Entry iso639Entry = ConvertFunctions.lineToIso639("aar\taa\tAfar, afar\t0\t0\n");

        assertThat(iso639Entry.getValue(),is("aar"));
        assertThat(iso639Entry.getValueAs2Char(),is("aa"));
        assertThat(iso639Entry.getName(),is("Afar, afar"));
    }

    @Test
    public void test_line_converter_with_missing_iso639_2_properties(){
        Iso639Entry iso639Entry = ConvertFunctions.lineToIso639("ace\t\tAchinese\t0\t0\n");

        assertThat(iso639Entry.getValue(),is("ace"));
        assertThat(iso639Entry.getValueAs2Char(),is(""));
        assertThat(iso639Entry.getName(),is("Achinese"));
    }

}