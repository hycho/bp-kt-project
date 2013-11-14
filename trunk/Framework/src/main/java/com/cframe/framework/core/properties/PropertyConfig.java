package com.cframe.framework.core.properties;



import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.cframe.framework.core.constants.ConfigurationConstant;



/**
* <PRE>
* 
* 
* </PRE>
* @author hycho
* @version 1.0
* @since 13/10/2013
* @modified
* @modifier
*/
@Configuration
@PropertySources(value={
		@PropertySource({"classpath:/config/service.datasource.properties"})
	})

public class PropertyConfig {
	static final Logger log = LoggerFactory.getLogger(PropertyConfig.class);
	
	@Autowired Environment env;
	
	@PostConstruct
	public void propertyCon(){
		log.info("injection Total Enviroment Property to ConfigurationConstant.");
		ConfigurationConstant.env = env;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	 
}
