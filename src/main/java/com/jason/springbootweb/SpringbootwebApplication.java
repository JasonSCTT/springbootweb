package com.jason.springbootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages="com.jason.springbootweb.dao.mapper")
public class SpringbootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
	}

}
