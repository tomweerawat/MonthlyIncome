package com.example.hotumit.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hotumit.monthlyincome.Utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao

class InfoAdapter(private val androidList: SumIncomeCollectionDao?, recyclerItemClickListener: RecyclerItemClickListener) : RecyclerView.Adapter<InfoViewHolder>() {
    override fun getItemCount(): Int {
        return androidList?.sumIncome?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        return InfoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.sum_income_view_row, parent, false))
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder?.let {
            val android = androidList?.sumIncome?.get(position)
            val unknownInfo = it.itemView?.context?.getString(R.string.unknown) ?: "Unknown"
            it.codeName(android?.startDate ?: unknownInfo)
            it.endDate1(android?.endDate ?: unknownInfo)
            it.Merchant1(android?.merchant ?: unknownInfo)


        }
    }


}