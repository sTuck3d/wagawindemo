package de.floschi.wagawindemo.children.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {"de.floschi.wagawindemo.children.db.dao"}
)
@EntityScan("de.floschi.wagawindemo.children.db.entity")
public class DatabaseConfig {
}
