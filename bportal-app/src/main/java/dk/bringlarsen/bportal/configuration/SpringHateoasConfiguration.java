package dk.bringlarsen.bportal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.DefaultCurieProvider;

@Configuration
public class SpringHateoasConfiguration {

    @Bean
    public CurieProvider curieProvider() {
        return new DefaultCurieProvider("doc", new UriTemplate("/docs/{rel}.html"));
    }
}
