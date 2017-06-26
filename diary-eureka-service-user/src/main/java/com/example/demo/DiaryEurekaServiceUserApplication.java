package com.example.demo;

import com.example.demo.check.UserServiceCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.check.User;
import com.example.demo.check.UserService;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DiaryEurekaServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaryEurekaServiceUserApplication.class, args);
	}

    @Autowired
    UserService userService;

	@RequestMapping("/list")
	public List<User> getStus(){
		return userService.getList();
	}

	@Autowired
	UserServiceCheck service;

	@RequestMapping("/check")
	public String check(@RequestParam("account") String account, @RequestParam("pass") String pass) {
		 if(service.getcheck(account,pass).size()==0){
		 	return "f";
		 }
		 return "t";
	}

	@RequestMapping("/add")
	public String add(@RequestParam("userAccount") String userAccount, @RequestParam("userPassword") String userPassword, @RequestParam("userSex") String userSex) {
		return service.getadd(userAccount,userPassword,userSex);
	}

}
