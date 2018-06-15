package com.example.hotumit.monthlyincome.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.hotumit.monthlyincome.R.id.*
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

    fun motnth1(motnth1: String) {
        itemView.motnth1.text = motnth1
    }

    fun gender1(gender1: String) {
        itemView.gender1.text = gender1
    }

    fun newreg1(newreg1: String) {
        itemView.newreg1.text = newreg1
    }

}