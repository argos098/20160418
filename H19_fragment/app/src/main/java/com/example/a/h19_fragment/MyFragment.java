package com.example.a.h19_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by a on 2016-04-21.
 */
public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        final TextView textViewCounter = (TextView) view.findViewById(R.id.textViewCounter);
        Button btnIncrease = (Button) view.findViewById(R.id.btnIncrease);

        btnIncrease.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(textViewCounter.getText().toString());
                value++;
                textViewCounter.setText(""+value);
            }
        });
        return view;
    }
}
