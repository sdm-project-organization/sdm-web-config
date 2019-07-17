package com.mo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@EnableConfigServer
public class ConfigApplication extends SpringBootServletInitializer {

	@Value("${spring.profiles}")
	String profiles;

	@Value("${server.port}")
	String port;

	@Value("${eureka.instance.hostname}")
	String discovery;

	@PostConstruct
	public void init() {
		System.out.println("profiles : " + profiles);
		System.out.println("port : " + port);
		System.out.println("discovery : " + discovery);
	}

	@RequestMapping(path = "/hello")
	public String hello() {
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
