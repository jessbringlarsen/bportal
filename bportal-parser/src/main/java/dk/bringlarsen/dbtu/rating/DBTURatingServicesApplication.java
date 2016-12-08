package dk.bringlarsen.dbtu.rating;

import dk.bringlarsen.dbtu.rating.common.model.Player;
import dk.bringlarsen.dbtu.rating.page.DBTURatinglisterPage;
import dk.bringlarsen.dbtu.rating.page.DBTURatinglisterPrintPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

class DBTURatingServicesApplication {
    private final DBTURatingServiceProperties properties;

    public DBTURatingServicesApplication(DBTURatingServiceProperties properties) {
        this.properties = properties;
    }

    public String getLatestSeason() {
        DBTURatinglisterPage dbtuRatinglisterPage = new DBTURatinglisterPage(retrieveDocument(properties.getDBTURatingPageURL()));
        return dbtuRatinglisterPage.getLatestSeason();
    }

    public List<Player> getPlayers(String seasonId) {
        String printPageLink = DBTURatinglisterPrintPageLinkBuilder.create(properties)
                .setSeasonId(seasonId)
                .build();

        DBTURatinglisterPrintPage dbtuRatinglisterPrintPage = new DBTURatinglisterPrintPage();
        return dbtuRatinglisterPrintPage.getPlayers(retrieveDocument(printPageLink));
    }

    private Document retrieveDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}