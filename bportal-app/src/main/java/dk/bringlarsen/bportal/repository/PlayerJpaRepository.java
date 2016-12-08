package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlayerJpaRepository extends JpaRepository<Player, Long> {
}
