package com.example.hotumit.monthlyincome.dao

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SumIncomeItemDao(
        @SerializedName("startDate") val startDate: String,
        @SerializedName("endDate") val endDate: String,
        @SerializedName("name") val name: String,
        @SerializedName("billaddress") val billaddress: String,
        @SerializedName("service") val service: String,
        @SerializedName("discountfromCoin") val discountfromCoin: String,
        @SerializedName("discountfromcode") val discountfromcode: String,
        @SerializedName("commissionfromMerchant") val commissionfromMerchant: String,
        @SerializedName("merchantIncome") val merchantIncome: String,
        @SerializedName("feediscountfromcode") val feediscountfromcode: String,
        @SerializedName("merchantNetIncome") val merchantNetIncome: String,
        @SerializedName("vatcase") val vatcase: String,
        @SerializedName("bankbanch") val bankbanch: String,
        @SerializedName("unitTime") val unitTime: String,
        @SerializedName("totalDiscount") val totalDiscount: String,
        @SerializedName("merchant") val merchant: String,
        @SerializedName("taxNo") val taxNo: String,
        @SerializedName("nameoftax") val nameoftax: String,
        @SerializedName("bankaccountno") val bankaccountno: String,
        @SerializedName("bank") val bank: String,
        @SerializedName("serviceValue") val serviceValue: String,
        @SerializedName("fee") val fee: String,
        @SerializedName("bankaccount") val bankaccount: String,
        @SerializedName("stringVAT") val stringVAT: String,
        @SerializedName("mail") val mail: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(startDate)
        writeString(endDate)
        writeString(name)
        writeString(billaddress)
        writeString(service)
        writeString(discountfromCoin)
        writeString(discountfromcode)
        writeString(commissionfromMerchant)
        writeString(merchantIncome)
        writeString(feediscountfromcode)
        writeString(merchantNetIncome)
        writeString(vatcase)
        writeString(bankbanch)
        writeString(unitTime)
        writeString(totalDiscount)
        writeString(merchant)
        writeString(taxNo)
        writeString(nameoftax)
        writeString(bankaccountno)
        writeString(bank)
        writeString(serviceValue)
        writeString(fee)
        writeString(bankaccount)
        writeString(stringVAT)
        writeString(mail)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SumIncomeItemDao> = object : Parcelable.Creator<SumIncomeItemDao> {
            override fun createFromParcel(source: Parcel): SumIncomeItemDao = SumIncomeItemDao(source)
            override fun newArray(size: Int): Array<SumIncomeItemDao?> = arrayOfNulls(size)
        }
    }
}