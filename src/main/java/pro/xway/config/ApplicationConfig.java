package pro.xway.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("pro.xway")
@ComponentScan("pro.xway.model")
@EnableJpaRepositories("pro.xway.dao")
@Import(pro.xway.config.DataSourceConfiguration.class)
public class ApplicationConfig {
}
