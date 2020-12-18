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
import com.trishasofttech.bulletcricketlive.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SquadsTeam extends Fragment {
    String sKey = "";
    String tokenid;
    ArrayList<String> ArryPlaying_Xi_A_All = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_A_XI = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_A_Benchers = new ArrayList<>();

    ArrayList<String> ArryPlaying_Xi_B_All = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_B_XI = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_B_Benchers = new ArrayList<>();


    ArrayList<String> ArryPlaying_Xi_B = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_A = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_A_Benchers = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_B_Benchers = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_A = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_B = new ArrayList<>();
    TextView tv_teama_name, tv_teama_name1, tv_teama_name2, tv_teama_name3, tv_teama_name4, tv_teama_name5, tv_teama_name6, tv_teama_name7,
            tv_teama_name8, tv_teama_name9, tv_teama_name10, tv_teama_name11, tv_teama_name12, tv_teama_name13, tv_teama_name14
            , tv_teama_name15, tv_teama_name16, tv_teama_name17;
    TextView tv_teamb_name, tv_teamb_name1, tv_teamb_name2, tv_teamb_name3, tv_teamb_name4, tv_teamb_name5, tv_teamb_name6, tv_teamb_name7, tv_teamb_name8,
            tv_teamb_name9, tv_teamb_name10, tv_teamb_name11, tv_teamb_name12, tv_teamb_name13, tv_teamb_name14, tv_teamb_name15
            , tv_teamb_name16, tv_teamb_name17;


    TextView tv_team_role1, tv_team_role2, tv_team_role3, tv_team_role4, tv_team_role5, tv_team_role6, tv_team_role7,
            tv_team_role8, tv_team_role9, tv_team_role10, tv_team_role11, tv_team_role12, tv_team_role13, tv_team_role14
            , tv_team_role15, tv_team_role16, tv_team_role17;
    TextView tv_teamb_role1, tv_teamb_role2, tv_teamb_role3, tv_teamb_role4, tv_teamb_role5, tv_teamb_role6, tv_teamb_role7,
            tv_teamb_role8, tv_teamb_role9, tv_teamb_role10, tv_teamb_role11, tv_teamb_role12, tv_teamb_role13, tv_teamb_role14
            , tv_teamb_role15, tv_teamb_role16, tv_teamb_role17;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.squads_layout, container, false);

        /*player role*/
        tv_teamb_role1 = v.findViewById(R.id.tv_teamb_role1);
        tv_teamb_role2 = v.findViewById(R.id.tv_teamb_role2);
        tv_teamb_role3 = v.findViewById(R.id.tv_teamb_role3);
        tv_teamb_role4 = v.findViewById(R.id.tv_teamb_role4);
        tv_teamb_role5 = v.findViewById(R.id.tv_teamb_role5);
        tv_teamb_role6 = v.findViewById(R.id.tv_teamb_role6);
        tv_teamb_role7 = v.findViewById(R.id.tv_teamb_role7);
        tv_teamb_role8 = v.findViewById(R.id.tv_teamb_role8);
        tv_teamb_role9 = v.findViewById(R.id.tv_teamb_role9);
        tv_teamb_role10 = v.findViewById(R.id.tv_teamb_role10);
        tv_teamb_role11 = v.findViewById(R.id.tv_teamb_role11);
        tv_teamb_role12 = v.findViewById(R.id.tv_teamb_role12);
        tv_teamb_role13 = v.findViewById(R.id.tv_teamb_role13);
        tv_teamb_role14 = v.findViewById(R.id.tv_teamb_role14);
        tv_teamb_role15 = v.findViewById(R.id.tv_teamb_role15);
        tv_teamb_role16 = v.findViewById(R.id.tv_teamb_role16);
        tv_teamb_role17 = v.findViewById(R.id.tv_teamb_role17);

        tv_team_role1 = v.findViewById(R.id.tv_teama_role1);
        tv_team_role2 = v.findViewById(R.id.tv_teama_role2);
        tv_team_role3 = v.findViewById(R.id.tv_teama_role3);
        tv_team_role4 = v.findViewById(R.id.tv_teama_role4);
        tv_team_role5 = v.findViewById(R.id.tv_teama_role5);
        tv_team_role6 = v.findViewById(R.id.tv_teama_role6);
        tv_team_role7 = v.findViewById(R.id.tv_teama_role7);
        tv_team_role8 = v.findViewById(R.id.tv_teama_role8);
        tv_team_role9 = v.findViewById(R.id.tv_teama_role9);
        tv_team_role10 = v.findViewById(R.id.tv_teama_role10);
        tv_team_role11 = v.findViewById(R.id.tv_teama_role11);
        tv_team_role12 = v.findViewById(R.id.tv_teama_role12);
        tv_team_role13 = v.findViewById(R.id.tv_teama_role13);
        tv_team_role14 = v.findViewById(R.id.tv_teama_role14);
        tv_team_role15 = v.findViewById(R.id.tv_teama_role15);
        tv_team_role16 = v.findViewById(R.id.tv_teama_role16);
        tv_team_role17 = v.findViewById(R.id.tv_teama_role17);


        tv_teama_name = v.findViewById(R.id.tv_teama_name);
        tv_teama_name1 = v.findViewById(R.id.tv_teama_name1);
        tv_teama_name2 = v.findViewById(R.id.tv_teama_name2);
        tv_teama_name3 = v.findViewById(R.id.tv_teama_name3);
        tv_teama_name4 = v.findViewById(R.id.tv_teama_name4);
        tv_teama_name5 = v.findViewById(R.id.tv_teama_name5);
        tv_teama_name6 = v.findViewById(R.id.tv_teama_name6);
        tv_teama_name7 = v.findViewById(R.id.tv_teama_name7);
        tv_teama_name8 = v.findViewById(R.id.tv_teama_name8);
        tv_teama_name9 = v.findViewById(R.id.tv_teama_name9);
        tv_teama_name10 = v.findViewById(R.id.tv_teama_name10);
        tv_teama_name11 = v.findViewById(R.id.tv_teama_name11);
        tv_teama_name12 = v.findViewById(R.id.tv_teama_name12);
        tv_teama_name13 = v.findViewById(R.id.tv_teama_name13);
        tv_teama_name14 = v.findViewById(R.id.tv_teama_name14);
        tv_teama_name15 = v.findViewById(R.id.tv_teama_name15);
        tv_teama_name16 = v.findViewById(R.id.tv_teama_name16);
        tv_teama_name17 = v.findViewById(R.id.tv_teama_name17);


        tv_teamb_name = v.findViewById(R.id.tv_teamb_name);
        tv_teamb_name1 = v.findViewById(R.id.tv_teamb_name1);
        tv_teamb_name2 = v.findViewById(R.id.tv_teamb_name2);
        tv_teamb_name3 = v.findViewById(R.id.tv_teamb_name3);
        tv_teamb_name4 = v.findViewById(R.id.tv_teamb_name4);
        tv_teamb_name5 = v.findViewById(R.id.tv_teamb_name5);
        tv_teamb_name6 = v.findViewById(R.id.tv_teamb_name6);
        tv_teamb_name7 = v.findViewById(R.id.tv_teamb_name7);
        tv_teamb_name8 = v.findViewById(R.id.tv_teamb_name8);
        tv_teamb_name9 = v.findViewById(R.id.tv_teamb_name9);
        tv_teamb_name10 = v.findViewById(R.id.tv_teamb_name10);
        tv_teamb_name11 = v.findViewById(R.id.tv_teamb_name11);
        tv_teamb_name12 = v.findViewById(R.id.tv_teamb_name12);
        tv_teamb_name13 = v.findViewById(R.id.tv_teamb_name13);
        tv_teamb_name14 = v.findViewById(R.id.tv_teamb_name14);
        tv_teamb_name15 = v.findViewById(R.id.tv_teamb_name15);
        tv_teamb_name16 = v.findViewById(R.id.tv_teamb_name16);
        tv_teamb_name17 = v.findViewById(R.id.tv_teamb_name17);

        SharedPreferences sp = getActivity().getSharedPreferences("tokenpref", 0);
        tokenid = sp.getString("tokenid", null);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            sKey = bundle.getString("skey", "defaultValue");
            loadline(sKey, tokenid);
            //    Toast.makeText(getActivity(), sKey, Toast.LENGTH_SHORT).show();
        }
        //loadmatch();
        return v;
    }

    private void loadline(String url, String tokenid) {

        final String lineUrl = "https://rest.cricketapi.com/rest/v2/match/" + sKey + "/?access_token=" + tokenid;

        StringRequest request = new StringRequest(0, lineUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jObjresponce = new JSONObject(response);
                    JSONObject jObjdata = jObjresponce.getJSONObject("data");
                    JSONObject jObjCard = jObjdata.getJSONObject("card");
                    JSONObject jObjTeam = jObjCard.getJSONObject("teams");
                    JSONObject jObjA = jObjTeam.getJSONObject("a");
                    JSONObject jObjB = jObjTeam.getJSONObject("b");
                    //  tv_teama_inning_1.setText(jObjA.getString("name"));
                    tv_teama_name.setText(jObjA.getString("name"));
                    tv_teamb_name.setText(jObjB.getString("name"));

                    /*Team before match*/
                    if(jObjCard.getString("status").equalsIgnoreCase("notstarted"))
                    {
                        //Batting Team A
                        JSONObject jObjMatchA = jObjA.getJSONObject("match");
                        JSONArray jArraPlay_Xi_A = jObjMatchA.getJSONArray("players");
                        for (int i = 0; i < jArraPlay_Xi_A.length(); i++) {
                            ArryPlaying_Xi_A.add(jArraPlay_Xi_A.getString(i));
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.size()+"", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.get(i), Toast.LENGTH_LONG).show();
                        }
                        // get the value of the dynamic key of playing player
                        for (int j = 0; j < ArryPlaying_Xi_A.size(); j++) {
                            JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                            Iterator keys = jObjPlayerA.keys();
                            while (keys.hasNext()) {
                                // loop to get the dynamic key
                                String currentDynamicKey = (String) keys.next();
                                if (ArryPlaying_Xi_A.get(j).equalsIgnoreCase(currentDynamicKey)) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    JSONObject currentDynamicValue = jObjPlayerA.getJSONObject(currentDynamicKey);
                                    hashMap.put("name", currentDynamicValue.getString("fullname"));
                                    hashMap.put("role", currentDynamicValue.getString("seasonal_role"));
                                    ArryHashPlaying_Xi_A.add(hashMap);
                                }
                            }
                        }

                        //End Batting Team A
                        if (0 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash = ArryHashPlaying_Xi_A.get(0);
                            tv_teama_name1.setText(hash.get("name"));
                            tv_team_role1.setText(hash.get("role"));
                        }
                        if (1 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_1 = ArryHashPlaying_Xi_A.get(1);
                            tv_teama_name2.setText(hash_1.get("name"));
                            tv_team_role2.setText(hash_1.get("role"));
                        }
                        if (2 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_2 = ArryHashPlaying_Xi_A.get(2);
                            tv_teama_name3.setText(hash_2.get("name"));
                            tv_team_role3.setText(hash_2.get("role"));
                        }
                        if (3 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_3 = ArryHashPlaying_Xi_A.get(3);
                            tv_teama_name4.setText(hash_3.get("name"));
                            tv_team_role4.setText(hash_3.get("role"));
                        }
                        if (4 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_4 = ArryHashPlaying_Xi_A.get(4);
                            tv_teama_name5.setText(hash_4.get("name"));
                            tv_team_role5.setText(hash_4.get("role"));
                        }

                        if (5 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_5 = ArryHashPlaying_Xi_A.get(5);
                            tv_teama_name6.setText(hash_5.get("name"));
                            tv_team_role6.setText(hash_5.get("role"));
                        }

                        if (6 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_6 = ArryHashPlaying_Xi_A.get(6);
                            tv_teama_name7.setText(hash_6.get("name"));
                            tv_team_role7.setText(hash_6.get("role"));
                        }

                        if (7 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_7 = ArryHashPlaying_Xi_A.get(7);
                            tv_teama_name8.setText(hash_7.get("name"));
                            tv_team_role8.setText(hash_7.get("role"));
                        }

                        if (8 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_8 = ArryHashPlaying_Xi_A.get(8);
                            tv_teama_name9.setText(hash_8.get("name"));
                            tv_team_role9.setText(hash_8.get("role"));
                        }

                        if (9 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_9 = ArryHashPlaying_Xi_A.get(9);
                            tv_teama_name10.setText(hash_9.get("name"));
                            tv_team_role10.setText(hash_9.get("role"));
                        }

                        if (10 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_10 = ArryHashPlaying_Xi_A.get(10);
                            tv_teama_name11.setText(hash_10.get("name"));
                            tv_team_role11.setText(hash_10.get("role"));
                        }


                        if (11 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_11 = ArryHashPlaying_Xi_A.get(11);
                            tv_teama_name12.setText(hash_11.get("name"));
                            tv_team_role12.setText(hash_11.get("role"));
                        }

                        if (12 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_12 = ArryHashPlaying_Xi_A.get(12);
                            tv_teama_name13.setText(hash_12.get("name"));
                            tv_team_role13.setText(hash_12.get("role"));
                        }

                        if (13 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_13 = ArryHashPlaying_Xi_A.get(13);
                            tv_teama_name14.setText(hash_13.get("name"));
                            tv_team_role14.setText(hash_13.get("role"));
                        }

                        if (14 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_14 = ArryHashPlaying_Xi_A.get(14);
                            tv_teama_name15.setText(hash_14.get("name"));
                            tv_team_role15.setText(hash_14.get("role"));
                        }

                        if (15 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_15 = ArryHashPlaying_Xi_A.get(15);
                            tv_teama_name16.setText(hash_15.get("name"));
                            tv_team_role16.setText(hash_15.get("role"));
                        }

                        if (16 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_16 = ArryHashPlaying_Xi_A.get(16);
                            tv_teama_name17.setText(hash_16.get("name"));
                            tv_team_role17.setText(hash_16.get("role"));
                        }

                        //Batting Team B
                        JSONObject jObjMatchB = jObjB.getJSONObject("match");
                        JSONArray jArraPlay_Xi_B = jObjMatchB.getJSONArray("players");
                        for (int i = 0; i < jArraPlay_Xi_B.length(); i++) {
                            ArryPlaying_Xi_B.add(jArraPlay_Xi_B.getString(i));
                        }


                        // get the value of the dynamic key
                        for (int j = 0; j < ArryPlaying_Xi_B.size(); j++) {
                            JSONObject jObjPlayerB = jObjCard.getJSONObject("players");
                            Iterator keys = jObjPlayerB.keys();
                            while (keys.hasNext()) {
                                // loop to get the dynamic key
                                String currentDynamicKey = (String) keys.next();
                                if (ArryPlaying_Xi_B.get(j).equalsIgnoreCase(currentDynamicKey)) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    JSONObject currentDynamicValue = jObjPlayerB.getJSONObject(currentDynamicKey);
                                    hashMap.put("name", currentDynamicValue.getString("fullname"));
                                    hashMap.put("role", currentDynamicValue.getString("seasonal_role"));
                                    ArryHashPlaying_Xi_B.add(hashMap);
                                }
                            }
                        }

                        //End Batting Team A
                        if (0 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash = ArryHashPlaying_Xi_B.get(0);
                            tv_teamb_name1.setText(hash.get("name") );
                            tv_teamb_role1.setText(hash.get("role"));
                        }
                        if (1 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_1 = ArryHashPlaying_Xi_B.get(1);
                            tv_teamb_name2.setText(hash_1.get("name"));
                            tv_teamb_role2.setText(hash_1.get("role"));
                        }
                        if (2 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_2 = ArryHashPlaying_Xi_B.get(2);
                            tv_teamb_name3.setText(hash_2.get("name"));
                            tv_teamb_role3.setText(hash_2.get("role"));
                        }
                        if (3 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_3 = ArryHashPlaying_Xi_B.get(3);
                            tv_teamb_name4.setText(hash_3.get("name"));
                            tv_teamb_role4.setText(hash_3.get("role"));
                        }
                        if (4 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_4 = ArryHashPlaying_Xi_B.get(4);
                            tv_teamb_name5.setText(hash_4.get("name"));
                            tv_teamb_role5.setText(hash_4.get("role"));
                        }

                        if (5 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_5 = ArryHashPlaying_Xi_B.get(5);
                            tv_teamb_name6.setText(hash_5.get("name"));
                            tv_teamb_role6.setText(hash_5.get("role"));
                        }

                        if (6 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_6 = ArryHashPlaying_Xi_B.get(6);
                            tv_teamb_name7.setText(hash_6.get("name"));
                            tv_teamb_role7.setText(hash_6.get("role"));
                        }

                        if (7 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_7 = ArryHashPlaying_Xi_B.get(7);
                            tv_teamb_name8.setText(hash_7.get("name"));
                            tv_teamb_role8.setText(hash_7.get("role"));
                        }

                        if (8 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_8 = ArryHashPlaying_Xi_B.get(8);
                            tv_teamb_name9.setText(hash_8.get("name"));
                            tv_teamb_role9.setText(hash_8.get("role"));
                        }

                        if (9 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_9 = ArryHashPlaying_Xi_B.get(9);
                            tv_teamb_name10.setText(hash_9.get("name"));
                            tv_teamb_role10.setText(hash_9.get("role"));
                        }

                        if (10 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_10 = ArryHashPlaying_Xi_B.get(10);
                            tv_teamb_name11.setText(hash_10.get("name"));
                            tv_teamb_role11.setText(hash_10.get("role"));
                        }

                        if (11 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_11 = ArryHashPlaying_Xi_B.get(11);
                            tv_teamb_name12.setText(hash_11.get("name"));
                            tv_teamb_role12.setText(hash_11.get("role"));
                        }

                        if (12 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_12 = ArryHashPlaying_Xi_B.get(12);
                            tv_teamb_name13.setText(hash_12.get("name"));
                            tv_teamb_role13.setText(hash_12.get("role"));
                        }

                        if (13 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_13 = ArryHashPlaying_Xi_B.get(13);
                            tv_teamb_name14.setText(hash_13.get("name"));
                            tv_teamb_role14.setText(hash_13.get("role"));
                        }

                        if (14 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_14 = ArryHashPlaying_Xi_B.get(14);
                            tv_teamb_name15.setText(hash_14.get("name"));
                            tv_teamb_role15.setText(hash_14.get("role"));
                        }

                        if (15 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_15 = ArryHashPlaying_Xi_B.get(15);
                            tv_teamb_name16.setText(hash_15.get("name"));
                            tv_teamb_role16.setText(hash_15.get("role"));
                        }

                        if (16 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_16 = ArryHashPlaying_Xi_B.get(16);
                            tv_teamb_name17.setText(hash_16.get("name"));
                            tv_teamb_role17.setText(hash_16.get("role"));
                        }

                    }

                    /*-----------------------------------------------------------------------------------*/

                    else {

                        //Toast.makeText(getActivity(), "running match", Toast.LENGTH_SHORT).show();


                        //Batting Team A
                        JSONObject jObjMatchA = jObjA.getJSONObject("match");
                        JSONArray jArraPlay_Xi_A = jObjMatchA.getJSONArray("playing_xi");
                        JSONArray jArraPlay_Xi_All = jObjMatchA.getJSONArray("players");
                        for (int i = 0; i < jArraPlay_Xi_A.length(); i++) {
                            ArryPlaying_Xi_A_XI.add(jArraPlay_Xi_A.getString(i));
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.size()+"", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.get(i), Toast.LENGTH_LONG).show();
                        }

                        for (int i = 0; i < jArraPlay_Xi_All.length(); i++) {
                            ArryPlaying_Xi_A_All.add(jArraPlay_Xi_All.getString(i));
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.size()+"", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.get(i), Toast.LENGTH_LONG).show();
                        }

                        for (String item : ArryPlaying_Xi_A_All) {
                            if (ArryPlaying_Xi_A_XI.contains(item)) {
                                //duplicateList.add(item);
                            } else {
                                ArryPlaying_Xi_A_Benchers.add(item);
                            }

                        }


                        for (int i = 0; i < jArraPlay_Xi_A.length(); i++) {
                            ArryPlaying_Xi_A.add(jArraPlay_Xi_A.getString(i));
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.size()+"", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.get(i), Toast.LENGTH_LONG).show();
                        }
                        // get the value of the dynamic key of playing player
                        for (int j = 0; j < ArryPlaying_Xi_A.size(); j++) {
                            JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                            Iterator keys = jObjPlayerA.keys();
                            while (keys.hasNext()) {
                                // loop to get the dynamic key
                                String currentDynamicKey = (String) keys.next();
                                if (ArryPlaying_Xi_A.get(j).equalsIgnoreCase(currentDynamicKey)) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    JSONObject currentDynamicValue = jObjPlayerA.getJSONObject(currentDynamicKey);
                                    hashMap.put("name", currentDynamicValue.getString("fullname"));
                                    hashMap.put("role", currentDynamicValue.getString("seasonal_role"));
                                    ArryHashPlaying_Xi_A.add(hashMap);
                                }
                            }
                        }

                        /*get the value of dynamic key benchers players*/
                        for (int j = 0; j < ArryPlaying_Xi_A_Benchers.size(); j++) {
                            JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                            Iterator keys = jObjPlayerA.keys();
                            while (keys.hasNext()) {
                                // loop to get the dynamic key
                                String currentDynamicKey = (String) keys.next();
                                if (ArryPlaying_Xi_A_Benchers.get(j).equalsIgnoreCase(currentDynamicKey)) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    JSONObject currentDynamicValue = jObjPlayerA.getJSONObject(currentDynamicKey);
                                    hashMap.put("name", currentDynamicValue.getString("fullname"));
                                    hashMap.put("role", currentDynamicValue.getString("seasonal_role"));
                                    ArryHashPlaying_Xi_A_Benchers.add(hashMap);
                                    //Toast.makeText(getActivity(), ArryPlaying_Xi_A_Benchers.get(j), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        //End Batting Team A
                        if (0 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash = ArryHashPlaying_Xi_A.get(0);
                            tv_teama_name1.setText(hash.get("name"));
                            tv_team_role1.setText(hash.get("role"));
                        }
                        if (1 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_1 = ArryHashPlaying_Xi_A.get(1);
                            tv_teama_name2.setText(hash_1.get("name"));
                            tv_team_role2.setText(hash_1.get("role"));
                        }
                        if (2 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_2 = ArryHashPlaying_Xi_A.get(2);
                            tv_teama_name3.setText(hash_2.get("name"));
                            tv_team_role3.setText(hash_2.get("role"));
                        }
                        if (3 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_3 = ArryHashPlaying_Xi_A.get(3);
                            tv_teama_name4.setText(hash_3.get("name"));
                            tv_team_role4.setText(hash_3.get("role"));
                        }
                        if (4 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_4 = ArryHashPlaying_Xi_A.get(4);
                            tv_teama_name5.setText(hash_4.get("name"));
                            tv_team_role5.setText(hash_4.get("role"));
                        }

                        if (5 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_5 = ArryHashPlaying_Xi_A.get(5);
                            tv_teama_name6.setText(hash_5.get("name"));
                            tv_team_role6.setText(hash_5.get("role"));
                        }

                        if (6 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_6 = ArryHashPlaying_Xi_A.get(6);
                            tv_teama_name7.setText(hash_6.get("name"));
                            tv_team_role7.setText(hash_6.get("role"));
                        }

                        if (7 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_7 = ArryHashPlaying_Xi_A.get(7);
                            tv_teama_name8.setText(hash_7.get("name"));
                            tv_team_role8.setText(hash_7.get("role"));
                        }

                        if (8 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_8 = ArryHashPlaying_Xi_A.get(8);
                            tv_teama_name9.setText(hash_8.get("name"));
                            tv_team_role9.setText(hash_8.get("role"));
                        }

                        if (9 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_9 = ArryHashPlaying_Xi_A.get(9);
                            tv_teama_name10.setText(hash_9.get("name"));
                            tv_team_role10.setText(hash_9.get("role"));
                        }

                        if (10 < ArryHashPlaying_Xi_A.size()) {
                            HashMap<String, String> hash_10 = ArryHashPlaying_Xi_A.get(10);
                            tv_teama_name11.setText(hash_10.get("name"));
                            tv_team_role11.setText(hash_10.get("role"));
                        }


                        if (0 < ArryHashPlaying_Xi_A_Benchers.size()) {
                            HashMap<String, String> hash_11 = ArryHashPlaying_Xi_A_Benchers.get(0);
                            tv_teama_name12.setText(hash_11.get("name"));
                            tv_team_role12.setText(hash_11.get("role"));
                        }

                        if (1 < ArryHashPlaying_Xi_A_Benchers.size()) {
                            HashMap<String, String> hash_12 = ArryHashPlaying_Xi_A_Benchers.get(1);
                            tv_teama_name13.setText(hash_12.get("name"));
                            tv_team_role13.setText(hash_12.get("role"));
                        }

                        if (2 < ArryHashPlaying_Xi_A_Benchers.size()) {
                            HashMap<String, String> hash_13 = ArryHashPlaying_Xi_A_Benchers.get(2);
                            tv_teama_name14.setText(hash_13.get("name"));
                            tv_team_role14.setText(hash_13.get("role"));
                        }

                        if (3 < ArryHashPlaying_Xi_A_Benchers.size()) {
                            HashMap<String, String> hash_14 = ArryHashPlaying_Xi_A_Benchers.get(3);
                            tv_teama_name15.setText(hash_14.get("name"));
                            tv_team_role15.setText(hash_14.get("role"));
                        }

                        if (4 < ArryHashPlaying_Xi_A_Benchers.size()) {
                            HashMap<String, String> hash_15 = ArryHashPlaying_Xi_A_Benchers.get(4);
                            tv_teama_name16.setText(hash_15.get("name"));
                            tv_team_role16.setText(hash_15.get("role"));
                        }

                        if (5 < ArryHashPlaying_Xi_A_Benchers.size()) {
                            HashMap<String, String> hash_16 = ArryHashPlaying_Xi_A_Benchers.get(5);
                            tv_teama_name17.setText(hash_16.get("name"));
                            tv_team_role17.setText(hash_16.get("role"));
                        }

                        //Batting Team B
                        JSONObject jObjMatchB = jObjB.getJSONObject("match");
                        JSONArray jArraPlay_Xi_B = jObjMatchB.getJSONArray("playing_xi");
                        JSONArray jArraPlay_Xi_AllB= jObjMatchB.getJSONArray("players");

                        for (int i = 0; i < jArraPlay_Xi_B.length(); i++) {
                            ArryPlaying_Xi_B_XI.add(jArraPlay_Xi_B.getString(i));
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.size()+"", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.get(i), Toast.LENGTH_LONG).show();
                        }

                        for (int i = 0; i < jArraPlay_Xi_AllB.length(); i++) {
                            ArryPlaying_Xi_B_All.add(jArraPlay_Xi_AllB.getString(i));
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.size()+"", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.get(i), Toast.LENGTH_LONG).show();
                        }

                        for (String item : ArryPlaying_Xi_B_All) {
                            if (ArryPlaying_Xi_B_XI.contains(item)) {
                                //duplicateList.add(item);
                            } else {
                                ArryPlaying_Xi_B_Benchers.add(item);
                            }

                        }


                        for (int i = 0; i < jArraPlay_Xi_B.length(); i++) {
                            ArryPlaying_Xi_B.add(jArraPlay_Xi_B.getString(i));
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.size()+"", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getActivity(), ArryPlaying_Xi_A.get(i), Toast.LENGTH_LONG).show();
                        }

                        // get the value of the dynamic key
                        for (int j = 0; j < ArryPlaying_Xi_B.size(); j++) {
                            JSONObject jObjPlayerB = jObjCard.getJSONObject("players");
                            Iterator keys = jObjPlayerB.keys();
                            while (keys.hasNext()) {
                                // loop to get the dynamic key
                                String currentDynamicKey = (String) keys.next();
                                if (ArryPlaying_Xi_B.get(j).equalsIgnoreCase(currentDynamicKey)) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    JSONObject currentDynamicValue = jObjPlayerB.getJSONObject(currentDynamicKey);
                                    hashMap.put("name", currentDynamicValue.getString("fullname"));
                                    hashMap.put("role", currentDynamicValue.getString("seasonal_role"));
                                    ArryHashPlaying_Xi_B.add(hashMap);
                                }
                            }
                        }

                        /*get the value of dynamic key benchers players*/
                        for (int j = 0; j < ArryPlaying_Xi_B_Benchers.size(); j++) {
                            JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                            Iterator keys = jObjPlayerA.keys();
                            while (keys.hasNext()) {
                                // loop to get the dynamic key
                                String currentDynamicKey = (String) keys.next();
                                if (ArryPlaying_Xi_B_Benchers.get(j).equalsIgnoreCase(currentDynamicKey)) {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    JSONObject currentDynamicValue = jObjPlayerA.getJSONObject(currentDynamicKey);
                                    hashMap.put("name", currentDynamicValue.getString("fullname"));
                                    hashMap.put("role", currentDynamicValue.getString("seasonal_role"));
                                    ArryHashPlaying_Xi_B_Benchers.add(hashMap);
                                    //Toast.makeText(getActivity(), ArryPlaying_Xi_A_Benchers.get(j), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        //End Batting Team A
                        if (0 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash = ArryHashPlaying_Xi_B.get(0);
                            tv_teamb_name1.setText(hash.get("name") );
                            tv_teamb_role1.setText(hash.get("role"));
                        }
                        if (1 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_1 = ArryHashPlaying_Xi_B.get(1);
                            tv_teamb_name2.setText(hash_1.get("name"));
                            tv_teamb_role2.setText(hash_1.get("role"));
                        }
                        if (2 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_2 = ArryHashPlaying_Xi_B.get(2);
                            tv_teamb_name3.setText(hash_2.get("name"));
                            tv_teamb_role3.setText(hash_2.get("role"));
                        }
                        if (3 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_3 = ArryHashPlaying_Xi_B.get(3);
                            tv_teamb_name4.setText(hash_3.get("name"));
                            tv_teamb_role4.setText(hash_3.get("role"));
                        }
                        if (4 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_4 = ArryHashPlaying_Xi_B.get(4);
                            tv_teamb_name5.setText(hash_4.get("name"));
                            tv_teamb_role5.setText(hash_4.get("role"));
                        }

                        if (5 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_5 = ArryHashPlaying_Xi_B.get(5);
                            tv_teamb_name6.setText(hash_5.get("name"));
                            tv_teamb_role6.setText(hash_5.get("role"));
                        }

                        if (6 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_6 = ArryHashPlaying_Xi_B.get(6);
                            tv_teamb_name7.setText(hash_6.get("name"));
                            tv_teamb_role7.setText(hash_6.get("role"));
                        }

                        if (7 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_7 = ArryHashPlaying_Xi_B.get(7);
                            tv_teamb_name8.setText(hash_7.get("name"));
                            tv_teamb_role8.setText(hash_7.get("role"));
                        }

                        if (8 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_8 = ArryHashPlaying_Xi_B.get(8);
                            tv_teamb_name9.setText(hash_8.get("name"));
                            tv_teamb_role9.setText(hash_8.get("role"));
                        }

                        if (9 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_9 = ArryHashPlaying_Xi_B.get(9);
                            tv_teamb_name10.setText(hash_9.get("name"));
                            tv_teamb_role10.setText(hash_9.get("role"));
                        }

                        if (10 < ArryHashPlaying_Xi_B.size()) {
                            HashMap<String, String> hash_10 = ArryHashPlaying_Xi_B.get(10);
                            tv_teamb_name11.setText(hash_10.get("name"));
                            tv_teamb_role11.setText(hash_10.get("role"));
                        }

                        if (0 < ArryHashPlaying_Xi_B_Benchers.size()) {
                            HashMap<String, String> hash_11 = ArryHashPlaying_Xi_B_Benchers.get(0);
                            tv_teamb_name12.setText(hash_11.get("name"));
                            tv_teamb_role12.setText(hash_11.get("role"));
                        }


                        if (1 < ArryHashPlaying_Xi_B_Benchers.size()) {
                            HashMap<String, String> hash_12 = ArryHashPlaying_Xi_B_Benchers.get(1);
                            tv_teamb_name13.setText(hash_12.get("name"));
                            tv_teamb_role13.setText(hash_12.get("role"));
                        }

                        if (2 < ArryHashPlaying_Xi_B_Benchers.size()) {
                            HashMap<String, String> hash_13 = ArryHashPlaying_Xi_B_Benchers.get(2);
                            tv_teamb_name14.setText(hash_13.get("name"));
                            tv_teamb_role14.setText(hash_13.get("role"));
                        }

                        if (3 < ArryHashPlaying_Xi_B_Benchers.size()) {
                            HashMap<String, String> hash_14 = ArryHashPlaying_Xi_B_Benchers.get(3);
                            tv_teamb_name15.setText(hash_14.get("name"));
                            tv_teamb_role15.setText(hash_14.get("role"));
                        }

                        if (4 < ArryHashPlaying_Xi_B_Benchers.size()) {
                            HashMap<String, String> hash_15 = ArryHashPlaying_Xi_B_Benchers.get(4);
                            tv_teamb_name16.setText(hash_15.get("name"));
                            tv_teamb_role16.setText(hash_15.get("role"));
                        }

                        if (5 < ArryHashPlaying_Xi_B_Benchers.size()) {
                            HashMap<String, String> hash_16 = ArryHashPlaying_Xi_B_Benchers.get(5);
                            tv_teamb_name17.setText(hash_16.get("name"));
                            tv_teamb_role17.setText(hash_16.get("role"));
                        }


                    }

                    /*Team between and after match*/


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