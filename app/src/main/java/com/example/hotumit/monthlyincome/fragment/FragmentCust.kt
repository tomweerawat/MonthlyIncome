package com.example.hotumit.monthlyincome.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View

import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.dao.NewCustItemCollectionDao
import com.example.hotumit.monthlyincome.utility.BaseActivity
import com.example.hotumit.monthlyincome.utility.Contextor
import com.example.hotumit.monthlyincome.utility.RecyclerItemClickListener
import com.example.hotumit.mykotlin.adapter.NewCusAdapter
import com.google.gson.GsonBuilder

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator

class FragmentCust : BaseActivity() {
    private var recyclerView: RecyclerView? = null

    internal lateinit var dao: NewCustItemCollectionDao
    internal lateinit var newcust: NewCusAdapter
    internal lateinit var swipeRefreshLayout: SwipeRefreshLayout


    private val recyclerItemClickListener = RecyclerItemClickListener { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_cust)
        getDataDao()
        initInstances()
        refresh()

    }

    private fun getDataDao() {
        dao = intent.getParcelableExtra("dao")
        Log.e("KotlinFragment", "KotlinFragment" + GsonBuilder().setPrettyPrinting().create().toJson(dao))
    }

    private fun initInstances() {
        recyclerView = findViewById(R.id.recycler_view_employee_list1)
        swipeRefreshLayout = findViewById<View>(R.id.swipLayoutRefresh1) as SwipeRefreshLayout
        val toolbar = findViewById<View>(R.id.toolBarr) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        val layoutManager = LinearLayoutManager(Contextor.getInstance().context)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.setHasFixedSize(true)
        newcust = NewCusAdapter(dao, recyclerItemClickListener)
        recyclerView!!.adapter = newcust
        recyclerView!!.itemAnimator = SlideInLeftAnimator()

    }

    private fun refresh() {
        swipeRefreshLayout.setOnRefreshListener { swipeRefreshLayout.isRefreshing = false }
    }
}
