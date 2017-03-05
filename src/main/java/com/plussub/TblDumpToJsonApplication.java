package com.plussub;

import com.plussub.convert.TblDumpTo;
import com.plussub.convert.TblDumpToJavaArrayConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SpringBootApplication
public class TblDumpToJsonApplication implements CommandLineRunner {

    @Autowired
    private TblDumpToJavaArrayConverter tblDumpToJsonConverter;
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
        SpringApplication.run(TblDumpToJsonApplication.class, args);
    }

    @Override
    public void run(String[] args) {
        try {

            File file = new ClassPathResource("opensub_tbl_dump",this.getClass()).getFile();
            try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {
                System.out.println(tblDumpToJsonConverter.convert(stream));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
