package com.essa10e.a31stapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by essa10e on 8/8/17.
 */

public class Tab2CardView extends Fragment {

    private final String TAG = "CardView TAB 1";

    private ListView mListView;

    // because it's a fragment WE only need to use onCreateView only.:

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // So we need to create a view object:
        View view = inflater.inflate(R.layout.cardview_layout, container, false);

        mListView = (ListView)view.findViewById(R.id.listview);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.mountain1, "Mountain 1"));
        list.add(new Card("drawable://" + R.drawable.mountain2, "Mountain 2"));
        list.add(new Card("drawable://" + R.drawable.mountain3, "Mountain 3"));
        list.add(new Card("drawable://" + R.drawable.mountain4, "Mountain 4"));
        list.add(new Card("drawable://" + R.drawable.mountain5, "Mountain 5"));
        list.add(new Card("drawable://" + R.drawable.mountain6, "Mountain 6"));
        list.add(new Card("drawable://" + R.drawable.mountain7, "Mountain 7"));
        list.add(new Card("drawable://" + R.drawable.mountain8, "Mountain 8"));
        list.add(new Card("drawable://" + R.drawable.mountain9, "Mountain 9"));
        list.add(new Card("drawable://" + R.drawable.mountain10, "Mountain 10"));
        list.add(new Card("drawable://" + R.drawable.mountain11, "Mountain 11"));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.cardview_layout_main, list);
        mListView.setAdapter(adapter);

        Log.d(TAG, "onCreateView started.");

        return view;
    }
}
