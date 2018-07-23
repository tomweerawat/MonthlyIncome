package com.example.hotumit.monthlyincome


import android.content.Intent

import android.view.animation.AnimationUtils
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation

import com.example.hotumit.monthlyincome.activity.LoginActivity
import kotlinx.android.synthetic.main.activity_splashscreen.*


class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)


        val animation_1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate)
        val animation_2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.antirotate)
        val animation_3 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out)

        hotumimg.startAnimation(animation_2)

        animation_2.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                hotumimg.startAnimation(animation_1)


            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })

        animation_1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                hotumimg.startAnimation(animation_3)
                finish()
                val i = Intent(getBaseContext(), LoginActivity::class.java)
                startActivity(i)


            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
    }
}