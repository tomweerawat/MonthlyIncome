package com.example.hotumit.monthlyincome.activity.java;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotumit.monthlyincome.R;
import com.example.hotumit.monthlyincome.activity.LoginActivity;
import com.example.hotumit.monthlyincome.utility.BaseActivity;

import com.example.hotumit.monthlyincome.adapter.ViewPagerAdapter;
import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao;
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao;
import com.example.hotumit.monthlyincome.fragment.SeperateIncomeFragment;
import com.example.hotumit.monthlyincome.fragment.SumncomeFragment;
import com.google.firebase.auth.FirebaseAuth;


public class MainBackup extends BaseActivity {
    Context c;
    TextView tv, tvfirebase;
    SharedPreferences pref;
    Button btn, signout;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    SeperateCollectionDao dao;
    SumIncomeCollectionDao sumIncomeCollectionDao;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button button;
    private ImageView img;
    final int[] ICONS = new int[]{
            R.drawable.ic_assignment_black_24dp,
            R.drawable.ic_assignment_ind_black_24dp,
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     /*   pref = getSharedPreferences("userdata", Context.MODE_PRIVATE);
        Log.d("DDDDDDDDDDDD", "DDDDDDDDDDDDdd" + "\t" + pref.getString(Constanst.EMAIL, "" + "\t" + pref));*/
        dao = getIntent().getParcelableExtra("dao");
        sumIncomeCollectionDao = getIntent().getParcelableExtra("sumIncomeCollectionDao");
        initInstances();
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                tabLayout.getTabAt(0).setIcon(ICONS[0]);
                tabLayout.getTabAt(1).setIcon(ICONS[1]);
                /*  tabLayout.getTabAt(2).setIcon(tabIcons[2]);*/

            }
        });

        initview();
    }


    private void initview() {
        tv = (TextView) findViewById(R.id.emailfirebase);
        tvfirebase = (TextView) findViewById(R.id.namefirebase);
        button = (Button) findViewById(R.id.signout);
        img = (ImageView) findViewById(R.id.imgnav);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainBackup.this, LoginActivity.class);
                startActivity(i);
            }
        });
      /*  tv.setText(pref.getString(Constanst.EMAIL, ""));
        tvfirebase.setText(pref.getString(Constanst.UNIQUE_ID, ""));
        Log.e("myimg","myimg"+pref.getString(Constanst.USERIMAGE, ""));
        Picasso.with(this).load(pref.getString(Constanst.USERIMAGE,"")).into(img);*/
    }

    private void initInstances() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        toolbar = findViewById(R.id.toolBarr);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainBackup.this,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }



    public void setupViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        /*adapter.addFragment(new MainFragment(), "");*/
        adapter.addFragment(SumncomeFragment.newInstance(sumIncomeCollectionDao), "");
        adapter.addFragment(SeperateIncomeFragment.newInstance(dao), "");
        viewPager.setAdapter(adapter);
    }


}

