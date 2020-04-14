package com.valorcompartido.springboot.app;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfiguration implements WebMvcConfigurer{
	
	public void addViesControllers(ViewControllerRegistry registry){
		registry.addViewController("/error_403").setViewName("error_403");
	}

}
