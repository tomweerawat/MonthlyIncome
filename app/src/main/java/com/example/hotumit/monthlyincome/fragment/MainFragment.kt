package com.example.hotumit.monthlyincome.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.example.hotumit.monthlyincome.utility.RecyclerItemClickListener
import com.example.hotumit.monthlyincome.R
import com.example.hotumit.monthlyincome.dao.PhotoItemDao


// Function
class MainFragment : Fragment() {

    // Variable
    private var recyclerView: RecyclerView? = null
    /*   private NoticeAdapter noticeAdapter;*/

    internal lateinit var swipeRefreshLayout: SwipeRefreshLayout


    internal var isLoadMore = false
    private val recyclerItemClickListener = RecyclerItemClickListener { }

    interface FragmentListener {
        fun onItemClicked(dao: PhotoItemDao)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (savedInstanceState != null);

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.content_main, container, false)
        initInstances(rootView, savedInstanceState)
        refresh()
        return rootView
    }

    private fun initInstances(rootView: View, savedInstanceState: Bundle?) {

        swipeRefreshLayout = rootView.findViewById<View>(R.id.swipLayoutRefresh) as SwipeRefreshLayout
        recyclerView = rootView.findViewById(R.id.recycler_view_employee_list)
        val layoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = layoutManager
        loadMoreData()

    }


    private fun refresh() {
        swipeRefreshLayout.setOnRefreshListener { swipeRefreshLayout.isRefreshing = false }
    }

    private fun loadMoreData() {
        /*       Call<PhotoItemCollectionDao> call = HttpManager.getInstance().getService().loadPhotoList();
        call.enqueue(new Callback<PhotoItemCollectionDao>() {
            @Override
            public void onResponse(Call<PhotoItemCollectionDao> call, Response<PhotoItemCollectionDao> response) {
                if(response.isSuccessful()){
                    PhotoItemCollectionDao dao = response.body();

                   *//* Toast.makeText(getActivity(),"Hello"+dao.getData().get(0).getCaption(),Toast.LENGTH_LONG).show();*//*
                   *//* PhotoItemDao = new ArrayList<>(Arrays.asList(dao.getData()));*//*
                  *//*  ArrayList<PhotoItemDao> PhotoItemDao = new ArrayList<>(Arrays.asList(dao.getData()));*//*
                    noticeAdapter = new NoticeAdapter(dao,recyclerItemClickListener);
                    recyclerView.setAdapter(noticeAdapter);



                }

            }

            @Override
            public void onFailure(Call<PhotoItemCollectionDao> call, Throwable t) {

            }
        });
*/

    }


    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {

        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }


}
