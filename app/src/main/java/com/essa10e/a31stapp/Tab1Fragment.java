package com.essa10e.a31stapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by essa10e on 8/7/17.
 */

public class Tab1Fragment extends Fragment {
    private final String TAG = "Fragment 1";

    private Button btnNavFragment1;

    // because it's a fragment WE only need to use onCreateView only.:

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // So we need to create a view object:
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        btnNavFragment1 = (Button)view.findViewById(R.id.btnNavFrag1);

        Log.d(TAG, "onCreateView started.");

        btnNavFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // because we are inside a fragment we only use getActivity() instead of MainActivity.this
                Toast.makeText(getActivity(), "Going to Frag 1", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
