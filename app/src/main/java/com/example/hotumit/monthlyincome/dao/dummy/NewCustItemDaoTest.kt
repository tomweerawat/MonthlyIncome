package com.example.hotumit.monthlyincome.dao.dummy

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class NewCustItemDaoTest(
        @SerializedName("month") val month: String,
        @SerializedName("gender") val gender: String,
        @SerializedName("newregister") val newregister: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(month)
        writeString(gender)
        writeString(newregister)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NewCustItemDaoTest> = object : Parcelable.Creator<NewCustItemDaoTest> {
            override fun createFromParcel(source: Parcel): NewCustItemDaoTest = NewCustItemDaoTest(source)
            override fun newArray(size: Int): Array<NewCustItemDaoTest?> = arrayOfNulls(size)
        }
    }
}