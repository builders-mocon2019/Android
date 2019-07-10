package com.example.builders.Main1;

import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
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

import com.example.builders.Main.ArticleModel;
import com.example.builders.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainFragment1 extends android.support.v4.app.Fragment {

    public static MainFragment1 newInstance(){
        MainFragment1 fragment = new MainFragment1();
        return fragment;
    }

    private int cateSelect=1;

    RecyclerView rcv;
    RecycleAdapter_Main1 rcvAdap;

    TextView cate;
    TextView m1, m2, m3, m4;



    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.activity_main1, container, false);

        rcv = v.findViewById(R.id.main1_recycler);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(lm); //RecyclerView에 LayoutManager 지정

        rcvAdap = new RecycleAdapter_Main1();

        rcv.setAdapter(rcvAdap);

        ArticleModel model = new ArticleModel();
        model.setName("이름");
        model.setWant("개발");
        model.setTeam("공모전/대회 팀원");
        model.setTitle("테스트용 타이틀입니다. 코드를 대신 짜줄 킹갓 개발자를 구하고 있습니다. 살려주세요");
        rcvAdap.add(model);

        getElements(v);

        TransitionDrawable background = (TransitionDrawable) m1.getBackground();
        background.startTransition(1);
        m1.setTextColor(Color.WHITE);
        m1.setTag("y");

        databaseReference.child("article").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ArticleModel model = dataSnapshot.getValue(ArticleModel.class);
                rcvAdap.add(model);
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
                    break;
            }

        }
    };
}
