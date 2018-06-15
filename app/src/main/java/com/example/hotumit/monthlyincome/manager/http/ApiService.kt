package com.example.hotumit.monthlyincome.manager.http


import com.example.hotumit.monthlyincome.dao.NewCustItemCollectionDao
import com.example.hotumit.monthlyincome.dao.PhotoItemCollectionDao

import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("list")
    fun loadPhotoList(): Call<PhotoItemCollectionDao>

    @POST("list/after/{id}")
    fun loadPhotoListAfterId(@Path("id") id: Int): Call<PhotoItemCollectionDao>

    @POST("list/before/{id}")
    fun loadPhotoListBeforeId(@Path("id") id: Int): Call<PhotoItemCollectionDao>

    @GET("SeperateIncome")
    fun loaddataIcome(@Query("startdate") startdate: String, @Query("enddate") enddate: String, @Query("email") vararg email: String): Call<SeperateCollectionDao>

    @GET("SumIncome")
    fun loaddataSumIcome(@Query("startdate") startdate: String, @Query("enddate") enddate: String, @Query("email") vararg email: String): Call<SumIncomeCollectionDao>

    @GET("getCustomer")
    fun loadNewCus(@Query("date") date: String, @Query("edate") edate: String): Call<NewCustItemCollectionDao>
}
