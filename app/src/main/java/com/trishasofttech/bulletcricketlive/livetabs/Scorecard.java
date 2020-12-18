package com.trishasofttech.bulletcricketlive.livetabs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.trishasofttech.bulletcricketlive.R;
import com.trishasofttech.bulletcricketlive.live.LiveAdapter;
import com.trishasofttech.bulletcricketlive.live.LiveHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Scorecard extends Fragment {

    String sKey = "";
    String matchUrl = "https://rest.cricketapi.com/rest/v2/match/" + sKey + "/?access_token=2s1294346407548948481s1295076065408072282";
    ArrayList<String> ArryPlaying_Xi_A = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_A_Bowling = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_B_Bowling = new ArrayList<>();
    ArrayList<String> ArryPlaying_Xi_B = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_A = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_A_Bowling = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_B_Bowling = new ArrayList<>();
    ArrayList<HashMap<String, String>> ArryHashPlaying_Xi_B = new ArrayList<>();
    TextView tv_teama_batsman, tv_teama_batsman1, tv_teama_batsman2, tv_teama_batsman3, tv_teama_batsman4, tv_teama_batsman5, tv_teama_batsman6,
            tv_teama_batsman7, tv_teama_batsman8, tv_teama_batsman9, tv_teama_batsman10, tv_teama_batsman11;

    TextView tv_teama_run1, tv_teama_run2, tv_teama_run3, tv_teama_run4, tv_teama_run5, tv_teama_run6, tv_teama_run7, tv_teama_run8, tv_teama_run9, tv_teama_run10, tv_teama_run11;
    TextView tv_teama_ball1, tv_teama_ball2, tv_teama_ball3, tv_teama_ball4, tv_teama_ball5, tv_teama_ball6, tv_teama_ball7, tv_teama_ball8, tv_teama_ball9, tv_teama_ball10, tv_teama_ball11;
    TextView tv_teama_4s1, tv_teama_4s2, tv_teama_4s3, tv_teama_4s4, tv_teama_4s5, tv_teama_4s6, tv_teama_4s7, tv_teama_4s8, tv_teama_4s9, tv_teama_4s10, tv_teama_4s11;
    TextView tv_teama_6s1, tv_teama_6s2, tv_teama_6s3, tv_teama_6s4, tv_teama_6s5, tv_teama_6s6, tv_teama_6s7, tv_teama_6s8, tv_teama_6s9, tv_teama_6s10, tv_teama_6s11;
    TextView tv_teama_sr1, tv_teama_sr2, tv_teama_sr3, tv_teama_sr4, tv_teama_sr5, tv_teama_sr6, tv_teama_sr7, tv_teama_sr8, tv_teama_sr9, tv_teama_sr10, tv_teama_sr11;
    TextView tv_teama_out1, tv_teama_out2, tv_teama_out3, tv_teama_out4, tv_teama_out5, tv_teama_out6, tv_teama_out7, tv_teama_out8, tv_teama_out9, tv_teama_out10, tv_teama_out11;


    TextView tv_teama_inning_1, tv_teama_inning_2, tv_teamb_inning_1, tv_teamb_inning_2;

    TextView tv_teama2_batsman1, tv_teama2_batsman2, tv_teama2_batsman3, tv_teama2_batsman4, tv_teama2_batsman5, tv_teama2_batsman6,
            tv_teama2_batsman7, tv_teama2_batsman8, tv_teama2_batsman9, tv_teama2_batsman10, tv_teama2_batsman11;

    TextView tv_teamb_batsman1, tv_teamb_batsman2, tv_teamb_batsman3, tv_teamb_batsman4, tv_teamb_batsman5, tv_teamb_batsman6,
            tv_teamb_batsman7, tv_teamb_batsman8, tv_teamb_batsman9, tv_teamb_batsman10, tv_teamb_batsman11;

    TextView tv_teamb2_batsman1, tv_teamb2_batsman2, tv_teamb2_batsman3, tv_teamb2_batsman4, tv_teamb2_batsman5, tv_teamb2_batsman6,
            tv_teamb2_batsman7, tv_teamb2_batsman8, tv_teamb2_batsman9, tv_teamb2_batsman10, tv_teamb2_batsman11;

    TextView tv_teamb_run1, tv_teamb_run2, tv_teamb_run3, tv_teamb_run4, tv_teamb_run5, tv_teamb_run6, tv_teamb_run7,
            tv_teamb_run8, tv_teamb_run9, tv_teamb_run10, tv_teamb_run11;

    TextView tv_teamb_ball1, tv_teamb_ball2, tv_teamb_ball3, tv_teamb_ball4, tv_teamb_ball5, tv_teamb_ball6, tv_teamb_ball7,
            tv_teamb_ball8, tv_teamb_ball9, tv_teamb_ball10, tv_teamb_ball11;

    TextView tv_teamb_4s1, tv_teamb_4s2, tv_teamb_4s3, tv_teamb_4s4, tv_teamb_4s5, tv_teamb_4s6, tv_teamb_4s7, tv_teamb_4s8, tv_teamb_4s9,
            tv_teamb_4s10, tv_teamb_4s11;

    TextView tv_teamb_6s1, tv_teamb_6s2, tv_teamb_6s3, tv_teamb_6s4, tv_teamb_6s5, tv_teamb_6s6, tv_teamb_6s7, tv_teamb_6s8, tv_teamb_6s9,
            tv_teamb_6s10, tv_teamb_6s11;

    TextView tv_teamb_sr1, tv_teamb_sr2, tv_teamb_sr3, tv_teamb_sr4, tv_teamb_sr5, tv_teamb_sr6, tv_teamb_sr7, tv_teamb_sr8, tv_teamb_sr9,
            tv_teamb_sr10, tv_teamb_sr11;
    TextView tv_teamb_out1, tv_teamb_out2, tv_teamb_out3, tv_teamb_out4, tv_teamb_out5, tv_teamb_out6, tv_teamb_out7,
            tv_teamb_out8,tv_teamb_out9,tv_teamb_out10,tv_teamb_out11;


    /*bowler data a team*/
    private TextView tv_teama_bowler1,tv_teama_bowler2,tv_teama_bowler3,tv_teama_bowler4,tv_teama_bowler5,tv_teama_bowler6,tv_teama_bowler7,tv_teama_bowler8,tv_teama_bowler9,tv_teama_bowler10,tv_teama_bowler11;
    private TextView tv_teama_over1, tv_teama_over2,tv_teama_over3,tv_teama_over4,tv_teama_over5,tv_teama_over6,tv_teama_over7,tv_teama_over8,tv_teama_over9,tv_teama_over10,tv_teama_over11;
    private TextView tv_teama_maidan1, tv_teama_maidan2,tv_teama_maidan3,tv_teama_maidan4,tv_teama_maidan5,tv_teama_maidan6,tv_teama_maidan7,tv_teama_maidan8,tv_teama_maidan9,tv_teama_maidan10,tv_teama_maidan11;
    private TextView tv_teama_b_run1,tv_teama_b_run2,tv_teama_b_run3,tv_teama_b_run4,tv_teama_b_run5,tv_teama_b_run6,tv_teama_b_run7,tv_teama_b_run8,tv_teama_b_run9,tv_teama_b_run10,tv_teama_b_run11;
    private TextView tv_teama_wicket1,tv_teama_wicket2,tv_teama_wicket3,tv_teama_wicket4,tv_teama_wicket5,tv_teama_wicket6,tv_teama_wicket7,tv_teama_wicket8,tv_teama_wicket9,tv_teama_wicket10,tv_teama_wicket11;
    private TextView tv_teama_eco1,tv_teama_eco2,tv_teama_eco3,tv_teama_eco4,tv_teama_eco5,tv_teama_eco6,tv_teama_eco7,tv_teama_eco8,tv_teama_eco9,tv_teama_eco10,tv_teama_eco11;


    /*bowler data b team*/
    private TextView tv_teamb_bowler1,tv_teamb_bowler2,tv_teamb_bowler3,tv_teamb_bowler4,tv_teamb_bowler5,tv_teamb_bowler6,tv_teamb_bowler7,tv_teamb_bowler8,tv_teamb_bowler9,tv_teamb_bowler10,tv_teamb_bowler11;
    private TextView tv_teamb_over1, tv_teamb_over2,tv_teamb_over3,tv_teamb_over4,tv_teamb_over5,tv_teamb_over6,tv_teamb_over7,tv_teamb_over8,tv_teamb_over9,tv_teamb_over10,tv_teamb_over11;
    private TextView tv_teamb_maidan1, tv_teamb_maidan2,tv_teamb_maidan3,tv_teamb_maidan4,tv_teamb_maidan5,tv_teamb_maidan6,tv_teamb_maidan7,tv_teamb_maidan8,tv_teamb_maidan9,tv_teamb_maidan10,tv_teamb_maidan11;
    private TextView tv_teamb_b_run1,tv_teamb_b_run2,tv_teamb_b_run3,tv_teamb_b_run4,tv_teamb_b_run5,tv_teamb_b_run6,tv_teamb_b_run7,tv_teamb_b_run8,tv_teamb_b_run9,tv_teamb_b_run10,tv_teamb_b_run11;
    private TextView tv_teamb_wicket1,tv_teamb_wicket2,tv_teamb_wicket3,tv_teamb_wicket4,tv_teamb_wicket5,tv_teamb_wicket6,tv_teamb_wicket7,tv_teamb_wicket8,tv_teamb_wicket9,tv_teamb_wicket10,tv_teamb_wicket11;
    private TextView tv_teamb_eco1,tv_teamb_eco2,tv_teamb_eco3,tv_teamb_eco4,tv_teamb_eco5,tv_teamb_eco6,tv_teamb_eco7,tv_teamb_eco8,tv_teamb_eco9,tv_teamb_eco10,tv_teamb_eco11;


    private ImageView iv_teama_up, iv_teama_up_2, iv_teamb_up, iv_teamb_up_2;
    private TableLayout table_team_a_1, table_team_a_2, table_team_b_1, table_team_b_2;

    private ConstraintLayout container_teama_2, container_teamb_2;
    private LinearLayout linear_layout_a1, linear_layout_b1;
    String tokenid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_scorecard, container, false);

        linear_layout_a1 = v.findViewById(R.id.linear_a1);
        linear_layout_b1 = v.findViewById(R.id.linear_b1);
        /*for test match container*/
        container_teama_2= v.findViewById(R.id.container_teama_2);
        container_teamb_2= v.findViewById(R.id.container_teamb_2);
        container_teama_2.setVisibility(View.GONE);
        container_teamb_2.setVisibility(View.GONE);

        /*team table hide*/
        iv_teama_up = v.findViewById(R.id.iv_teama_up);
        iv_teama_up_2 = v.findViewById(R.id.iv_teama_up_2);
        iv_teamb_up = v.findViewById(R.id.iv_teamb_up);
        iv_teamb_up_2 = v.findViewById(R.id.iv_teamb_up_2);

        /*team a b score heading*/
        tv_teama_inning_1 = v.findViewById(R.id.tv_teama_inning_1);
        tv_teama_inning_2 = v.findViewById(R.id.tv_teama_inning_2);
        tv_teamb_inning_1 = v.findViewById(R.id.tv_teamb_inning_1);
        tv_teamb_inning_2 = v.findViewById(R.id.tv_teamb_inning_2);

        /*tablelayout container for team a and b*/
        table_team_a_1 = v.findViewById(R.id.table_team_a_1);
        table_team_a_2 = v.findViewById(R.id.table_team_a_2);
        table_team_b_1 = v.findViewById(R.id.table_team_b_1);
        table_team_b_2 = v.findViewById(R.id.table_team_b_2);

        /*a team inning 1*/
        tv_teama_batsman = v.findViewById(R.id.tv_teama_batsman);
        tv_teama_batsman1 = v.findViewById(R.id.tv_teama_batsman1);
        tv_teama_batsman2 = v.findViewById(R.id.tv_teama_batsman2);
        tv_teama_batsman3 = v.findViewById(R.id.tv_teama_batsman3);
        tv_teama_batsman4 = v.findViewById(R.id.tv_teama_batsman4);
        tv_teama_batsman5 = v.findViewById(R.id.tv_teama_batsman5);
        tv_teama_batsman6 = v.findViewById(R.id.tv_teama_batsman6);
        tv_teama_batsman7 = v.findViewById(R.id.tv_teama_batsman7);
        tv_teama_batsman8 = v.findViewById(R.id.tv_teama_batsman8);
        tv_teama_batsman9 = v.findViewById(R.id.tv_teama_batsman9);
        tv_teama_batsman10 = v.findViewById(R.id.tv_teama_batsman10);
        tv_teama_batsman11 = v.findViewById(R.id.tv_teama_batsman11);
        /*team a out by*/
        tv_teama_out1 = v.findViewById(R.id.tv_teama_out1);
        tv_teama_out2 = v.findViewById(R.id.tv_teama_out2);
        tv_teama_out3 = v.findViewById(R.id.tv_teama_out3);
        tv_teama_out4 = v.findViewById(R.id.tv_teama_out4);
        tv_teama_out5 = v.findViewById(R.id.tv_teama_out5);
        tv_teama_out6 = v.findViewById(R.id.tv_teama_out6);
        tv_teama_out7 = v.findViewById(R.id.tv_teama_out7);
        tv_teama_out8 = v.findViewById(R.id.tv_teama_out8);
        tv_teama_out9 = v.findViewById(R.id.tv_teama_out9);
        tv_teama_out10 = v.findViewById(R.id.tv_teama_out10);
        tv_teama_out11 = v.findViewById(R.id.tv_teama_out11);

        /*a team bowler inning 1*/
        tv_teama_bowler1=v.findViewById(R.id.tv_teama_bowler1);
        tv_teama_bowler2=v.findViewById(R.id.tv_teama_bowler2);
        tv_teama_bowler3=v.findViewById(R.id.tv_teama_bowler3);
        tv_teama_bowler4=v.findViewById(R.id.tv_teama_bowler4);
        tv_teama_bowler5=v.findViewById(R.id.tv_teama_bowler5);
        tv_teama_bowler6=v.findViewById(R.id.tv_teama_bowler6);
        tv_teama_bowler7=v.findViewById(R.id.tv_teama_bowler7);
        tv_teama_bowler8=v.findViewById(R.id.tv_teama_bowler8);
        tv_teama_bowler9=v.findViewById(R.id.tv_teama_bowler9);
        tv_teama_bowler10=v.findViewById(R.id.tv_teama_bowler10);
        tv_teama_bowler11=v.findViewById(R.id.tv_teama_bowler11);

        tv_teama_over1=v.findViewById(R.id.tv_teama_over1);
        tv_teama_over2=v.findViewById(R.id.tv_teama_over2);
        tv_teama_over3=v.findViewById(R.id.tv_teama_over3);
        tv_teama_over4=v.findViewById(R.id.tv_teama_over4);
        tv_teama_over5=v.findViewById(R.id.tv_teama_over5);
        tv_teama_over6=v.findViewById(R.id.tv_teama_over6);
        tv_teama_over7=v.findViewById(R.id.tv_teama_over7);
        tv_teama_over8=v.findViewById(R.id.tv_teama_over8);
        tv_teama_over9=v.findViewById(R.id.tv_teama_over9);
        tv_teama_over10=v.findViewById(R.id.tv_teama_over10);
        tv_teama_over11=v.findViewById(R.id.tv_teama_over11);

        tv_teama_maidan1= v.findViewById(R.id.tv_teama_maidan1);
        tv_teama_maidan2= v.findViewById(R.id.tv_teama_maidan2);
        tv_teama_maidan3= v.findViewById(R.id.tv_teama_maidan3);
        tv_teama_maidan4= v.findViewById(R.id.tv_teama_maidan4);
        tv_teama_maidan5= v.findViewById(R.id.tv_teama_maidan5);
        tv_teama_maidan6= v.findViewById(R.id.tv_teama_maidan6);
        tv_teama_maidan7= v.findViewById(R.id.tv_teama_maidan7);
        tv_teama_maidan8= v.findViewById(R.id.tv_teama_maidan8);
        tv_teama_maidan9= v.findViewById(R.id.tv_teama_maidan9);
        tv_teama_maidan10= v.findViewById(R.id.tv_teama_maidan10);
        tv_teama_maidan11= v.findViewById(R.id.tv_teama_maidan11);

        tv_teama_b_run1 = v.findViewById(R.id.tv_teama_b_run1);
        tv_teama_b_run2 = v.findViewById(R.id.tv_teama_b_run2);
        tv_teama_b_run3 = v.findViewById(R.id.tv_teama_b_run3);
        tv_teama_b_run4 = v.findViewById(R.id.tv_teama_b_run4);
        tv_teama_b_run5 = v.findViewById(R.id.tv_teama_b_run5);
        tv_teama_b_run6 = v.findViewById(R.id.tv_teama_b_run6);
        tv_teama_b_run7 = v.findViewById(R.id.tv_teama_b_run7);
        tv_teama_b_run8 = v.findViewById(R.id.tv_teama_b_run8);
        tv_teama_b_run9 = v.findViewById(R.id.tv_teama_b_run9);
        tv_teama_b_run10 = v.findViewById(R.id.tv_teama_b_run10);
        tv_teama_b_run11 = v.findViewById(R.id.tv_teama_b_run11);

        tv_teama_wicket1 = v.findViewById(R.id.tv_teama_wicket1);
        tv_teama_wicket2 = v.findViewById(R.id.tv_teama_wicket2);
        tv_teama_wicket3 = v.findViewById(R.id.tv_teama_wicket3);
        tv_teama_wicket4 = v.findViewById(R.id.tv_teama_wicket4);
        tv_teama_wicket5 = v.findViewById(R.id.tv_teama_wicket5);
        tv_teama_wicket6 = v.findViewById(R.id.tv_teama_wicket6);
        tv_teama_wicket7 = v.findViewById(R.id.tv_teama_wicket7);
        tv_teama_wicket8 = v.findViewById(R.id.tv_teama_wicket8);
        tv_teama_wicket9 = v.findViewById(R.id.tv_teama_wicket9);
        tv_teama_wicket10 = v.findViewById(R.id.tv_teama_wicket10);
        tv_teama_wicket11 = v.findViewById(R.id.tv_teama_wicket11);

        tv_teama_eco1 = v.findViewById(R.id.tv_teama_eco1);
        tv_teama_eco2 = v.findViewById(R.id.tv_teama_eco2);
        tv_teama_eco3 = v.findViewById(R.id.tv_teama_eco3);
        tv_teama_eco4 = v.findViewById(R.id.tv_teama_eco4);
        tv_teama_eco5 = v.findViewById(R.id.tv_teama_eco5);
        tv_teama_eco6 = v.findViewById(R.id.tv_teama_eco6);
        tv_teama_eco7 = v.findViewById(R.id.tv_teama_eco7);
        tv_teama_eco8 = v.findViewById(R.id.tv_teama_eco8);
        tv_teama_eco9 = v.findViewById(R.id.tv_teama_eco9);
        tv_teama_eco10 = v.findViewById(R.id.tv_teama_eco10);
        tv_teama_eco11 = v.findViewById(R.id.tv_teama_eco11);


        /*b team bowler inning 1*/
        tv_teamb_bowler1=v.findViewById(R.id.tv_teamb_bowler1);
        tv_teamb_bowler2=v.findViewById(R.id.tv_teamb_bowler2);
        tv_teamb_bowler3=v.findViewById(R.id.tv_teamb_bowler3);
        tv_teamb_bowler4=v.findViewById(R.id.tv_teamb_bowler4);
        tv_teamb_bowler5=v.findViewById(R.id.tv_teamb_bowler5);
        tv_teamb_bowler6=v.findViewById(R.id.tv_teamb_bowler6);
        tv_teamb_bowler7=v.findViewById(R.id.tv_teamb_bowler7);
        tv_teamb_bowler8=v.findViewById(R.id.tv_teamb_bowler8);
        tv_teamb_bowler9=v.findViewById(R.id.tv_teamb_bowler9);
        tv_teamb_bowler10=v.findViewById(R.id.tv_teamb_bowler10);
        tv_teamb_bowler11=v.findViewById(R.id.tv_teamb_bowler11);

        tv_teamb_over1=v.findViewById(R.id.tv_teamb_over1);
        tv_teamb_over2=v.findViewById(R.id.tv_teamb_over2);
        tv_teamb_over3=v.findViewById(R.id.tv_teamb_over3);
        tv_teamb_over4=v.findViewById(R.id.tv_teamb_over4);
        tv_teamb_over5=v.findViewById(R.id.tv_teamb_over5);
        tv_teamb_over6=v.findViewById(R.id.tv_teamb_over6);
        tv_teamb_over7=v.findViewById(R.id.tv_teamb_over7);
        tv_teamb_over8=v.findViewById(R.id.tv_teamb_over8);
        tv_teamb_over9=v.findViewById(R.id.tv_teamb_over9);
        tv_teamb_over10=v.findViewById(R.id.tv_teamb_over10);
        tv_teamb_over11=v.findViewById(R.id.tv_teamb_over11);

        tv_teamb_maidan1= v.findViewById(R.id.tv_teamb_maidan1);
        tv_teamb_maidan2= v.findViewById(R.id.tv_teamb_maidan2);
        tv_teamb_maidan3= v.findViewById(R.id.tv_teamb_maidan3);
        tv_teamb_maidan4= v.findViewById(R.id.tv_teamb_maidan4);
        tv_teamb_maidan5= v.findViewById(R.id.tv_teamb_maidan5);
        tv_teamb_maidan6= v.findViewById(R.id.tv_teamb_maidan6);
        tv_teamb_maidan7= v.findViewById(R.id.tv_teamb_maidan7);
        tv_teamb_maidan8= v.findViewById(R.id.tv_teamb_maidan8);
        tv_teamb_maidan9= v.findViewById(R.id.tv_teamb_maidan9);
        tv_teamb_maidan10= v.findViewById(R.id.tv_teamb_maidan10);
        tv_teamb_maidan11= v.findViewById(R.id.tv_teamb_maidan11);

        tv_teamb_b_run1 = v.findViewById(R.id.tv_teamb_b_run1);
        tv_teamb_b_run2 = v.findViewById(R.id.tv_teamb_b_run2);
        tv_teamb_b_run3 = v.findViewById(R.id.tv_teamb_b_run3);
        tv_teamb_b_run4 = v.findViewById(R.id.tv_teamb_b_run4);
        tv_teamb_b_run5 = v.findViewById(R.id.tv_teamb_b_run5);
        tv_teamb_b_run6 = v.findViewById(R.id.tv_teamb_b_run6);
        tv_teamb_b_run7 = v.findViewById(R.id.tv_teamb_b_run7);
        tv_teamb_b_run8 = v.findViewById(R.id.tv_teamb_b_run8);
        tv_teamb_b_run9 = v.findViewById(R.id.tv_teamb_b_run9);
        tv_teamb_b_run10 = v.findViewById(R.id.tv_teamb_b_run10);
        tv_teamb_b_run11 = v.findViewById(R.id.tv_teamb_b_run11);

        tv_teamb_wicket1 = v.findViewById(R.id.tv_teamb_wicket1);
        tv_teamb_wicket2 = v.findViewById(R.id.tv_teamb_wicket2);
        tv_teamb_wicket3 = v.findViewById(R.id.tv_teamb_wicket3);
        tv_teamb_wicket4 = v.findViewById(R.id.tv_teamb_wicket4);
        tv_teamb_wicket5 = v.findViewById(R.id.tv_teamb_wicket5);
        tv_teamb_wicket6 = v.findViewById(R.id.tv_teamb_wicket6);
        tv_teamb_wicket7 = v.findViewById(R.id.tv_teamb_wicket7);
        tv_teamb_wicket8 = v.findViewById(R.id.tv_teamb_wicket8);
        tv_teamb_wicket9 = v.findViewById(R.id.tv_teamb_wicket9);
        tv_teamb_wicket10 = v.findViewById(R.id.tv_teamb_wicket10);
        tv_teamb_wicket11 = v.findViewById(R.id.tv_teamb_wicket11);

        tv_teamb_eco1 = v.findViewById(R.id.tv_teamb_eco1);
        tv_teamb_eco2 = v.findViewById(R.id.tv_teamb_eco2);
        tv_teamb_eco3 = v.findViewById(R.id.tv_teamb_eco3);
        tv_teamb_eco4 = v.findViewById(R.id.tv_teamb_eco4);
        tv_teamb_eco5 = v.findViewById(R.id.tv_teamb_eco5);
        tv_teamb_eco6 = v.findViewById(R.id.tv_teamb_eco6);
        tv_teamb_eco7 = v.findViewById(R.id.tv_teamb_eco7);
        tv_teamb_eco8 = v.findViewById(R.id.tv_teamb_eco8);
        tv_teamb_eco9 = v.findViewById(R.id.tv_teamb_eco9);
        tv_teamb_eco10 = v.findViewById(R.id.tv_teamb_eco10);
        tv_teamb_eco11 = v.findViewById(R.id.tv_teamb_eco11);



        /*a team inning 2*/
        tv_teama2_batsman1 = v.findViewById(R.id.tv_teama2_batsman1);
        tv_teama2_batsman2 = v.findViewById(R.id.tv_teama2_batsman2);
        tv_teama2_batsman3 = v.findViewById(R.id.tv_teama2_batsman3);
        tv_teama2_batsman4 = v.findViewById(R.id.tv_teama2_batsman4);
        tv_teama2_batsman5 = v.findViewById(R.id.tv_teama2_batsman5);
        tv_teama2_batsman6 = v.findViewById(R.id.tv_teama2_batsman6);
        tv_teama2_batsman7 = v.findViewById(R.id.tv_teama2_batsman7);
        tv_teama2_batsman8 = v.findViewById(R.id.tv_teama2_batsman8);
        tv_teama2_batsman9 = v.findViewById(R.id.tv_teama2_batsman9);
        tv_teama2_batsman10 = v.findViewById(R.id.tv_teama2_batsman10);
        tv_teama2_batsman11 = v.findViewById(R.id.tv_teama2_batsman11);
        /*team b inning 1*/
        tv_teamb_batsman1 = v.findViewById(R.id.tv_teamb_batsman1);
        tv_teamb_batsman2 = v.findViewById(R.id.tv_teamb_batsman2);
        tv_teamb_batsman3 = v.findViewById(R.id.tv_teamb_batsman3);
        tv_teamb_batsman4 = v.findViewById(R.id.tv_teamb_batsman4);
        tv_teamb_batsman5 = v.findViewById(R.id.tv_teamb_batsman5);
        tv_teamb_batsman6 = v.findViewById(R.id.tv_teamb_batsman6);
        tv_teamb_batsman7 = v.findViewById(R.id.tv_teamb_batsman7);
        tv_teamb_batsman8 = v.findViewById(R.id.tv_teamb_batsman8);
        tv_teamb_batsman9 = v.findViewById(R.id.tv_teamb_batsman9);
        tv_teamb_batsman10 = v.findViewById(R.id.tv_teamb_batsman10);
        tv_teamb_batsman11 = v.findViewById(R.id.tv_teamb_batsman11);
        /*team b inning 2*/
        tv_teamb2_batsman1 = v.findViewById(R.id.tv_teamb2_batsman1);
        tv_teamb2_batsman2 = v.findViewById(R.id.tv_teamb2_batsman2);
        tv_teamb2_batsman3 = v.findViewById(R.id.tv_teamb2_batsman3);
        tv_teamb2_batsman4 = v.findViewById(R.id.tv_teamb2_batsman4);
        tv_teamb2_batsman5 = v.findViewById(R.id.tv_teamb2_batsman5);
        tv_teamb2_batsman6 = v.findViewById(R.id.tv_teamb2_batsman6);
        tv_teamb2_batsman7 = v.findViewById(R.id.tv_teamb2_batsman7);
        tv_teamb2_batsman8 = v.findViewById(R.id.tv_teamb2_batsman8);
        tv_teamb2_batsman9 = v.findViewById(R.id.tv_teamb2_batsman9);
        tv_teamb2_batsman10 = v.findViewById(R.id.tv_teamb2_batsman10);
        tv_teamb2_batsman11 = v.findViewById(R.id.tv_teamb2_batsman11);


