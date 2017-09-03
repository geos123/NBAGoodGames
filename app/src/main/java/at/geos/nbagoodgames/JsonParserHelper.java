package at.geos.nbagoodgames;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParserHelper {

    private String jsonString;

    public JsonParserHelper(String jsonString) {
        this.setJsonString(jsonString);
    }


    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonResultSets = jsonObject.getJSONArray("resultSets");
            JSONObject jsonResultSetObject = jsonResultSets.getJSONObject(1);
            JSONArray jsonArrayAllGames = jsonResultSetObject.getJSONArray("rowSet");

            for(int i = 0; i < jsonArrayAllGames.length(); i = i + 2) {
                Game game = new Game();

                JSONArray gameArrayRoadTeam = jsonArrayAllGames.getJSONArray(i);
                JSONArray gameArrayHomeTeam = jsonArrayAllGames.getJSONArray(i+1);
                String roadTeam = gameArrayRoadTeam.getString(4);
                int roadTeamScore = gameArrayRoadTeam.getInt(22);
                String homeTeam = gameArrayHomeTeam.getString(4);
                int homeTeamScore = gameArrayHomeTeam.getInt(22);

                game.setRoadTeam(roadTeam);
                game.setHomeTeam(homeTeam);
                game.setScoreHomeTeam(homeTeamScore);
                game.setScoreRoadTeam(roadTeamScore);

                Log.e("Game:", game.toString());

                games.add(game);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return games;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }
}


