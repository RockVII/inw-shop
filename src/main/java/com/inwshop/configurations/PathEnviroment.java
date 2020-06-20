package com.inwshop.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:pathURL.properties")
public class PathEnviroment {
	
	@Autowired
	private Environment env;
	
	public String getProperty(String key) {
		System.out.println(key);
		return this.env.getProperty(key);
	}

}
