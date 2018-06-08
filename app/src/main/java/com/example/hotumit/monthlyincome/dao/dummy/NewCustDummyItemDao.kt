package com.example.hotumit.monthlyincome.dao.dummy

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class NewCustDummyItemDao(
        @SerializedName("newcuss") var newcuss: ArrayList<Newcus>
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(Newcus.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(newcuss)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NewCustDummyItemDao> = object : Parcelable.Creator<NewCustDummyItemDao> {
            override fun createFromParcel(source: Parcel): NewCustDummyItemDao = NewCustDummyItemDao(source)
            override fun newArray(size: Int): Array<NewCustDummyItemDao?> = arrayOfNulls(size)
        }
    }
}