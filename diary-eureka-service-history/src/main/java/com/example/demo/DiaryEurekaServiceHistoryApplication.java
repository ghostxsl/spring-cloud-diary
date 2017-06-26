package com.example.demo;

import com.example.demo.history.HService;
import com.example.demo.history.Hhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DiaryEurekaServiceHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaryEurekaServiceHistoryApplication.class, args);
	}

	@Autowired
	HService hService;

	@RequestMapping("/history")
	public List<Hhistory> getlist(@RequestParam("account") String account){
		return hService.getlist(account);
	}

	@RequestMapping("/save")
	public String save(@RequestParam("filename") String filename, @RequestParam("date") String date, @RequestParam("account") String account, @RequestParam("usertext") String usertext){
		return hService.getsave(filename,date,account,usertext);
	}

	@RequestMapping("/lookup")
	public List<Hhistory> lookup(@RequestParam("account") String account, @RequestParam("filename") String filename){
		return hService.lookup(account,filename);
	}
}
