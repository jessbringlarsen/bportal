package dk.bringlarsen.dbtu.rating;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DBTURatinglisterPrintPageLinkBuilderTest {

    @Test
    @Ignore
    public void testBuild()  {
        String link = DBTURatinglisterPrintPageLinkBuilder.create(new DBTURatingServiceProperties())
                .setSeasonId("42014")
                .setPageNo("1")
                .build();

        assertThat(link, is("http://bordtennisportalen.dk/DBTU/Ranglister/Udskriv/?params=,59,42014,,,,,False,,,,,1,,,0"));
    }
}