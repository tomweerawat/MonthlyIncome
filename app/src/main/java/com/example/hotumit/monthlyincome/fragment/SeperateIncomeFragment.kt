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
import com.example.hotumit.monthlyincome.dao.SeparateItemIncomeDao
import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao
import com.example.hotumit.mykotlin.adapter.SeperateIncomeAdapter

class SeperateIncomeFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    internal lateinit var seperateIncomeAdapter: SeperateIncomeAdapter

    internal lateinit var swipeRefreshLayout: SwipeRefreshLayout
    internal var dao: SeperateCollectionDao? = null

    private val recyclerItemClickListener = RecyclerItemClickListener { }

    interface FragmentListener {
        fun OnItemClick(dao: SeparateItemIncomeDao)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.content_main, container, false)
        dao = arguments!!.getParcelable("dao")
        Log.e("getArguments", "getArguments" + dao!!)
        initInstances(rootView, savedInstanceState)
        refresh()
        return rootView
    }

    private fun initInstances(rootView: View, savedInstanceState: Bundle?) {
        swipeRefreshLayout = rootView.findViewById<View>(R.id.swipLayoutRefresh) as SwipeRefreshLayout
        recyclerView = rootView.findViewById(R.id.recycler_view_employee_list)
        val layoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        seperateIncomeAdapter = SeperateIncomeAdapter(dao, recyclerItemClickListener)
        recyclerView!!.adapter = seperateIncomeAdapter

    }


    private fun refresh() {
        swipeRefreshLayout.setOnRefreshListener { swipeRefreshLayout.isRefreshing = false }
    }

    companion object {

        fun newInstance(dao: SeperateCollectionDao): SeperateIncomeFragment {
            val fragment = SeperateIncomeFragment()
            val args = Bundle()
            args.putParcelable("dao", dao)
            fragment.arguments = args
            return fragment
        }
    }
}
