package com.danshi.danhanxinag.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.danshi.danhanxinag.base.BaseActivity;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.fragment.MeizhiFragment;
import com.danshi.danhanxinag.fragment.MeizhiFragment2;
import com.danshi.danhanxinag.fragment.NewsFragment;
import com.danshi.danhanxinag.fragment.StoryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 20939 on 2016/11/16.
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    private NewsFragment mNewsFragment;
    private MeizhiFragment mMeizhiFragment;
    private StoryFragment mStoryFragment;
    private MeizhiFragment2 mMeizhiFragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        showMeizhiFragment();
      /*设置toolbar上的触发NavigationView的按钮*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_camera:
                showMeizhiFragment();
                break;
            case R.id.nav_gallery:
                showNewsFragment();
                break;
            case R.id.nav_slideshow:
                showStoryFragment();
                break;
            case R.id.nav_manage:
                startActivity(new Intent(this,AboutMeActivity.class));
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                showMeiZhiFragment();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showMeiZhiFragment() {

        if (mMeizhiFragment2 == null) {
            mMeizhiFragment2 = new MeizhiFragment2();
        }
        showContentFragment(mMeizhiFragment2, R.id.fragment_container);

    }

    private void showStoryFragment() {
        if (mStoryFragment == null) {
            mStoryFragment = new StoryFragment();
        }
        showContentFragment(mStoryFragment, R.id.fragment_container);
    }

    private void showMeizhiFragment() {
        if (mMeizhiFragment == null) {
            mMeizhiFragment = new MeizhiFragment();
        }
        showContentFragment(mMeizhiFragment, R.id.fragment_container);
    }

    private void showNewsFragment() {
        if (mNewsFragment == null) {
            mNewsFragment = new NewsFragment();
        }
        showContentFragment(mNewsFragment, R.id.fragment_container);
    }
}
