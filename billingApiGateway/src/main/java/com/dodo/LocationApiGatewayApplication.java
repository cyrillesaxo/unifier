package com.dodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class LocationApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationApiGatewayApplication.class, args);
	}
	
}
