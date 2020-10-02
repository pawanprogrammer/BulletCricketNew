package com.trishasofttech.bulletcricketlive;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.trishasofttech.bulletcricketlive.livetabs.LiveDetailsActivity;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.MyHolder>{
    Context context;
    private String[] name;
    private String[] date;
    private String[] gname;
    private String[] place;
    private String[] matchtime;
    private String[] series;
    private String[] matchtype;
    private String[] matchlink;
    private int[] id;
    int seriesid;


    public SeriesAdapter(Context context, String[] name, String[] date, int[] id, int seriesid, String[] matchtime,
                         String [] gname, String [] place, String [] series, String [] matchtype, String[] link) {
        this.context = context;
        this.name = name;
        this.date = date;
        this.matchtime = matchtime;
        this.gname=gname;
        this.place = place;
        this.id = id;
        this.series = series;
        this.seriesid = seriesid;
        this.matchtype=matchtype;
        this.matchlink = link;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_detailseries,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {


        holder.notedate.setText("Date: "+date[position]+"\nTime: "+matchtime[position]);
        holder.noteName.setText(name[position]);

        holder.gname.setText(gname[position]);
        holder.place.setText(place[position]);
        holder.tv_series.setText(series[position]);
        holder.tv_matchtype.setText(matchtype[position]);

        holder.card_result.setOnClickListener(new View.OnClickListener() {
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
                live.putExtra("key", matchlink[position]);
                context.startActivity(live);


            }
        });

        //holder.notedate.setText(String.valueOf(id[position]));
        //holder.notedate.setText(date[position]);
        /*holder.book_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(url[position]));
                context.startActivity(intent);
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return series.length;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView noteName,notedate, gname, place, tv_series, tv_matchtype;
        //ConstraintLayout book_layout;
        CardView card_result;
        public MyHolder(View itemView) {
            super(itemView);
            card_result = itemView.findViewById(R.id.card_result);
            noteName=itemView.findViewById(R.id.tv_title);
            notedate=itemView.findViewById(R.id.tv_date);
            gname=itemView.findViewById(R.id.gname);
            place=itemView.findViewById(R.id.place);
            tv_series = itemView.findViewById(R.id.tv_series);
            tv_matchtype = itemView.findViewById(R.id.tv_matchtype);
            //book_layout = itemView.findViewById(R.id.book_layout);
        }
    }
}