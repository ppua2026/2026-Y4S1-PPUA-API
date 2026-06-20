package kh.edu.ppua.api;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfiguration
@SpringBootApplication
public class PPUAApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PPUAApiApplication.class, args);
    }

    @PostConstruct
    void init(){
        System.out.println("Bean Initialized");
        // Connection to Database, Other Services
    }

    @PreDestroy
    void deploy(){
        System.out.println("Bean PreDestroy");
        //  Disconnect from Database, Other Services
    }
}
