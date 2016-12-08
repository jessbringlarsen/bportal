package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClubJpaRepository extends JpaRepository<Club, Long> {
}
