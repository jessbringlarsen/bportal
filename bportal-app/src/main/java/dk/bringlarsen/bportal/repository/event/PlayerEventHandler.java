package dk.bringlarsen.bportal.repository.event;

import dk.bringlarsen.bportal.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Player.class)
public class PlayerEventHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @HandleBeforeCreate
    public void handlePlayerCreate(Player player) {
        logger.info("Creating: " + player.toString());
    }

    @HandleBeforeSave
    public void handlePlayerSave(Player player) {
        logger.info("Updating: " + player.toString());
    }
}
