package com.example.hotumit.monthlyincome.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.R.drawable.t
import com.example.hotumit.monthlyincome.R.id.*
import com.example.hotumit.monthlyincome.Utility.BaseActivity
import com.example.hotumit.monthlyincome.Utility.ClickListener
import com.example.hotumit.monthlyincome.Utility.Contextor
import com.example.hotumit.monthlyincome.Utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.constants.Constanst
import com.example.hotumit.monthlyincome.dao.PhotoItemDao
import com.example.hotumit.monthlyincome.dao.dummy.MenuGenerator
import com.example.hotumit.mykotlin.adapter.MenuAdapter
import com.example.hotumit.mykotlin.adapter.NewCusAdapter
import kotlinx.android.synthetic.main.layout_menu.*
import kotlinx.android.synthetic.main.layout_selectmenu.*

class HomeMenu : BaseActivity(), ClickListener {


    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_row)
        /*  initclick()*/
        initview()

        var pref = getSharedPreferences("userdata", Context.MODE_PRIVATE)
        Log.e("Test", "Test" + pref.getString(Constanst.EMAIL, ""))
        etxt.text = pref.getString(Constanst.EMAIL, "")

    }

    private fun initview() {
        recyclerView = findViewById(R.id.rvAndroidVersion) as RecyclerView
        val layoutManager = GridLayoutManager(Contextor.getInstance().context, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        val adapter = MenuAdapter(MenuGenerator.createAndroidVersionInfo(), recyclerItemClickListener)
        recyclerView.adapter = adapter
        adapter.setClickListener(this)

    }

    override fun itemClicked(view: View?, position: Int) {
        if (position == 0) {
            startActivity(Intent(this@HomeMenu, ActivityNewCus::class.java))
        } else {
            startActivity(Intent(this@HomeMenu, ActivityChoose::class.java))
        }
    }

    private fun initclick() {
        newcus.setOnClickListener {
            startActivity(Intent(this@HomeMenu, ActivityNewCus::class.java))
        }
        income.setOnClickListener {
            startActivity(Intent(this@HomeMenu, ActivityChoose::class.java))
        }
    }

    private val recyclerItemClickListener = RecyclerItemClickListener {
    }


}