package com.example.hotumit.monthlyincome.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.utility.BaseActivity

import com.example.hotumit.monthlyincome.adapter.ViewPagerAdapter
import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao
import com.example.hotumit.monthlyincome.fragment.SeperateIncomeFragment
import com.example.hotumit.monthlyincome.fragment.SumncomeFragment
import com.google.firebase.auth.FirebaseAuth


class MainActivity : BaseActivity() {
    internal var c: Context? = null
    internal lateinit var tv: TextView
    internal lateinit var tvfirebase: TextView
    internal var pref: SharedPreferences? = null
    internal var btn: Button? = null
    internal var signout: Button? = null
    internal lateinit var drawerLayout: DrawerLayout
    internal lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    internal lateinit var toolbar: Toolbar
    internal lateinit var dao: SeperateCollectionDao

    private var viewPager: ViewPager? = null
    private var tabLayout: TabLayout? = null
    private var button: Button? = null
    private var img: ImageView? = null
    internal val ICONS = intArrayOf(R.drawable.ic_assignment_black_24dp, R.drawable.ic_assignment_ind_black_24dp)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*   pref = getSharedPreferences("userdata", Context.MODE_PRIVATE);
        Log.d("DDDDDDDDDDDD", "DDDDDDDDDDDDdd" + "\t" + pref.getString(Constanst.EMAIL, "" + "\t" + pref));*/
        dao = intent.getParcelableExtra("dao")

        initInstances()
        tabLayout!!.post {
            tabLayout!!.setupWithViewPager(viewPager)
            tabLayout!!.getTabAt(0)!!.setIcon(ICONS[0])
            tabLayout!!.getTabAt(1)!!.setIcon(ICONS[1])
            /*  tabLayout.getTabAt(2).setIcon(tabIcons[2]);*/
        }

        initview()
    }


    private fun initview() {
        tv = findViewById<View>(R.id.emailfirebase) as TextView
        tvfirebase = findViewById<View>(R.id.namefirebase) as TextView
        button = findViewById<View>(R.id.signout) as Button
        img = findViewById<View>(R.id.imgnav) as ImageView
        button!!.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val i = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(i)
        }
        /*  tv.setText(pref.getString(Constanst.EMAIL, ""));
           tvfirebase.setText(pref.getString(Constanst.UNIQUE_ID, ""));
           Log.e("myimg","myimg"+pref.getString(Constanst.USERIMAGE, ""));
           Picasso.with(this).load(pref.getString(Constanst.USERIMAGE,"")).into(img);*/
    }

    private fun initInstances() {
        viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        setupViewPager(viewPager)
        tabLayout!!.setupWithViewPager(viewPager)
        toolbar = findViewById(R.id.toolBarr)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)

        actionBarDrawerToggle = ActionBarDrawerToggle(
                this@MainActivity,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }


    fun setupViewPager(upViewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        /*adapter.addFragment(new MainFragment(), "");*/
        adapter.addFragment(SumncomeFragment.newInstance(ActivityChoose.daosum), "")
        adapter.addFragment(SeperateIncomeFragment.newInstance(dao), "")
        viewPager!!.adapter = adapter
    }


}

