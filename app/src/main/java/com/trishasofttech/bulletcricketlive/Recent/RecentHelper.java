package com.trishasofttech.bulletcricketlive.Recent;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class RecentHelper {
    public static ArrayList<HashMap<String, String>> arrLiveData = new ArrayList<>();
    public static String[] match;
    public static String[] matchtype;
    public static String[] matchvenue;
    public static String[] matchseries;
    public static String[] matchdate;
    private static String json;
    public static long[] id;

    public RecentHelper(String json) {
        this.json = json;
    }

    public static void livehelper() {

        JSONObject jo = null;
        try {
            jo = new JSONObject(json);
            JSONObject jo1 = jo.getJSONObject("data");
            JSONArray ja = jo1.getJSONArray("cards");
            match = new String[ja.length()];
            matchtype = new String[ja.length()];
            matchvenue = new String[ja.length()];
            matchseries = new String[ja.length()];
            matchdate = new String[ja.length()];
            id = new long[ja.length()];
            //scorecard=new String[jsonArray.length()];
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo2 = ja.getJSONObject(i);
                if (jo2.getString("status").toString().equalsIgnoreCase("completed")
                /*|| jo2.getString("status").toString().equalsIgnoreCase("started")
                || jo2.getString("status").toString().equalsIgnoreCase("notstarted")*/)
                {
                    HashMap<String, String> hashMap = new HashMap<>();
                    if(jo2.getString("status").toString().equalsIgnoreCase("notstarted")) {
                        JSONObject Jstart_date = jo2.getJSONObject ( "start_date" );

                        hashMap.put("start_date", Jstart_date.getString("timestamp"));
                    }else {

                        hashMap.put("start_date", "Vs");
                    }
                    JSONObject jObjresult = jo2.getJSONObject("msgs");
                    hashMap.put("match_result", jObjresult.getString("completed"));
                    hashMap.put("matchseries", jo2.getString("name"));
                    hashMap.put("key", jo2.getString("key"));
                    JSONObject jobjTeam = jo2.getJSONObject("teams");
                    JSONObject jObjteamA = jobjTeam.getJSONObject("a");
                    hashMap.put("aTeam", jObjteamA.getString("key"));
                    JSONObject jObjteamB = jobjTeam.getJSONObject("b");
                    hashMap.put("bTeam", jObjteamB.getString("key"));

                    if (jo2.getString("format").toString().equalsIgnoreCase("test")) {
                        JSONObject jobjIning = jo2.getJSONObject("innings");

                        if(jobjIning.has ( "b_1" )) {

                            JSONObject jObjb_1 = jobjIning.getJSONObject ( "b_1" );
                            hashMap.put ( "b_1" , jObjb_1.getString ( "run_str" ) );
                            hashMap.put ( "bruns" , jObjb_1.getString ( "runs" ) );
                            hashMap.put ( "bwickets" , jObjb_1.getString ( "wickets" ) );
                            hashMap.put ( "bovers" , jObjb_1.getString ( "overs" ) );
                        }

                        if(jobjIning.has ( "a_1" )){

                            JSONObject jObja_1 = jobjIning.getJSONObject ( "a_1" );
                            hashMap.put ( "a_1" , jObja_1.getString ( "run_str" ) );
                            hashMap.put ( "aruns" , jObja_1.getString ( "runs" ) );
                            hashMap.put ( "awickets" , jObja_1.getString ( "wickets" ) );
                            hashMap.put ( "aovers" , jObja_1.getString ( "overs" ) );
                        }

                    }
                    if (jo2.getString("format").toString().equalsIgnoreCase("t20")) {

                        JSONObject jobjIning = jo2.getJSONObject("innings");
                        if(jobjIning.has ( "b_1" )) {


                            JSONObject jObjb_1 = jobjIning.getJSONObject ( "b_1" );
                            hashMap.put ( "b_1" , jObjb_1.getString ( "run_str" ) );
                            hashMap.put ( "bruns" , jObjb_1.getString ( "runs" ) );
                            hashMap.put ( "bwickets" , jObjb_1.getString ( "wickets" ) );
                            hashMap.put ( "bovers" , jObjb_1.getString ( "overs" ) );
                        }

                        if(jobjIning.has ( "a_1" )) {

                            JSONObject jObja_1 = jobjIning.getJSONObject ( "a_1" );
                            hashMap.put ( "a_1" , jObja_1.getString ( "run_str" ) );
                            hashMap.put ( "aruns" , jObja_1.getString ( "runs" ) );
                            hashMap.put ( "awickets" , jObja_1.getString ( "wickets" ) );
                            hashMap.put ( "aovers" , jObja_1.getString ( "overs" ) );
                        }

                    }


                    arrLiveData.add(hashMap);

                    match[i] = jo2.getString("related_name");
                    matchtype[i] = jo2.getString("format");
                    matchvenue[i] = jo2.getString("venue");
                    JSONObject jo3 = jo2.getJSONObject("season");
                    matchseries[i] = jo3.getString("name");
                    JSONObject jo4 = jo2.getJSONObject("start_date");
                    matchdate[i] = jo4.getString("iso");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
