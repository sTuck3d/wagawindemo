package de.floschi.wagawindemo.family.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {"de.floschi.wagawindemo.family.db.dao"}
)
@EntityScan("de.floschi.wagawindemo.family.db.entity")
public class DatabaseConfig {
}
