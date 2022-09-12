package de.floschi.wagawindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

// Exclude R2dbcAutoConfiguration of Spring, so the pooling is correctly set with the
// io.r2dbc config
@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class WagawindemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WagawindemoApplication.class, args);
    }

}
