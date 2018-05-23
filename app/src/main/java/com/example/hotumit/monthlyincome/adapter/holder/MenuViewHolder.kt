package com.example.hotumit.mykotlin.adapter

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.hotumit.monthlyincome.R.id.*
import kotlinx.android.synthetic.main.layout_item_menu.view.*
import kotlinx.android.synthetic.main.layout_menu.view.*
import kotlinx.android.synthetic.main.single_view_row.view.*
import com.example.hotumit.monthlyincome.Utility.ClickListener
import com.example.hotumit.monthlyincome.Utility.Contextor
import com.example.hotumit.monthlyincome.activity.ActivityNewCus
import com.example.hotumit.mykotlin.adapter.MenuAdapter.Companion.clicklistener

import kotlinx.android.synthetic.main.layout_selectmenu.*


class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var view: View = itemView


    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (clicklistener != null) {
            clicklistener.itemClicked(p0, getAdapterPosition());


        }
    }


    fun codeName(txt: String) {
        itemView.newcusreg.text = txt

    }


}