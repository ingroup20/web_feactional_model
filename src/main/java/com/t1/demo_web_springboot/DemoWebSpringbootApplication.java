package com.t1.demo_web_springboot;

import com.t1.demo_web_springboot.mail.JavaMailService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebSpringbootApplication {

    @Autowired
    JavaMailService javaMailService ;

    public static void main(String[] args) {
        SpringApplication.run(DemoWebSpringbootApplication.class, args);
        System.out.println("Hello, Spring Boot!");
    }

//    @PostConstruct
//    public void run() {
//        String sendTo = "";
//        String sendFrom = "";
//        javaMailService.sendMail(sendTo, sendFrom, "orderSendFrom");
//    }

}
