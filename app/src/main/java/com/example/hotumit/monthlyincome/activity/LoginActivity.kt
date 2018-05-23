package com.example.hotumit.monthlyincome.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.example.hotumit.monthlyincome.Utility.BaseActivity
import com.example.hotumit.monthlyincome.constants.Constanst
import com.example.hotumit.monthlyincome.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_emailpassword.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity() {

    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Login Activity"
    private lateinit var pref:SharedPreferences;
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emailpassword)
        initlogin()
        pref = getSharedPreferences("userdata", Context.MODE_PRIVATE);

    }

    private fun initlogin() {
        mAuth = FirebaseAuth.getInstance()

        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@LoginActivity, HomeMenu::class.java))
            finish()
        }

        login_loginBtn.setOnClickListener {
            val email = login_emailEditText.text.toString().trim { it <= ' ' }
            val password = login_passwordEditText.text.toString().trim { it <= ' ' }

            if (email.isEmpty()) {
                toast("Please enter your email address.")
                Log.d(TAG, "Email was empty!")
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                toast("Please enter your password.")
                Log.d(TAG, "Password was empty!")
                return@setOnClickListener
            }

            mAuth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (password.length < 6) {
                        login_passwordEditText.error = "Please check your password. Password must have minimum 6 characters."
                        Log.d(TAG, "Enter password less than 6 characters.")
                    } else {
                        toast("Authentication Failed: " + task.exception!!.message)
                        Log.d(TAG, "Authentication Failed: " + task.exception!!.message)
                    }
                } else {
                    toast("Sign in successfully!")
                    Log.d(TAG, "Sign in successfully!")
                    initFirebase()
                    showProgressDialog()
                    startActivity(Intent(this@LoginActivity, HomeMenu::class.java))
                    finish()
                }
            }
        }
    }
    private fun initFirebase() {
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth!!.currentUser
        Log.e("currentuser","currentuser"+user!!.email);
        initSharedPreferences(user)



    }

    private fun initSharedPreferences(user: FirebaseUser) {
        Log.e("startshareprederences", "startshareprederences" + user.email!!)
        val editor = pref.edit()
        editor.putString(Constanst.EMAIL, user.email)
        editor.putString(Constanst.UNIQUE_ID, user.uid)
        editor.putString(Constanst.NAME, user.displayName)
        editor.putString(Constanst.USERIMAGE, user.photoUrl.toString())
        editor.apply()
    }


}
