package dk.bringlarsen.dbtu.rating.common.model;

public class Player {
    private final String id;
    private final String name;
    private final String club;
    private final int points;
    private final int noOfMatches;
    private final int advancement;

    public Player(String id, String name, String club, int points, int advancement, int noOfMatches) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.points = points;
        this.advancement = advancement;
        this.noOfMatches = noOfMatches;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public int getPoints() {
        return points;
    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public int getAdvancement() {
        return advancement;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", club='"  + club + '\'' +
                ", points=" + points +
                ", advancement=" + advancement +
                ", noOfMatches=" + noOfMatches +
                '}';
    }
}
