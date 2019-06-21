package com.example.builders;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.builders.Auth.LoginActivity;
import com.example.builders.Auth.UserDB;
import com.google.firebase.auth.FirebaseAuth;

public class MainFragment4 extends android.support.v4.app.Fragment {

    public static MainFragment4 newInstance(){
        MainFragment4 fragment = new MainFragment4();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.activity_main4, container, false);

        TextView logoutBtn;

        UserDB userDB = new UserDB();
        //textView = findViewById(R.id.maintxt);
        //textView.setText(userDB.getUserName(this) + userDB.getUserBirth(this) + userDB.getUserId(this) + userDB.getUserCan(this) + userDB.getUserWant(this) + userDB.getUserTeam(this));
        logoutBtn = v.findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut(); //Firebase의 현재 Auth 항목을 가져와 로그아웃 실행
                startActivity(new Intent(getContext(), LoginActivity.class)); //로그인 액티비티 실행
                getActivity().finish(); //현재 액티비티 종료
//                RegisterDialog registerDialog = new RegisterDialog(MainActivity.this);
//                registerDialog.setCancelable(false);
//                registerDialog.show();
            }
        });
        return v;
    }
}
