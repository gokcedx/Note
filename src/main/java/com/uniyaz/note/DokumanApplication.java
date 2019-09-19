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
		SpringApplication.run(DokumanApplication.class, args);
	}

	@Bean
	public AbstractXmlHttpMessageConverter<Object> objectMap() {
		return new GokceKubra();
	}
}
