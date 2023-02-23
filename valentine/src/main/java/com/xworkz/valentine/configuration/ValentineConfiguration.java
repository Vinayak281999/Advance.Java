package com.xworkz.valentine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//2
@Configuration
@ComponentScan("com.xworkz.valentine")
public class ValentineConfiguration {
	public ValentineConfiguration() {
		System.out.println("Created " + getClass().getSimpleName());
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
