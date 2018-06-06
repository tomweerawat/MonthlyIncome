package com.example.hotumit.monthlyincome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hotumit.monthlyincome.utility.RecyclerItemClickListener;
import com.example.hotumit.monthlyincome.R;
import com.example.hotumit.monthlyincome.dao.PhotoItemDao;

public class MainFragment extends Fragment {

    public interface FragmentListener {
        void onItemClicked(PhotoItemDao dao);
    }

    // Variable
    private RecyclerView recyclerView;
 /*   private NoticeAdapter noticeAdapter;*/

    SwipeRefreshLayout swipeRefreshLayout;





    boolean isLoadMore = false;


    // Function
    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (savedInstanceState != null);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        initInstances(rootView, savedInstanceState);
        refresh();
        return rootView;
    }

    private void initInstances(View rootView, Bundle savedInstanceState) {

        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipLayoutRefresh);
        recyclerView = rootView.findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        loadMoreData();

    }


    private void refresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void loadMoreData() {
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
    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick() {



        }
    };



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
