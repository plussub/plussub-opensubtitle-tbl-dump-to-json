package com.plussub;

import com.google.common.collect.Lists;
import com.plussub.convert.TblDumpToJsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TblDumpToJsonApplication {

	@Autowired
	private TblDumpToJsonConverter tblDumpToJsonConverter;


	public static void main(String[] args) {
		SpringApplication.run(TblDumpToJsonApplication.class, args);
	}

	public void run(String[] args){
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");
		System.out.print("hello world");

		System.out.print("hello world");

		tblDumpToJsonConverter.convert(Lists.newArrayList("asdf"));
	}
}
