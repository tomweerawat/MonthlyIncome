package com.example.hotumit.monthlyincome

import android.app.Application

import com.example.hotumit.monthlyincome.Utility.Contextor


/**
 * Created by HOTUM IT on 26/3/2561.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Contextor.getInstance().init(applicationContext)

    }
}
