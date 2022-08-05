package com.jason.springbootweb;

import com.jason.springbootweb.interceptor.SessionIntegerceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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


	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
//		registry.addInterceptor(new SessionIntegerceptor()).addPathPatterns("/**").excludePathPatterns("/html/**").excludePathPatterns("/static/**");
	}
}