///// TEAM B
        tv_teamb_ball1 = v.findViewById(R.id.tv_teamb_ball1);
        tv_teamb_ball2 = v.findViewById(R.id.tv_teamb_ball2);
        tv_teamb_ball3 = v.findViewById(R.id.tv_teamb_ball3);
        tv_teamb_ball4 = v.findViewById(R.id.tv_teamb_ball4);
        tv_teamb_ball5 = v.findViewById(R.id.tv_teamb_ball5);
        tv_teamb_ball6 = v.findViewById(R.id.tv_teamb_ball6);
        tv_teamb_ball7 = v.findViewById(R.id.tv_teamb_ball7);
        tv_teamb_ball8 = v.findViewById(R.id.tv_teamb_ball8);
        tv_teamb_ball9 = v.findViewById(R.id.tv_teamb_ball9);
        tv_teamb_ball10 = v.findViewById(R.id.tv_teamb_ball10);
        tv_teamb_ball11 = v.findViewById(R.id.tv_teamb_ball11);

        tv_teama_ball1 = v.findViewById(R.id.tv_teama_ball1);
        tv_teama_ball2 = v.findViewById(R.id.tv_teama_ball2);
        tv_teama_ball3 = v.findViewById(R.id.tv_teama_ball3);
        tv_teama_ball4 = v.findViewById(R.id.tv_teama_ball4);
        tv_teama_ball5 = v.findViewById(R.id.tv_teama_ball5);
        tv_teama_ball6 = v.findViewById(R.id.tv_teama_ball6);
        tv_teama_ball7 = v.findViewById(R.id.tv_teama_ball7);
        tv_teama_ball8 = v.findViewById(R.id.tv_teama_ball8);
        tv_teama_ball9 = v.findViewById(R.id.tv_teama_ball9);
        tv_teama_ball10 = v.findViewById(R.id.tv_teama_ball10);
        tv_teama_ball11 = v.findViewById(R.id.tv_teama_ball11);

        tv_teamb_run1 = v.findViewById(R.id.tv_teamb_run1);
        tv_teamb_run2 = v.findViewById(R.id.tv_teamb_run2);
        tv_teamb_run3 = v.findViewById(R.id.tv_teamb_run3);
        tv_teamb_run4 = v.findViewById(R.id.tv_teamb_run4);
        tv_teamb_run5 = v.findViewById(R.id.tv_teamb_run5);
        tv_teamb_run6 = v.findViewById(R.id.tv_teamb_run6);
        tv_teamb_run7 = v.findViewById(R.id.tv_teamb_run7);
        tv_teamb_run8 = v.findViewById(R.id.tv_teamb_run8);
        tv_teamb_run9 = v.findViewById(R.id.tv_teamb_run9);
        tv_teamb_run10 = v.findViewById(R.id.tv_teamb_run10);
        tv_teamb_run11 = v.findViewById(R.id.tv_teamb_run11);

        tv_teama_run1 = v.findViewById(R.id.tv_teama_run1);
        tv_teama_run2 = v.findViewById(R.id.tv_teama_run2);
        tv_teama_run3 = v.findViewById(R.id.tv_teama_run3);
        tv_teama_run4 = v.findViewById(R.id.tv_teama_run4);
        tv_teama_run5 = v.findViewById(R.id.tv_teama_run5);
        tv_teama_run6 = v.findViewById(R.id.tv_teama_run6);
        tv_teama_run7 = v.findViewById(R.id.tv_teama_run7);
        tv_teama_run8 = v.findViewById(R.id.tv_teama_run8);
        tv_teama_run9 = v.findViewById(R.id.tv_teama_run9);
        tv_teama_run10 = v.findViewById(R.id.tv_teama_run10);
        tv_teama_run11 = v.findViewById(R.id.tv_teama_run11);

        tv_teamb_4s1 = v.findViewById(R.id.tv_teamb_4s1);
        tv_teamb_4s2 = v.findViewById(R.id.tv_teamb_4s2);
        tv_teamb_4s3 = v.findViewById(R.id.tv_teamb_4s3);
        tv_teamb_4s4 = v.findViewById(R.id.tv_teamb_4s4);
        tv_teamb_4s5 = v.findViewById(R.id.tv_teamb_4s5);
        tv_teamb_4s6 = v.findViewById(R.id.tv_teamb_4s6);
        tv_teamb_4s7 = v.findViewById(R.id.tv_teamb_4s7);
        tv_teamb_4s8 = v.findViewById(R.id.tv_teamb_4s8);
        tv_teamb_4s9 = v.findViewById(R.id.tv_teamb_4s9);
        tv_teamb_4s10 = v.findViewById(R.id.tv_teamb_4s10);
        tv_teamb_4s11 = v.findViewById(R.id.tv_teamb_4s11);

        tv_teama_4s1 = v.findViewById(R.id.tv_teama_4s1);
        tv_teama_4s2 = v.findViewById(R.id.tv_teama_4s2);
        tv_teama_4s3 = v.findViewById(R.id.tv_teama_4s3);
        tv_teama_4s4 = v.findViewById(R.id.tv_teama_4s4);
        tv_teama_4s5 = v.findViewById(R.id.tv_teama_4s5);
        tv_teama_4s6 = v.findViewById(R.id.tv_teama_4s6);
        tv_teama_4s7 = v.findViewById(R.id.tv_teama_4s7);
        tv_teama_4s8 = v.findViewById(R.id.tv_teama_4s8);
        tv_teama_4s9 = v.findViewById(R.id.tv_teama_4s9);
        tv_teama_4s10 = v.findViewById(R.id.tv_teama_4s10);
        tv_teama_4s11 = v.findViewById(R.id.tv_teama_4s11);

        tv_teamb_6s1 = v.findViewById(R.id.tv_teamb_6s1);
        tv_teamb_6s2 = v.findViewById(R.id.tv_teamb_6s2);
        tv_teamb_6s3 = v.findViewById(R.id.tv_teamb_6s3);
        tv_teamb_6s4 = v.findViewById(R.id.tv_teamb_6s4);
        tv_teamb_6s5 = v.findViewById(R.id.tv_teamb_6s5);
        tv_teamb_6s6 = v.findViewById(R.id.tv_teamb_6s6);
        tv_teamb_6s7 = v.findViewById(R.id.tv_teamb_6s7);
        tv_teamb_6s8 = v.findViewById(R.id.tv_teamb_6s8);
        tv_teamb_6s9 = v.findViewById(R.id.tv_teamb_6s9);
        tv_teamb_6s10 = v.findViewById(R.id.tv_teamb_6s10);
        tv_teamb_6s11 = v.findViewById(R.id.tv_teamb_6s11);

        tv_teama_6s1 = v.findViewById(R.id.tv_teama_6s1);
        tv_teama_6s2 = v.findViewById(R.id.tv_teama_6s2);
        tv_teama_6s3 = v.findViewById(R.id.tv_teama_6s3);
        tv_teama_6s4 = v.findViewById(R.id.tv_teama_6s4);
        tv_teama_6s5 = v.findViewById(R.id.tv_teama_6s5);
        tv_teama_6s6 = v.findViewById(R.id.tv_teama_6s6);
        tv_teama_6s7 = v.findViewById(R.id.tv_teama_6s7);
        tv_teama_6s8 = v.findViewById(R.id.tv_teama_6s8);
        tv_teama_6s9 = v.findViewById(R.id.tv_teama_6s9);
        tv_teama_6s10 = v.findViewById(R.id.tv_teama_6s10);
        tv_teama_6s11 = v.findViewById(R.id.tv_teama_6s11);

        tv_teamb_sr1 = v.findViewById(R.id.tv_teamb_sr1);
        tv_teamb_sr2 = v.findViewById(R.id.tv_teamb_sr2);
        tv_teamb_sr3 = v.findViewById(R.id.tv_teamb_sr3);
        tv_teamb_sr4 = v.findViewById(R.id.tv_teamb_sr4);
        tv_teamb_sr5 = v.findViewById(R.id.tv_teamb_sr5);
        tv_teamb_sr6 = v.findViewById(R.id.tv_teamb_sr6);
        tv_teamb_sr7 = v.findViewById(R.id.tv_teamb_sr7);
        tv_teamb_sr8 = v.findViewById(R.id.tv_teamb_sr8);
        tv_teamb_sr9 = v.findViewById(R.id.tv_teamb_sr9);
        tv_teamb_sr10 = v.findViewById(R.id.tv_teamb_sr10);
        tv_teamb_sr11 = v.findViewById(R.id.tv_teamb_sr11);

        tv_teama_sr1 = v.findViewById(R.id.tv_teama_sr1);
        tv_teama_sr2 = v.findViewById(R.id.tv_teama_sr2);
        tv_teama_sr3 = v.findViewById(R.id.tv_teama_sr3);
        tv_teama_sr4 = v.findViewById(R.id.tv_teama_sr4);
        tv_teama_sr5 = v.findViewById(R.id.tv_teama_sr5);
        tv_teama_sr6 = v.findViewById(R.id.tv_teama_sr6);
        tv_teama_sr7 = v.findViewById(R.id.tv_teama_sr7);
        tv_teama_sr8 = v.findViewById(R.id.tv_teama_sr8);
        tv_teama_sr9 = v.findViewById(R.id.tv_teama_sr9);
        tv_teama_sr10 = v.findViewById(R.id.tv_teama_sr10);
        tv_teama_sr11 = v.findViewById(R.id.tv_teama_sr11);

        /*team b out by*/
        tv_teamb_out1 = v.findViewById(R.id.tv_teamb_out1);
        tv_teamb_out2 = v.findViewById(R.id.tv_teamb_out2);
        tv_teamb_out3 = v.findViewById(R.id.tv_teamb_out3);
        tv_teamb_out4 = v.findViewById(R.id.tv_teamb_out4);
        tv_teamb_out5 = v.findViewById(R.id.tv_teamb_out5);
        tv_teamb_out6 = v.findViewById(R.id.tv_teamb_out6);
        tv_teamb_out7 = v.findViewById(R.id.tv_teamb_out7);
        tv_teamb_out8 = v.findViewById(R.id.tv_teamb_out8);
        tv_teamb_out9 = v.findViewById(R.id.tv_teamb_out9);
        tv_teamb_out10 = v.findViewById(R.id.tv_teamb_out10);
        tv_teamb_out11 = v.findViewById(R.id.tv_teamb_out11);


        /*to hide the team a inning 1*/
        iv_teama_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linear_layout_a1.getVisibility() == View.VISIBLE) {
                    linear_layout_a1.setVisibility(View.GONE);
                } else {
                    linear_layout_a1.setVisibility(View.VISIBLE);
                }

            }
        });

        /*to hide the team a inning 2*/
        iv_teama_up_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (table_team_a_2.getVisibility() == View.VISIBLE) {
                    table_team_a_2.setVisibility(View.GONE);
                } else {
                    table_team_a_2.setVisibility(View.VISIBLE);
                }

            }
        });

        /*hide the visiblity in one day and t20*/
        table_team_b_2.setVisibility(View.GONE);
        table_team_a_2.setVisibility(View.GONE);

        /*to hide the team b inning 1*/
        iv_teamb_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linear_layout_b1.getVisibility() == View.VISIBLE) {
                    linear_layout_b1.setVisibility(View.GONE);
                } else {
                    linear_layout_b1.setVisibility(View.VISIBLE);
                }

            }
        });

        /*to hide the team b inning 2*/
        iv_teamb_up_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (table_team_b_2.getVisibility() == View.VISIBLE) {
                    table_team_b_2.setVisibility(View.GONE);
                } else {
                    table_team_b_2.setVisibility(View.VISIBLE);
                }
            }
        });

        /*tv_a_team = v.findViewById(R.id.tv_a_team);
        tv_b_team = v.findViewById(R.id.tv_b_team);
        tv_batting_a = v.findViewById(R.id.tv_batting_a);
        tv_run_a = v.findViewById(R.id.tv_run_a);
        tv_ball_a = v.findViewById(R.id.tv_ball_a);
        tv_4s_a = v.findViewById(R.id.tv_4s_a);
        tv_6s_a = v.findViewById(R.id.tv_6s_a);
        tv_sr_a = v.findViewById(R.id.tv_sr_a);*/

        SharedPreferences sp = getActivity().getSharedPreferences("tokenpref", 0);
        tokenid = sp.getString("tokenid", null);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            sKey = bundle.getString("skey", "defaultValue");
            loadCuMatch(sKey, tokenid);
        }

        //Toast.makeText(getActivity(), sKey + " ScoreCard", Toast.LENGTH_LONG).show();
        return v;
    }

    private void loadCuMatch(String sKey, String tokenid) {
        String LiveUrl = "https://rest.cricketapi.com/rest/v2/match/" + sKey + "/?access_token="+tokenid;
        StringRequest sr = new StringRequest(0, LiveUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                try {
                    JSONObject jObjresponce = new JSONObject(response);
                    JSONObject jObjdata = jObjresponce.getJSONObject("data");
                    JSONObject jObjCard = jObjdata.getJSONObject("card");
                    JSONObject jObjTeam = jObjCard.getJSONObject("teams");
                    JSONObject jObjA = jObjTeam.getJSONObject("a");
                    JSONObject jObjB = jObjTeam.getJSONObject("b");
                    //  tv_teama_inning_1.setText(jObjA.getString("name"));
                    JSONObject jObjNow = jObjCard.getJSONObject("now");



                    if (jObjNow.getString("batting_team").equalsIgnoreCase("a")) {
                        tv_teama_inning_1.setText(jObjA.getString("name") + "  " + jObjNow.getString("runs_str"));


                    } else {
                        tv_teama_inning_1.setText(jObjA.getString("name") + "  Yet To Bat");

                    }
                    if (jObjNow.getString("batting_team").equalsIgnoreCase("b")) {
                        tv_teamb_inning_1.setText(jObjB.getString("name") + "  " + jObjNow.getString("runs_str"));

                    } else {
                        tv_teamb_inning_1.setText(jObjB.getString("name") + "  Yet To Bat");

                    }

                    //T20
                    if(jObjCard.getString ( "format" ).equalsIgnoreCase ( "t20" )){
                        JSONObject jObjeinnings = jObjCard.getJSONObject ( "innings" );
                        JSONObject jObja_1 = jObjeinnings.getJSONObject ( "a_1" );
                        tv_teama_inning_1.setText(jObjA.getString("name") + "  " + jObja_1.getString("run_str"));
                        JSONObject jObjb_1 = jObjeinnings.getJSONObject ( "b_1" );
                        tv_teamb_inning_1.setText(jObjB.getString("name") + "  " + jObjb_1.getString("run_str"));
                    }

                    //End T20

                    //Batting Team A
                    JSONObject jObjMatchA = jObjA.getJSONObject("match");
                    JSONArray jArraPlay_Xi_A = jObjMatchA.getJSONArray("playing_xi");
                    JSONObject jObjeinnings = jObjCard.getJSONObject ( "innings" );
                    JSONObject jObja_1 = jObjeinnings.getJSONObject ( "a_1" );
                    JSONArray jArrabatting_order = jObja_1.getJSONArray ( "batting_order" );
                    JSONArray jArrabowling_order = jObja_1.getJSONArray ( "bowling_order" );
                    for (int i = 0; i < jArrabatting_order.length(); i++) {
                        ArryPlaying_Xi_A.add(jArrabatting_order.getString(i));
                    }

                    for (int i = 0; i < jArrabowling_order.length(); i++) {
                        ArryPlaying_Xi_A_Bowling.add(jArrabowling_order.getString(i));

                        //Toast.makeText(getActivity(), jArrabowling_order.getString(i), Toast.LENGTH_SHORT).show();
                    }

                    //BAtting Team B
                    JSONObject jObjMatchB = jObjB.getJSONObject("match");
                    JSONArray jArraPlay_Xi_B = jObjMatchB.getJSONArray("playing_xi");
                    JSONObject jObjeinningsB = jObjCard.getJSONObject ( "innings" );
                    JSONObject jObjb_1 = jObjeinningsB.getJSONObject ( "b_1" );
                    JSONArray jArrabatting_orderB = jObjb_1.getJSONArray ( "batting_order" );
                    JSONArray jArrbbowling_order = jObjb_1.getJSONArray ( "bowling_order" );

                    for (int i = 0; i < jArrabatting_orderB.length(); i++) {
                        ArryPlaying_Xi_B.add(jArrabatting_orderB.getString(i));
                    }

                    for (int i = 0; i < jArrbbowling_order.length(); i++) {
                        ArryPlaying_Xi_B_Bowling.add(jArrbbowling_order.getString(i));
                        //
                        // Toast.makeText(getActivity(), jArrbbowling_order.getString(i), Toast.LENGTH_SHORT).show();
                    }

                    // get the value of the dynamic key
                    for (int j = 0; j < ArryPlaying_Xi_B_Bowling.size(); j++) {
                        JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                        Iterator keys = jObjPlayerA.keys();
                        while (keys.hasNext ( )) {
                            // loop to get the dynamic key
                            String currentDynamicKey = ( String ) keys.next ( );
                            HashMap<String, String> hashmap = new HashMap<> ( );

                            if (ArryPlaying_Xi_B_Bowling.get ( j ).equalsIgnoreCase ( currentDynamicKey )) {
                                HashMap<String, String> hashMap1 = new HashMap<> ( );
                                JSONObject currentDynamicValue = jObjPlayerA.getJSONObject ( currentDynamicKey );
                                hashMap1.put ( "name" , currentDynamicValue.getString ( "fullname" ) );

                                String team_a = currentDynamicValue.getString ( "fullname" );
                                JSONObject jObjmatch = currentDynamicValue.getJSONObject ( "match" );
                                JSONObject jObjinnings = jObjmatch.getJSONObject ( "innings" );
                                JSONObject jObj_1 = jObjinnings.getJSONObject ( "1" );
                                JSONObject jObjBatting = jObj_1.getJSONObject ( "bowling" );

                                //hashMap.put("out_str", jObjBatting.getString("out_str"));
                                if (jObjBatting.has ( "dots" )) {
                                    hashMap1.put ( "runs" , String.valueOf ( jObjBatting.getInt ( "runs" ) ) );
                                    hashMap1.put ( "overs" , String.valueOf ( jObjBatting.getInt ( "overs" ) ) );
                                    hashMap1.put ( "maiden_overs" , String.valueOf ( jObjBatting.getInt ( "maiden_overs" ) ) );
                                    hashMap1.put ( "wickets" , String.valueOf ( jObjBatting.getInt ( "wickets" ) ) );
                                    hashMap1.put ( "economy" , String.valueOf ( jObjBatting.getInt ( "economy" ) ) );
                                    /*if (jObjBatting.getBoolean ( "dismissed" )) {
                                        hashMap.put ( "out_str" , jObjBatting.getString ( "out_str" ) );
                                    } else {
                                        hashMap.put ( "out_str" , "Not Out" );
                                    }*/
                                    //hashMap.put("out_str", jObjBatting.getString("out_str"));
                                }
                                ArryHashPlaying_Xi_B_Bowling.add ( hashMap1 );
                                //Toast.makeText(getActivity(), ArryHashPlaying_Xi_A_Bowling.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("bowling_B_data", ArryHashPlaying_Xi_B_Bowling.toString());
                            }
                        }
                    }


                    // get the value of the dynamic key
                    for (int j = 0; j < ArryPlaying_Xi_A_Bowling.size(); j++) {
                        JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                        Iterator keys = jObjPlayerA.keys();
                        while (keys.hasNext ( )) {
                            // loop to get the dynamic key
                            String currentDynamicKey = ( String ) keys.next ( );
                            HashMap<String, String> hashmap = new HashMap<> ( );

                            if (ArryPlaying_Xi_A_Bowling.get ( j ).equalsIgnoreCase ( currentDynamicKey )) {
                                HashMap<String, String> hashMap = new HashMap<> ( );
                                JSONObject currentDynamicValue = jObjPlayerA.getJSONObject ( currentDynamicKey );
                                hashMap.put ( "name" , currentDynamicValue.getString ( "fullname" ) );

                                String team_a = currentDynamicValue.getString ( "fullname" );
                                JSONObject jObjmatch = currentDynamicValue.getJSONObject ( "match" );
                                JSONObject jObjinnings = jObjmatch.getJSONObject ( "innings" );
                                JSONObject jObj_1 = jObjinnings.getJSONObject ( "1" );
                                JSONObject jObjBatting = jObj_1.getJSONObject ( "bowling" );

                                //hashMap.put("out_str", jObjBatting.getString("out_str"));
                                if (jObjBatting.has ( "dots" )) {
                                    hashMap.put ( "runs" , String.valueOf ( jObjBatting.getInt ( "runs" ) ) );
                                    hashMap.put ( "overs" , String.valueOf ( jObjBatting.getInt ( "overs" ) ) );
                                    hashMap.put ( "maiden_overs" , String.valueOf ( jObjBatting.getInt ( "maiden_overs" ) ) );
                                    hashMap.put ( "wickets" , String.valueOf ( jObjBatting.getInt ( "wickets" ) ) );
                                    hashMap.put ( "economy" , String.valueOf ( jObjBatting.getInt ( "economy" ) ) );
                                    /*if (jObjBatting.getBoolean ( "dismissed" )) {
                                        hashMap.put ( "out_str" , jObjBatting.getString ( "out_str" ) );
                                    } else {
                                        hashMap.put ( "out_str" , "Not Out" );
                                    }*/
                                    //hashMap.put("out_str", jObjBatting.getString("out_str"));
                                }
                                ArryHashPlaying_Xi_A_Bowling.add ( hashMap );
                                //Toast.makeText(getActivity(), ArryHashPlaying_Xi_A_Bowling.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("bowling_data", ArryHashPlaying_Xi_A_Bowling.toString());
                            }
                        }
                    }

                        // get the value of the dynamic key
                        for (int j = 0; j < ArryPlaying_Xi_A.size(); j++) {
                            JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                            Iterator keys = jObjPlayerA.keys();
                            while (keys.hasNext ( )) {
                                // loop to get the dynamic key
                                String currentDynamicKey = ( String ) keys.next ( );
                                HashMap<String, String> hashmap = new HashMap<> ( );

                                if (ArryPlaying_Xi_A.get ( j ).equalsIgnoreCase ( currentDynamicKey )) {
                                    HashMap<String, String> hashMap = new HashMap<> ( );
                                    JSONObject currentDynamicValue = jObjPlayerA.getJSONObject ( currentDynamicKey );
                                    hashMap.put ( "name" , currentDynamicValue.getString ( "fullname" ) );

                                    String team_a = currentDynamicValue.getString ( "fullname" );
                                    JSONObject jObjmatch = currentDynamicValue.getJSONObject ( "match" );
                                    JSONObject jObjinnings = jObjmatch.getJSONObject ( "innings" );
                                    JSONObject jObj_1 = jObjinnings.getJSONObject ( "1" );
                                    JSONObject jObjBatting = jObj_1.getJSONObject ( "batting" );

                                    //hashMap.put("out_str", jObjBatting.getString("out_str"));
                                    if (jObjBatting.has ( "runs" )) {
                                        hashMap.put ( "run" , String.valueOf ( jObjBatting.getInt ( "runs" ) ) );
                                        hashMap.put ( "balls" , String.valueOf ( jObjBatting.getInt ( "balls" ) ) );
                                        hashMap.put ( "fours" , String.valueOf ( jObjBatting.getInt ( "fours" ) ) );
                                        hashMap.put ( "sixes" , String.valueOf ( jObjBatting.getInt ( "sixes" ) ) );
                                        hashMap.put ( "strike_rate" , String.valueOf ( jObjBatting.getInt ( "strike_rate" ) ) );
                                        if (jObjBatting.getBoolean ( "dismissed" )) {
                                            hashMap.put ( "out_str" , jObjBatting.getString ( "out_str" ) );
                                        } else {
                                            hashMap.put ( "out_str" , "Not Out" );
                                        }
                                        //hashMap.put("out_str", jObjBatting.getString("out_str"));
                                    }
                                    ArryHashPlaying_Xi_A.add ( hashMap );

                                }
                            }
                        }
                            for (int jj = 0; jj < ArryPlaying_Xi_B.size(); jj++) {
                                JSONObject jObjPlayerA = jObjCard.getJSONObject("players");
                                Iterator keys = jObjPlayerA.keys();
                                while (keys.hasNext()) {
                                    // loop to get the dynamic key
                                    String currentDynamicKey = ( String ) keys.next ( );
                                    HashMap<String, String> hashmap = new HashMap<> ( );

                                    if (currentDynamicKey.equalsIgnoreCase ( ArryPlaying_Xi_B.get ( jj ) )) {
                                        HashMap<String, String> hashMap = new HashMap<> ( );
                                        JSONObject currentDynamicValue = jObjPlayerA.getJSONObject ( currentDynamicKey );
                                        hashMap.put ( "name" , currentDynamicValue.getString ( "fullname" ) );

                                        String team_a = currentDynamicValue.getString ( "fullname" );
                                        JSONObject jObjmatch = currentDynamicValue.getJSONObject ( "match" );
                                        JSONObject jObjinnings = jObjmatch.getJSONObject ( "innings" );
                                        JSONObject jObj_1 = jObjinnings.getJSONObject ( "1" );
                                        JSONObject jObjBatting = jObj_1.getJSONObject ( "batting" );

                                        if (jObjBatting.getBoolean ( "dismissed" )) {
                                            hashMap.put ( "out_str" , jObjBatting.getString ( "out_str" ) );
                                        } else {
                                            hashMap.put ( "out_str" , "Not Out" );
                                        }

                                        if (jObjBatting.has ( "runs" )) {
                                            hashMap.put ( "run" , String.valueOf ( jObjBatting.getInt ( "runs" ) ) );
                                            hashMap.put ( "balls" , String.valueOf ( jObjBatting.getInt ( "balls" ) ) );
                                            hashMap.put ( "fours" , String.valueOf ( jObjBatting.getInt ( "fours" ) ) );
                                            hashMap.put ( "sixes" , String.valueOf ( jObjBatting.getInt ( "sixes" ) ) );
                                            hashMap.put ( "strike_rate" , String.valueOf ( jObjBatting.getInt ( "strike_rate" ) ) );

                                        }

                                        ArryHashPlaying_Xi_B.add ( hashMap );

                                    }



                        }

                        //Toast.makeText(MainActivity.this, ArryHashPlaying_Xi_A.size() + "", Toast.LENGTH_SHORT).show();
                        Log.d("array", ArryHashPlaying_Xi_A.toString());
                        /*display team a player name*/
                        Log.d("team a", ArryHashPlaying_Xi_A.toString());

                       // Log.d("currentDynamicKey", currentDynamicKey);
                    }

                    /*display bowling data A team*/
                    if(0<ArryHashPlaying_Xi_B_Bowling.size ()) {
                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 0 );
                        tv_teama_bowler1.setText ( hash_b.get ( "name" ) );
                        tv_teama_over1.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run1.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan1.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco1.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket1.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler1.setVisibility(View.GONE);
                        tv_teama_over1.setVisibility(View.GONE);
                        tv_teama_b_run1.setVisibility(View.GONE);
                        tv_teama_maidan1.setVisibility(View.GONE );
                        tv_teama_eco1.setVisibility(View.GONE );
                        tv_teama_wicket1.setVisibility(View.GONE );
                    }
                    if(1<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 1 );
                        tv_teama_bowler2.setText ( hash_b.get ( "name" ) );
                        tv_teama_over2.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run2.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan2.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco2.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket2.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler2.setVisibility(View.GONE);
                        tv_teama_over2.setVisibility(View.GONE);
                        tv_teama_b_run2.setVisibility(View.GONE);
                        tv_teama_maidan2.setVisibility(View.GONE );
                        tv_teama_eco2.setVisibility(View.GONE );
                        tv_teama_wicket2.setVisibility(View.GONE );
                    }
                    if(2<ArryHashPlaying_Xi_B_Bowling.size ()) {
                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 2 );
                        tv_teama_bowler3.setText ( hash_b.get ( "name" ) );
                        tv_teama_over3.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run3.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan3.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco3.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket3.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler3.setVisibility(View.GONE);
                        tv_teama_over3.setVisibility(View.GONE);
                        tv_teama_b_run3.setVisibility(View.GONE);
                        tv_teama_maidan3.setVisibility(View.GONE );
                        tv_teama_eco3.setVisibility(View.GONE );
                        tv_teama_wicket3.setVisibility(View.GONE );
                    }


                    if(3<ArryHashPlaying_Xi_B_Bowling.size ()) {
                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 3 );
                        tv_teama_bowler4.setText ( hash_b.get ( "name" ) );
                        tv_teama_over4.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run4.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan4.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco4.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket4.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler4.setVisibility(View.GONE);
                        tv_teama_over4.setVisibility(View.GONE);
                        tv_teama_b_run4.setVisibility(View.GONE);
                        tv_teama_maidan4.setVisibility(View.GONE);
                        tv_teama_eco4.setVisibility(View.GONE);
                        tv_teama_wicket4.setVisibility(View.GONE);
                    }

                    if(4<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 4 );
                        tv_teama_bowler5.setText ( hash_b.get ( "name" ) );
                        tv_teama_over5.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run5.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan5.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco5.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket5.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler5.setVisibility(View.GONE);
                        tv_teama_over5.setVisibility(View.GONE);
                        tv_teama_b_run5.setVisibility(View.GONE);
                        tv_teama_maidan5.setVisibility(View.GONE);
                        tv_teama_eco5.setVisibility(View.GONE);
                        tv_teama_wicket5.setVisibility(View.GONE);
                    }
                    if(5<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 5 );
                        tv_teama_bowler6.setText ( hash_b.get ( "name" ) );
                        tv_teama_over6.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run6.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan6.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco6.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket6.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler6.setVisibility(View.GONE);
                        tv_teama_over6.setVisibility(View.GONE);
                        tv_teama_b_run6.setVisibility(View.GONE);
                        tv_teama_maidan6.setVisibility(View.GONE);
                        tv_teama_eco6.setVisibility(View.GONE);
                        tv_teama_wicket6.setVisibility(View.GONE);
                    }
                    if(6<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 6 );
                        tv_teama_bowler7.setText ( hash_b.get ( "name" ) );
                        tv_teama_over7.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run7.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan7.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco7.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket7.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler7.setVisibility(View.GONE);
                        tv_teama_over7.setVisibility(View.GONE);
                        tv_teama_b_run7.setVisibility(View.GONE);
                        tv_teama_maidan7.setVisibility(View.GONE);
                        tv_teama_eco7.setVisibility(View.GONE);
                        tv_teama_wicket7.setVisibility(View.GONE);
                    }
                    if(7<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 7 );
                        tv_teama_bowler8.setText ( hash_b.get ( "name" ) );
                        tv_teama_over8.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run8.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan8.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco8.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket8.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler8.setVisibility(View.GONE);
                        tv_teama_over8.setVisibility(View.GONE);
                        tv_teama_b_run8.setVisibility(View.GONE);
                        tv_teama_maidan8.setVisibility(View.GONE);
                        tv_teama_eco8.setVisibility(View.GONE);
                        tv_teama_wicket8.setVisibility(View.GONE);
                    }
                    if(8<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 8 );
                        tv_teama_bowler9.setText ( hash_b.get ( "name" ) );
                        tv_teama_over9.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run9.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan9.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco9.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket9.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler9.setVisibility(View.GONE);
                        tv_teama_over9.setVisibility(View.GONE);
                        tv_teama_b_run9.setVisibility(View.GONE);
                        tv_teama_maidan9.setVisibility(View.GONE);
                        tv_teama_eco9.setVisibility(View.GONE);
                        tv_teama_wicket9.setVisibility(View.GONE);
                    }

                    if(9<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 9 );
                        tv_teama_bowler10.setText ( hash_b.get ( "name" ) );
                        tv_teama_over10.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run10.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan10.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco10.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket10.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler10.setVisibility(View.GONE);
                        tv_teama_over10.setVisibility(View.GONE);
                        tv_teama_b_run10.setVisibility(View.GONE);
                        tv_teama_maidan10.setVisibility(View.GONE);
                        tv_teama_eco10.setVisibility(View.GONE);
                        tv_teama_wicket10.setVisibility(View.GONE);
                    }
                    if(10<ArryHashPlaying_Xi_B_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B_Bowling.get ( 10 );
                        tv_teama_bowler11.setText ( hash_b.get ( "name" ) );
                        tv_teama_over11.setText ( hash_b.get ( "overs" ) );
                        tv_teama_b_run11.setText ( hash_b.get ( "runs" ) );
                        tv_teama_maidan11.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teama_eco11.setText ( hash_b.get ( "economy" ) );
                        tv_teama_wicket11.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teama_bowler11.setVisibility(View.GONE);
                        tv_teama_over11.setVisibility(View.GONE);
                        tv_teama_b_run11.setVisibility(View.GONE);
                        tv_teama_maidan11.setVisibility(View.GONE);
                        tv_teama_eco11.setVisibility(View.GONE);
                        tv_teama_wicket11.setVisibility(View.GONE);
                    }


                    /*display bowling data B team*/
                    if(0<ArryHashPlaying_Xi_A_Bowling.size ()) {
                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 0 );
                        tv_teamb_bowler1.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over1.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run1.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan1.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco1.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket1.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler1.setVisibility(View.GONE);
                        tv_teamb_over1.setVisibility(View.GONE);
                        tv_teamb_b_run1.setVisibility(View.GONE);
                        tv_teamb_maidan1.setVisibility(View.GONE );
                        tv_teamb_eco1.setVisibility(View.GONE );
                        tv_teamb_wicket1.setVisibility(View.GONE );
                    }
                    if(1<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 1 );
                        tv_teamb_bowler2.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over2.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run2.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan2.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco2.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket2.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler2.setVisibility(View.GONE);
                        tv_teamb_over2.setVisibility(View.GONE);
                        tv_teamb_b_run2.setVisibility(View.GONE);
                        tv_teamb_maidan2.setVisibility(View.GONE );
                        tv_teamb_eco2.setVisibility(View.GONE );
                        tv_teamb_wicket2.setVisibility(View.GONE );
                    }
                    if(2<ArryHashPlaying_Xi_A_Bowling.size ()) {
                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 2 );
                        tv_teamb_bowler3.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over3.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run3.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan3.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco3.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket3.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler3.setVisibility(View.GONE);
                        tv_teamb_over3.setVisibility(View.GONE);
                        tv_teamb_b_run3.setVisibility(View.GONE);
                        tv_teamb_maidan3.setVisibility(View.GONE );
                        tv_teamb_eco3.setVisibility(View.GONE );
                        tv_teamb_wicket3.setVisibility(View.GONE );
                    }


                    if(3<ArryHashPlaying_Xi_A_Bowling.size ()) {
                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 3 );
                        tv_teamb_bowler4.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over4.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run4.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan4.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco4.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket4.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler4.setVisibility(View.GONE);
                        tv_teamb_over4.setVisibility(View.GONE);
                        tv_teamb_b_run4.setVisibility(View.GONE);
                        tv_teamb_maidan4.setVisibility(View.GONE);
                        tv_teamb_eco4.setVisibility(View.GONE);
                        tv_teamb_wicket4.setVisibility(View.GONE);
                    }

                    if(4<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 4 );
                        tv_teamb_bowler5.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over5.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run5.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan5.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco5.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket5.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler5.setVisibility(View.GONE);
                        tv_teamb_over5.setVisibility(View.GONE);
                        tv_teamb_b_run5.setVisibility(View.GONE);
                        tv_teamb_maidan5.setVisibility(View.GONE);
                        tv_teamb_eco5.setVisibility(View.GONE);
                        tv_teamb_wicket5.setVisibility(View.GONE);
                    }
                    if(5<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 5 );
                        tv_teamb_bowler6.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over6.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run6.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan6.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco6.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket6.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler6.setVisibility(View.GONE);
                        tv_teamb_over6.setVisibility(View.GONE);
                        tv_teamb_b_run6.setVisibility(View.GONE);
                        tv_teamb_maidan6.setVisibility(View.GONE);
                        tv_teamb_eco6.setVisibility(View.GONE);
                        tv_teamb_wicket6.setVisibility(View.GONE);
                    }
                    if(6<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 6 );
                        tv_teamb_bowler7.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over7.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run7.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan7.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco7.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket7.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler7.setVisibility(View.GONE);
                        tv_teamb_over7.setVisibility(View.GONE);
                        tv_teamb_b_run7.setVisibility(View.GONE);
                        tv_teamb_maidan7.setVisibility(View.GONE);
                        tv_teamb_eco7.setVisibility(View.GONE);
                        tv_teamb_wicket7.setVisibility(View.GONE);
                    }
                    if(7<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 7 );
                        tv_teamb_bowler8.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over8.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run8.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan8.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco8.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket8.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler8.setVisibility(View.GONE);
                        tv_teamb_over8.setVisibility(View.GONE);
                        tv_teamb_b_run8.setVisibility(View.GONE);
                        tv_teamb_maidan8.setVisibility(View.GONE);
                        tv_teamb_eco8.setVisibility(View.GONE);
                        tv_teamb_wicket8.setVisibility(View.GONE);
                    }
                    if(8<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 8 );
                        tv_teamb_bowler9.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over9.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run9.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan9.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco9.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket9.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler9.setVisibility(View.GONE);
                        tv_teamb_over9.setVisibility(View.GONE);
                        tv_teamb_b_run9.setVisibility(View.GONE);
                        tv_teamb_maidan9.setVisibility(View.GONE);
                        tv_teamb_eco9.setVisibility(View.GONE);
                        tv_teamb_wicket9.setVisibility(View.GONE);
                    }

                    if(9<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 9 );
                        tv_teamb_bowler10.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over10.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run10.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan10.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco10.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket10.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler10.setVisibility(View.GONE);
                        tv_teamb_over10.setVisibility(View.GONE);
                        tv_teamb_b_run10.setVisibility(View.GONE);
                        tv_teamb_maidan10.setVisibility(View.GONE);
                        tv_teamb_eco10.setVisibility(View.GONE);
                        tv_teamb_wicket10.setVisibility(View.GONE);
                    }
                    if(10<ArryHashPlaying_Xi_A_Bowling.size ()) {

                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_A_Bowling.get ( 10 );
                        tv_teamb_bowler11.setText ( hash_b.get ( "name" ) );
                        tv_teamb_over11.setText ( hash_b.get ( "overs" ) );
                        tv_teamb_b_run11.setText ( hash_b.get ( "runs" ) );
                        tv_teamb_maidan11.setText ( hash_b.get ( "maiden_overs" ) );
                        tv_teamb_eco11.setText ( hash_b.get ( "economy" ) );
                        tv_teamb_wicket11.setText ( hash_b.get ( "wickets" ) );
                        //tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_bowler11.setVisibility(View.GONE);
                        tv_teamb_over11.setVisibility(View.GONE);
                        tv_teamb_b_run11.setVisibility(View.GONE);
                        tv_teamb_maidan11.setVisibility(View.GONE);
                        tv_teamb_eco11.setVisibility(View.GONE);
                        tv_teamb_wicket11.setVisibility(View.GONE);
                    }


                    //End Batting Team B
                    if(0<ArryHashPlaying_Xi_B.size ()) {
                        HashMap<String, String> hash_b = ArryHashPlaying_Xi_B.get ( 0 );
                        tv_teamb_batsman1.setText ( hash_b.get ( "name" ) );
                        tv_teamb_ball1.setText ( hash_b.get ( "balls" ) );
                        tv_teamb_run1.setText ( hash_b.get ( "run" ) );
                        tv_teamb_4s1.setText ( hash_b.get ( "fours" ) );
                        tv_teamb_6s1.setText ( hash_b.get ( "sixes" ) );
                        tv_teamb_sr1.setText ( hash_b.get ( "strike_rate" ) );
                        tv_teamb_out1.setText ( hash_b.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman1.setVisibility ( View.GONE );
                        tv_teamb_ball1.setVisibility ( View.GONE );
                        tv_teamb_run1.setVisibility ( View.GONE );
                        tv_teamb_4s1.setVisibility ( View.GONE );
                        tv_teamb_6s1.setVisibility ( View.GONE );
                        tv_teamb_sr1.setVisibility ( View.GONE );
                        tv_teamb_out1.setVisibility ( View.GONE );
                    }
                    if(1<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_1 = ArryHashPlaying_Xi_B.get ( 1 );
                        tv_teamb_batsman2.setText ( hash_b_1.get ( "name" ) );
                        tv_teamb_ball2.setText ( hash_b_1.get ( "balls" ) );
                        tv_teamb_run2.setText ( hash_b_1.get ( "run" ) );
                        tv_teamb_4s2.setText ( hash_b_1.get ( "fours" ) );
                        tv_teamb_6s2.setText ( hash_b_1.get ( "sixes" ) );
                        tv_teamb_sr2.setText ( hash_b_1.get ( "strike_rate" ) );
                        tv_teamb_out2.setText ( hash_b_1.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman2.setVisibility ( View.GONE );
                        tv_teamb_ball2.setVisibility ( View.GONE );
                        tv_teamb_run2.setVisibility ( View.GONE );
                        tv_teamb_4s2.setVisibility ( View.GONE );
                        tv_teamb_6s2.setVisibility ( View.GONE );
                        tv_teamb_sr2.setVisibility ( View.GONE );
                        tv_teamb_out2.setVisibility ( View.GONE );
                    }
                    if(2<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_2 = ArryHashPlaying_Xi_B.get ( 2 );
                        tv_teamb_batsman3.setText ( hash_b_2.get ( "name" ) );
                        tv_teamb_ball3.setText ( hash_b_2.get ( "balls" ) );
                        tv_teamb_run3.setText ( hash_b_2.get ( "run" ) );
                        tv_teamb_4s3.setText ( hash_b_2.get ( "fours" ) );
                        tv_teamb_6s3.setText ( hash_b_2.get ( "sixes" ) );
                        tv_teamb_sr3.setText ( hash_b_2.get ( "strike_rate" ) );
                        tv_teamb_out3.setText ( hash_b_2.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman3.setVisibility ( View.GONE );
                        tv_teamb_ball3.setVisibility ( View.GONE );
                        tv_teamb_run3.setVisibility ( View.GONE );
                        tv_teamb_4s3.setVisibility ( View.GONE );
                        tv_teamb_6s3.setVisibility ( View.GONE );
                        tv_teamb_sr3.setVisibility ( View.GONE );
                        tv_teamb_out3.setVisibility ( View.GONE );
                    }


                    if(3<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_3 = ArryHashPlaying_Xi_B.get ( 3 );
                        if (hash_b_3.size ( ) > 1) {
                            tv_teamb_batsman4.setText ( hash_b_3.get ( "name" ) );
                            tv_teamb_ball4.setText ( hash_b_3.get ( "balls" ) );
                            tv_teamb_run4.setText ( hash_b_3.get ( "run" ) );
                            tv_teamb_4s4.setText ( hash_b_3.get ( "fours" ) );
                            tv_teamb_6s4.setText ( hash_b_3.get ( "sixes" ) );
                            tv_teamb_sr4.setText ( hash_b_3.get ( "strike_rate" ) );
                            tv_teamb_out4.setText ( hash_b_3.get ( "out_str" ) );
                        } else {
                            tv_teamb_batsman4.setText ( hash_b_3.get ( "name" ) );
                            tv_teamb_ball4.setText ( "-" );
                            tv_teamb_run4.setText ( "-" );
                            tv_teamb_4s4.setText ( "-" );
                            tv_teamb_6s4.setText ( "-" );
                            tv_teamb_sr4.setText ( "-" );
                        }
                    }else {
                        tv_teamb_batsman4.setVisibility ( View.GONE );
                        tv_teamb_ball4.setVisibility ( View.GONE );
                        tv_teamb_run4.setVisibility ( View.GONE );
                        tv_teamb_4s4.setVisibility ( View.GONE );
                        tv_teamb_6s4.setVisibility ( View.GONE );
                        tv_teamb_sr4.setVisibility ( View.GONE );
                        tv_teamb_out4.setVisibility ( View.GONE );
                    }

                    if(4<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_4 = ArryHashPlaying_Xi_B.get ( 4 );
                        tv_teamb_batsman5.setText ( hash_b_4.get ( "name" ) );
                        tv_teamb_ball5.setText ( hash_b_4.get ( "balls" ) );
                        tv_teamb_run5.setText ( hash_b_4.get ( "run" ) );
                        tv_teamb_4s5.setText ( hash_b_4.get ( "fours" ) );
                        tv_teamb_6s5.setText ( hash_b_4.get ( "sixes" ) );
                        tv_teamb_sr5.setText ( hash_b_4.get ( "strike_rate" ) );
                        tv_teamb_out5.setText ( hash_b_4.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman5.setVisibility ( View.GONE );
                        tv_teamb_ball5.setVisibility ( View.GONE );
                        tv_teamb_run5.setVisibility ( View.GONE );
                        tv_teamb_4s5.setVisibility ( View.GONE );
                        tv_teamb_6s5.setVisibility ( View.GONE );
                        tv_teamb_sr5.setVisibility ( View.GONE );
                        tv_teamb_out5.setVisibility ( View.GONE );
                    }
                        if(5<ArryHashPlaying_Xi_B.size ()) {

                            HashMap<String, String> hash_b_5 = ArryHashPlaying_Xi_B.get ( 5 );
                        tv_teamb_batsman6.setText ( hash_b_5.get ( "name" ) );
                        tv_teamb_ball6.setText ( hash_b_5.get ( "balls" ) );
                        tv_teamb_run6.setText ( hash_b_5.get ( "run" ) );
                        tv_teamb_4s6.setText ( hash_b_5.get ( "fours" ) );
                        tv_teamb_6s6.setText ( hash_b_5.get ( "sixes" ) );
                        tv_teamb_sr6.setText ( hash_b_5.get ( "strike_rate" ) );
                        tv_teamb_out6.setText ( hash_b_5.get ( "out_str" ) );
                    }else {
                            tv_teamb_batsman6.setVisibility ( View.GONE );
                            tv_teamb_ball6.setVisibility ( View.GONE );
                            tv_teamb_run6.setVisibility ( View.GONE );
                            tv_teamb_4s6.setVisibility ( View.GONE );
                            tv_teamb_6s6.setVisibility ( View.GONE );
                            tv_teamb_sr6.setVisibility ( View.GONE );
                            tv_teamb_out6.setVisibility ( View.GONE );
                        }
                    if(6<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_6 = ArryHashPlaying_Xi_B.get ( 6 );
                        tv_teamb_batsman7.setText ( hash_b_6.get ( "name" ) );
                        tv_teamb_ball7.setText ( hash_b_6.get ( "balls" ) );
                        tv_teamb_run7.setText ( hash_b_6.get ( "run" ) );
                        tv_teamb_4s7.setText ( hash_b_6.get ( "fours" ) );
                        tv_teamb_6s7.setText ( hash_b_6.get ( "sixes" ) );
                        tv_teamb_sr7.setText ( hash_b_6.get ( "strike_rate" ) );
                        tv_teamb_out7.setText ( hash_b_6.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman7.setVisibility ( View.GONE );
                        tv_teamb_ball7.setVisibility ( View.GONE );
                        tv_teamb_run7.setVisibility ( View.GONE );
                        tv_teamb_4s7.setVisibility ( View.GONE );
                        tv_teamb_6s7.setVisibility ( View.GONE );
                        tv_teamb_sr7.setVisibility ( View.GONE );
                        tv_teamb_out7.setVisibility ( View.GONE );
                    }
                    if(7<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_7 = ArryHashPlaying_Xi_B.get ( 7 );
                        tv_teamb_batsman8.setText ( hash_b_7.get ( "name" ) );
                        tv_teamb_ball8.setText ( hash_b_7.get ( "balls" ) );
                        tv_teamb_run8.setText ( hash_b_7.get ( "run" ) );
                        tv_teamb_4s8.setText ( hash_b_7.get ( "fours" ) );
                        tv_teamb_6s8.setText ( hash_b_7.get ( "sixes" ) );
                        tv_teamb_sr8.setText ( hash_b_7.get ( "strike_rate" ) );
                        tv_teamb_out8.setText ( hash_b_7.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman8.setVisibility ( View.GONE );
                        tv_teamb_ball8.setVisibility ( View.GONE );
                        tv_teamb_run8.setVisibility ( View.GONE );
                        tv_teamb_4s8.setVisibility ( View.GONE );
                        tv_teamb_6s8.setVisibility ( View.GONE );
                        tv_teamb_sr8.setVisibility ( View.GONE );
                        tv_teamb_out8.setVisibility ( View.GONE );
                    }
                    if(8<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_8 = ArryHashPlaying_Xi_B.get ( 8 );
                        tv_teamb_batsman9.setText ( hash_b_8.get ( "name" ) );
                        tv_teamb_ball9.setText ( hash_b_8.get ( "balls" ) );
                        tv_teamb_run9.setText ( hash_b_8.get ( "run" ) );
                        tv_teamb_4s9.setText ( hash_b_8.get ( "fours" ) );
                        tv_teamb_6s9.setText ( hash_b_8.get ( "sixes" ) );
                        tv_teamb_sr9.setText ( hash_b_8.get ( "strike_rate" ) );
                        tv_teamb_out9.setText ( hash_b_8.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman9.setVisibility ( View.GONE );
                        tv_teamb_ball9.setVisibility ( View.GONE );
                        tv_teamb_run9.setVisibility ( View.GONE );
                        tv_teamb_4s9.setVisibility ( View.GONE );
                        tv_teamb_6s9.setVisibility ( View.GONE );
                        tv_teamb_sr9.setVisibility ( View.GONE );
                        tv_teamb_out9.setVisibility ( View.GONE );
                    }

                    if(9<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_9 = ArryHashPlaying_Xi_B.get ( 9 );
                        tv_teamb_batsman10.setText ( hash_b_9.get ( "name" ) );
                        tv_teamb_ball10.setText ( hash_b_9.get ( "balls" ) );
                        tv_teamb_run10.setText ( hash_b_9.get ( "run" ) );
                        tv_teamb_4s10.setText ( hash_b_9.get ( "fours" ) );
                        tv_teamb_6s10.setText ( hash_b_9.get ( "sixes" ) );
                        tv_teamb_sr10.setText ( hash_b_9.get ( "strike_rate" ) );
                        tv_teamb_out10.setText ( hash_b_9.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman10.setVisibility ( View.GONE );
                        tv_teamb_ball10.setVisibility ( View.GONE );
                        tv_teamb_run10.setVisibility ( View.GONE );
                        tv_teamb_4s10.setVisibility ( View.GONE );
                        tv_teamb_6s10.setVisibility ( View.GONE );
                        tv_teamb_sr10.setVisibility ( View.GONE );
                        tv_teamb_out10.setVisibility ( View.GONE );
                    }
                    if(10<ArryHashPlaying_Xi_B.size ()) {

                        HashMap<String, String> hash_b_10 = ArryHashPlaying_Xi_B.get ( 10 );
                        tv_teamb_batsman11.setText ( hash_b_10.get ( "name" ) );
                        tv_teamb_ball11.setText ( hash_b_10.get ( "balls" ) );
                        tv_teamb_run11.setText ( hash_b_10.get ( "run" ) );
                        tv_teamb_4s11.setText ( hash_b_10.get ( "fours" ) );
                        tv_teamb_6s11.setText ( hash_b_10.get ( "sixes" ) );
                        tv_teamb_sr11.setText ( hash_b_10.get ( "strike_rate" ) );
                        tv_teamb_out11.setText ( hash_b_10.get ( "out_str" ) );
                    }else {
                        tv_teamb_batsman11.setVisibility ( View.GONE );
                        tv_teamb_ball11.setVisibility ( View.GONE );
                        tv_teamb_run11.setVisibility ( View.GONE );
                        tv_teamb_4s11.setVisibility ( View.GONE );
                        tv_teamb_6s11.setVisibility ( View.GONE );
                        tv_teamb_sr11.setVisibility ( View.GONE );
                        tv_teamb_out11.setVisibility ( View.GONE );
                    }
                    //End Batting Team A
                    if(0<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash = ArryHashPlaying_Xi_A.get ( 0 );
                        tv_teama_batsman1.setText ( hash.get ( "name" ) );
                        tv_teama_run1.setText ( hash.get ( "run" ) );
                        tv_teama_ball1.setText ( hash.get ( "balls" ) );
                        tv_teama_4s1.setText ( hash.get ( "fours" ) );
                        tv_teama_6s1.setText ( hash.get ( "sixes" ) );
                        tv_teama_sr1.setText ( hash.get ( "strike_rate" ) );
                        tv_teama_out1.setText ( hash.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman1.setVisibility ( View.GONE );
                        tv_teama_ball1.setVisibility ( View.GONE );
                        tv_teama_run1.setVisibility ( View.GONE );
                        tv_teama_4s1.setVisibility ( View.GONE );
                        tv_teama_6s1.setVisibility ( View.GONE );
                        tv_teama_sr1.setVisibility ( View.GONE );
                        tv_teama_out1.setVisibility ( View.GONE );
                    }
                    if(1<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_1 = ArryHashPlaying_Xi_A.get ( 1 );
                        tv_teama_batsman2.setText ( hash_1.get ( "name" ) );
                        tv_teama_run2.setText ( hash_1.get ( "run" ) );
                        tv_teama_ball2.setText ( hash_1.get ( "balls" ) );
                        tv_teama_4s2.setText ( hash_1.get ( "fours" ) );
                        tv_teama_6s2.setText ( hash_1.get ( "sixes" ) );
                        tv_teama_sr2.setText ( hash_1.get ( "strike_rate" ) );
                        tv_teama_out2.setText ( hash_1.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman2.setVisibility ( View.GONE );
                        tv_teama_ball2.setVisibility ( View.GONE );
                        tv_teama_run2.setVisibility ( View.GONE );
                        tv_teama_4s2.setVisibility ( View.GONE );
                        tv_teama_6s2.setVisibility ( View.GONE );
                        tv_teama_sr2.setVisibility ( View.GONE );
                        tv_teama_out2.setVisibility ( View.GONE );
                    }

                    if(2<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_2 = ArryHashPlaying_Xi_A.get ( 2 );
                        tv_teama_batsman3.setText ( hash_2.get ( "name" ) );
                        tv_teama_run3.setText ( hash_2.get ( "run" ) );
                        tv_teama_ball3.setText ( hash_2.get ( "balls" ) );
                        tv_teama_4s3.setText ( hash_2.get ( "fours" ) );
                        tv_teama_6s3.setText ( hash_2.get ( "sixes" ) );
                        tv_teama_sr3.setText ( hash_2.get ( "strike_rate" ) );
                        tv_teama_out3.setText ( hash_2.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman3.setVisibility ( View.GONE );
                        tv_teama_ball3.setVisibility ( View.GONE );
                        tv_teama_run3.setVisibility ( View.GONE );
                        tv_teama_4s3.setVisibility ( View.GONE );
                        tv_teama_6s3.setVisibility ( View.GONE );
                        tv_teama_sr3.setVisibility ( View.GONE );
                        tv_teama_out3.setVisibility ( View.GONE );
                    }

                    if(3<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_3 = ArryHashPlaying_Xi_A.get ( 3 );
                        tv_teama_batsman4.setText ( hash_3.get ( "name" ) );
                        tv_teama_run4.setText ( hash_3.get ( "run" ) );
                        tv_teama_ball4.setText ( hash_3.get ( "balls" ) );
                        tv_teama_4s4.setText ( hash_3.get ( "fours" ) );
                        tv_teama_6s4.setText ( hash_3.get ( "sixes" ) );
                        tv_teama_sr4.setText ( hash_3.get ( "strike_rate" ) );
                        tv_teama_out4.setText ( hash_3.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman4.setVisibility ( View.GONE );
                        tv_teama_ball4.setVisibility ( View.GONE );
                        tv_teama_run4.setVisibility ( View.GONE );
                        tv_teama_4s4.setVisibility ( View.GONE );
                        tv_teama_6s4.setVisibility ( View.GONE );
                        tv_teama_sr4.setVisibility ( View.GONE );
                        tv_teama_out4.setVisibility ( View.GONE );
                    }

                    if(4<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_4 = ArryHashPlaying_Xi_A.get ( 4 );
                        tv_teama_batsman5.setText ( hash_4.get ( "name" ) );
                        tv_teama_run5.setText ( hash_4.get ( "run" ) );
                        tv_teama_ball5.setText ( hash_4.get ( "balls" ) );
                        tv_teama_4s5.setText ( hash_4.get ( "fours" ) );
                        tv_teama_6s5.setText ( hash_4.get ( "sixes" ) );
                        tv_teama_sr5.setText ( hash_4.get ( "strike_rate" ) );
                        tv_teama_out5.setText ( hash_4.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman5.setVisibility ( View.GONE );
                        tv_teama_ball5.setVisibility ( View.GONE );
                        tv_teama_run5.setVisibility ( View.GONE );
                        tv_teama_4s5.setVisibility ( View.GONE );
                        tv_teama_6s5.setVisibility ( View.GONE );
                        tv_teama_sr5.setVisibility ( View.GONE );
                        tv_teama_out5.setVisibility ( View.GONE );
                    }
                    if(5<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_5 = ArryHashPlaying_Xi_A.get ( 5 );
                        tv_teama_batsman6.setText ( hash_5.get ( "name" ) );
                        tv_teama_run6.setText ( hash_5.get ( "run" ) );
                        tv_teama_ball6.setText ( hash_5.get ( "balls" ) );
                        tv_teama_4s6.setText ( hash_5.get ( "fours" ) );
                        tv_teama_6s6.setText ( hash_5.get ( "sixes" ) );
                        tv_teama_sr6.setText ( hash_5.get ( "strike_rate" ) );
                        tv_teama_out6.setText ( hash_5.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman6.setVisibility ( View.GONE );
                        tv_teama_ball6.setVisibility ( View.GONE );
                        tv_teama_run6.setVisibility ( View.GONE );
                        tv_teama_4s6.setVisibility ( View.GONE );
                        tv_teama_6s6.setVisibility ( View.GONE );
                        tv_teama_sr6.setVisibility ( View.GONE );
                        tv_teama_out6.setVisibility ( View.GONE );
                    }

                    if(6<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_6 = ArryHashPlaying_Xi_A.get ( 6 );
                        tv_teama_batsman7.setText ( hash_6.get ( "name" ) );
                        tv_teama_run7.setText ( hash_6.get ( "run" ) );
                        tv_teama_ball7.setText ( hash_6.get ( "balls" ) );
                        tv_teama_4s7.setText ( hash_6.get ( "fours" ) );
                        tv_teama_6s7.setText ( hash_6.get ( "sixes" ) );
                        tv_teama_sr7.setText ( hash_6.get ( "strike_rate" ) );
                        tv_teama_out7.setText ( hash_6.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman7.setVisibility ( View.GONE );
                        tv_teama_ball7.setVisibility ( View.GONE );
                        tv_teama_run7.setVisibility ( View.GONE );
                        tv_teama_4s7.setVisibility ( View.GONE );
                        tv_teama_6s7.setVisibility ( View.GONE );
                        tv_teama_sr7.setVisibility ( View.GONE );
                        tv_teama_out7.setVisibility ( View.GONE );
                    }

                    if(7<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_7 = ArryHashPlaying_Xi_A.get ( 7 );
                        tv_teama_batsman8.setText ( hash_7.get ( "name" ) );
                        tv_teama_run8.setText ( hash_7.get ( "run" ) );
                        tv_teama_ball8.setText ( hash_7.get ( "balls" ) );
                        tv_teama_4s8.setText ( hash_7.get ( "fours" ) );
                        tv_teama_6s8.setText ( hash_7.get ( "sixes" ) );
                        tv_teama_sr8.setText ( hash_7.get ( "strike_rate" ) );
                        tv_teama_out8.setText ( hash_7.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman8.setVisibility ( View.GONE );
                        tv_teama_ball8.setVisibility ( View.GONE );
                        tv_teama_run8.setVisibility ( View.GONE );
                        tv_teama_4s8.setVisibility ( View.GONE );
                        tv_teama_6s8.setVisibility ( View.GONE );
                        tv_teama_sr8.setVisibility ( View.GONE );
                        tv_teama_out8.setVisibility ( View.GONE );
                    }

                    if(8<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_8 = ArryHashPlaying_Xi_A.get ( 8 );
                        tv_teama_batsman9.setText ( hash_8.get ( "name" ) );
                        tv_teama_run9.setText ( hash_8.get ( "run" ) );
                        tv_teama_ball9.setText ( hash_8.get ( "balls" ) );
                        tv_teama_4s9.setText ( hash_8.get ( "fours" ) );
                        tv_teama_6s9.setText ( hash_8.get ( "sixes" ) );
                        tv_teama_sr9.setText ( hash_8.get ( "strike_rate" ) );
                        tv_teama_out9.setText ( hash_8.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman9.setVisibility ( View.GONE );
                        tv_teama_ball9.setVisibility ( View.GONE );
                        tv_teama_run9.setVisibility ( View.GONE );
                        tv_teama_4s9.setVisibility ( View.GONE );
                        tv_teama_6s9.setVisibility ( View.GONE );
                        tv_teama_sr9.setVisibility ( View.GONE );
                        tv_teama_out9.setVisibility ( View.GONE );
                    }

                    if(9<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_9 = ArryHashPlaying_Xi_A.get ( 9 );
                        tv_teama_batsman10.setText ( hash_9.get ( "name" ) );
                        tv_teama_run10.setText ( hash_9.get ( "run" ) );
                        tv_teama_ball10.setText ( hash_9.get ( "balls" ) );
                        tv_teama_4s10.setText ( hash_9.get ( "fours" ) );
                        tv_teama_6s10.setText ( hash_9.get ( "sixes" ) );
                        tv_teama_sr10.setText ( hash_9.get ( "strike_rate" ) );
                        tv_teama_out10.setText ( hash_9.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman10.setVisibility ( View.GONE );
                        tv_teama_ball10.setVisibility ( View.GONE );
                        tv_teama_run10.setVisibility ( View.GONE );
                        tv_teama_4s10.setVisibility ( View.GONE );
                        tv_teama_6s10.setVisibility ( View.GONE );
                        tv_teama_sr10.setVisibility ( View.GONE );
                        tv_teama_out10.setVisibility ( View.GONE );
                    }

                    if(10<ArryHashPlaying_Xi_A.size ()) {

                        HashMap<String, String> hash_10 = ArryHashPlaying_Xi_A.get ( 10 );
                        tv_teama_batsman11.setText ( hash_10.get ( "name" ) );
                        tv_teama_run11.setText ( hash_10.get ( "run" ) );
                        tv_teama_ball11.setText ( hash_10.get ( "balls" ) );
                        tv_teama_4s11.setText ( hash_10.get ( "fours" ) );
                        tv_teama_6s11.setText ( hash_10.get ( "sixes" ) );
                        tv_teama_sr11.setText ( hash_10.get ( "strike_rate" ) );
                        tv_teama_out11.setText ( hash_10.get ( "out_str" ) );
                    }else {
                        tv_teama_batsman11.setVisibility ( View.GONE );
                        tv_teama_ball11.setVisibility ( View.GONE );
                        tv_teama_run11.setVisibility ( View.GONE );
                        tv_teama_4s11.setVisibility ( View.GONE );
                        tv_teama_6s11.setVisibility ( View.GONE );
                        tv_teama_sr11.setVisibility ( View.GONE );
                        tv_teama_out11.setVisibility ( View.GONE );
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue rq = Volley.newRequestQueue(getActivity());
        rq.add(sr);
    }

}