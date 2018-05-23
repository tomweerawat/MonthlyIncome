package com.example.hotumit.monthlyincome.dao.dummy

import com.example.hotumit.monthlyincome.dao.MenuItemDao
import org.jetbrains.anko.Android


object MenuGenerator {
    fun createAndroidVersionInfo(): MutableList<MenuItemDao> {
        return arrayListOf(
                MenuItemDao(txt = "Newcustomer"),
                MenuItemDao(txt = "MonthlyIncome"),
                MenuItemDao(txt = "Dummy"),
                MenuItemDao(txt = "Dummy")


        )
    }
}