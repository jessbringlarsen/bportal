package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(excerptProjection = MatchExcerptProjection.class)
@RepositoryRestResource
public interface MatchJpaRepository extends JpaRepository<Match, Long> {
}
