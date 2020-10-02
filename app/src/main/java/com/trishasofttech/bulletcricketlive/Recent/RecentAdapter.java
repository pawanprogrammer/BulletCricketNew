package com.trishasofttech.bulletcricketlive.Recent;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.trishasofttech.bulletcricketlive.R;
import com.trishasofttech.bulletcricketlive.livetabs.LiveDetailsActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.MyNoteHolder> {
    Context context;
    ArrayList<HashMap<String, String>> ArrayListSeries;
    private String[] match;
    private String[] matchtype;
    private String[] matchvenue;
    private String[] matchseries;
    private String[] matchdate;
    private String[] team2logo;
    private long[] id;
    private static final String FORMAT = "%02d:%02d:%02d";

    String data;

    public RecentAdapter(Context context, String[] match, long[] id, String[] matchseries, ArrayList ArrayListSeries) {
        this.context = context;
        this.id = id;
        this.match = match;
        this.matchseries = matchseries;
        this.ArrayListSeries = ArrayListSeries;
    }

    @Override
    public MyNoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_info, parent, false);
        return new MyNoteHolder(view);
    }

    public Drawable getImage(String name) {
        return context.getResources().getDrawable(
                context.getResources().getIdentifier(name, "drawable",
                        context.getPackageName()));
    }

    @Override
    public void onBindViewHolder(final MyNoteHolder holder, final int position) {
        //Toast.makeText ( context,match.toString (),Toast.LENGTH_LONG ).show ();
        final HashMap<String, String> hash = ArrayListSeries.get(position);
        //Toast.makeText(context, hash.get("matchseries"), Toast.LENGTH_SHORT).show();
        holder.noteName.setText(hash.get("matchseries"));
        holder.tv_team1.setText(hash.get("aTeam"));
        holder.tv_team2.setText(hash.get("bTeam"));
        holder.tv_matchresult.setText(hash.get("match_result"));
        String a_team_score = hash.get("a_1");

        //Toast.makeText(context, hash.get("aTeam"), Toast.LENGTH_SHORT).show();
        //Drawable image = getImage(hash.get("key"));
        try {
            int id = context.getResources().getIdentifier("com.trishasofttech.bulletcricketlive:drawable/" + hash.get("aTeam"), null, null);
           if(id == 0){
               holder.iv_team1.setImageDrawable(context.getResources().getDrawable(R.drawable.logo));
           }else{
               holder.iv_team1.setImageResource(id);
           }

            int id1 = context.getResources().getIdentifier("com.trishasofttech.bulletcricketlive:drawable/" + hash.get("bTeam"), null, null);

            if (id1 ==0)
            {
                holder.iv_team2.setImageDrawable(context.getResources().getDrawable(R.drawable.logo));

            }else {
                holder.iv_team2.setImageResource(id1);
            }

        }
        catch (Exception e)
        {
            e.getMessage();
        }

       //holder.iv_team1.setImageDrawable(context.getResources().getDrawable(R.drawable.kxip));

//        String a_team_scores=a_team_score.replace("in", "\n");
        holder.tv_runs1.setText(hash.get("aruns") + "/" + hash.get("awickets"));
        holder.tv_overs1.setText(hash.get("aovers") + " (Overs)");
        String b_team_score = hash.get("b_1");
        // String b_team_scores=b_team_score.replace("in", "\n");
        holder.tv_runs2.setText(hash.get("bruns") + "/" + hash.get("bwickets"));
        holder.tv_overs2.setText(hash.get("bovers") + " (Overs)");


        if (hash.get("start_date").equalsIgnoreCase("Vs")) {
            holder.tv_vs.setText("Vs");

        } else {

            //Toast.makeText(context, hash.get("start_date"), Toast.LENGTH_SHORT).show();

            long miliSec = Long.parseLong(hash.get("start_date"));

            long currentsec = miliSec - 19800000;
            DateFormat simple = new SimpleDateFormat("HH:mm:ss");

            Date result = new Date(currentsec);

            //  holder.tv_vs.setText ( simple.format ( result ) );
            final String con_date_time = simple.format(result);

            new CountDownTimer(currentsec, 1000) { // adjust the milli seconds here

                public void onTick(long millisUntilFinished) {

                    long ms = millisUntilFinished;
                    /*String text = String.format("%02d\'%02d\' %02d\"",
                            TimeUnit.MILLISECONDS.toHours(ms) - TimeUnit.HOURS.toHours(TimeUnit.MILLISECONDS.toHours(ms)),
                            TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                            TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
                    holder.tv_vs.setText(text);*/
                    holder.tv_vs.setText("" + String.format(FORMAT,
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }

                public void onFinish() {
                    holder.tv_vs.setText("Vs");
                }
            }.start();

        }
        holder.cardlive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent live = new Intent(context, LiveDetailsActivity.class);
                live.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                live.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                /*SharedPreferences sp= context.getSharedPreferences("live", 0);
                SharedPreferences.Editor ed = sp.edit();
                ed.putLong("id", id[position]);
                ed.putString("match", String.valueOf(match[position]));
                Toast.makeText(context, String.valueOf(match[position]), Toast.LENGTH_SHORT).show();
                ed.commit();
                */
                live.putExtra("key", hash.get("key"));
                context.startActivity(live);


            }
        });
    }


    @Override
    public int getItemCount() {
        return ArrayListSeries.size();
    }

    class MyNoteHolder extends RecyclerView.ViewHolder {
        TextView tv_matchresult, noteName, notedate, tv_team1, tv_team2, team1_market, team2_market, tv_runs1, tv_runs2, tv_overs1, tv_overs2, tv_vs;
        ImageView iv_team1, iv_team2;
        CardView cardlive;

        public MyNoteHolder(View itemView) {
            super(itemView);
            tv_matchresult = itemView.findViewById(R.id.tv_matchresult);
            noteName = itemView.findViewById(R.id.tv_title);
            notedate = itemView.findViewById(R.id.tv_date);
            iv_team1 = itemView.findViewById(R.id.iv_team1);
            iv_team2 = itemView.findViewById(R.id.iv_team2);
            tv_team1 = itemView.findViewById(R.id.tv_team1);
            tv_team2 = itemView.findViewById(R.id.tv_team2);
            team1_market = itemView.findViewById(R.id.team1_market);
            team2_market = itemView.findViewById(R.id.team2_market);
            tv_runs1 = itemView.findViewById(R.id.tv_runs1);
            tv_runs2 = itemView.findViewById(R.id.tv_runs2);
            tv_overs1 = itemView.findViewById(R.id.tv_overs1);
            tv_overs2 = itemView.findViewById(R.id.tv_overs2);
            tv_vs = itemView.findViewById(R.id.tv_vs);


            cardlive = itemView.findViewById(R.id.card_live);
        }
    }
}