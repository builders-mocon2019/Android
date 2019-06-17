package com.example.builders.Auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.builders.R;

public class RegisterDialog extends Dialog {


    public RegisterDialog(@NonNull Context c) {
        super(c);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.activity_register_dialog);

        TextView textView = findViewById(R.id.regi_dialog_txt);
        Shader textShader = new LinearGradient(150, 0, 0, textView.getPaint().getTextSize(),
                new int[]{Color.parseColor("#FD690A"), Color.parseColor("#F5B20E")},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);

    }
}
