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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.R;

public class RegiFragment3 extends Fragment {

    TextView regiTxt3, regiResult;

    TextView r31, r32, r33, r34, r35, r36, r37, r38, r39, rextra_txt;
    LinearLayout rextra;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register3, container, false);

        regiTxt3 = v.findViewById(R.id.regi_txt3);
        Shader textShader = new LinearGradient(150, 0, 0, regiTxt3.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange), getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        regiTxt3.getPaint().setShader(textShader);

        regiResult = v.findViewById(R.id.regi3_result);

        r31 = v.findViewById(R.id.regi3_1);
        r31.setOnClickListener(onClickListener);
        r32 = v.findViewById(R.id.regi3_2);
        r32.setOnClickListener(onClickListener);
        r33 = v.findViewById(R.id.regi3_3);
        r33.setOnClickListener(onClickListener);
        r34 = v.findViewById(R.id.regi3_4);
        r34.setOnClickListener(onClickListener);
        r35 = v.findViewById(R.id.regi3_5);
        r35.setOnClickListener(onClickListener);
        r36 = v.findViewById(R.id.regi3_6);
        r36.setOnClickListener(onClickListener);
        r37 = v.findViewById(R.id.regi3_7);
        r37.setOnClickListener(onClickListener);
        r38 = v.findViewById(R.id.regi3_8);
        r38.setOnClickListener(onClickListener);
        r39 = v.findViewById(R.id.regi3_9);
        r39.setOnClickListener(onClickListener);

        rextra = v.findViewById(R.id.regi3_extra);
        rextra_txt = v.findViewById(R.id.regi3_extra_txt);

        return v;
    }

    TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.regi3_1:
                    if (r31.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r31.setTextColor(Color.WHITE);
                        r31.setTag("y");

                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r31.setTextColor(Color.BLACK);
                        r31.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_2:
                    if (r32.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r32.setTextColor(Color.WHITE);
                        r32.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r32.setTextColor(Color.BLACK);
                        r32.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_3:
                    if (r33.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r33.setTextColor(Color.WHITE);
                        r33.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r33.setTextColor(Color.BLACK);
                        r33.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_4:
                    r34 = v.findViewById(R.id.regi3_4);
                    if (r34.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r34.setTextColor(Color.WHITE);
                        r34.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r34.setTextColor(Color.BLACK);
                        r34.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_5:
                    if (r35.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r35.setTextColor(Color.WHITE);
                        r35.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r35.setTextColor(Color.BLACK);
                        r35.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_6:
                    if (r36.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r36.setTextColor(Color.WHITE);
                        r36.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r36.setTextColor(Color.BLACK);
                        r36.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_7:
                    if (r37.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r37.setTextColor(Color.WHITE);
                        r37.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r37.setTextColor(Color.BLACK);
                        r37.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_8:
                    if (r38.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r38.setTextColor(Color.WHITE);
                        r38.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r38.setTextColor(Color.BLACK);
                        r38.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.regi3_9:
                    if (r39.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        r39.setTextColor(Color.WHITE);
                        r39.setTag("y");
                        rextra.setVisibility(View.VISIBLE);
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        r39.setTextColor(Color.BLACK);
                        r39.setTag("n");
                        rextra.setVisibility(View.GONE);
                    }
                    setResult();
                    break;

            }

        }
    };

    void setResult(){
        regiResult.setText("");
        if(r31.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r31.getText().toString());
        if(r32.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r32.getText().toString());
        if(r33.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r33.getText().toString());
        if(r34.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r34.getText().toString());
        if(r35.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r35.getText().toString());
        if(r36.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r36.getText().toString());
        if(r37.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r37.getText().toString());
        if(r38.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+r38.getText().toString());
        if(r39.getTag()=="y") regiResult.setText(regiResult.getText().toString()+" "+"기타 "+rextra_txt.getText().toString());
    }

}
