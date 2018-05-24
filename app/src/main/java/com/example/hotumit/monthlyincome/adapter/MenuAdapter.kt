package com.example.hotumit.mykotlin.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hotumit.monthlyincome.Utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.Utility.ClickListener
import com.example.hotumit.monthlyincome.dao.MenuItemDao
import com.example.hotumit.monthlyincome.dao.dummy.ImageDummyData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_menu.view.*

class MenuAdapter(private val androidList: MutableList<MenuItemDao>?, recyclerItemClickListener: RecyclerItemClickListener) : RecyclerView.Adapter<MenuViewHolder>() {
    companion object {
        public lateinit var clicklistener: ClickListener
    }


    override fun getItemCount(): Int {
        return androidList?.size ?: 0
    }

    fun setClickListener(listener: ClickListener) {
        clicklistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.layout_item_menu, parent, false))
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        val language = arrayOf(R.drawable.book, R.drawable.money, R.drawable.bag, R.drawable.cloud)
        Picasso.with(holder.itemView.getContext())
                .load(ImageDummyData.getData().get(position))
                .centerCrop()
                .resize(240, 240)
                .into(holder.itemView.logoimg)

        if (position == 0) {

        } else if (position == 1) {
            holder.itemView.mCardViewBottom.setCardBackgroundColor(Color.parseColor("#b9f5ca"))
            holder.itemView.lnbg.setBackgroundColor((Color.parseColor("#1de9b6")))

        } else if (position == 2) {
            holder.itemView.mCardViewBottom.setCardBackgroundColor(Color.parseColor("#fefe8d"))
            holder.itemView.lnbg.setBackgroundColor((Color.parseColor("#ffea3b")))
            holder.itemView.newcusreg.setTextColor(Color.parseColor("#475151"))
        } else if (position == 3) {
            holder.itemView.mCardViewBottom.setCardBackgroundColor(Color.parseColor("#84ffff"))
            holder.itemView.lnbg.setBackgroundColor((Color.parseColor("#03a9f4")))
        }

        holder?.let {
            val android = androidList?.get(position)
            val unknownInfo = it.itemView?.context?.getString(R.string.unknown) ?: "Unknown"
            it.codeName(android?.txt ?: unknownInfo)

        }
    }


}