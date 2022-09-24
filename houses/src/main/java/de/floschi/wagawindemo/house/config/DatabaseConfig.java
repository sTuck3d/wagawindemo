package de.floschi.wagawindemo.house.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {"de.floschi.wagawindemo.house.db.dao"}
)
@EntityScan("de.floschi.wagawindemo.house.db.entity")
public class DatabaseConfig {
}
