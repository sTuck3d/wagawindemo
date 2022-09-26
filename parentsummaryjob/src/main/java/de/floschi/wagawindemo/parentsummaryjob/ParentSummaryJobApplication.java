package de.floschi.wagawindemo.parentsummaryjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"de.floschi.wagawindemo.*"})
public class ParentSummaryJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentSummaryJobApplication.class, args);
    }

}
