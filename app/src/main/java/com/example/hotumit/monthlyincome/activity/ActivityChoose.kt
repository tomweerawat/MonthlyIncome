package com.example.hotumit.monthlyincome.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.Utility.BaseActivity
import com.example.hotumit.monthlyincome.Utility.Contextor
import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import kotlinx.android.synthetic.main.activity_choosedate.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityChoose : BaseActivity() {


    companion object {
        lateinit var daosum: SumIncomeCollectionDao
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosedate)

        btnseperate.setOnClickListener(View.OnClickListener {
            if (startdate.text.toString().matches("".toRegex()) && enddate.text.toString().matches("".toRegex()) && email.text.toString().matches("".toRegex())) {
                Toast.makeText(Contextor.getInstance().context, "Please Insert Data", Toast.LENGTH_LONG).show()
            } else if (startdate.text.toString().matches("".toRegex())) {
                Toast.makeText(Contextor.getInstance().context, "Startdate Null", Toast.LENGTH_LONG).show()
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.startdate))
            } else if (enddate.text.toString().matches("".toRegex())) {
                Toast.makeText(Contextor.getInstance().context, "Enddate Null", Toast.LENGTH_LONG).show()
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.enddate))
            } else if (email.text.toString().matches("".toRegex())) {
                Toast.makeText(Contextor.getInstance().context, "Email Null", Toast.LENGTH_LONG).show()
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.email))
            } else {
                showProgressDialog()
                loadDataIncome()
                loadData()

            }
        })

        inittoolbar()

    }

    private fun inittoolbar() {
        val toolbar = findViewById(R.id.tb) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener{
            finish()
        }

    }

    private fun loadDataIncome() {
        val call = HttpManager.ApiService()
        call.loaddataIcome(startdate.text.toString(),enddate.text.toString(),email.text.toString()).enqueue(object: Callback<SeperateCollectionDao?> {
            override fun onResponse(call: Call<SeperateCollectionDao?>?, response: Response<SeperateCollectionDao?>?) {
                val dao = response?.body()
                Log.e("tomtom1","tomtom1"+dao);
                gotoActivity(dao)
            }

            override fun onFailure(call: Call<SeperateCollectionDao?>?, t: Throwable?) {

                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })
    }

    private fun gotoActivity(dao: SeperateCollectionDao?) {
        val i = Intent(this@ActivityChoose, MainActivity::class.java)
        i.putExtra("dao", dao)
        startActivity(i)
    }


    private fun loadData() {
        val call = HttpManager.ApiService()
        call.loaddataSumIcome(startdate.text.toString(),enddate.text.toString(),email.text.toString()).enqueue(object: Callback<SumIncomeCollectionDao?> {
            override fun onResponse(call: Call<SumIncomeCollectionDao?>?, response: Response<SumIncomeCollectionDao?>?) {
                daosum = response?.body()!!
                Log.e("tomtom","tomtom"+daosum);
            }
            override fun onFailure(call: Call<SumIncomeCollectionDao?>?, t: Throwable?) {
                Toast.makeText(Contextor.getInstance().context, "Failure" + t?.message, Toast.LENGTH_LONG).show()
            }


        })

    }




}