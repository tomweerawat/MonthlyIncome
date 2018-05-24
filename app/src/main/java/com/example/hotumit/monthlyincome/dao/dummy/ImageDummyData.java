package com.example.hotumit.monthlyincome.dao.dummy;


import com.example.hotumit.monthlyincome.R;

import java.util.ArrayList;
import java.util.List;

public final class ImageDummyData {


    public static List<Integer> getData() {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.book);
        list.add(R.drawable.money);
        list.add(R.drawable.bag);
        list.add(R.drawable.cloud);

        return list;
    }


}
