package com.example.builders.Main2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.Auth.UserDB;
import com.example.builders.Main.ArticleModel;
import com.example.builders.Main1.RecycleAdapter_Main1;
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

public class MainFragment2 extends android.support.v4.app.Fragment {

    private Context mContext;

    public static MainFragment2 newInstance() {
        MainFragment2 fragment = new MainFragment2();
        return fragment;
    }

    List<ArticleModel> list = new ArrayList<>();
    List<LikeModel> likeList = new ArrayList<>();

    RecyclerView rcv;
    RecycleAdapter_Main2 rcvAdap;

    TextView c1, c2;

    int cateSelect = 1;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.activity_main2, container, false);

        mContext = container.getContext();
        getElements(v);

        TransitionDrawable background = (TransitionDrawable) c1.getBackground();
        background.startTransition(1);
        c1.setTextColor(Color.WHITE);
        c1.setTag("y");

        rcv = v.findViewById(R.id.main2_recycler);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);

        lm.setReverseLayout(true);
        lm.setStackFromEnd(true);

        rcv.setLayoutManager(lm); //RecyclerView에 LayoutManager 지정

        rcvAdap = new RecycleAdapter_Main2();
        rcv.setAdapter(rcvAdap);


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

        databaseReference.child("like").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                LikeModel model = dataSnapshot.getValue(LikeModel.class);
                likeList.add(model);
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

    TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main2_cate1:
                    if (c1.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        c1.setTextColor(Color.WHITE);
                        c1.setTag("y");
                        background = (TransitionDrawable) c2.getBackground();
                        if (c2.getTag().equals("y")) background.reverseTransition(1);
                        c2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        c2.setTag("n");
                    }
                    cateSelect = 1;
                    refreshItems();
                    break;
                case R.id.main2_cate2:
                    if (c2.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        c2.setTextColor(Color.WHITE);
                        c2.setTag("y");
                        background = (TransitionDrawable) c1.getBackground();
                        if (c1.getTag().equals("y")) background.reverseTransition(1);
                        c1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        c1.setTag("n");
                    }
                    cateSelect = 2;
                    refreshItems();
                    break;
            }

        }
    };

    void getElements(View v) {
        c1 = v.findViewById(R.id.main2_cate1);
        c1.setOnClickListener(onClickListener);
        c2 = v.findViewById(R.id.main2_cate2);
        c2.setOnClickListener(onClickListener);
    }

    void refreshItems() {
        rcvAdap.deleteAll();
        UserDB userDB = new UserDB();
        for (int i = 0; i < list.size(); i++) {
            switch (cateSelect) {
                case 1:
                    for(int j=0;j< likeList.size();j++){
                        if(likeList.get(j).getKey().equals(userDB.getUserName(mContext)+list.get(i).getNum()))
                            rcvAdap.add(list.get(i));
                    }
                    break;
                case 2:
                    if (list.get(i).getName().equals(userDB.getUserName(mContext)))
                        rcvAdap.add(list.get(i));
                    break;
            }
        }
    }

}
