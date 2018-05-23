package com.example.hotumit.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.Utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao

class SeperateIncomeAdapter(private val androidList: SeperateCollectionDao?, recyclerItemClickListener: RecyclerItemClickListener) : RecyclerView.Adapter<SeperateViewHolder>() {
    override fun getItemCount(): Int {
        return androidList?.separateIncome?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeperateViewHolder {
        return SeperateViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.income_view_row, parent, false))
    }

    override fun onBindViewHolder(holder: SeperateViewHolder, position: Int) {
        holder?.let {
            val android = androidList?.separateIncome?.get(position)
            val unknownInfo = it.itemView?.context?.getString(R.string.unknown) ?: "Unknown"
            it.codeName(android?.transactiondatetime ?: unknownInfo)
            it.billaddress(android?.billaddress ?: unknownInfo)






        }
    }


}