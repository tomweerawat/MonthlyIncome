package com.example.hotumit.monthlyincome.dao


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


class SumIncomeCollectionDao(@SerializedName("sumIncome") val sumIncome: ArrayList<SumIncomeItemDao>)
    : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(SumIncomeItemDao.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(sumIncome)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SumIncomeCollectionDao> = object : Parcelable.Creator<SumIncomeCollectionDao> {
            override fun createFromParcel(source: Parcel): SumIncomeCollectionDao = SumIncomeCollectionDao(source)
            override fun newArray(size: Int): Array<SumIncomeCollectionDao?> = arrayOfNulls(size)
        }
    }
}
