package dk.bringlarsen.bportal.api.projection;

import dk.bringlarsen.bportal.model.Match;
import dk.bringlarsen.bportal.model.Player;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "matchExcerptProjection", types = { Match.class })
public interface MatchExcerptProjection {

    String getResult();

    LocalDateTime getWhen();

    Player getPlayer1();

    Player getPlayer2();
}
