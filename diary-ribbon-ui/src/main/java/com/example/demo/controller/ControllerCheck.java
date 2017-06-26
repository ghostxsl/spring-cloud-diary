package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.ServiceCheck;

@RestController
public class ControllerCheck {
    @Autowired
    ServiceCheck service;

    @RequestMapping("/check")
    public String check(@RequestParam("account") String account,@RequestParam("pass") String pass) {
        return service.serviceRe(account,pass);
    }

    @RequestMapping("/add")
    public String add(@RequestParam("userAccount") String userAccount, @RequestParam("userPassword") String userPassword, @RequestParam("userSex") String userSex) {
        return service.serviceRe1(userAccount,userPassword,userSex);
    }

    @RequestMapping("/history")
    public String history(@RequestParam("account") String account) {
        return service.serviceRe2(account);
    }

    @RequestMapping("/save")
    public String save(@RequestParam("filename") String filename,@RequestParam("date") String date,@RequestParam("account") String account, @RequestParam("usertext") String usertext) {
        return service.serviceRe3(filename,date,account,usertext);
    }

    @RequestMapping("/lookup")
    public String lookup(@RequestParam("account") String account,@RequestParam("filename") String filename) {
        return service.serviceRe4(account,filename);
    }

}
