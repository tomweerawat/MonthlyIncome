package com.example.hotumit.monthlyincome.dao

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class CustCollectionDao(
        @SerializedName("newcus") val newcus: ArrayList<CustItemDao>
) : Parcelable {
    constructor(source: Parcel) : this(
            ArrayList<CustItemDao>().apply { source.readList(this, CustItemDao::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(newcus)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CustCollectionDao> = object : Parcelable.Creator<CustCollectionDao> {
            override fun createFromParcel(source: Parcel): CustCollectionDao = CustCollectionDao(source)
            override fun newArray(size: Int): Array<CustCollectionDao?> = arrayOfNulls(size)
        }
    }
}
