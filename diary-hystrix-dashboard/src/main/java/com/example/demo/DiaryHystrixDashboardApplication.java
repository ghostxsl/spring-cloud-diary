package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@Controller
public class DiaryHystrixDashboardApplication {

	@RequestMapping("/")
	public String home() { return "forward:/hystrix"; }

	public static void main(String[] args) {
		SpringApplication.run(DiaryHystrixDashboardApplication.class, args);
	}
}
