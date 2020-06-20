package com.inwshop.filters;

import com.inwshop.configurations.PathEnviroment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckPublicEndPoints {

	@Autowired
	private PathEnviroment env;
	
	
	public Boolean execute(String path) {	
		return  Boolean.parseBoolean(env.getProperty(path));
		//return true;
	}
	
}
