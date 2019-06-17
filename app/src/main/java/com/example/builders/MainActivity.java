package com.example.builders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.builders.Auth.LoginActivity;
import com.example.builders.Auth.RegisterActivity;
import com.example.builders.Auth.RegisterDialog;
import com.example.builders.Auth.UserDB;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button logoutBtn;
    TextView textView;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDB userDB = new UserDB();
        textView = findViewById(R.id.maintxt);
        textView.setText(userDB.getUserName(this)+userDB.getUserBirth(this)+userDB.getUserId(this)+userDB.getUserCan(this)+userDB.getUserWant(this)+userDB.getUserTeam(this));
        logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut(); //Firebase의 현재 Auth 항목을 가져와 로그아웃 실행
                startActivity(new Intent(MainActivity.this, LoginActivity.class)); //로그인 액티비티 실행
                finish(); //현재 액티비티 종료
//                RegisterDialog registerDialog = new RegisterDialog(MainActivity.this);
//                registerDialog.setCancelable(false);
//                registerDialog.show();
            }
        });
    }
}
