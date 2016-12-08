package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.ClubMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClubMembershipJpaRepository extends JpaRepository<ClubMembership, Long> {
}
