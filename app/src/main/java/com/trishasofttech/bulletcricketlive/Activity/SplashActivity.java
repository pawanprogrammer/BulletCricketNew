package com.trishasofttech.bulletcricketlive.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.trishasofttech.bulletcricketlive.R;
import com.trishasofttech.bulletcricketlive.TestingActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        /*hide the status bar and actionbar*/
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*create sharedpreferences to store the token key*/
        sp = getSharedPreferences("tokenpref", 0);
        ed = sp.edit();
        /*to get the access token and store in sharedpreferences*/
        loadservices();

        /*Jump to MainActivity after 2 sec*/
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splash);
                finish();
            }
        }, 2000);


    }


    private void loadservices() {
        StringRequest sr = new StringRequest(1, "https://rest.cricketapi.com/rest/v2/auth/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jo = new JSONObject(response);
                    JSONObject joAuth = jo.getJSONObject("auth");
                    String tokenid = joAuth.getString("access_token");
                    /*pass tokenid to sharedpreferences*/
                    ed.putString("tokenid", tokenid);
                    ed.commit();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("access_key", "0b4493705446403556093735ef542914");
                map.put("secret_key", "bb57041e85ab5c279d62b00f085d526b");
                map.put("app_id", "com.trishasofttech.bulletcricketlive");
                map.put("device_id", "developer");
                return map;
            }
        };
        RequestQueue rq = Volley.newRequestQueue(this);
        rq.add(sr);
    }
}
