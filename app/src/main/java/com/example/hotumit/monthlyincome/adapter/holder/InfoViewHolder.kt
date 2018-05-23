package com.example.hotumit.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.hotumit.monthlyincome.R.id.*
import kotlinx.android.synthetic.main.sum_income_view_row.view.*


class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /*   val image: ImageView = itemView.img*/


    fun codeName(codeName: String) {
        itemView.startDate1.text = codeName
    }

    fun endDate1(endDate1: String) {
        itemView.endDate1.text = endDate1
    }

    fun Merchant1(Merchant1: String) {
        itemView.Merchant1.text = Merchant1
    }

    fun Service1(Service1: String) {
        itemView.Service1.text = Service1
    }

    fun UnitTime1(UnitTime1: String) {
        itemView.UnitTime1.text = UnitTime1
    }

    fun VATCase1(VATCase1: String) {
        itemView.VATCase1.text = VATCase1
    }

    fun MerchantIncome1(MerchantIncome1: String) {
        itemView.MerchantIncome1.text = MerchantIncome1
    }

    fun ServiceValue1(ServiceValue1: String) {
        itemView.ServiceValue1.text = ServiceValue1
    }

    fun StringVAT1(StringVAT1: String) {
        itemView.StringVAT1.text = StringVAT1
    }

    fun CommissionfromMerchant1(CommissionfromMerchant1: String) {
        itemView.CommissionfromMerchant1.text = CommissionfromMerchant1
    }

    fun MerchantNetIncome1(MerchantNetIncome1: String) {
        itemView.MerchantNetIncome1.text = MerchantNetIncome1
    }

    fun FEE1(FEE1: String) {
        itemView.FEE1.text = FEE1
    }

    fun FEEDiscountfromcode1(FEEDiscountfromcode1: String) {
        itemView.FEEDiscountfromcode1.text = FEEDiscountfromcode1
    }

    fun Discountfromcode1(Discountfromcode1: String) {
        itemView.Discountfromcode1.text = Discountfromcode1
    }

    fun DiscountfromCoin1(DiscountfromCoin1: String) {
        itemView.DiscountfromCoin1.text = DiscountfromCoin1
    }

    fun TotalDiscount1(TotalDiscount1: String) {
        itemView.TotalDiscount1.text = TotalDiscount1
    }

    fun Nameoftax1(Nameoftax1: String) {
        itemView.Nameoftax1.text = Nameoftax1
    }

    fun Bank1(Bank1: String) {
        itemView.Bank1.text = Bank1
    }

    fun Bankaccountno1(Bankaccountno1: String) {
        itemView.Bankaccountno1.text = Bankaccountno1
    }

    fun name1(name1: String) {
        itemView.name1.text = name1
    }

    fun Bankbanch1(Bankbanch1: String) {
        itemView.Bankbanch1.text = Bankbanch1
    }

    fun billaddress1(billaddress1: String) {
        itemView.billaddress1.text = billaddress1
    }

    fun Mail1(Mail1: String) {
        itemView.Mail1.text = Mail1
    }


}