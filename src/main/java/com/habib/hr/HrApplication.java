package com.habib.hr;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class HrApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {

	    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	        for (HttpMessageConverter converter : converters) {
	            if (converter instanceof org.springframework.http.converter.json.MappingJackson2HttpMessageConverter) {
	                ObjectMapper mapper = ((MappingJackson2HttpMessageConverter) converter).getObjectMapper();
	                mapper.registerModule(new Hibernate5Module());
	                // replace Hibernate4Module() with the proper class for your hibernate version.
	            }
	        }
	    }
	}
}
