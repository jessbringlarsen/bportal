package dk.bringlarsen.dbtu.rating.page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DBTURatinglisterPageTest {

    private static Document document;

    @BeforeClass
    public static void setup() throws IOException {
        File file = new File(DBTURatinglisterPageTest.class.getClassLoader().getResource("dbtuRatinglisterPage.html").getFile());
        document = Jsoup.parse(file, "UTF-8", "http://bordtennisportalen.dk");
    }

    @Test
    public void testParseSeasons() {
        DBTURatinglisterPage page = new DBTURatinglisterPage(document);
        Set<String> seasons = page.getSeasons();

        assertThat(seasons.size(), is(5));
        assertThat(seasons, hasItem("42015"));
    }

    @Test
    public void testSelectedSeason() {
        DBTURatinglisterPage page = new DBTURatinglisterPage(document);

        assertThat(page.getLatestSeason(), is("42015"));
    }
}