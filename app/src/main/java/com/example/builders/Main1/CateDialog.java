package com.example.builders.Main1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.builders.Auth.DBLoadActivity;
import com.example.builders.Intro.WalkthroughActivity;
import com.example.builders.R;

public class CateDialog extends Dialog {

    TextView c1, c2, c3, c4, c5, c6, c7, c8;
    Button cateBtn;

    private String result="";

    OnMyDialogResult mDialogResult;

    static SharedPreferences getSharedPreferences(Context context) { //SharedPreferences 호출 함수
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public CateDialog(final Context c) {
        super(c);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_cate_dialog);

//        TextView textView = findViewById(R.id.cate_dialog_txt);
//        Shader textShader = new LinearGradient(150, 0, 0, textView.getPaint().getTextSize(),
//                new int[]{Color.parseColor("#FD690A"), Color.parseColor("#F5B20E")},
//                new float[]{0, 1}, Shader.TileMode.CLAMP);
//        textView.getPaint().setShader(textShader);

        getElements();


        cateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences(getContext()).edit(); //SharedPreference 에디터 생성
                //에디터에 받아온 값 저장
                editor.putString("nowCate", result)
                        .apply(); //SharedPreference에 반영

                if( mDialogResult != null ){
                    mDialogResult.finish(result);
                }
                CateDialog.this.dismiss();
            }
        });

    }

    TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cateBtn.setVisibility(View.VISIBLE);
            TransitionDrawable background = (TransitionDrawable) v.getBackground();
            switch (v.getId()) {
                case R.id.cate_dialog1:
                    clearSelection();
                    background.startTransition(200);
                    c1.setTextColor(Color.WHITE);
                    c1.setTag("y");
                    result = c1.getText().toString();
                    break;
                case R.id.cate_dialog2:
                    clearSelection();
                    background.startTransition(200);
                    c2.setTextColor(Color.WHITE);
                    c2.setTag("y");
                    result = c2.getText().toString();
                    break;
                case R.id.cate_dialog3:
                    clearSelection();
                    background.startTransition(200);
                    c3.setTextColor(Color.WHITE);
                    c3.setTag("y");
                    result = c3.getText().toString();
                    break;
                case R.id.cate_dialog4:
                    clearSelection();
                    background.startTransition(200);
                    c4.setTextColor(Color.WHITE);
                    c4.setTag("y");
                    result = c4.getText().toString();
                    break;
                case R.id.cate_dialog5:
                    clearSelection();
                    background.startTransition(200);
                    c5.setTextColor(Color.WHITE);
                    c5.setTag("y");
                    result = c5.getText().toString();
                    break;
                case R.id.cate_dialog6:
                    clearSelection();
                    background.startTransition(200);
                    c6.setTextColor(Color.WHITE);
                    c6.setTag("y");
                    result = c6.getText().toString();
                    break;
                case R.id.cate_dialog7:
                    clearSelection();
                    background.startTransition(200);
                    c7.setTextColor(Color.WHITE);
                    c7.setTag("y");
                    result = c7.getText().toString();
                    break;
                case R.id.cate_dialog8:
                    clearSelection();
                    background.startTransition(200);
                    c8.setTextColor(Color.WHITE);
                    c8.setTag("y");
                    result = c8.getText().toString();
                    break;
            }

        }
    };

    void getElements(){

        cateBtn = findViewById(R.id.cate_dialog_btn);

        c1 = findViewById(R.id.cate_dialog1);
        c1.setOnClickListener(onClickListener);
        c2 = findViewById(R.id.cate_dialog2);
        c2.setOnClickListener(onClickListener);
        c3 = findViewById(R.id.cate_dialog3);
        c3.setOnClickListener(onClickListener);
        c4 = findViewById(R.id.cate_dialog4);
        c4.setOnClickListener(onClickListener);
        c5 = findViewById(R.id.cate_dialog5);
        c5.setOnClickListener(onClickListener);
        c6 = findViewById(R.id.cate_dialog6);
        c6.setOnClickListener(onClickListener);
        c7 = findViewById(R.id.cate_dialog7);
        c7.setOnClickListener(onClickListener);
        c8 = findViewById(R.id.cate_dialog8);
        c8.setOnClickListener(onClickListener);
    }

    void clearSelection(){
        TransitionDrawable background;

        background = (TransitionDrawable) c1.getBackground();
        if (c1.getTag().equals("y")) background.reverseTransition(1);
        c1.setTextColor(Color.BLACK);
        c1.setTag("n");
        background = (TransitionDrawable) c2.getBackground();
        if (c2.getTag().equals("y")) background.reverseTransition(1);
        c2.setTextColor(Color.BLACK);
        c2.setTag("n");
        background = (TransitionDrawable) c3.getBackground();
        if (c3.getTag().equals("y")) background.reverseTransition(1);
        c3.setTextColor(Color.BLACK);
        c3.setTag("n");
        background = (TransitionDrawable) c4.getBackground();
        if (c4.getTag().equals("y")) background.reverseTransition(1);
        c4.setTextColor(Color.BLACK);
        c4.setTag("n");
        background = (TransitionDrawable) c5.getBackground();
        if (c5.getTag().equals("y")) background.reverseTransition(1);
        c5.setTextColor(Color.BLACK);
        c5.setTag("n");
        background = (TransitionDrawable) c6.getBackground();
        if (c6.getTag().equals("y")) background.reverseTransition(1);
        c6.setTextColor(Color.BLACK);
        c6.setTag("n");
        background = (TransitionDrawable) c7.getBackground();
        if (c7.getTag().equals("y")) background.reverseTransition(1);
        c7.setTextColor(Color.BLACK);
        c7.setTag("n");
        background = (TransitionDrawable) c8.getBackground();
        if (c8.getTag().equals("y")) background.reverseTransition(1);
        c8.setTextColor(Color.BLACK);
        c8.setTag("n");
    }

    public void setDialogResult(OnMyDialogResult dialogResult){
        mDialogResult = dialogResult;
    }

    public interface OnMyDialogResult{
        void finish(String result);
    }

}
