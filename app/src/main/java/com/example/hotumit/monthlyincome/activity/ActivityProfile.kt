package com.example.hotumit.monthlyincome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.constants.Constanst
import com.example.hotumit.monthlyincome.utility.BaseActivity
import com.example.hotumit.monthlyincome.utility.Contextor
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.layout_menu.*
import android.R.id.edit
import com.google.android.gms.flags.impl.SharedPreferencesFactory.getSharedPreferences
import android.content.SharedPreferences
import android.widget.Toast
import com.example.hotumit.monthlyincome.activity.LoginActivity.Companion.mGoogleApiClient
import com.facebook.login.Login


class ActivityProfile : BaseActivity() {

    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var pref = getSharedPreferences("userdata", Context.MODE_PRIVATE)
        Log.e("jkl", "jkl" + pref.getString(Constanst.EMAIL, ""))
        profemail.text = pref.getString(Constanst.EMAIL, "")
        Picasso.with(Contextor.getInstance().context)
                .load(pref.getString(Constanst.USERIMAGE,""))
                .centerCrop()
                .resize(240, 240)
                .into(profimg)
        inittoolbar()
        profsignout.setOnClickListener {
            signOut()
           /* startActivity(Intent(this@ActivityProfile, LoginActivity::class.java))*/
        }

    }

    private fun inittoolbar() {
        val toolbar = findViewById(R.id.toolBarr) as Toolbar?
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        toolbar?.setNavigationOnClickListener {
            finish()
        }

    }
    private fun signOut() {


     /*   FirebaseAuth.getInstance().signOut()*/
        val settings = Contextor.getInstance().context.getSharedPreferences("PreferencesName", Context.MODE_PRIVATE)
        settings.edit().clear().commit()

        Log.e("setting","setting"+settings)
       /* LoginActivity.mAuth!!.signOut()*/
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this@ActivityProfile, LoginActivity::class.java))



    }
}