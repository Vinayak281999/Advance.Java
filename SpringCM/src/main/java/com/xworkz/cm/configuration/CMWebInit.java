package com.xworkz.cm.configuration;

import java.util.Arrays;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CMWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
	public CMWebInit() {
		//web initialzetion
		System.out.println("Running getRootConfigClasses");
}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Created getServletConfigClasses");
		Class[] ref = { CMSpringConfiguration.class };
		return ref;
		// return the configured class
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Created getServletMappings");
		String[] ref2 = {"/"};
		System.out.println(Arrays.toString(ref2));
		return ref2;
		
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Running configureDefaultServletHandling");
		configurer.enable();
	}
	
}
