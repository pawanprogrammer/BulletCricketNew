package com.trishasofttech.bulletcricketlive.livetabs;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.trishasofttech.bulletcricketlive.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Liveline extends Fragment {
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_A = new ArrayList<>();
    String sKey = "";
    TextView line_final_result, line_info, line_team1, line_team2, line_runs_, line_target_, line_crr_, line_overs_,
            line_rrr, line_ballsreq, line_run_req, line_mr1, line_mr2,
            line_lastball1,line_lastball2,line_lastball3,line_lastball4,line_lastball5,line_lastball6;
    TextView tv_mini_batsman1, tv_mini_batsman2, tv_mini_run1, tv_mini_run2, tv_mini_ball1, tv_mini_ball2,
            tv_mini_4s1, tv_mini_4s2, tv_mini_6s1, tv_mini_6s2, tv_mini_sr1, tv_mini_sr2,
            tv_mini_bowler1,tv_mini_over1, tv_mini_maidan1,tv_mini_bowler_runs1,tv_mini_wicket1,tv_mini_eco1;
    Handler handler;
    String tokenid;
    String sbatsman1, sbatsman2, sbowler1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.liveline_layout, container, false);
        /*mini scorecard*/
        tv_mini_batsman1= v.findViewById(R.id.tv_mini_batsman1);
        tv_mini_batsman2= v.findViewById(R.id.tv_mini_batsman2);
        tv_mini_run1= v.findViewById(R.id.tv_mini_run1);
        tv_mini_run2= v.findViewById(R.id.tv_mini_run2);
        tv_mini_ball1= v.findViewById(R.id.tv_mini_ball1);
        tv_mini_ball2= v.findViewById(R.id.tv_mini_ball2);
        tv_mini_4s1= v.findViewById(R.id.tv_mini_4s1);
        tv_mini_4s2= v.findViewById(R.id.tv_mini_4s2);
        tv_mini_6s1= v.findViewById(R.id.tv_mini_6s1);
        tv_mini_6s2= v.findViewById(R.id.tv_mini_6s2);
        tv_mini_sr1= v.findViewById(R.id.tv_mini_sr1);
        tv_mini_sr2= v.findViewById(R.id.tv_mini_sr2);
        tv_mini_bowler1 = v.findViewById(R.id.tv_mini_bowler1);
        tv_mini_over1 = v.findViewById(R.id.tv_mini_over1);
        tv_mini_maidan1 =v.findViewById(R.id.tv_mini_maidan1);
        tv_mini_bowler_runs1 =v.findViewById(R.id.tv_mini_bowler_runs1);
        tv_mini_wicket1 = v.findViewById(R.id.tv_mini_wicket1);
        tv_mini_eco1 = v.findViewById(R.id.tv_mini_eco1);

        line_lastball1 = v.findViewById(R.id.line_lastball1);
        line_lastball2 = v.findViewById(R.id.line_lastball2);
        line_lastball3 = v.findViewById(R.id.line_lastball3);
        line_lastball4 = v.findViewById(R.id.line_lastball4);
        line_lastball5 = v.findViewById(R.id.line_lastball5);
        line_lastball6 = v.findViewById(R.id.line_lastball6);

        line_mr1 = v.findViewById(R.id.line_mr1);
        line_mr2 = v.findViewById(R.id.line_mr2);
        line_final_result=v.findViewById(R.id.line_final);
        line_info=v.findViewById(R.id.line_info);
        line_team1=v.findViewById(R.id.line_team1);
        line_team2=v.findViewById(R.id.line_team2);
        line_runs_ = v.findViewById(R.id.line_runs_);
        line_overs_ = v.findViewById(R.id.line_overs_);
        line_target_ = v.findViewById(R.id.line_target_);
        line_ballsreq = v.findViewById(R.id.line_ballsreq_);
        line_rrr = v.findViewById(R.id.line_rrr_);
        line_run_req = v.findViewById(R.id.line_runreq_);
        line_crr_ = v.findViewById(R.id.line_crr_);
        SharedPreferences sp = getActivity().getSharedPreferences("tokenpref", 0);
        tokenid = sp.getString("tokenid", null);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            sKey = bundle.getString("skey", "defaultValue");
            loadline(sKey, tokenid);

            /*handler = new Handler();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    while (true) {
                        try {
                            Thread.sleep(2000);
                            handler.post(new Runnable() {

                                @Override
                                public void run() {
                                    // TODO Auto-generated method stub
                                    // Write your code here to update the UI.
                                    loadline(sKey, tokenid);
                                }
                            });
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }
            }).start();*/


        }

        /*if (bundle!=null)
        {
            sKey = bundle.getString("skey", "defaultValue");
            loadlastsixball(sKey, tokenid);
        }*/
        //loadmatch();
        return v;
    }

    private void loadline(String url, String tokenid) {
        final String lineUrl = "https://rest.cricketapi.com/rest/v2/match/" + sKey + "/?access_token="+tokenid;

        StringRequest request = new StringRequest(0, lineUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText ( getActivity (),response+" ScoreCard",Toast.LENGTH_LONG ).show ();
                try {
                    JSONObject jObjresponce = new JSONObject(response);
                    JSONObject jObjdata = jObjresponce.getJSONObject("data");
                    JSONObject jObjCard = jObjdata.getJSONObject("card");
                    /*get mini scorecard for dynamic */
                    JSONObject jObjNow = jObjCard.getJSONObject("now");
                    JSONObject jObjbat_player = jObjNow.getJSONObject("last_ball");
                    sbatsman1 = jObjbat_player.getString("striker");
                    sbatsman2 = jObjbat_player.getString("nonstriker");
                    JSONObject jObjbow_player = jObjbat_player.getJSONObject("bowler");
                    sbowler1 = jObjbow_player.getString("key");
                    JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                    Iterator keys = jObjPlayerA.keys();
                    while (keys.hasNext()) {
                        // loop to get the dynamic key
                        String currentDynamicKey = (String) keys.next();
                        if (currentDynamicKey.equalsIgnoreCase(sbatsman1)) {
                            JSONObject currentDynamicValue = jObjPlayerA.getJSONObject ( currentDynamicKey );
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put ( "name" , currentDynamicValue.getString ( "fullname" ) );

                            tv_mini_batsman1.setText(currentDynamicValue.getString ( "fullname" ));
                            JSONObject jObjmatch = currentDynamicValue.getJSONObject ( "match" );
                            JSONObject jObjinnings = jObjmatch.getJSONObject ( "innings" );
                            JSONObject jObj_1 = jObjinnings.getJSONObject ( "1" );
                            JSONObject jObjBatting = jObj_1.getJSONObject ( "batting" );

                            if (jObjBatting.has ( "runs" )) {
                                tv_mini_run1.setText(String.valueOf ( jObjBatting.getInt ( "runs" ) )) ;
                                tv_mini_ball1.setText (String.valueOf ( jObjBatting.getInt ( "balls" ) ) );
                                tv_mini_4s1.setText(String.valueOf ( jObjBatting.getInt ( "fours" ) ) );
                                tv_mini_6s1.setText(String.valueOf ( jObjBatting.getInt ( "sixes" ) ) );
                                tv_mini_sr1.setText ( String.valueOf ( jObjBatting.getInt ( "strike_rate" ) ) );
                            }

                        }

                        /*2nd player data*/
                        if (currentDynamicKey.equalsIgnoreCase(sbatsman2)) {
                            JSONObject currentDynamicValue = jObjPlayerA.getJSONObject ( currentDynamicKey );

                            tv_mini_batsman2.setText(currentDynamicValue.getString ( "fullname" ));
                            JSONObject jObjmatch = currentDynamicValue.getJSONObject ( "match" );
                            JSONObject jObjinnings = jObjmatch.getJSONObject ( "innings" );
                            JSONObject jObj_1 = jObjinnings.getJSONObject ( "1" );
                            JSONObject jObjBatting = jObj_1.getJSONObject ( "batting" );

                            if (jObjBatting.has ( "runs" )) {
                                tv_mini_run2.setText(String.valueOf ( jObjBatting.getInt ( "runs" ) )) ;
                                tv_mini_ball2.setText (String.valueOf ( jObjBatting.getInt ( "balls" ) ) );
                                tv_mini_4s2.setText(String.valueOf ( jObjBatting.getInt ( "fours" ) ) );
                                tv_mini_6s2.setText(String.valueOf ( jObjBatting.getInt ( "sixes" ) ) );
                                tv_mini_sr2.setText ( String.valueOf ( jObjBatting.getInt ( "strike_rate" ) ) );
                            }

                        }

                        /*current bowler data*/
                        if (currentDynamicKey.equalsIgnoreCase(sbowler1)) {
                            JSONObject currentDynamicValue = jObjPlayerA.getJSONObject ( currentDynamicKey );

                            tv_mini_bowler1.setText(currentDynamicValue.getString ( "fullname" ));
                            JSONObject jObjmatch = currentDynamicValue.getJSONObject ( "match" );
                            JSONObject jObjinnings = jObjmatch.getJSONObject ( "innings" );
                            JSONObject jObj_1 = jObjinnings.getJSONObject ( "1" );
                            JSONObject jObjBatting = jObj_1.getJSONObject ( "bowling" );
                            //hashMap.put("out_str", jObjBatting.getString("out_str"));
                            if (jObjBatting.has ( "dots" )) {
                                tv_mini_bowler_runs1.setText(String.valueOf ( jObjBatting.getInt ( "runs" ) ) );
                                tv_mini_over1.setText(  String.valueOf ( jObjBatting.getInt ( "overs" ) ) );
                                tv_mini_maidan1.setText( String.valueOf ( jObjBatting.getInt ( "maiden_overs" ) ) );
                                tv_mini_wicket1.setText (String.valueOf ( jObjBatting.getInt ( "wickets" ) ) );
                                tv_mini_eco1.setText ( String.valueOf ( jObjBatting.getInt ( "economy" ) ) );
                                    /*if (jObjBatting.getBoolean ( "dismissed" )) {
                                        hashMap.put ( "out_str" , jObjBatting.getString ( "out_str" ) );
                                    } else {
                                        hashMap.put ( "out_str" , "Not Out" );
                                    }*/
                                //hashMap.put("out_str", jObjBatting.getString("out_str"));
                            }
                        }
                    }

                            Toast.makeText(getActivity(), jObjbat_player.getString("striker"), Toast.LENGTH_SHORT).show();

                    /*to show the Team Match Name*/
                    line_info.setText(jObjCard.getString("name"));
                    JSONObject jObjTeam = jObjCard.getJSONObject("teams");
                    JSONObject jObjA = jObjTeam.getJSONObject("a");
                    JSONObject jObjB = jObjTeam.getJSONObject("b");

                    /*display the winning ratio*/
                    JSONObject jObjtWinning = jObjCard.getJSONObject("winning_ratio");
                    line_mr1.setText(jObjtWinning.getString("a"));
                    line_mr2.setText(jObjtWinning.getString("b"));

                    /*show the result of match*/
                    JSONObject jObjMsg = jObjCard.getJSONObject("msgs");
                    line_final_result.setText(jObjMsg.getString("result"));
                    String ateam = jObjA.getString("name");
                    String bteam = jObjB.getString("name");
                    JSONArray jArry_bat_order = jObjCard.getJSONArray("batting_order");
                    JSONArray jArray_bat_team = jArry_bat_order.getJSONArray(0);
                    String bat_team_1 = (String) jArray_bat_team.get(0);

                    JSONObject jObj_now = jObjCard.getJSONObject("now");
                    String jObj_now_1 = jObj_now.getString("batting_team");

                    /*get the last six ball*/
                    JSONArray jArrayRecent = jObj_now.getJSONArray("recent_overs");
                    JSONArray jArrayOver = jArrayRecent.getJSONArray(0);
                    JSONArray jArraylast = jArrayOver.getJSONArray(1);
                    for (int i=0; i<jArraylast.length(); i++)
                    {
                        HashMap<String, String> hash_lastball = new HashMap<>();
                        hash_lastball.put("lastball", jArraylast.get(i).toString());
                        ArryHashPlaying_Xi_A.add(hash_lastball);
                    }


                    //Toast.makeText(getActivity(), ArryHashPlaying_Xi_A.get(0).toString(), Toast.LENGTH_SHORT).show();
                    JSONObject jObjball = jObjCard.getJSONObject("balls");
                    // jObjball.getString(String.valueOf(ArryHashPlaying_Xi_A.get(0)));
                    // ArryHashPlaying_Xi_A.get ( ha_tetst.get ( "" ) )
                    // String test_key = String.valueOf(ArryHashPlaying_Xi_A.get(0).get ( "lastball" ));
                    //JSONObject jObjlastball = new JSONObject(ArryHashPlaying_Xi_A.get(0));




                    if (0 < ArryHashPlaying_Xi_A.size()) {
                        JSONObject jObjlastball = jObjball.getJSONObject(String.valueOf(ArryHashPlaying_Xi_A.get(0).get ( "lastball" )));
                        JSONObject jbastsman = jObjlastball.getJSONObject ("batsman");

                        line_lastball1.setText(jbastsman.getString ("runs"));
                        if (jObjCard.getString("status").equalsIgnoreCase("started"))
                        {
                            line_final_result.setText(jbastsman.getString ("runs")+"-"+jbastsman.getString ("runs")+
                                    "-"+jbastsman.getString ("runs"));
                        }

                        //tv_team_role1.setText(hash.get("role"));
                    }
                    if (1 < ArryHashPlaying_Xi_A.size()) {
                        JSONObject jObjlastball = jObjball.getJSONObject(String.valueOf(ArryHashPlaying_Xi_A.get(1).get ( "lastball" )));
                        JSONObject jbastsman = jObjlastball.getJSONObject ("batsman");

                        line_lastball2.setText(jbastsman.getString ("runs"));
                        if (jObjCard.getString("status").equalsIgnoreCase("started"))
                        {

                            line_final_result.setText(jbastsman.getString ("runs")+"-"+jbastsman.getString ("runs")+
                                    "-"+jbastsman.getString ("runs"));
                        }
                    }
                    if (2 < ArryHashPlaying_Xi_A.size()) {
                        JSONObject jObjlastball = jObjball.getJSONObject(String.valueOf(ArryHashPlaying_Xi_A.get(2).get ( "lastball" )));
                        JSONObject jbastsman = jObjlastball.getJSONObject ("batsman");

                        line_lastball3.setText(jbastsman.getString ("runs"));
                        if (jObjCard.getString("status").equalsIgnoreCase("started"))
                        {
                            line_final_result.setText(jbastsman.getString ("runs")+"-"+jbastsman.getString ("runs")+
                                "-"+jbastsman.getString ("runs"));
                        }
                    }
                    if (3 < ArryHashPlaying_Xi_A.size()) {
                        JSONObject jObjlastball = jObjball.getJSONObject(String.valueOf(ArryHashPlaying_Xi_A.get(3).get ( "lastball" )));
                        JSONObject jbastsman = jObjlastball.getJSONObject ("batsman");

                        line_lastball4.setText(jbastsman.getString ("runs"));
                        if (jObjCard.getString("status").equalsIgnoreCase("started"))
                        {
                            line_final_result.setText(jbastsman.getString ("runs")+"-"+jbastsman.getString ("runs")+
                                    "-"+jbastsman.getString ("runs"));
                        }
                        //tv_team_role4.setText(hash_3.get("role"));
                    }
                    if (4 < ArryHashPlaying_Xi_A.size()) {
                        JSONObject jObjlastball = jObjball.getJSONObject(String.valueOf(ArryHashPlaying_Xi_A.get(4).get ( "lastball" )));
                        JSONObject jbastsman = jObjlastball.getJSONObject ("batsman");

                        line_lastball5.setText(jbastsman.getString ("runs"));
                        if (jObjCard.getString("status").equalsIgnoreCase("started"))
                        {
                            line_final_result.setText(jbastsman.getString ("runs")+"-"+jbastsman.getString ("runs")+
                                    "-"+jbastsman.getString ("runs"));
                        }
                    }

                    if (5 < ArryHashPlaying_Xi_A.size()) {
                        JSONObject jObjlastball = jObjball.getJSONObject(String.valueOf(ArryHashPlaying_Xi_A.get(5).get ( "lastball" )));
                        JSONObject jbastsman = jObjlastball.getJSONObject ("batsman");

                        line_lastball6.setText(jbastsman.getString ("runs"));
                        if (jObjCard.getString("status").equalsIgnoreCase("started"))
                        {
                            line_final_result.setText(jbastsman.getString ("runs")+"-"+jbastsman.getString ("runs")+
                                    "-"+jbastsman.getString ("runs"));
                        }
                    }


                    //Toast.makeText(getActivity(), jArraylast.get(0).toString(), Toast.LENGTH_SHORT).show();
                    if (jObj_now_1.equals("a"))
                    {
                        line_team1.setText(ateam);
                        line_team2.setText(bteam);
                        line_runs_.setText(jObj_now.getString("runs")+" / "+
                                jObj_now.getString("wicket"));
                        line_crr_.setText(jObj_now.getString("run_rate"));
                        String originalString = jObj_now.getString("runs_str");
                        String overs;
                        if (originalString.length() > 7)
                        {
                            overs = originalString.substring(originalString.length() - 7);
                        }
                        else
                        {
                            overs = originalString;
                        }

                        line_overs_.setText(overs);

                        JSONObject jObjReq = jObj_now.getJSONObject("req");
                        String target_run = jObjReq.getString("target_runs");
                        line_target_.setText(target_run);
                        line_run_req.setText(jObjReq.getString("runs"));
                        line_ballsreq.setText(jObjReq.getString("balls"));
                        line_rrr.setText(jObjReq.getString("runs_rate"));
                    }
                    else {
                        line_team1.setText(bteam);
                        line_team2.setText(ateam);
                        line_runs_.setText(jObj_now.getString("runs")+" / "+
                                jObj_now.getString("wicket"));
                        line_crr_.setText(jObj_now.getString("run_rate"));
                        String originalString = jObj_now.getString("runs_str");
                        String overs;
                        if (originalString.length() > 7)
                        {
                            overs = originalString.substring(originalString.length() - 7);
                        }
                        else
                        {
                            overs = originalString;
                        }

                        line_overs_.setText(overs);

                        JSONObject jObjReq = jObj_now.getJSONObject("req");
                        String target_run = jObjReq.getString("target_runs");
                        line_target_.setText(target_run);
                        line_run_req.setText(jObjReq.getString("runs"));
                        line_ballsreq.setText(jObjReq.getString("balls"));
                        line_rrr.setText(jObjReq.getString("runs_rate"));
                    }

                    /*get the current batting team score*/
                    /*if (bat_team_1.equals("a"))
                    {
                        line_team1.setText(ateam);
                        line_team2.setText(bteam);
                        JSONObject jObj_inning = jObjCard.getJSONObject("innings");
                        JSONObject jObj_inning_a = jObj_inning.getJSONObject("a_1");
                        line_runs_.setText(jObj_inning_a.getString("runs")+" / "+
                                jObj_inning_a.getString("wickets"));
                        line_crr_.setText(jObj_inning_a.getString("run_rate"));
                        line_overs_.setText(jObj_inning_a.getString("overs"));
                    }
                    if (bat_team_1.equals("b"))
                    {
                        line_team1.setText(bteam);
                        line_team2.setText(ateam);
                        JSONObject jObj_inning = jObjCard.getJSONObject("innings");
                        JSONObject jObj_inning_b = jObj_inning.getJSONObject("b_1");
                        line_runs_.setText(jObj_inning_b.getString("runs")+" / "+
                                jObj_inning_b.getString("wickets"));
                        line_crr_.setText(jObj_inning_b.getString("run_rate"));
                        line_overs_.setText(jObj_inning_b.getString("overs"));
                    }*/

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}