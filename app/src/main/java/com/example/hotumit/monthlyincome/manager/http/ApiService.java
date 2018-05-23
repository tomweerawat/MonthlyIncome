package com.example.hotumit.monthlyincome.manager.http;



import com.example.hotumit.monthlyincome.dao.NewCustItemCollectionDao;
import com.example.hotumit.monthlyincome.dao.PhotoItemCollectionDao;

import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao;
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @POST("list")
    Call<PhotoItemCollectionDao> loadPhotoList();

    @POST("list/after/{id}")
    Call<PhotoItemCollectionDao> loadPhotoListAfterId(@Path("id") int id);

    @POST("list/before/{id}")
    Call<PhotoItemCollectionDao> loadPhotoListBeforeId(@Path("id") int id);

    @GET("SeperateIncome")
    Call <SeperateCollectionDao> loaddataIcome(@Query("startdate") String startdate, @Query("enddate") String enddate, @Query("email") String... email);

    @GET("SumIncome")
    Call <SumIncomeCollectionDao> loaddataSumIcome(@Query("startdate") String startdate, @Query("enddate") String enddate, @Query("email") String... email);

    @GET("getCustomer")
    Call<NewCustItemCollectionDao> loadNewCus(@Query("date")String date,@Query("edate")String edate);
}
