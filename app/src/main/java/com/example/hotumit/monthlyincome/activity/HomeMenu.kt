package com.example.hotumit.monthlyincome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.R.id.etxt
import com.example.hotumit.monthlyincome.R.id.income
import com.example.hotumit.monthlyincome.activity.java.DatePicker
import com.example.hotumit.monthlyincome.activity.java.DatePickerActivity
import com.example.hotumit.monthlyincome.utility.BaseActivity
import com.example.hotumit.monthlyincome.utility.ClickListener
import com.example.hotumit.monthlyincome.utility.Contextor
import com.example.hotumit.monthlyincome.utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.constants.Constanst
import com.example.hotumit.monthlyincome.dao.dummy.ImageDummyData
import com.example.hotumit.monthlyincome.dao.dummy.MenuGenerator
import com.example.hotumit.mykotlin.adapter.MenuAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_menu.view.*
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
        Log.e("MyImage", "MyImage" + pref.getString(Constanst.USERIMAGE, ""))
        etxt.text = pref.getString(Constanst.EMAIL, "")
        Picasso.with(Contextor.getInstance().context)
                .load(pref.getString(Constanst.USERIMAGE,""))
                .centerCrop()
                .resize(240, 240)
                .into(profile_image)
        profile_image.setOnClickListener {
            startActivity(Intent(this@HomeMenu, ActivityProfile::class.java))
        }
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
        }
        else if (position == 1) {
            startActivity(Intent(this@HomeMenu, ActivityChoose::class.java))
        }else{
            startActivity(Intent(this@HomeMenu, DatePicker::class.java))
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