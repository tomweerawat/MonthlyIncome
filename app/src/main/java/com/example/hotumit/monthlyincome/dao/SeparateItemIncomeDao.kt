package com.example.hotumit.monthlyincome.dao

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SeparateItemIncomeDao(
        @SerializedName("transactiondatetime") val transactiondatetime: String,
        @SerializedName("commissionfromerchant") val commissionfromerchant: String?,
        @SerializedName("merchantnetincome") val merchantnetincome: String,
        @SerializedName("feeincludevat") val feeincludevat: String,
        @SerializedName("discountfromcode") val discountfromcode: String,
        @SerializedName("coinused") val coinused: String,
        @SerializedName("billaddress") val billaddress: String,
        @SerializedName("service") val service: String,
        @SerializedName("incomefromcust") val incomefromcust: String,
        @SerializedName("totaldiscount") val totaldiscount: String,
        @SerializedName("custName") val custName: String,
        @SerializedName("custLastName") val custLastName: String,
        @SerializedName("vatcase") val vatcase: String,
        @SerializedName("merchant") val merchant: String,
        @SerializedName("taxNo") val taxNo: String,
        @SerializedName("nameoftax") val nameoftax: String,
        @SerializedName("unit") val unit: String
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
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(transactiondatetime)
        writeString(commissionfromerchant)
        writeString(merchantnetincome)
        writeString(feeincludevat)
        writeString(discountfromcode)
        writeString(coinused)
        writeString(billaddress)
        writeString(service)
        writeString(incomefromcust)
        writeString(totaldiscount)
        writeString(custName)
        writeString(custLastName)
        writeString(vatcase)
        writeString(merchant)
        writeString(taxNo)
        writeString(nameoftax)
        writeString(unit)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SeparateItemIncomeDao> = object : Parcelable.Creator<SeparateItemIncomeDao> {
            override fun createFromParcel(source: Parcel): SeparateItemIncomeDao = SeparateItemIncomeDao(source)
            override fun newArray(size: Int): Array<SeparateItemIncomeDao?> = arrayOfNulls(size)
        }
    }
}
