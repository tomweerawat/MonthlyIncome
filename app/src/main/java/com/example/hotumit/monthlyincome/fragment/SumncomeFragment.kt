package com.example.hotumit.monthlyincome.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.example.hotumit.monthlyincome.utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.activity.ActivityChoose

import com.example.hotumit.monthlyincome.dao.SeparateItemIncomeDao
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao
import com.example.hotumit.mykotlin.adapter.InfoAdapter


class SumncomeFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    internal lateinit var sumIncomeAdapter: InfoAdapter


    internal lateinit var swipeRefreshLayout: SwipeRefreshLayout
    internal var sumIncomeCollectionDao: SumIncomeCollectionDao? = null

    private val recyclerItemClickListener = RecyclerItemClickListener { }

    interface FragmentListener {
        fun OnItemClick(dao: SeparateItemIncomeDao)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.content_main, container, false)
        sumIncomeCollectionDao = arguments!!.getParcelable("sumIncomeCollectionDao")
        Log.e("asdf", "asdf" + sumIncomeCollectionDao!!)
        initInstances(rootView, savedInstanceState)
        refresh()
        return rootView
    }

    private fun initInstances(rootView: View, savedInstanceState: Bundle?) {
        swipeRefreshLayout = rootView.findViewById<View>(R.id.swipLayoutRefresh) as SwipeRefreshLayout
        recyclerView = rootView.findViewById(R.id.recycler_view_employee_list)
        val layoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        sumIncomeAdapter = InfoAdapter(ActivityChoose.daosum, recyclerItemClickListener)
        recyclerView!!.adapter = sumIncomeAdapter


    }


    private fun refresh() {
        swipeRefreshLayout.setOnRefreshListener { swipeRefreshLayout.isRefreshing = false }
    }

    companion object {

        fun newInstance(dao: SumIncomeCollectionDao): SumncomeFragment {
            val fragment = SumncomeFragment()
            val args = Bundle()
            args.putParcelable("sumIncomeCollectionDao", dao)
            fragment.arguments = args
            return fragment
        }
    }
}
