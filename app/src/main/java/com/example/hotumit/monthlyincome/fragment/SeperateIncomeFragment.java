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
import com.example.hotumit.monthlyincome.dao.PhotoItemDao;
import com.example.hotumit.monthlyincome.dao.SeparateItemIncomeDao;
import com.example.hotumit.monthlyincome.dao.SeperateCollectionDao;
import com.example.hotumit.mykotlin.adapter.SeperateIncomeAdapter;

public class SeperateIncomeFragment extends Fragment {
    private RecyclerView recyclerView;
    SeperateIncomeAdapter seperateIncomeAdapter;

    SwipeRefreshLayout swipeRefreshLayout;
    SeperateCollectionDao dao;

    public interface FragmentListener{
        void OnItemClick(SeparateItemIncomeDao dao);

    }

    public static SeperateIncomeFragment newInstance(SeperateCollectionDao dao) {
        SeperateIncomeFragment fragment = new SeperateIncomeFragment();
        Bundle args = new Bundle();
        args.putParcelable("dao",dao);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        dao = getArguments().getParcelable("dao");
        Log.e("getArguments","getArguments"+dao);
        initInstances(rootView, savedInstanceState);
        refresh();
        return rootView;
    }

    private void initInstances(View rootView, Bundle savedInstanceState) {
        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipLayoutRefresh);
        recyclerView = rootView.findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        seperateIncomeAdapter = new SeperateIncomeAdapter(dao,recyclerItemClickListener);
        recyclerView.setAdapter(seperateIncomeAdapter);

    }

    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick() {

          /*  Toast.makeText(MainActivity.this,
                    "List title:  " + notice.getCamera(),
                    Toast.LENGTH_LONG).show();*/
        /*    Intent i = new Intent(MainActivity.this, MoreinfoActivity.class);
            i.putExtra("dao", notice);
            startActivity(i);*/

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
