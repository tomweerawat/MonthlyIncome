package com.example.hotumit.monthlyincome.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.R.id.*
import com.example.hotumit.monthlyincome.utility.BaseActivity
import com.example.hotumit.monthlyincome.utility.Contextor
import com.example.hotumit.monthlyincome.dao.NewCustItemCollectionDao
import com.example.hotumit.monthlyincome.dao.NewCustItemDao
import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao
import com.example.hotumit.monthlyincome.dao.dummy.NewCustDummyItemDao
import com.example.hotumit.monthlyincome.dao.dummy.Newcus
import com.example.hotumit.monthlyincome.fragment.FragmentCust
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_newcus.*
import org.jetbrains.anko.Android
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class ActivityNewCus : BaseActivity() {



    var totalmale: String = ""
    var totalfemale: String = ""
    var month: String = ""
    private val TAG = "MyActivity"
    lateinit var newcust: NewCustDummyItemDao
    /*     val users: MutableList<Newcus>? = null
*/
 val users : MutableList<Newcus> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newcus)
        initview()
        inittoolbar()
    }

    private fun initview() {
        btnnewcus.setOnClickListener {
            if (edtnew.text.toString().matches("".toRegex()) && edate.text.toString().matches("".toRegex())) {
                Toast.makeText(Contextor.getInstance().context, "Please Insert Data", Toast.LENGTH_LONG).show()
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.edtnew))
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.edate))
            } else if (edtnew.text.toString().matches("".toRegex())) {
                Toast.makeText(Contextor.getInstance().context, "Please Insert StartData", Toast.LENGTH_LONG).show()
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.edtnew))
            } else if (edate.text.toString().matches("".toRegex())) {
                Toast.makeText(Contextor.getInstance().context, "Please Insert EndData", Toast.LENGTH_LONG).show()
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(2)
                        .playOn(findViewById(R.id.edate))
            } else {
                loadData()

            }

        }
    }

    private fun inittoolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolBarr)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

    }

    private fun loadData() {
        val call = HttpManager.ApiService()
        call.loadNewCus(edtnew.text.toString(), edate.text.toString()).enqueue(object : Callback<NewCustItemCollectionDao?> {

            override fun onResponse(call: Call<NewCustItemCollectionDao?>?, response: Response<NewCustItemCollectionDao?>?) {
                val dao = response?.body()
                Log.e(TAG, "Mydata" + GsonBuilder().setPrettyPrinting().create().toJson(dao))

            /*    for (item in dao!!.newcuss) {

                    month = item.month




                    if (item.gender.equals("M")) {
                        totalmale = item.newregister

                    } else if (item.gender.equals("F")) {
                        totalfemale = item.newregister

                    }
                    users.add(Newcus(month, totalmale, totalfemale))
                }

                newcust= NewCustDummyItemDao(users as ArrayList<Newcus>)
                Log.e(TAG, "Mydata" + GsonBuilder().setPrettyPrinting().create().toJson(newcust))*/





                gotoActivity(dao)



            }

            override fun onFailure(call: Call<NewCustItemCollectionDao?>?, t: Throwable?) {

            }


        })
    }

    private fun gotoActivity(dao: NewCustItemCollectionDao?) {
        showProgressDialog()
        val i = Intent(this, FragmentCust::class.java)
        i.putExtra("dao", dao)
        startActivity(i)
    }

    /*  private fun gotoActivity(newcust: NewCustDummyItemDao) {
          showProgressDialog()
          val i = Intent(this, FragmentCust::class.java)
          i.putExtra("dao", newcust)
          startActivity(i)
      }*/


}