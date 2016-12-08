package dk.bringlarsen.dbtu.rating.page;

import dk.bringlarsen.dbtu.rating.common.exception.DBTURatinglisterPageParseException;
import dk.bringlarsen.dbtu.rating.common.model.Player;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBTURatinglisterPrintPage {

    private static final Pattern NAME_AND_CLUB = Pattern.compile("(.+), (.+)");
    private static final String RATING_GRID_LIST_ID = "RankingListGrid";


    public List<Player> getPlayers(Document document) {
        List<Player> players = new ArrayList<>();

        Elements elements = getTableRowsExcludingHeader(document);

        for (Element trElement : elements) {
            String id = trElement.child(2).text();

            Matcher nameClubMatcher = tryParseNameAndClub(trElement.child(3).text());
            String name = nameClubMatcher.group(1);
            String club = nameClubMatcher.group(2);

            Integer points = Integer.valueOf(trElement.child(4).text());
            Integer advancement = Integer.valueOf(trElement.child(5).text());
            Integer noOfMatches = Integer.valueOf(trElement.child(6).text());

            players.add(new Player(id, name, club, points, advancement, noOfMatches));
        }
        return players;
    }

    private Elements getTableRowsExcludingHeader(Document document) {
        Elements rankingListGrid = document.getElementsByClass(RATING_GRID_LIST_ID);
        Elements elements = rankingListGrid.get(0).child(0).children();
        elements.remove(0); // remove headers

        return elements;
    }

    private Matcher tryParseNameAndClub(String nameAndClub) {
        Matcher nameClubMatcher = NAME_AND_CLUB.matcher(nameAndClub);
        if(!nameClubMatcher.matches()) {
            throw new DBTURatinglisterPageParseException("Navn og klub kan ikke udtrækkes fra: " + nameAndClub);
        }
        return nameClubMatcher;
    }
}