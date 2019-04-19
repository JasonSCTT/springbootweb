package com.jason.springbootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages="com.jason.springbootweb.dao.mapper")
public class SpringbootwebApplication  extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
	}


	// 加载静态资源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String baseLocation = "classpath:";
		baseLocation = "file:D:\\tool\\intellijproject\\springbootweb\\src\\main\\resources";
		registry.addResourceHandler("/html/**").addResourceLocations(baseLocation + "/templates/");
		registry.addResourceHandler("/static/**").addResourceLocations(baseLocation + "/static/");
		super.addResourceHandlers(registry);
	}

}
