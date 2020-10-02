package com.trishasofttech.bulletcricketlive.livetabs;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.trishasofttech.bulletcricketlive.R;

public class LiveDetailsActivity extends AppCompatActivity {
    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    String skey = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_details);
        getSupportActionBar().hide();
        //Initializing the tablayout
        tabLayout = findViewById(R.id.tabLayout);
        try{
            skey = getIntent ().getStringExtra ( "key" );
            //Toast.makeText ( LiveDetailsActivity.this,skey,Toast.LENGTH_LONG ).show ();
        }catch (Exception e){

        }


        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Liveline"));
        tabLayout.addTab(tabLayout.newTab().setText("INFO"));
        tabLayout.addTab(tabLayout.newTab().setText("Scorecard"));
        tabLayout.addTab(tabLayout.newTab().setText("Squads"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = findViewById(R.id.pager);

        //Creating our pager adapter
        LivePager adapter = new LivePager(getSupportFragmentManager(), tabLayout.getTabCount(),skey);

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
