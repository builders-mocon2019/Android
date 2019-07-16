package com.example.builders.Main4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.builders.Auth.LoginActivity;
import com.example.builders.Auth.UserDB;
import com.example.builders.Dialog.Dialog_DeleteUser;
import com.example.builders.Dialog.Dialog_NewPassword;
import com.example.builders.R;
import com.google.firebase.auth.FirebaseAuth;

import java.io.ByteArrayInputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainFragment4 extends android.support.v4.app.Fragment {

    public static MainFragment4 newInstance(){
        MainFragment4 fragment = new MainFragment4();
        return fragment;
    }

    TextView logoutBtn, newpwBtn, deleteBtn;
    TextView userName, userId;
    TextView c1, c2, c3, c4, c5, c6, c7, c8, c9;
    TextView t1, t2, t3;

    CircleImageView profile;

    String[] can;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.activity_main4, container, false);

        UserDB userDB = new UserDB();
        getElements(v);
        userName.setText(userDB.getUserName(getContext()));
        userId.setText(userDB.getUserId(getContext()));
        can = userDB.getUserCan(getContext()).split(" ");

        String data = userDB.getUserProfile(getContext());

        //데이터 base64 형식으로 Decode
        String txtPlainOrg = "";
        byte[] bytePlainOrg = Base64.decode(data, 0);

        //byte[] 데이터  stream 데이터로 변환 후 bitmapFactory로 이미지 생성
        ByteArrayInputStream inStream = new ByteArrayInputStream(bytePlainOrg);
        Bitmap bm = BitmapFactory.decodeStream(inStream) ;

        profile.setImageBitmap(bm);

        for (String s : can) {
            switch (s) {
                case "영상":
                    c1.setBackgroundResource(R.drawable.btn_gradient);
                    c1.setTextColor(Color.WHITE);
                    break;
                case "봉사":
                    c2.setBackgroundResource(R.drawable.btn_gradient);
                    c2.setTextColor(Color.WHITE);
                    break;
                case "공연":
                    c3.setBackgroundResource(R.drawable.btn_gradient);
                    c3.setTextColor(Color.WHITE);
                    break;
                case "디자인":
                    c4.setBackgroundResource(R.drawable.btn_gradient);
                    c4.setTextColor(Color.WHITE);
                    break;
                case "개발":
                    c5.setBackgroundResource(R.drawable.btn_gradient);
                    c5.setTextColor(Color.WHITE);
                    break;
                case "스포츠":
                    c6.setBackgroundResource(R.drawable.btn_gradient);
                    c6.setTextColor(Color.WHITE);
                    break;
                case "아이디어":
                    c7.setBackgroundResource(R.drawable.btn_gradient);
                    c7.setTextColor(Color.WHITE);
                    break;
                case "스터디":
                    c8.setBackgroundResource(R.drawable.btn_gradient);
                    c8.setTextColor(Color.WHITE);
                    break;
                case "기타":
                    c9.setBackgroundResource(R.drawable.btn_gradient);
                    c9.setTextColor(Color.WHITE);
                    break;
            }

            switch (userDB.getUserTeam(getContext())){
                case "공모전 / 대회 팀원이 필요해요":
                    t1.setBackgroundResource(R.drawable.btn_gradient);
                    t1.setTextColor(Color.WHITE);
                    break;
                case "가볍게 취미를 함께 할 사람이 필요해요":
                    t2.setBackgroundResource(R.drawable.btn_gradient);
                    t2.setTextColor(Color.WHITE);
                    break;
                case "프로젝트를 함께 할 팀원이 필요해요":
                    t3.setBackgroundResource(R.drawable.btn_gradient);
                    t3.setTextColor(Color.WHITE);
                    break;
            }
        }

        logoutBtn = v.findViewById(R.id.main_logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut(); //Firebase의 현재 Auth 항목을 가져와 로그아웃 실행
                startActivity(new Intent(getContext(), LoginActivity.class)); //로그인 액티비티 실행
                getActivity().finish(); //현재 액티비티 종료

            }
        });

        newpwBtn = v.findViewById(R.id.main_newpwBtn);
        newpwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new Dialog_NewPassword();
                dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog_newpassword");
            }
        });

        deleteBtn = v.findViewById(R.id.main_deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new Dialog_DeleteUser();
                dialogFragment.show(getActivity().getSupportFragmentManager(), "dialog_deleteuser");
            }
        });

        return v;
    }

    void getElements(View v){
        userName = v.findViewById(R.id.main_user_name);
        userId = v.findViewById(R.id.main_user_id);
        profile = v.findViewById(R.id.main4_profile);

        c1 = v.findViewById(R.id.main_user_can_1);
        c2 = v.findViewById(R.id.main_user_can_2);
        c3 = v.findViewById(R.id.main_user_can_3);
        c4 = v.findViewById(R.id.main_user_can_4);
        c5 = v.findViewById(R.id.main_user_can_5);
        c6 = v.findViewById(R.id.main_user_can_6);
        c7 = v.findViewById(R.id.main_user_can_7);
        c8 = v.findViewById(R.id.main_user_can_8);
        c9 = v.findViewById(R.id.main_user_can_9);

        t1 = v.findViewById(R.id.main_user_team_1);
        t2 = v.findViewById(R.id.main_user_team_2);
        t3 = v.findViewById(R.id.main_user_team_3);
    }
}
