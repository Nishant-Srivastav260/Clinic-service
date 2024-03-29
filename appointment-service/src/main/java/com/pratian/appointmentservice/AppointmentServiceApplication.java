package com.pratian.appointmentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;


//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableCircuitBreaker
//@EnableEurekaClient
public class AppointmentServiceApplication {
//	@Value(value = "${swagger.url.productionURL}")
//    public String productionURL;
//    @Value(value = "${swagger.url.localURL}")
//    public String localURL;
	public static void main(String[] args) {
		SpringApplication.run(AppointmentServiceApplication.class, args);	
	}
//	@Bean
//    public OpenAPI customOpenAPI() {
//       // Server productionserver = new Server();
//        Server localserver = new Server();
//        List<Server> servers = new ArrayList<>();
//      // productionserver.setUrl(productionURL);
//       localserver.setUrl(localURL);
//        //servers.add(productionserver);
//        servers.add(localserver);
//        OpenAPI openAPI = new OpenAPI();
//        openAPI.setServers(servers);
//        return openAPI;
//    }
	
	@LoadBalanced
	@Bean
	public RestTemplate rTemplate() {
		return new RestTemplate();
	}
	

}
