package de.floschi.wagawindemo.children;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"de.floschi.wagawindemo.*"})
public class ChildApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChildApplication.class, args);
    }

}
