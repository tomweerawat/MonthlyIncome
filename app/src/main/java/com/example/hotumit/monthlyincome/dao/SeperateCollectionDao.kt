package com.example.hotumit.monthlyincome.dao

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class SeperateCollectionDao(
        @SerializedName("separateIncome") val separateIncome: ArrayList<SeparateItemIncomeDao>
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(SeparateItemIncomeDao.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(separateIncome)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SeperateCollectionDao> = object : Parcelable.Creator<SeperateCollectionDao> {
            override fun createFromParcel(source: Parcel): SeperateCollectionDao = SeperateCollectionDao(source)
            override fun newArray(size: Int): Array<SeperateCollectionDao?> = arrayOfNulls(size)
        }
    }
}