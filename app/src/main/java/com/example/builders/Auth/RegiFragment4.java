package com.example.builders.Auth;

import android.graphics.Color;
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

public class RegiFragment4 extends Fragment {

    TextView regiTxt4, regiResult;

    TextView r41, r42, r43, r44, r45, r46, r47, r48, r49;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register4, container, false);

        regiTxt4 = v.findViewById(R.id.regi_txt4);
        Shader textShader=new LinearGradient(150, 0, 0, regiTxt4.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange),getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        regiTxt4.getPaint().setShader(textShader);


        regiResult = v.findViewById(R.id.regi4_result);

        r41 = v.findViewById(R.id.regi4_1);
        r41.setOnClickListener(onClickListener);
        r42 = v.findViewById(R.id.regi4_2);
        r42.setOnClickListener(onClickListener);
        r43 = v.findViewById(R.id.regi4_3);
        r43.setOnClickListener(onClickListener);
        r44 = v.findViewById(R.id.regi4_4);
        r44.setOnClickListener(onClickListener);
        r45 = v.findViewById(R.id.regi4_5);
        r45.setOnClickListener(onClickListener);
        r46 = v.findViewById(R.id.regi4_6);
        r46.setOnClickListener(onClickListener);
        r47 = v.findViewById(R.id.regi4_7);
        r47.setOnClickListener(onClickListener);
        r48 = v.findViewById(R.id.regi4_8);
        r48.setOnClickListener(onClickListener);
        r49 = v.findViewById(R.id.regi4_9);
        r49.setOnClickListener(onClickListener);

        return v;
    }

    TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.regi4_1:
                    if (r41.getTag().equals("n")) {
                        r41.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r41.setTextColor(Color.WHITE);
                        r41.setTag("y");

                    } else {
                        r41.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r41.setTextColor(Color.BLACK);
                        r41.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_2:
                    if (r42.getTag().equals("n")) {
                        r42.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r42.setTextColor(Color.WHITE);
                        r42.setTag("y");
                    } else {
                        r42.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r42.setTextColor(Color.BLACK);
                        r42.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_3:
                    if (r43.getTag().equals("n")) {
                        r43.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r43.setTextColor(Color.WHITE);
                        r43.setTag("y");
                    } else {
                        r43.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r43.setTextColor(Color.BLACK);
                        r43.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_4:
                    r44 = v.findViewById(R.id.regi4_4);
                    if (r44.getTag().equals("n")) {
                        r44.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r44.setTextColor(Color.WHITE);
                        r44.setTag("y");
                    } else {
                        r44.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r44.setTextColor(Color.BLACK);
                        r44.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_5:
                    if (r45.getTag().equals("n")) {
                        r45.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r45.setTextColor(Color.WHITE);
                        r45.setTag("y");
                    } else {
                        r45.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r45.setTextColor(Color.BLACK);
                        r45.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_6:
                    if (r46.getTag().equals("n")) {
                        r46.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r46.setTextColor(Color.WHITE);
                        r46.setTag("y");
                    } else {
                        r46.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r46.setTextColor(Color.BLACK);
                        r46.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_7:
                    if (r47.getTag().equals("n")) {
                        r47.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r47.setTextColor(Color.WHITE);
                        r47.setTag("y");
                    } else {
                        r47.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r47.setTextColor(Color.BLACK);
                        r47.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_8:
                    if (r48.getTag().equals("n")) {
                        r48.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r48.setTextColor(Color.WHITE);
                        r48.setTag("y");
                    } else {
                        r48.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r48.setTextColor(Color.BLACK);
                        r48.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi4_9:
                    if (r49.getTag().equals("n")) {
                        r49.setBackground(getResources().getDrawable(R.drawable.btn_gradient));
                        r49.setTextColor(Color.WHITE);
                        r49.setTag("y");
                    } else {
                        r49.setBackground(getResources().getDrawable(R.drawable.login_textbox));
                        r49.setTextColor(Color.BLACK);
                        r49.setTag("n");
                    }
                    setResult();
                    break;

            }

        }
    };

    void setResult(){
        regiResult.setText("");
        if(r41.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r41.getText().toString());
        if(r42.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r42.getText().toString());
        if(r43.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r43.getText().toString());
        if(r44.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r44.getText().toString());
        if(r45.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r45.getText().toString());
        if(r46.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r46.getText().toString());
        if(r47.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r47.getText().toString());
        if(r48.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r48.getText().toString());
        if(r49.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r49.getText().toString());
    }
}
