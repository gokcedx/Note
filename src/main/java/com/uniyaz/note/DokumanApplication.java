package com.uniyaz.note;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.xml.AbstractXmlHttpMessageConverter;
import org.springframework.web.accept.MappingMediaTypeFileExtensionResolver;

@SpringBootApplication
public class DokumanApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DokumanApplication.class, args);
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
//		ApplicationContext appctx = SpringApplication.run(DokumanApplication.class, args);
//
//		GreetingServiceImpl bsi =  appcNtx.getBean(GreetingServiceImpl.class);
//		System.out.println(bsi.getEnglishServiceValue());
//		System.out.println(bsi.getFrenchService2Value());


	}

	@Bean
	public AbstractXmlHttpMessageConverter<Object> objectMap() {
		return new GokceKubra();
	}
}
