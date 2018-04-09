package com.emoplayer.app.emoplayer.activities;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.emoplayer.app.emoplayer.R;
import com.emoplayer.app.emoplayer.fragments.Albums;
import com.emoplayer.app.emoplayer.fragments.Artists;
import com.emoplayer.app.emoplayer.fragments.Genres;
import com.emoplayer.app.emoplayer.fragments.Playlists;
import com.emoplayer.app.emoplayer.fragments.Tracks;

public class MainActivity extends AppCompatActivity implements
        Tracks.OnFragmentInteractionListener,
        Albums.OnFragmentInteractionListener,
        Artists.OnFragmentInteractionListener,
        Genres.OnFragmentInteractionListener,
        Playlists.OnFragmentInteractionListener
{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private android.support.v7.widget.Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***code for drawer toolbar***/
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);



        /***code for drawer toggle button***/
        drawerLayout = findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /***code for tablayout***/
        final TabLayout tabLayout = findViewById(R.id.tablayout);
        String Tabs[] = {"TRACKS","ALBUMS","PLAYLISTS","ARTISTS","GENERS"};
        for(int i = 0; i < Tabs.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(Tabs[i]));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter = new com.emoplayer.app.emoplayer.adapters.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    /*function for drawer option selection)*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
