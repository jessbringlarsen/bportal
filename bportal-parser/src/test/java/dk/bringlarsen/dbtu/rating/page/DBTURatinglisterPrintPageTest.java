package dk.bringlarsen.dbtu.rating.page;

import dk.bringlarsen.dbtu.rating.common.model.Player;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class DBTURatinglisterPrintPageTest {

    private static Document document;

    @BeforeClass
    public static void setup() throws IOException {
        File file = new File(DBTURatinglisterPrintPageTest.class.getClassLoader().getResource("dbtuRatinglisterPrintPage.html").getFile());
        document = Jsoup.parse(file, "UTF-8", "http://bordtennisportalen.dk");
    }

    @Test
    public void testPaarsedPlayersCount() {
        DBTURatinglisterPrintPage dbtuRatinglisterPrintPage = new DBTURatinglisterPrintPage();

        List<Player> result = dbtuRatinglisterPrintPage.getPlayers(document);
        assertThat(result.size(), is(11));
    }

    @Test
    public void test() {
        DBTURatinglisterPrintPage dbtuRatinglisterPrintPage = new DBTURatinglisterPrintPage();

        Player player = dbtuRatinglisterPrintPage.getPlayers(document).get(0);
        assertThat(player.getId(), is("280368‑THQU"));
        assertThat(player.getName(), is("Thomas Quvang"));
        assertThat(player.getClub(), is("Frederiksværk"));
        assertThat(player.getPoints(), is(2016));
        assertThat(player.getAdvancement(), is(-1));
        assertThat(player.getNoOfMatches(), is(50));
    }
}
