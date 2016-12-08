package dk.bringlarsen.bportal.configuration;


import dk.bringlarsen.bportal.repository.event.PlayerEventHandler;
import dk.bringlarsen.bportal.repository.event.RepositoryEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public PlayerEventHandler personEventHandler() {
        return new PlayerEventHandler();
    }

    @Bean
    public RepositoryEventListener repositoryEventListener() {
        return new RepositoryEventListener();
    }
}


