package com.example.builders.Auth;


import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.builders.R;

import org.w3c.dom.Text;

public class RegiFragment1 extends Fragment {

    TextView regiTxt1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register1, container, false);

        regiTxt1 = v.findViewById(R.id.regi_txt1);
        Shader textShader=new LinearGradient(150, 0, 0, regiTxt1.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange),getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        regiTxt1.getPaint().setShader(textShader);
        return v;
    }

}
