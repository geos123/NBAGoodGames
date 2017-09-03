package at.geos.nbagoodgames;


public class Game {

    private String homeTeam;
    private String roadTeam;
    private int scoreHomeTeam;
    private int scoreRoadTeam;

    public void setScoreRoadTeam(int scoreRoadTeam) {
        this.scoreRoadTeam = scoreRoadTeam;
    }

    public int getScoreRoadTeam() {
        return scoreRoadTeam;
    }

    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    public void setScoreHomeTeam(int scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
    }

    public String getRoadTeam() {
        return roadTeam;
    }

    public void setRoadTeam(String roadTeam) {
        this.roadTeam = roadTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }


    @Override
    public String toString() {
        return roadTeam + "-" + homeTeam + " " + scoreRoadTeam + ":" + scoreHomeTeam;
    }
}
