package at.geos.nbagoodgames;

/**
 * Created by OG on 23.08.2017.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class JsonParserHelperTest {

    private final String jsonString = "{\"resource\":\"scoreboardV2\",\"parameters\":{\"GameDate\":\"03/11/2017\",\"LeagueID\":\"00\",\"DayOffset\":\"0\"},\"resultSets\":[{\"name\":\"GameHeader\",\"headers\":[\"GAME_DATE_EST\",\"GAME_SEQUENCE\",\"GAME_ID\",\"GAME_STATUS_ID\",\"GAME_STATUS_TEXT\",\"GAMECODE\",\"HOME_TEAM_ID\",\"VISITOR_TEAM_ID\",\"SEASON\",\"LIVE_PERIOD\",\"LIVE_PC_TIME\",\"NATL_TV_BROADCASTER_ABBREVIATION\",\"HOME_TV_BROADCASTER_ABBREVIATION\",\"AWAY_TV_BROADCASTER_ABBREVIATION\",\"LIVE_PERIOD_TIME_BCAST\",\"ARENA_NAME\",\"WH_STATUS\"],\"rowSet\":[[\"2017-03-11T00:00:00\",1,\"0021600973\",3,\"Final\",\"20170311/UTAOKC\",1610612760,1610612762,\"2016\",4,\"     \",null,\"FSOK\",\"ROOT-RM\",\"Q4       - \",\"Chesapeake Energy Arena\",1],[\"2017-03-11T00:00:00\",2,\"0021600974\",3,\"Final\",\"20170311/PHILAC\",1610612746,1610612755,\"2016\",4,\"     \",null,\"FSNP\",\"TCN-P\",\"Q4       - \",\"Staples Center\",1],[\"2017-03-11T00:00:00\",3,\"0021600975\",3,\"Final\",\"20170311/NYKDET\",1610612765,1610612752,\"2016\",4,\"     \",null,\"FSD\",\"MSG\",\"Q4       - \",\"Palace of Auburn Hills\",1],[\"2017-03-11T00:00:00\",4,\"0021600976\",3,\"Final\",\"20170311/NOPCHA\",1610612766,1610612740,\"2016\",5,\"     \",null,\"FSSE-CHA\",\"FSNO\",\"Q5       - \",\"Spectrum Center\",1],[\"2017-03-11T00:00:00\",5,\"0021600977\",3,\"Final\",\"20170311/CLEORL\",1610612753,1610612739,\"2016\",4,\"     \",null,\"FSFL\",\"FSO\",\"Q4       - \",\"Amway Center\",1],[\"2017-03-11T00:00:00\",6,\"0021600978\",3,\"Final\",\"20170311/MINMIL\",1610612749,1610612750,\"2016\",4,\"     \",null,\"FSNWI\",\"FSNN-MIN\",\"Q4       - \",\"BMO Harris Bradley Center\",1],[\"2017-03-11T00:00:00\",7,\"0021600979\",3,\"Final\",\"20170311/TORMIA\",1610612748,1610612761,\"2016\",4,\"     \",null,\"FS-SUN\",\"SN1\",\"Q4       - \",\"AmericanAirlines Arena\",1],[\"2017-03-11T00:00:00\",8,\"0021600980\",3,\"Final\",\"20170311/GSWSAS\",1610612759,1610612744,\"2016\",4,\"     \",\"ABC\",null,null,\"Q4       - ABC\",\"AT&T Center\",1],[\"2017-03-11T00:00:00\",9,\"0021600981\",3,\"Final\",\"20170311/ATLMEM\",1610612763,1610612737,\"2016\",4,\"     \",null,\"FSSE-MEM\",\"FSSE-ATL\",\"Q4       - \",\"FedExForum\",1],[\"2017-03-11T00:00:00\",10,\"0021600982\",3,\"Final\",\"20170311/PHXDAL\",1610612742,1610612756,\"2016\",4,\"     \",null,\"FSSW-DAL\",\"FSA\",\"Q4       - \",\"American Airlines Center\",1],[\"2017-03-11T00:00:00\",11,\"0021600983\",3,\"Final\",\"20170311/WASPOR\",1610612757,1610612764,\"2016\",5,\"     \",null,\"CSN-POR\",\"CSN-W\",\"Q5       - \",\"Moda Center\",1],[\"2017-03-11T00:00:00\",12,\"0021600984\",3,\"Final\",\"20170311/DENSAC\",1610612758,1610612743,\"2016\",4,\"     \",null,\"NBCS-CA\",\"ASE\",\"Q4       - \",\"Golden 1 Center\",1]]},{\"name\":\"LineScore\",\"headers\":[\"GAME_DATE_EST\",\"GAME_SEQUENCE\",\"GAME_ID\",\"TEAM_ID\",\"TEAM_ABBREVIATION\",\"TEAM_CITY_NAME\",\"TEAM_NAME\",\"TEAM_WINS_LOSSES\",\"PTS_QTR1\",\"PTS_QTR2\",\"PTS_QTR3\",\"PTS_QTR4\",\"PTS_OT1\",\"PTS_OT2\",\"PTS_OT3\",\"PTS_OT4\",\"PTS_OT5\",\"PTS_OT6\",\"PTS_OT7\",\"PTS_OT8\",\"PTS_OT9\",\"PTS_OT10\",\"PTS\",\"FG_PCT\",\"FT_PCT\",\"FG3_PCT\",\"AST\",\"REB\",\"TOV\"],\"rowSet\":[[\"2017-03-11T00:00:00\",1,\"0021600973\",1610612762,\"UTA\",\"Utah\",\"Jazz\",\"41-25\",23,25,28,28,0,0,0,0,0,0,0,0,0,0,104,0.480,0.821,0.450,15,36,12],[\"2017-03-11T00:00:00\",1,\"0021600973\",1610612760,\"OKC\",\"Oklahoma City\",\"Thunder\",\"37-29\",29,33,29,21,0,0,0,0,0,0,0,0,0,0,112,0.500,0.750,0.348,23,43,12],[\"2017-03-11T00:00:00\",2,\"0021600974\",1610612755,\"PHI\",\"Philadelphia\",\"76ers\",\"23-42\",30,27,22,21,0,0,0,0,0,0,0,0,0,0,100,0.476,0.714,0.333,28,41,16],[\"2017-03-11T00:00:00\",2,\"0021600974\",1610612746,\"LAC\",\"LA\",\"Clippers\",\"40-26\",32,24,19,37,0,0,0,0,0,0,0,0,0,0,112,0.494,0.828,0.320,25,41,13],[\"2017-03-11T00:00:00\",3,\"0021600975\",1610612752,\"NYK\",\"New York\",\"Knicks\",\"26-40\",23,30,28,11,0,0,0,0,0,0,0,0,0,0,92,0.439,0.636,0.433,26,44,18],[\"2017-03-11T00:00:00\",3,\"0021600975\",1610612765,\"DET\",\"Detroit\",\"Pistons\",\"33-33\",35,31,23,23,0,0,0,0,0,0,0,0,0,0,112,0.479,0.579,0.333,27,51,7],[\"2017-03-11T00:00:00\",4,\"0021600976\",1610612740,\"NOP\",\"New Orleans\",\"Pelicans\",\"26-40\",32,27,24,29,13,0,0,0,0,0,0,0,0,0,125,0.505,0.688,0.412,33,47,10],[\"2017-03-11T00:00:00\",4,\"0021600976\",1610612766,\"CHA\",\"Charlotte\",\"Hornets\",\"29-37\",27,31,20,34,10,0,0,0,0,0,0,0,0,0,122,0.451,0.850,0.283,32,50,9],[\"2017-03-11T00:00:00\",5,\"0021600977\",1610612739,\"CLE\",\"Cleveland\",\"Cavaliers\",\"43-21\n";

    JsonParserHelper jsonParserHelper;


    @Before
    public void setup() {
        jsonParserHelper = new JsonParserHelper(jsonString);
    }


    @Test
    public void test() {

        jsonParserHelper.getGames();



    }

}
