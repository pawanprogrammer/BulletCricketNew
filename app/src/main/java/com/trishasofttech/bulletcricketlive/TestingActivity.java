package com.trishasofttech.bulletcricketlive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        getSupportActionBar().setTitle("POINT TABLE");

    }

    private void loadservices() {
        StringRequest sr = new StringRequest(1, "https://rest.cricketapi.com/rest/v2/auth/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(TestingActivity.this, response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
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