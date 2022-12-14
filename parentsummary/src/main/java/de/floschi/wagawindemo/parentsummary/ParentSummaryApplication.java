package de.floschi.wagawindemo.parentsummary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"de.floschi.wagawindemo.*"})
public class ParentSummaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentSummaryApplication.class, args);
    }

}
