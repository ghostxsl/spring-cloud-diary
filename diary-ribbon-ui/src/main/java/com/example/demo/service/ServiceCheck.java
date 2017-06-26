package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCheck {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "checkError")
    public String serviceRe(String account,String pass){
        return restTemplate.getForObject(
                "http://SERVICE-USER/check?account="+account
                        + "&pass="+pass,String.class);
    }

    public String checkError(String account,String pass) {
        return "Oh, no, something went wrong!";
    }

    @HystrixCommand(fallbackMethod = "addError")
    public String serviceRe1(String userAccount,String userPassword,String userSex){
        return restTemplate.getForObject(
                "http://SERVICE-USER/add?userAccount="+userAccount
                + "&userPassword="+userPassword
                + "&userSex="+userSex,String.class);
    }

    public String addError(String userAccount,String userPassword,String userSex) {
        return "Oh, no, something went wrong!";
    }

    @HystrixCommand(fallbackMethod = "historyError")
    public String serviceRe2(String account){
        return restTemplate.getForObject(
                "http://SERVICE-HISTORY/history?account="+account,String.class);
    }

    public String historyError(String account) {
        return "Oh, no, something went wrong!";
    }

    @HystrixCommand(fallbackMethod = "saveError")
    public String serviceRe3(String filename,String date,String account,String usertext){
        return restTemplate.getForObject(
                "http://SERVICE-HISTORY/save?filename="+filename
                        + "&date="+date
                        + "&account="+account
                        + "&usertext="+usertext,String.class);
    }

    public String saveError(String filename,String date,String account,String usertext) {
        return "Oh, no, something went wrong!";
    }

    @HystrixCommand(fallbackMethod = "lookupError")
    public String serviceRe4(String account,String filename){
        return restTemplate.getForObject(
                "http://SERVICE-HISTORY/lookup?account="+account
                        + "&filename="+filename,String.class);
    }

    public String lookupError(String account,String filename) {
        return "Oh, no, something went wrong!";
    }

}
