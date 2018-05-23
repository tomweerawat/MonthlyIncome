package com.example.hotumit.monthlyincome.dao

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class NewCustItemCollectionDao(
        @SerializedName("newcuss") val newcuss: List<NewCustItemDao>
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(NewCustItemDao.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(newcuss)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NewCustItemCollectionDao> = object : Parcelable.Creator<NewCustItemCollectionDao> {
            override fun createFromParcel(source: Parcel): NewCustItemCollectionDao = NewCustItemCollectionDao(source)
            override fun newArray(size: Int): Array<NewCustItemCollectionDao?> = arrayOfNulls(size)
        }
    }
}