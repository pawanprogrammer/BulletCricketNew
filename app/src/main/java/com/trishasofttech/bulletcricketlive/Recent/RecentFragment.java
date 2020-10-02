package com.trishasofttech.bulletcricketlive.Recent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.trishasofttech.bulletcricketlive.R;

public class RecentFragment extends Fragment {

    private RecentModel notificationsViewModel;
    private RecyclerView recyclerView;
    private SharedPreferences sp;
   // private String live_url= "http://cricapi.com/api/cricket/?apikey=QU2rB4akb2SbwAmUFTwtZQ8whBX2";
   // String url = "http://cricapi.com/api/cricketScore?apikey=QU2rB4akb2SbwAmUFTwtZQ8whBX2&unique_id=";
    String live_match = "https://rest.cricketapi.com/rest/v2/recent_matches/?access_token=2s1294346407548948481s1296483124376651865&card_type=summary_card";
    Handler handler;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.base_layout, container, false);
        recyclerView = v.findViewById(R.id.recycler_upcoming);
        recyclerView.setHasFixedSize(true);
        //to use RecycleView, you need a layout manager. default is LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        sp=getActivity().getSharedPreferences("tokenpref", 0);
        final String tokenid = sp.getString("tokenid", null);

        loadupcoming(tokenid);
        /*handler = new Handler ();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 20 seconds
                loadupcoming(tokenid);
                Toast.makeText ( getActivity (),"update",Toast.LENGTH_LONG ).show ();
            }
        }, 10000);*/
        return v;
    }

    private void loadupcoming(String tokenid) {
        String live_url = "https://rest.cricketapi.com/rest/v2/recent_matches/?access_token="+tokenid+"&card_type=summary_card";
        //String test_url ="https://rest.cricketapi.com/rest/v2/recent_matches/?access_token=2s1294346407548948481s1312092390290496346&card_type=summary_card";
        StringRequest request = new StringRequest(live_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                if(RecentHelper.arrLiveData.size () >0){
                    RecentHelper.arrLiveData.clear ();
                }
                RecentHelper parse = new RecentHelper(response);
                parse.livehelper();
                RecentAdapter adapter = new RecentAdapter(getActivity(), RecentHelper.match, RecentHelper.id, RecentHelper.matchseries, RecentHelper.arrLiveData);
                recyclerView.setAdapter(adapter);
                //progressBar.setVisibility(View.GONE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
                // pd.dismiss();
                //progressBar.setVisibility(View.GONE);

            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}
