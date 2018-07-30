package com.example.hotumit.monthlyincome.activity.java

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.builders.DatePickerBuilder
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener
import com.applandeo.materialcalendarview.utils.DateUtils
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.R.drawable.calendar
import com.example.hotumit.monthlyincome.dao.NewCustItemCollectionDao
import com.example.hotumit.monthlyincome.dao.TimeDao
import com.example.hotumit.monthlyincome.fragment.FragmentCust
import com.example.hotumit.monthlyincome.manager.singleton.HttpManager
import com.example.hotumit.monthlyincome.utility.BaseActivity
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_newcus.*
import kotlinx.android.synthetic.main.datepicker_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class DatePicker : BaseActivity(), OnSelectDateListener {
    val datep: MutableList<String> = ArrayList()
    internal lateinit var time: TimeDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datepicker_layout)

        initCalendar()
          date_button.setOnClickListener {
              selectCalendar()
          }
        inittoolbar()
    }

    private fun inittoolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolBarr)
        toolbar.setTitle("NewCustomer")
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

    }

    private fun selectCalendar() {
        var sdate: String
        var edate: String

        val format = SimpleDateFormat("yyyy-MM-dd")
        sdate = format.format(calendarView.selectedDates[0].time)
        edate = format.format(calendarView.selectedDates[1].time)

        loadData(sdate,edate)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onSelect(calendar: MutableList<Calendar>?) {
        var sdate: String
        var edate: String
/*        for (i in calendar!!) {
            val format = SimpleDateFormat("yyyy-MM-dd")
            format.format(i.time)
            Toast.makeText(applicationContext, "Select" + format.format(i.time), Toast.LENGTH_SHORT).show()

     *//*       sdate = format.format(i.time)
            val edate = format.format(calendar[1].time)



            loadDataIncome(sdate, edate)
            loadData(sdate, edate)*//*

        }*/
        val format = SimpleDateFormat("yyyy-MM-dd")
        sdate = format.format(calendar!![0].time)
        edate = format.format(calendar[1].time)
        Log.e("startdate", "startdate" + sdate + "\n" + edate)
       /* loadDataIncome(sdate, edate)
        loadData(sdate, edate)*/
        loadData(sdate, edate)
    }

/*    private fun loadDataIncome(sdate: String, edate: String) {
        val call = HttpManager.ApiService()
        call.loaddataIcome(sdate, edate, emailedt.text.toString()).enqueue(object : Callback<SeperateCollectionDao?> {
            override fun onResponse(call: Call<SeperateCollectionDao?>?, response: Response<SeperateCollectionDao?>?) {
                val dao = response?.body()
                Log.e("tomtom1", "tomtom1" + dao);
                gotoActivity(dao)
            }

            override fun onFailure(call: Call<SeperateCollectionDao?>?, t: Throwable?) {

            }


        })
    }

    private fun loadData(sdate: String, edate: String) {
        Log.e("Hellothis", "Hellothis" + sdate + "\t" + edate)
        val call = HttpManager.ApiService()
        call.loaddataSumIcome(sdate, edate, emailedt.text.toString()).enqueue(object : Callback<SumIncomeCollectionDao?> {
            override fun onResponse(call: Call<SumIncomeCollectionDao?>?, response: Response<SumIncomeCollectionDao?>?) {
                ActivityChoose.daosum = response?.body()!!
                Log.e("tomtom", "tomtom" + ActivityChoose.daosum)


            }

            override fun onFailure(call: Call<SumIncomeCollectionDao?>?, t: Throwable?) {
                Toast.makeText(Contextor.getInstance().context, "Failure" + t?.message, Toast.LENGTH_LONG).show()
            }


        })

    }*/

    private fun loadData(sdate: String, edate: String) {
        val call = HttpManager.ApiService()
        call.loadNewCus(sdate, edate).enqueue(object : Callback<NewCustItemCollectionDao?> {

            override fun onResponse(call: Call<NewCustItemCollectionDao?>?, response: Response<NewCustItemCollectionDao?>?) {
                val dao = response?.body()
                Log.e("MyData", "Mydata" + GsonBuilder().setPrettyPrinting().create().toJson(dao))
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

    private fun initCalendar() {
        val min = Calendar.getInstance()
        min.add(Calendar.MONTH, -5)

        val max = Calendar.getInstance()
        max.add(Calendar.DAY_OF_MONTH, 3)
        val rangeBuilder = DatePickerBuilder(this, this)
                .pickerType(CalendarView.MANY_DAYS_PICKER)
                .date(max)
                .headerColor(R.color.colorPrimaryDark)
                .headerLabelColor(R.color.colorAccent)
                .selectionColor(R.color.daysLabelColor)
                .todayLabelColor(R.color.colorAccent)
                .dialogButtonsColor(android.R.color.holo_green_dark)
                .disabledDaysLabelsColor(android.R.color.holo_purple)
                .previousButtonSrc(R.drawable.ic_chevron_left_black_24dp)
                .forwardButtonSrc(R.drawable.ic_chevron_right_black_24dp)
                .minimumDate(min)
                .maximumDate(max)
                .disabledDays(getDisabledDays());
        val rangePicker = rangeBuilder.build()



      /*  date_button.setOnClickListener {
            rangePicker.show()
        }*/
    }


    private fun getDisabledDays(): List<Calendar> {
        val firstDisabled = DateUtils.getCalendar()
        firstDisabled.add(Calendar.DAY_OF_MONTH, 2)

        val secondDisabled = DateUtils.getCalendar()
        secondDisabled.add(Calendar.DAY_OF_MONTH, 1)

        val thirdDisabled = DateUtils.getCalendar()
        thirdDisabled.add(Calendar.DAY_OF_MONTH, 18)

        val calendars = ArrayList<Calendar>()
        calendars.add(firstDisabled)
        calendars.add(secondDisabled)
        calendars.add(thirdDisabled)
        return calendars
    }

}