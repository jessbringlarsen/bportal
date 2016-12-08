package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.Main;
import dk.bringlarsen.bportal.model.Club;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class ClubJpaRepositoryTest {

    @Autowired
    private ClubJpaRepository clubJpaRepository;

    @Test
    public void testPersistClub() {
        Club club = new Club()
                .setName("jebla");
        Club saved = clubJpaRepository.saveAndFlush(club);

       assertThat(clubJpaRepository.exists(saved.getId()), is(true));
    }
}