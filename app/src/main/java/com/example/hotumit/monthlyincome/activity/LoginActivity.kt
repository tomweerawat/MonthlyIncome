package com.example.hotumit.monthlyincome.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hotumit.monthlyincome.utility.BaseActivity
import com.example.hotumit.monthlyincome.constants.Constanst
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.utility.Contextor
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_emailpassword.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(), GoogleApiClient.OnConnectionFailedListener {

    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Login Activity"
    private lateinit var pref: SharedPreferences;
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null
    private val REQUEST_CODE_SIGN_IN = 9001
    val GOOGLE_LOG_IN_RC = 1
    var mGoogleApiClient: GoogleApiClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emailpassword)
        initgmaillogin()
        initlogin()
        pref = getSharedPreferences("userdata", Context.MODE_PRIVATE)

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
        Log.e("currentuser", "currentuser" + user!!.email)
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

    /*Google Signin*/

    private fun initgmaillogin() {
        Log.e("initgmaillogin", "initgmaillogin")
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.request_client_id))
                .requestEmail()
                .build()

        mGoogleApiClient = GoogleApiClient.Builder(this@LoginActivity)
                .enableAutoManage(this@LoginActivity ) { }
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()
        mAuth = FirebaseAuth.getInstance()

        btn_sign_in.setOnClickListener {
            signIn()

        }
        test.setOnClickListener {
            signOut()
        }
    }

    private fun signIn() {
        Log.e(TAG, "Starting Google LogIn Flow.")
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(signInIntent, GOOGLE_LOG_IN_RC)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i(TAG, "Got Result code ${requestCode}.")
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == GOOGLE_LOG_IN_RC) {

            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            Log.e(TAG,"QWERTY"+"\t"+result.status)
            Log.i(TAG, "With Google LogIn, is result a success? ${result.isSuccess}.")
            if (result.isSuccess) {
                val account = result.signInAccount
                firebaseAuthWithGoogle(account!!)
            } else {
                Toast.makeText(this, "Some error occurred.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.e(TAG, "firebaseAuthWithGoogle():" + acct.id!!)
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        val user = mAuth!!.currentUser
                        Log.e(TAG,"User"+user)
                        initFirebase()
                        showProgressDialog()
                        startActivity(Intent(this@LoginActivity, HomeMenu::class.java))

                    } else {
                        // Sign in fails
                        Toast.makeText(this, "Sign in fail.", Toast.LENGTH_SHORT).show()
                    }
                }
    }
    override fun onConnectionFailed(p0: ConnectionResult) {
        Toast.makeText(applicationContext, "Google Play Services error.", Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()

        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        Log.e("CurrentUser","CurrentUser"+currentUser)
    }
    private fun signOut() {
        // sign out Firebase
        mAuth!!.signOut()

        // sign out Google
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback { }

    }
    companion object {

    }

}
