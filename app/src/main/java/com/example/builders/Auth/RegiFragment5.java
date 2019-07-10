package com.example.builders.Auth;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.builders.R;

public class RegiFragment5 extends Fragment {

    TextView regiTxt5, regiResult;
    TextView r51, r52, r53;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register5, container, false);

        regiTxt5 = v.findViewById(R.id.regi_txt5);
        Shader textShader=new LinearGradient(150, 0, 0, regiTxt5.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange),getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        regiTxt5.getPaint().setShader(textShader);

        regiResult = v.findViewById(R.id.regi5_result);

        r51 = v.findViewById(R.id.regi5_1);
        r51.setOnClickListener(onClickListener);
        r52 = v.findViewById(R.id.regi5_2);
        r52.setOnClickListener(onClickListener);
        r53 = v.findViewById(R.id.regi5_3);
        r53.setOnClickListener(onClickListener);

        return v;
    }

    TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.regi5_1:
                    if (r51.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r51.setTextColor(Color.WHITE);
                        r51.setTag("y");
                        background = (TransitionDrawable) r52.getBackground();
                        if (r52.getTag().equals("y")) background.reverseTransition(200);
                        r52.setTextColor(Color.BLACK);
                        r52.setTag("n");
                        background = (TransitionDrawable) r53.getBackground();
                        if (r53.getTag().equals("y")) background.reverseTransition(200);
                        r53.setTextColor(Color.BLACK);
                        r53.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi5_2:
                    if (r52.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r52.setTextColor(Color.WHITE);
                        r52.setTag("y");
                        background = (TransitionDrawable) r51.getBackground();
                        if (r51.getTag().equals("y")) background.reverseTransition(200);
                        r51.setTextColor(Color.BLACK);
                        r51.setTag("n");
                        background = (TransitionDrawable) r53.getBackground();
                        if (r53.getTag().equals("y")) background.reverseTransition(200);
                        r53.setTextColor(Color.BLACK);
                        r53.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi5_3:
                    if (r53.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r53.setTextColor(Color.WHITE);
                        r53.setTag("y");
                        background = (TransitionDrawable) r51.getBackground();
                        if (r51.getTag().equals("y")) background.reverseTransition(200);
                        r51.setTextColor(Color.BLACK);
                        r51.setTag("n");
                        background = (TransitionDrawable) r52.getBackground();
                        if (r52.getTag().equals("y")) background.reverseTransition(200);
                        r52.setTextColor(Color.BLACK);
                        r52.setTag("n");
                    }
                    setResult();
                    break;
            }

        }
    };

    void setResult(){
        regiResult.setText("");
        if(r51.getTag()=="y") regiResult.setText(r51.getText().toString());
        else if(r52.getTag()=="y") regiResult.setText(r52.getText().toString());
        else if(r53.getTag()=="y") regiResult.setText(r53.getText().toString());
    }
}
