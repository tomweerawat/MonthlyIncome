package com.example.hotumit.monthlyincome

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

import com.example.hotumit.monthlyincome.utility.Contextor


/**
 * Created by HOTUM IT on 26/3/2561.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Contextor.getInstance().init(applicationContext)

    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
