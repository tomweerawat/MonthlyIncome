package com.example.hotumit.monthlyincome.dao.dummy

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Newcus(
        @SerializedName("month") val month: String,
        @SerializedName("totalofmale") val totalofmale: String,
        @SerializedName("totaloffemale") val totaloffemale: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(month)
        writeString(totalofmale)
        writeString(totaloffemale)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Newcus> = object : Parcelable.Creator<Newcus> {
            override fun createFromParcel(source: Parcel): Newcus = Newcus(source)
            override fun newArray(size: Int): Array<Newcus?> = arrayOfNulls(size)
        }
    }
}