package at.geos.nbagoodgames;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private DateStringUtil dateStringUtil;
    ListView resultListView;
    String resultJSON;
    TextView dateTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultListView = (ListView) findViewById(R.id.resultsListView);
        this.dateTV = (TextView) findViewById(R.id.dateTV);

        this.dateStringUtil = new DateStringUtil();
        String dateString = dateStringUtil.getYesterdayDateString();
        this.dateTV.setText(dateStringUtil.getYsterdayDateStringPretty());

        this.getData(dateString);
    }


    public void getData(String dateString) {
        Log.e("getData", "getDAta");
        new RetrieveData().execute(dateString);
    }


    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }


    public void parseJson(String result) {
        Log.e("Json:", result);
        JsonParserHelper jsonParserHelper = new JsonParserHelper(result);
        ArrayList<Game> resultList = (ArrayList) jsonParserHelper.getGames();
        if(resultList != null) {
            Log.e("not null", "not null");
            ResultListAdapter resultListAdapter = new ResultListAdapter(this, resultList);
            this.resultListView.setAdapter(resultListAdapter);

        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String dateString = this.dateStringUtil.getDateString(year, month, dayOfMonth);
        this.dateTV.setText(dateStringUtil.getDateStringPretty(year, month, dayOfMonth));
        this.getData(dateString);
    }


    class RetrieveData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String response) {


            parseJson(resultJSON);

            if(response == null) {
                Log.e("ERROR", "onPostExecute");
            } else {
                // TODO: 03.09.2017
            }
        }

        @Override
        protected String doInBackground(String... params) {
            String urlStringFirstPart = "http://stats.nba.com/stats/scoreboardV2?DayOffset=0&LeagueID=00&gameDate=";
            String urlString = urlStringFirstPart + params[0];

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Accept","application/json, text/plain, */*");
                connection.setRequestProperty("Referer", "http://stats.nba.com/scores");
                connection.setRequestProperty("Connection", "keep-alive");

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while((line = br.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                br.close();

                resultJSON = stringBuilder.toString();
                //parseJson(stringBuilder.toString());
                return null;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

