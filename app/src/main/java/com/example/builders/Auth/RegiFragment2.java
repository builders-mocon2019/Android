package com.example.builders.Auth;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.builders.R;

public class RegiFragment2 extends Fragment {

    TextView regiTxt2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register2, container, false);

        regiTxt2 = v.findViewById(R.id.regi_txt2);
        Shader textShader=new LinearGradient(150, 0, 0, regiTxt2.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange),getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        regiTxt2.getPaint().setShader(textShader);
        return v;
    }
}
