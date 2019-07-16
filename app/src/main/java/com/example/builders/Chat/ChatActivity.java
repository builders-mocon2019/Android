package com.example.builders.Chat;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.Auth.UserDB;
import com.example.builders.Auth.UserModel;
import com.example.builders.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ChatActivity extends AppCompatActivity {

    TextView title;
    LinearLayout backBtn;

    //Firebase Authentication, Database 가져오기
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth firebaseAuth;

    //RecyclerView 및 어댑터 선언
    RecyclerView rcv;
    RecycleAdapter_People rcvAdap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        title = findViewById(R.id.chat_txt);
        Shader textShader = new LinearGradient(150, 0, 0, title.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        title.getPaint().setShader(textShader);

        backBtn = findViewById(R.id.chat_backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        firebaseAuth = FirebaseAuth.getInstance(); //Firebase 현재 Auth 정보 가져오기
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        rcv = findViewById(R.id.people_recycler); //RecyclerView findViewById
        LinearLayoutManager lm = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        lm.setReverseLayout(true);
        lm.setStackFromEnd(true);

        rcv.setLayoutManager(lm); //RecyclerView에 LayoutManager 지정

        //Adapter 선언 및 RecyclerView의 Adapter로 지정
        rcvAdap = new RecycleAdapter_People();
        rcv.setAdapter(rcvAdap);

        databaseReference.child("message").addChildEventListener(new ChildEventListener() { //Firebase Database의 message 항목에 이벤트 리스너 생성
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { //message 항목에 값이 추가되었다면(메세지 수신)

                RecycleModel_ChatPage member = dataSnapshot.getValue(RecycleModel_ChatPage.class); //추가된 값을 RecycleModel_ChatPage 양식으로 DB에서 가져옴
                RecycleModel_Chat model = new RecycleModel_Chat(member.getName(),
                        member.getMsg(), member.getTime(), member.getProfile()); //가져온 값을 RecycleModel_Chat 양식으로 캐스팅

                UserDB userDB = new UserDB();

                if(member.getTo().equals(userDB.getUserName(getApplicationContext()))){ //만약 메세지의 받는 사람이 자신이라면
                    if(!(member.getTime().equals(""))) {
                        for (int i = 0; i < rcvAdap.getItems().size(); i++) { //현재 RecyclerView의 아이템 개수만큼 반복
                            if (member.getName().equals(rcvAdap.getItems().get(i).getName())) { //만약 RecyclerView의 i 위치에 있던 메세지를 보낸 사람과 현재 메세지를 보낸 사람이 일치한다면
                                rcvAdap.delete(i); //RecyclerView에서 중복되는 기존의 메세지 아이템을 삭제
                            }
                        }
                        rcvAdap.add(model); //RecyclerView에 항목 추가
                    }
                }
                else if (member.getName().equals(userDB.getUserName(getApplicationContext()))) { //혹은 메세지를 보낸 사람이 자신이라면
                    if (!(member.getTime().equals(""))) {
                        for (int i = 0; i < rcvAdap.getItems().size(); i++) { //현재 RecyclerView의 아이템 개수만큼 반복
                            if (member.getTo().equals(rcvAdap.getItems().get(i).getName())) { //만약 RecyclerView의 i 위치에 있던 메세지와 현재 메세지의 보낸 사람이 모두 자신이라면
                                rcvAdap.delete(i); //RecyclerView에서 중복되는 기존의 메세지 아이템을 삭제
                            }
                        }
                        model.setName(member.getTo()); //아이템의 보낸 사람 이메일을 받는 사람(상대)로 변경
                        model.setText("회원님: " + member.getMsg()); //메세지 내용에 자신이 전송한 메세지임을 표시
                        rcvAdap.add(model); //RecyclerView에 항목 추가
                    }
                }

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

        RecycleClick_People.addRecycler(rcv).setOnItemClickListener(new RecycleClick_People.OnItemClickListener() { //RecyclerViewd에 onClickListener 추가
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                //Toast.makeText(ChatActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ChatPageActivity.class); //프로필 화면으로 Intent 선언

                //Intent에 RecyclerView의 클릭된 위치 아이템에서 가져온 메세지 유저 정보 첨부
                intent.putExtra("name", rcvAdap.getItems().get(position).getName());
                intent.putExtra("profile", rcvAdap.getItems().get(position).getProfile());
                startActivity(intent); //프로필 화면 Activity 실행
            }
        });

    }
}
