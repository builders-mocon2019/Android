package com.example.builders.Main1;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.builders.Auth.RegisterActivity;
import com.example.builders.Auth.RegisterDialog;
import com.example.builders.Auth.UserDB;
import com.example.builders.Main.ArticleModel;
import com.example.builders.R;
import com.example.builders.Write.LikeModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class MainFragment1 extends android.support.v4.app.Fragment {

    public static MainFragment1 newInstance(){
        MainFragment1 fragment = new MainFragment1();
        return fragment;
    }

    private int cateSelect=1;
    private String nowCate;

    RecyclerView rcv;
    RecycleAdapter_Main1 rcvAdap;

    TextView cate;
    TextView m1, m2, m3, m4;

    List<ArticleModel> list = new ArrayList<>();
    List<LikeModel> likeList = new ArrayList<>();

    Context mContext;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth firebaseAuth;

    static SharedPreferences getSharedPreferences(Context context) { //SharedPreferences 호출 함수
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.activity_main1, container, false);

        mContext = container.getContext();

        rcv = v.findViewById(R.id.main1_recycler);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);

        lm.setReverseLayout(true);
        lm.setStackFromEnd(true);

        rcv.setLayoutManager(lm); //RecyclerView에 LayoutManager 지정

        rcvAdap = new RecycleAdapter_Main1();

        rcv.setAdapter(rcvAdap);

//        ArticleModel model = new ArticleModel();
//        model.setName("이름");
//        model.setWant("개발");
//        model.setTeam("공모전/대회 팀원");
//        model.setTitle("테스트용 타이틀입니다. 코드를 대신 짜줄 킹갓 개발자를 구하고 있습니다. 살려주세요");
//        rcvAdap.add(model);

        getElements(v);

        TransitionDrawable background = (TransitionDrawable) m1.getBackground();
        background.startTransition(1);
        m1.setTextColor(Color.WHITE);
        m1.setTag("y");

        String lastCate = getSharedPreferences(getContext()).getString("nowCate", "");

        if(lastCate.equals("")) nowCate = "개발";
        else nowCate = lastCate;
        cate.setText(nowCate);

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CateDialog cateDialog = new CateDialog(getContext());
                cateDialog.setDialogResult(new CateDialog.OnMyDialogResult() {
                    @Override
                    public void finish(String result) {
                        nowCate=result;
                        cate.setText(result);
                        refreshItems();
                    }
                });
                cateDialog.show();
            }
        });

        databaseReference.child("like").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                LikeModel model = dataSnapshot.getValue(LikeModel.class);
                likeList.add(model);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("article").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ArticleModel model = dataSnapshot.getValue(ArticleModel.class);
                list.add(model);
                refreshItems();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return v;
    }

    void getElements(View v){
        cate = v.findViewById(R.id.main1_menu_cate);
        m1 = v.findViewById(R.id.main1_menu1);
        m1.setOnClickListener(onClickListener);
        m2 = v.findViewById(R.id.main1_menu2);
        m2.setOnClickListener(onClickListener);
        m3 = v.findViewById(R.id.main1_menu3);
        m3.setOnClickListener(onClickListener);
        m4 = v.findViewById(R.id.main1_menu4);
        m4.setOnClickListener(onClickListener);
    }

    TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main1_menu1:
                    if (m1.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        m1.setTextColor(Color.WHITE);
                        m1.setTag("y");
                        background = (TransitionDrawable) m2.getBackground();
                        if (m2.getTag().equals("y")) background.reverseTransition(1);
                        m2.setTextColor(Color.BLACK);
                        m2.setTag("n");
                        background = (TransitionDrawable) m3.getBackground();
                        if (m3.getTag().equals("y")) background.reverseTransition(1);
                        m3.setTextColor(Color.BLACK);
                        m3.setTag("n");
                        background = (TransitionDrawable) m4.getBackground();
                        if (m4.getTag().equals("y")) background.reverseTransition(1);
                        m4.setTextColor(Color.BLACK);
                        m4.setTag("n");
                    }
                    cateSelect=1;
                    refreshItems();
                    break;
                case R.id.main1_menu2:
                    if (m2.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        m2.setTextColor(Color.WHITE);
                        m2.setTag("y");
                        background = (TransitionDrawable) m1.getBackground();
                        if (m1.getTag().equals("y")) background.reverseTransition(1);
                        m1.setTextColor(Color.BLACK);
                        m1.setTag("n");
                        background = (TransitionDrawable) m3.getBackground();
                        if (m3.getTag().equals("y")) background.reverseTransition(1);
                        m3.setTextColor(Color.BLACK);
                        m3.setTag("n");
                        background = (TransitionDrawable) m4.getBackground();
                        if (m4.getTag().equals("y")) background.reverseTransition(1);
                        m4.setTextColor(Color.BLACK);
                        m4.setTag("n");
                    }
                    cateSelect=2;
                    refreshItems();
                    break;
                case R.id.main1_menu3:
                    if (m3.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        m3.setTextColor(Color.WHITE);
                        m3.setTag("y");
                        background = (TransitionDrawable) m1.getBackground();
                        if (m1.getTag().equals("y")) background.reverseTransition(1);
                        m1.setTextColor(Color.BLACK);
                        m1.setTag("n");
                        background = (TransitionDrawable) m2.getBackground();
                        if (m2.getTag().equals("y")) background.reverseTransition(1);
                        m2.setTextColor(Color.BLACK);
                        m2.setTag("n");
                        background = (TransitionDrawable) m4.getBackground();
                        if (m4.getTag().equals("y")) background.reverseTransition(1);
                        m4.setTextColor(Color.BLACK);
                        m4.setTag("n");
                    }
                    cateSelect=3;
                    refreshItems();
                    break;
                case R.id.main1_menu4:
                    if (m4.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        m4.setTextColor(Color.WHITE);
                        m4.setTag("y");
                        background = (TransitionDrawable) m1.getBackground();
                        if (m1.getTag().equals("y")) background.reverseTransition(1);
                        m1.setTextColor(Color.BLACK);
                        m1.setTag("n");
                        background = (TransitionDrawable) m2.getBackground();
                        if (m2.getTag().equals("y")) background.reverseTransition(1);
                        m2.setTextColor(Color.BLACK);
                        m2.setTag("n");
                        background = (TransitionDrawable) m3.getBackground();
                        if (m3.getTag().equals("y")) background.reverseTransition(1);
                        m3.setTextColor(Color.BLACK);
                        m3.setTag("n");
                    }
                    cateSelect=4;
                    refreshItems();
                    break;
            }

        }
    };

    void refreshItems(){
        rcvAdap.deleteAll();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWant().contains(nowCate)){
                boolean likeCheck=false;
                UserDB userDB = new UserDB();
                switch (cateSelect){
                    case 1:
                        for(int j=0;j<likeList.size();j++){
                            if(likeList.get(j).getKey().equals(userDB.getUserName(mContext)+list.get(i).getNum()))
                                likeCheck = true;
                        }
                        if(likeCheck) rcvAdap.addWithLike(list.get(i));
                        else rcvAdap.add(list.get(i));
                        break;
                    case 2:
                        if(list.get(i).getTeam().contains("대회")) rcvAdap.add(list.get(i));
                        break;
                    case 3:
                        if(list.get(i).getTeam().contains("취미")) rcvAdap.add(list.get(i));
                        break;
                    case 4:
                        if(list.get(i).getTeam().contains("프로젝트")) rcvAdap.add(list.get(i));
                        break;
                }

            }
        }
    }
}
