package org.clases.libroservice.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "org.clases.libroservice.persistence.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "org.clases.libroservice.persistence.model")
public class LibroConfiguration {

}
