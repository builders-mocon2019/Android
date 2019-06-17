package com.example.builders.Auth;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.builders.R;

public class RegiFragment2 extends Fragment {

    TextView regiTxt2;
    EditText password, passwordcheck;

    ImageView pwcheckicon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register2, container, false);

        regiTxt2 = v.findViewById(R.id.regi_txt2);
        Shader textShader=new LinearGradient(150, 0, 0, regiTxt2.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange),getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        regiTxt2.getPaint().setShader(textShader);

        password = v.findViewById(R.id.regi_password);
        passwordcheck = v.findViewById(R.id.regi_passwordcheck);
        password.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        passwordcheck.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        pwcheckicon = v.findViewById(R.id.regi_passwordcheck_icon);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkIcon();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordcheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkIcon();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }
    //SOF change-edittext-password-mask-character-to-asterisk
    public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new AsteriskPasswordTransformationMethod.PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;
            public PasswordCharSequence(CharSequence source) {
                mSource = source;
            }
            public char charAt(int index) {
                return '*';
            }
            public int length() {
                return mSource.length();
            }
            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end);
            }
        }
    }
    void checkIcon(){
        if(password.getText().toString().equals(passwordcheck.getText().toString())){
            if(password.getText().length()>=6){
                pwcheckicon.setImageResource(R.drawable.ic_check_24dp);
            }
        }
        else pwcheckicon.setImageResource(R.drawable.ic_uncheck_24dp);

    }
}
