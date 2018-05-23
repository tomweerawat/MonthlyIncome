package com.example.hotumit.monthlyincome.manager.singleton;

import android.content.Context;

import com.example.hotumit.monthlyincome.Utility.Contextor;
import com.example.hotumit.monthlyincome.constants.Constanst;
import com.example.hotumit.monthlyincome.manager.http.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class HttpManagerForIncome {

    private static HttpManagerForIncome instance;

    public static HttpManagerForIncome getInstance() {
        if (instance == null)
            instance = new HttpManagerForIncome();
        return instance;
    }

    private Context mContext;
    private ApiService service;

    private HttpManagerForIncome() {
        mContext = Contextor.getInstance().getContext();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient
                .Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();



        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constanst.Base_Income_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(ApiService.class);
    }

    public ApiService getService() {
        return service;
    }
}
