package com.example.builders.Main2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.builders.R;

public class MainFragment2 extends android.support.v4.app.Fragment {

    public static MainFragment2 newInstance(){
        MainFragment2 fragment = new MainFragment2();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.activity_main2, container, false);

        return v;
    }
}
