package com.example.hotumit.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hotumit.monthlyincome.utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.adapter.holder.NewCusViewHolder
import com.example.hotumit.monthlyincome.dao.NewCustItemCollectionDao
import kotlinx.android.synthetic.main.nav_header_main.*
import android.R.array
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.hotumit.monthlyincome.constants.PostType
import com.example.hotumit.monthlyincome.dao.dummy.NewCustDummyItemDao
import com.example.hotumit.monthlyincome.dao.dummy.Newcus
import com.example.hotumit.monthlyincome.utility.Contextor
import com.google.gson.GsonBuilder


class NewCusAdapter(private val androidList: NewCustItemCollectionDao, recyclerItemClickListener: RecyclerItemClickListener) : RecyclerView.Adapter<NewCusViewHolder>() {
    override fun getItemCount(): Int {
        return androidList?.newcuss?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCusViewHolder {
        Log.e("viewType", "viewType" + viewType)

        val viewHolder: NewCusViewHolder = when (viewType) {
        PostType.PHOTO -> NewCusViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.newcus_view_row, parent, false))

            else ->NewCusViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.newcus_view_row, parent, false))

        }


       /* return NewCusViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.newcus_view_row, parent, false))*/
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewCusViewHolder, position: Int) {




        if (position > 0){
            holder.itemView.setVisibility(View.GONE);
        }/*else{
           val inBounds = position >= 0 && position < androidList.newcuss.size
            holder.motnth(androidList.newcuss[position].month)
            holder.gender(androidList.newcuss[position].gender)
            holder.newreg(androidList.newcuss[position].newregister)
            holder.motnth1(androidList.newcuss[position].month)
            holder.gender1(androidList.newcuss[position].gender)
            holder.newreg1(androidList.newcuss[position].newregister)
            Log.e("BBBB", "BBBB" + GsonBuilder().setPrettyPrinting().create().toJson(androidList.newcuss[position].month)[position])
        }*/




        holder?.let {
            val android = androidList?.newcuss?.get(position)

            val unknownInfo = it.itemView?.context?.getString(R.string.unknown) ?: "Unknown"
            it.motnth(android?.month ?: unknownInfo)
            it.gender(android?.gender ?:unknownInfo)
            it.newreg(android?.newregister?:unknownInfo)

        }

    }


}