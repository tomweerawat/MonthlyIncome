package com.example.hotumit.monthlyincome.dao

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class NewCustItemDao(
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
        val CREATOR: Parcelable.Creator<NewCustItemDao> = object : Parcelable.Creator<NewCustItemDao> {
            override fun createFromParcel(source: Parcel): NewCustItemDao = NewCustItemDao(source)
            override fun newArray(size: Int): Array<NewCustItemDao?> = arrayOfNulls(size)
        }
    }
}