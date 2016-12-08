package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.Main;
import dk.bringlarsen.bportal.model.Club;
import dk.bringlarsen.bportal.model.ClubMembership;
import dk.bringlarsen.bportal.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@Transactional
public class PlayerRepositoryTest {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Autowired
    private EntityManager entityManager;

    private static final LocalDate MEMBER_FROM = LocalDate.of(2000, Month.JANUARY, 1);
    private static final LocalDate MEMBER_TO = LocalDate.of(2015, Month.JANUARY, 1);

    @Test
    public void testPersistPlayerWithClub() {
        Player player = new Player()
                .setName("player");

        ClubMembership clubMembership = new ClubMembership()
                .setClub(new Club()
                        .setName("club"))
                .setPlayer(player)
                .setMemberFrom(MEMBER_FROM)
                .setMemberTo(MEMBER_TO);

        player.setClubMemberships(Collections.singletonList(clubMembership));

        Long id = playerJpaRepository.saveAndFlush(player).getId();
        entityManager.clear();

        List<ClubMembership> clubMemberships = playerJpaRepository.findOne(id).getClubMemberships();
        ClubMembership membership = clubMemberships.get(0);

        assertThat(clubMemberships.size(), is(1));
        assertThat(membership.getClub().getName(), is("club"));
        assertThat(membership.getMemberFrom(), is(MEMBER_FROM));
        assertThat(membership.getMemberTo(), is(MEMBER_TO));
        assertThat(membership.getPlayer(), is(player));
    }
}
