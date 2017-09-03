package at.geos.nbagoodgames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ResultListAdapter extends ArrayAdapter<Game>{

    public ResultListAdapter(Context context, ArrayList<Game> games) {
        super(context, 0, games);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Game game = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_game, parent, false);
        }
        TextView roadTeamTV = (TextView) convertView.findViewById(R.id.roadTeamTV);
        TextView homeTeamTV = (TextView) convertView.findViewById(R.id.homeTeamTV);

        roadTeamTV.setText(game.getRoadTeam());
        homeTeamTV.setText(game.getHomeTeam());

        return convertView;
    }
}
