package com.example.hotumit.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.layout_item_menu.view.*
import com.example.hotumit.mykotlin.adapter.MenuAdapter.Companion.clicklistener


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