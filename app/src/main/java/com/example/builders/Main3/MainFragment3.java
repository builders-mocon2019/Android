package com.example.builders.Main3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.builders.R;

public class MainFragment3 extends android.support.v4.app.Fragment {

    public static MainFragment3 newInstance(){
        MainFragment3 fragment = new MainFragment3();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.activity_main3, container, false);

        return v;
    }
}
