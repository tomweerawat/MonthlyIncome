package com.example.hotumit.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hotumit.monthlyincome.Utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.adapter.holder.NewCusViewHolder
import com.example.hotumit.monthlyincome.dao.NewCustItemCollectionDao
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao

class NewCusAdapter(private val androidList: NewCustItemCollectionDao?, recyclerItemClickListener: RecyclerItemClickListener) : RecyclerView.Adapter<NewCusViewHolder>() {
    override fun getItemCount(): Int {
        return androidList?.newcuss?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCusViewHolder {
        return NewCusViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.newcus_view_row, parent, false))
    }

    override fun onBindViewHolder(holder: NewCusViewHolder, position: Int) {
        holder?.let {
            val android = androidList?.newcuss?.get(position)
            val unknownInfo = it.itemView?.context?.getString(R.string.unknown) ?: "Unknown"
            it.motnth(android?.month ?: unknownInfo)
            it.gender(android?.gender ?: unknownInfo)
            it.newreg(android?.newregister ?: unknownInfo)



        }
    }


}