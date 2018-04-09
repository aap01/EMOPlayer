package com.emoplayer.app.emoplayer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.emoplayer.app.emoplayer.fragments.Albums;
import com.emoplayer.app.emoplayer.fragments.Artists;
import com.emoplayer.app.emoplayer.fragments.Genres;
import com.emoplayer.app.emoplayer.fragments.Playlists;
import com.emoplayer.app.emoplayer.fragments.Tracks;

public class PagerAdapter extends FragmentStatePagerAdapter{
    int numOfTabs;
    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

       // String Tabs[] = {"TRACKS","ALBUMS","PLAYLISTS","ARTISTS","GENERS"};
        switch (position){
            case 0:
                Tracks tab1 = new Tracks();
                return tab1;
            case 1:
                Albums tab2 = new Albums();
                return  tab2;
            case 2:
                Playlists tab3 = new Playlists();
                return tab3;
            case 3:
                Artists tab4 = new Artists();
                return tab4;
            case 4:
                Genres tab5 = new Genres();
                return tab5;

                default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
