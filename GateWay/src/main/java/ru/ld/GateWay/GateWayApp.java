package ru.ld.GateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GateWayApp {

	public static void main(String[] args) {
		SpringApplication.run(GateWayApp.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("MicroService1",r->r.path("/managers/**")
						.uri("http://localhost:8081/"))
				.route("MicroService2",r->r.path("/clients/**")
						.uri("http://localhost:8082/"))
				.build();}

}
