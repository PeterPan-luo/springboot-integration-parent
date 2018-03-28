package com.luo.study.mmmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.luo.study.mmmapper.mapper")
public class MmMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmMapperApplication.class, args);
	}
}
