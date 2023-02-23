package com.xworkz.aeroplan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.aeroplan")
public class AeroplaneConf {

	public AeroplaneConf() {
		System.out.println("Created"+getClass().getSimpleName());
		
	}
	@Bean
	public ViewResolver viewResolver() {//web page view
		System.out.println("Created view resolver");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		System.out.println("Registering local container Entity manager factory bean ");
		return new LocalContainerEntityManagerFactoryBean();
	}
}
