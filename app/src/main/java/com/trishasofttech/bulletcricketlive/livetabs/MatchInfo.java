package com.trishasofttech.bulletcricketlive.livetabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.trishasofttech.bulletcricketlive.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class MatchInfo extends Fragment {

    TextView tv_match, tv_matchdate, tv_series, tv_matchtype, tv_matchvenue, tv_matchtoss;
    String tokenid;
    String sKey = "" ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_livedetails, container, false);
        tv_match = v.findViewById(R.id.tv_matchs);
        tv_matchdate = v.findViewById(R.id.tv_matchdates);
        tv_matchtype = v.findViewById(R.id.tv_matchtypes);
        tv_series = v.findViewById(R.id.tv_matchseriess);
        tv_matchvenue = v.findViewById(R.id.tv_matchvenues);
        tv_matchtoss = v.findViewById(R.id.tv_matchtosses);
        SharedPreferences sp = getActivity().getSharedPreferences("tokenpref", 0);
        tokenid = sp.getString("tokenid", null);
        //tv_match.setText(sp.getString("match", null));
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            sKey = bundle.getString ("skey", "defaultValue");
            loadCuMatch(sKey, tokenid);
        }
        return v;
    }
    private void loadCuMatch(String sKey, String tokenid) {
        String LiveUrl = "https://rest.cricketapi.com/rest/v2/match/"+sKey+"/?access_token="+tokenid;
        StringRequest request = new StringRequest(LiveUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // Toast.makeText ( getActivity (),response+" ScoreCard",Toast.LENGTH_LONG ).show ();
                try {
                    JSONObject jObjresponce = new JSONObject ( response ) ;
                    JSONObject jObjdata     =   jObjresponce.getJSONObject ( "data" );
                    JSONObject jObjCard    =  jObjdata.getJSONObject ( "card" );
                    JSONObject jObjTeam    = jObjCard.getJSONObject ( "teams" );
                    JSONObject jObjA       = jObjTeam.getJSONObject ( "a" );
                    JSONObject jObjB       = jObjTeam.getJSONObject ( "b" );

                    tv_match.setText ( jObjCard.getString ( "name" ) );
                    tv_matchtype.setText ( jObjCard.getString ( "format" ) );
                    tv_series.setText ( jObjCard.getString ( "title" ) );
                    JSONObject jsonObject_start_date =  jObjCard.getJSONObject ( "start_date" );
                    tv_matchdate.setText ( jsonObject_start_date.getString ( "str" ) );
                    tv_matchvenue.setText ( jObjCard.getString ( "venue" ) );
                    JSONObject jObjToss = jObjCard.getJSONObject("toss");
                    tv_matchtoss.setText(jObjToss.getString("str"));

                    // do something here with the value...

                    //End Batting Team A


                } catch (JSONException e) {
                    e.printStackTrace ( );
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse( VolleyError error) {
                // Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
                // pd.dismiss();
                //progressBar.setVisibility(View.GONE);

            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }


}
