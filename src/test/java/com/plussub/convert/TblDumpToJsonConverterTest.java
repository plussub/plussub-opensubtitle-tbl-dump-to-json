package com.plussub.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;
import com.plussub.convert.Iso639Entry;
import com.plussub.convert.TblDumpToJsonConverter;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sbreitenstein on 15/02/17.
 */
public class TblDumpToJsonConverterTest {


    @Test
    public void test_line_converter_with_all_properties(){
        Iso639Entry iso639Entry = TblDumpToJsonConverter.lineToIso639("aar\taa\tAfar, afar\t0\t0\n");

        assertThat(iso639Entry.getValue(),is("aar"));
        assertThat(iso639Entry.getValueAs2Char(),is("aa"));
        assertThat(iso639Entry.getName(),is("Afar, afar"));
    }

    @Test
    public void test_line_converter_with_missing_iso639_2_properties(){
        Iso639Entry iso639Entry = TblDumpToJsonConverter.lineToIso639("ace\t\tAchinese\t0\t0\n");

        assertThat(iso639Entry.getValue(),is("ace"));
        assertThat(iso639Entry.getValueAs2Char(),is(""));
        assertThat(iso639Entry.getName(),is("Achinese"));
    }


    @Test
    public void test() throws JSONException, JsonProcessingException {
        List<String> list = Lists.newArrayList("aar\taa\tAfar, afar\t0\t0\n", "ace\t\tAchinese\t0\t0\n");
        String expected = "[{" +
                "    \"iso639\": \"aar\"," +
                "    \"iso639_2\": \"aa\"," +
                "    \"iso639Name\": \"Afar, afar\"," +
                "    \"valueField\": \"{\\\"iso639\\\":\\\"aar\\\",\\\"iso639_2\\\":\\\"aa\\\",\\\"iso639Name\\\":\\\"Afar, afar\\\"}\"" +
                "}, {" +
                "    \"iso639\": \"ace\"," +
                "    \"iso639_2\": \"\"," +
                "    \"iso639Name\": \"Achinese\"," +
                "    \"valueField\": \"{\\\"iso639\\\":\\\"ace\\\",\\\"iso639_2\\\":\\\"\\\",\\\"iso639Name\\\":\\\"Achinese\\\"}\"" +
                "}]";

        String result = new TblDumpToJsonConverter().convert(list);
        JSONAssert.assertEquals(expected, result, false);

    }
}
