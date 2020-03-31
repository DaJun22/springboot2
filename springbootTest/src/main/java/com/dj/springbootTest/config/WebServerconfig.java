package com.dj.springbootTest.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebServerconfig {
	@Bean
	public Connector connector() {
		Connector connector = new Connector();
		connector.setScheme("http");
		connector.setPort(8081);
		return connector;
	}
	
	
	public ServletWebServerFactory servletWebServerFactory() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(connector());
		
		return tomcat;
	
	}
}
