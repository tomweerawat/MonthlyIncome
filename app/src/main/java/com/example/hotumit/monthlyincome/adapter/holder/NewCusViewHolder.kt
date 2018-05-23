package com.example.hotumit.monthlyincome.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.hotumit.monthlyincome.R.id.Merchant1
import com.example.hotumit.monthlyincome.R.id.endDate1
import kotlinx.android.synthetic.main.newcus_view_row.view.*
import kotlinx.android.synthetic.main.sum_income_view_row.view.*

class NewCusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun motnth(motnth: String) {
        itemView.motnth.text = motnth
    }

    fun gender(gender: String) {
        itemView.gender.text = gender
    }

    fun newreg(newreg: String) {
        itemView.newreg.text = newreg
    }

}