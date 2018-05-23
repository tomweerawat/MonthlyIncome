package com.example.hotumit.monthlyincome.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hotumit.monthlyincome.Utility.RecyclerItemClickListener;
import com.example.hotumit.monthlyincome.R;
import com.example.hotumit.monthlyincome.activity.ActivityChoose;
import com.example.hotumit.monthlyincome.dao.PhotoItemDao;

import com.example.hotumit.monthlyincome.dao.SeparateItemIncomeDao;
import com.example.hotumit.monthlyincome.dao.SumIncomeCollectionDao;
import com.example.hotumit.mykotlin.adapter.InfoAdapter;


public class SumncomeFragment extends Fragment {
    private RecyclerView recyclerView;
    InfoAdapter sumIncomeAdapter;


    SwipeRefreshLayout swipeRefreshLayout;
    SumIncomeCollectionDao sumIncomeCollectionDao;

    public interface FragmentListener{
        void OnItemClick(SeparateItemIncomeDao dao);

    }

    public static SumncomeFragment newInstance(SumIncomeCollectionDao dao) {
        SumncomeFragment fragment = new SumncomeFragment();
        Bundle args = new Bundle();
        args.putParcelable("sumIncomeCollectionDao",dao);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        sumIncomeCollectionDao = getArguments().getParcelable("sumIncomeCollectionDao");
        Log.e("asdf","asdf"+sumIncomeCollectionDao);
        initInstances(rootView, savedInstanceState);
        refresh();
        return rootView;
    }

    private void initInstances(View rootView, Bundle savedInstanceState) {
        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipLayoutRefresh);
        recyclerView = rootView.findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        sumIncomeAdapter = new InfoAdapter(ActivityChoose.daosum,recyclerItemClickListener);
        recyclerView.setAdapter(sumIncomeAdapter);




    }

    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick() {

        }
    };



    private void refresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
