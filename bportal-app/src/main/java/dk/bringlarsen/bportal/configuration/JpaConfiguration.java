package dk.bringlarsen.bportal.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages={"dk.bringlarsen.bportal.repository"})
public class JpaConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
