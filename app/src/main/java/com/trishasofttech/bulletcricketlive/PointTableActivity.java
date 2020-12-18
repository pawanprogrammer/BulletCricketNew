package com.trishasofttech.bulletcricketlive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PointTableActivity extends AppCompatActivity {
TextView tv_league, tv_teams1, tv_points1,tv_win1,tv_loss1, tv_nr1, tv_pts1, tv_nrr1,
        tv_teams2, tv_points2,tv_win2,tv_loss2, tv_nr2, tv_pts2, tv_nrr2,
        tv_teams3, tv_points3,tv_win3,tv_loss3, tv_nr3, tv_pts3, tv_nrr3,
        tv_teams4, tv_points4,tv_win4,tv_loss4, tv_nr4, tv_pts4, tv_nrr4,
        tv_teams5, tv_points5,tv_win5,tv_loss5, tv_nr5, tv_pts5, tv_nrr5,
        tv_teams6, tv_points6,tv_win6,tv_loss6, tv_nr6, tv_pts6, tv_nrr6,
        tv_teams7, tv_points7,tv_win7,tv_loss7, tv_nr7, tv_pts7, tv_nrr7,
    tv_teams8, tv_points8,tv_win8,tv_loss8, tv_nr8, tv_pts8, tv_nrr8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        getSupportActionBar().setTitle("POINT TABLE");
        tv_league = findViewById(R.id.tv_league);
        tv_teams1 = findViewById(R.id.tv_teams1);
        tv_points1 = findViewById(R.id.tv_points1);
        tv_win1 = findViewById(R.id.tv_win1);
        tv_loss1 = findViewById(R.id.tv_loss1);
        tv_nr1 = findViewById(R.id.tv_nr1);
        tv_pts1 = findViewById(R.id.tv_pts1);
        tv_nrr1 = findViewById(R.id.tv_nrr1);

        tv_teams2 = findViewById(R.id.tv_teams2);
        tv_points2 = findViewById(R.id.tv_points2);
        tv_win2 = findViewById(R.id.tv_win2);
        tv_loss2 = findViewById(R.id.tv_loss2);
        tv_nr2 = findViewById(R.id.tv_nr2);
        tv_pts2 = findViewById(R.id.tv_pts2);
        tv_nrr2 = findViewById(R.id.tv_nrr2);

        tv_teams3 = findViewById(R.id.tv_teams3);
        tv_points3 = findViewById(R.id.tv_points3);
        tv_win3 = findViewById(R.id.tv_win3);
        tv_loss3 = findViewById(R.id.tv_loss3);
        tv_nr3 = findViewById(R.id.tv_nr3);
        tv_pts3 = findViewById(R.id.tv_pts3);
        tv_nrr3 = findViewById(R.id.tv_nrr3);

        tv_teams4 = findViewById(R.id.tv_teams4);
        tv_points4 = findViewById(R.id.tv_points4);
        tv_win4 = findViewById(R.id.tv_win4);
        tv_loss4 = findViewById(R.id.tv_loss4);
        tv_nr4 = findViewById(R.id.tv_nr4);
        tv_pts4 = findViewById(R.id.tv_pts4);
        tv_nrr4 = findViewById(R.id.tv_nrr4);

        tv_teams5 = findViewById(R.id.tv_teams5);
        tv_points5 = findViewById(R.id.tv_points5);
        tv_win5 = findViewById(R.id.tv_win5);
        tv_loss5 = findViewById(R.id.tv_loss5);
        tv_nr5 = findViewById(R.id.tv_nr5);
        tv_pts5 = findViewById(R.id.tv_pts5);
        tv_nrr5 = findViewById(R.id.tv_nrr5);

        tv_teams6 = findViewById(R.id.tv_teams6);
        tv_points6 = findViewById(R.id.tv_points6);
        tv_win6 = findViewById(R.id.tv_win6);
        tv_loss6 = findViewById(R.id.tv_loss6);
        tv_nr6 = findViewById(R.id.tv_nr6);
        tv_pts6 = findViewById(R.id.tv_pts6);
        tv_nrr6 = findViewById(R.id.tv_nrr6);

        tv_teams7 = findViewById(R.id.tv_teams7);
        tv_points7 = findViewById(R.id.tv_points7);
        tv_win7 = findViewById(R.id.tv_win7);
        tv_loss7 = findViewById(R.id.tv_loss7);
        tv_nr7 = findViewById(R.id.tv_nr7);
        tv_pts7 = findViewById(R.id.tv_pts7);
        tv_nrr7 = findViewById(R.id.tv_nrr7);

        tv_teams8 = findViewById(R.id.tv_teams8);
        tv_points8 = findViewById(R.id.tv_points8);
        tv_win8 = findViewById(R.id.tv_win8);
        tv_loss8 = findViewById(R.id.tv_loss8);
        tv_nr8 = findViewById(R.id.tv_nr8);
        tv_pts8 = findViewById(R.id.tv_pts8);
        tv_nrr8 = findViewById(R.id.tv_nrr8);

        loadservices();
    }

    private void loadservices() {
        StringRequest sr = new StringRequest(0, "http://searchkero.com/cricket/point.json", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(PointTableActivity.this, response, Toast.LENGTH_LONG).show();
                try {
                    JSONObject jObj = new JSONObject(response);
                    JSONArray jArray = jObj.getJSONArray("data");
                    JSONObject jObjPoint1 = jArray.getJSONObject(0);
                    tv_league.setText(jObjPoint1.getString("league_id"));
                    tv_teams1.setText(jObjPoint1.getString("name"));
                    tv_points1.setText(jObjPoint1.getString("P"));
                    tv_win1.setText(jObjPoint1.getString("W"));
                    tv_loss1.setText(jObjPoint1.getString("L"));
                    tv_nr1.setText(jObjPoint1.getString("NR"));
                    tv_pts1.setText(jObjPoint1.getString("Pts"));
                    tv_nrr1.setText(jObjPoint1.getString("NRR"));

                    JSONObject jObjPoint2 = jArray.getJSONObject(1);
                    tv_teams2.setText(jObjPoint2.getString("name"));
                    tv_points2.setText(jObjPoint2.getString("P"));
                    tv_win2.setText(jObjPoint2.getString("W"));
                    tv_loss2.setText(jObjPoint2.getString("L"));
                    tv_nr2.setText(jObjPoint2.getString("NR"));
                    tv_pts2.setText(jObjPoint2.getString("Pts"));
                    tv_nrr2.setText(jObjPoint2.getString("NRR"));

                    JSONObject jObjPoint3 = jArray.getJSONObject(2);
                    tv_teams3.setText(jObjPoint3.getString("name"));
                    tv_points3.setText(jObjPoint3.getString("P"));
                    tv_win3.setText(jObjPoint3.getString("W"));
                    tv_loss3.setText(jObjPoint3.getString("L"));
                    tv_nr3.setText(jObjPoint3.getString("NR"));
                    tv_pts3.setText(jObjPoint3.getString("Pts"));
                    tv_nrr3.setText(jObjPoint3.getString("NRR"));

                    JSONObject jObjPoint4 = jArray.getJSONObject(3);
                    tv_teams4.setText(jObjPoint4.getString("name"));
                    tv_points4.setText(jObjPoint4.getString("P"));
                    tv_win4.setText(jObjPoint4.getString("W"));
                    tv_loss4.setText(jObjPoint4.getString("L"));
                    tv_nr4.setText(jObjPoint4.getString("NR"));
                    tv_pts4.setText(jObjPoint4.getString("Pts"));
                    tv_nrr4.setText(jObjPoint4.getString("NRR"));

                    JSONObject jObjPoint5 = jArray.getJSONObject(4);
                    tv_teams5.setText(jObjPoint5.getString("name"));
                    tv_points5.setText(jObjPoint5.getString("P"));
                    tv_win5.setText(jObjPoint5.getString("W"));
                    tv_loss5.setText(jObjPoint5.getString("L"));
                    tv_nr5.setText(jObjPoint5.getString("NR"));
                    tv_pts5.setText(jObjPoint5.getString("Pts"));
                    tv_nrr5.setText(jObjPoint5.getString("NRR"));

                    JSONObject jObjPoint6 = jArray.getJSONObject(5);
                    tv_teams6.setText(jObjPoint6.getString("name"));
                    tv_points6.setText(jObjPoint6.getString("P"));
                    tv_win6.setText(jObjPoint6.getString("W"));
                    tv_loss6.setText(jObjPoint6.getString("L"));
                    tv_nr6.setText(jObjPoint6.getString("NR"));
                    tv_pts6.setText(jObjPoint6.getString("Pts"));
                    tv_nrr6.setText(jObjPoint6.getString("NRR"));

                    JSONObject jObjPoint7 = jArray.getJSONObject(6);
                    tv_teams7.setText(jObjPoint7.getString("name"));
                    tv_points7.setText(jObjPoint7.getString("P"));
                    tv_win7.setText(jObjPoint7.getString("W"));
                    tv_loss7.setText(jObjPoint7.getString("L"));
                    tv_nr7.setText(jObjPoint7.getString("NR"));
                    tv_pts7.setText(jObjPoint7.getString("Pts"));
                    tv_nrr7.setText(jObjPoint7.getString("NRR"));

                    JSONObject jObjPoint8 = jArray.getJSONObject(7);
                    tv_teams8.setText(jObjPoint8.getString("name"));
                    tv_points8.setText(jObjPoint8.getString("P"));
                    tv_win8.setText(jObjPoint8.getString("W"));
                    tv_loss8.setText(jObjPoint8.getString("L"));
                    tv_nr8.setText(jObjPoint8.getString("NR"));
                    tv_pts8.setText(jObjPoint8.getString("Pts"));
                    tv_nrr8.setText(jObjPoint8.getString("NRR"));
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue rq = Volley.newRequestQueue(this);
        rq.add(sr);
    }
}