package colo.spring.cloud.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import colo.spring.cloud.services.example.ServiceExample;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationRestService {

	private static Logger log = LoggerFactory.getLogger(ApplicationRestService.class);

	

	public static void main(String[] args) {

		// Agregue esto porq no registra bien el nombre en zuul, lo saqué de aca
		// https://github.com/spring-cloud/spring-cloud-netflix/issues/1335
		System.setProperty("spring.application.name", "Public-RestService");
		SpringApplication.run(ApplicationRestService.class, args);

	}

}
