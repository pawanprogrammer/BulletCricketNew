package com.trishasofttech.bulletcricketlive.livetabs;


import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.google.gson.JsonObject;
import com.trishasofttech.bulletcricketlive.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Liveline extends Fragment {
    String sKey = "";
    TextView line_final_result, line_info, line_team1, line_team2, line_runs_, line_target_, line_crr_, line_overs_,
    line_rrr, line_ballsreq, line_run_req, line_mr1, line_mr2;
    String tokenid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.liveline_layout, container, false);
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
        tokenid = sp.getString("tokenid", null);        Bundle bundle = this.getArguments();
        if (bundle != null) {
            sKey = bundle.getString("skey", "defaultValue");
            loadline(sKey, tokenid);
            //    Toast.makeText(getActivity(), sKey, Toast.LENGTH_SHORT).show();
        }
        //loadmatch();
        return v;
    }    private void loadline(String url, String tokenid) {
        final String lineUrl = "https://rest.cricketapi.com/rest/v2/match/" + sKey + "/?access_token="+tokenid;

        StringRequest request = new StringRequest(0, lineUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText ( getActivity (),response+" ScoreCard",Toast.LENGTH_LONG ).show ();
                try {
                    JSONObject jObjresponce = new JSONObject(response);
                    JSONObject jObjdata = jObjresponce.getJSONObject("data");
                    JSONObject jObjCard = jObjdata.getJSONObject("card");
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