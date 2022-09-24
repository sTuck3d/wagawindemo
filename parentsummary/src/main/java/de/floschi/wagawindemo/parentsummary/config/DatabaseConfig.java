package de.floschi.wagawindemo.parentsummary.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {"de.floschi.wagawindemo.parentsummary.db.dao"}
)
@EntityScan("de.floschi.wagawindemo.parentsummary.db.entity")
public class DatabaseConfig {
}
