package dk.bringlarsen.dbtu.rating;

import dk.bringlarsen.dbtu.rating.common.model.Player;

import java.util.List;

public class DBTURatingServices {
    private final DBTURatingServicesApplication dbtuRatingServicesApplication;

    public DBTURatingServices(DBTURatingServiceProperties properties) {
        dbtuRatingServicesApplication = new DBTURatingServicesApplication(properties);
    }

    public List<Player> getPlayers() {
        String latestSeasonId = dbtuRatingServicesApplication.getLatestSeason();

        return dbtuRatingServicesApplication.getPlayers(latestSeasonId);
    }
}