package com.plussub;

import com.google.common.collect.Lists;
import com.plussub.convert.TblDumpToJsonConverter;
import org.junit.Test;

import java.util.List;

/**
 * Created by sbreitenstein on 15/02/17.
 */
public class TblDumpToJsonConverterTest {

    @Test
    public void test(){
        List<String> list = Lists.newArrayList("aar\taa\tAfar, afar\t0\t0\n","ace\t\tAchinese\t0\t0\n");

        System.out.print(new TblDumpToJsonConverter().convert(list));
    }
}
