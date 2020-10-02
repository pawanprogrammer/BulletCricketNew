package com.trishasofttech.bulletcricketlive.livetabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class LivePager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    String sKey;

    //Constructor to the class
    public LivePager(FragmentManager fm, int tabCount, String skey) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
        this.sKey = skey;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Liveline tab1 = new Liveline();
                Bundle bundle1 = new Bundle();
                bundle1.putString("skey", sKey);
                tab1.setArguments(bundle1);
                return tab1;
            case 1:
                MatchInfo tab2 = new MatchInfo();
                Bundle bundle2 = new Bundle();
                bundle2.putString("skey", sKey);
                tab2.setArguments(bundle2);
                return tab2;
            case 2:
                Scorecard tab3 = new Scorecard();
                Bundle bundle = new Bundle();
                bundle.putString("skey", sKey);
                tab3.setArguments(bundle);
                return tab3;
            case 3:
                SquadsTeam tab4 = new SquadsTeam();
                Bundle bundle3 = new Bundle();
                bundle3.putString("skey", sKey);
                tab4.setArguments(bundle3);
                return tab4;

            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

}