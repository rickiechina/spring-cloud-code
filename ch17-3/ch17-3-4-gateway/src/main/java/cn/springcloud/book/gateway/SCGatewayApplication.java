package cn.springcloud.book.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SCGatewayApplication {
	@Bean
	public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("add_request_header_route", r ->
						r.path("/test").filters(f -> f.addResponseHeader("x-response-user", "Rickie Lee"))
								.uri("http://localhost:8071/test/head"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SCGatewayApplication.class, args);
	}
}
