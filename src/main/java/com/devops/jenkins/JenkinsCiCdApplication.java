package com.devops.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsCiCdApplication {

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + " Congrats to complete CI and CD";
    }

    public static void main(String[] args) {
        SpringApplication.run(JenkinsCiCdApplication.class, args);
    }

}
