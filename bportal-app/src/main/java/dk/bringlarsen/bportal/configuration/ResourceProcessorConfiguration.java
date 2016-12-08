package dk.bringlarsen.bportal.configuration;

import dk.bringlarsen.bportal.model.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

@Configuration
public class ResourceProcessorConfiguration {

    @Bean
    public ResourceProcessor<Resource<Player>> playerProcessor() {
        return new ResourceProcessor<Resource<Player>>() {

            @Override
            public Resource<Player> process(Resource<Player> resource) {

                resource.add(new Link("http://localhost:8080/people", "import"));
                return resource;
            }
        };
    }
}
