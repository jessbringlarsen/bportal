package dk.bringlarsen.dbtu.rating.page;

import dk.bringlarsen.dbtu.rating.common.exception.DBTURatinglisterPageParseException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DBTURatinglisterPage {

    private static final String SEASONS_LIST_ID = "ctl00_ContentPlaceHolder1_ShowRankings1_DropDownListSeasons";

    private final Document document;

    public DBTURatinglisterPage(Document document) {
        this.document = document;
    }

    public Set<String> getSeasons() {
        return getChildValues(SEASONS_LIST_ID);
    }

    public String getLatestSeason() {
        return getSelectedChildValue(SEASONS_LIST_ID).get();
    }

    private Optional<String> getSelectedChildValue(String elementId) {
        for (Element child : getChildElements(elementId)) {
            if(child.hasAttr("selected")) {
                return Optional.of(child.attr("value"));
            }
        }
        return Optional.empty();
    }

    private Set<String> getChildValues(String elementId) {
        return getChildElements(elementId)
                .stream()
                .map(child -> child.attr("value"))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private Collection<Element> getChildElements(String elementId) {
        if(!hasElementId(elementId)) {
            throw new DBTURatinglisterPageParseException(elementId + " findes ikke!");
        }

        Element versions = document.getElementById(elementId);
        return versions.children().stream().collect(Collectors.toList());
    }

    private boolean hasElementId(String elementId) {
        return document.getElementById(elementId) != null;
    }
}