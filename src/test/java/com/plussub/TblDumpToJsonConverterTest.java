package com.plussub;

import com.google.common.collect.Lists;
import com.plussub.convert.TblDumpToJsonConverter;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sbreitenstein on 15/02/17.
 */
public class TblDumpToJsonConverterTest {


    @Test
    public void test() throws JSONException {
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
