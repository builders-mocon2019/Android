package com.example.builders.Write;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.Auth.UserDB;
import com.example.builders.Main.ArticleModel;
import com.example.builders.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class WriteActivity extends AppCompatActivity {

    TextView writeTxt;
    LinearLayout backBtn;

    EditText titleTxt, textTxt;
    TextView w1, w2, w3, w4, w5, w6, w7, w8, w9, want;
    TextView t1, t2, t3, team;
    TextView port;

    Button uploadBtn;

    private int articleNum=0;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        getElements();

        Shader textShader = new LinearGradient(150, 0, 0, writeTxt.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        writeTxt.getPaint().setShader(textShader);

        final DatabaseReference numRef = firebaseDatabase.getReference("article_num");
        numRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                articleNum = Integer.parseInt(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(want.getText().toString().equals("")||team.getText().toString().equals("")
                ||titleTxt.getText().toString().equals("")||textTxt.getText().toString().equals("")){
                    Toast.makeText(WriteActivity.this, "빈칸을 입력해주세요", Toast.LENGTH_SHORT).show();

                }
                else {
                    if(articleNum!=0){
                        UserDB userDB = new UserDB();
                        ArticleModel model = new ArticleModel(
                                userDB.getUserName(getApplicationContext()), titleTxt.getText().toString(),
                                textTxt.getText().toString(), want.getText().toString(), team.getText().toString(),
                                "port", articleNum, userDB.getUserProfile(getApplicationContext()));
                        databaseReference.child("article").push().setValue(model);
                        Map<String, Object> childUpdates = new HashMap<>();
                        childUpdates.put("article_num", articleNum+1);
                        databaseReference.updateChildren(childUpdates);
                        finish();
                    }
                    else{
                        Toast.makeText(WriteActivity.this, "인터넷이 연결되었는지 확인하세요", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }

    TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.write_want_1:
                    if (w1.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w1.setTextColor(Color.WHITE);
                        w1.setTag("y");

                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w1.setTextColor(Color.BLACK);
                        w1.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_2:
                    if (w2.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w2.setTextColor(Color.WHITE);
                        w2.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w2.setTextColor(Color.BLACK);
                        w2.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_3:
                    if (w3.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w3.setTextColor(Color.WHITE);
                        w3.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w3.setTextColor(Color.BLACK);
                        w3.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_4:
                    w4 = v.findViewById(R.id.write_want_4);
                    if (w4.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w4.setTextColor(Color.WHITE);
                        w4.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w4.setTextColor(Color.BLACK);
                        w4.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_5:
                    if (w5.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w5.setTextColor(Color.WHITE);
                        w5.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w5.setTextColor(Color.BLACK);
                        w5.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_6:
                    if (w6.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w6.setTextColor(Color.WHITE);
                        w6.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w6.setTextColor(Color.BLACK);
                        w6.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_7:
                    if (w7.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w7.setTextColor(Color.WHITE);
                        w7.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w7.setTextColor(Color.BLACK);
                        w7.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_8:
                    if (w8.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w8.setTextColor(Color.WHITE);
                        w8.setTag("y");
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w8.setTextColor(Color.BLACK);
                        w8.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_want_9:
                    if (w9.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        w9.setTextColor(Color.WHITE);
                        w9.setTag("y");
                        //rextra.setVisibility(View.VISIBLE);
                    } else {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.reverseTransition(200);
                        w9.setTextColor(Color.BLACK);
                        w9.setTag("n");
                        //rextra.setVisibility(View.GONE);
                    }
                    setResult();
                    break;
                case R.id.write_team_1:
                    if (t1.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        t1.setTextColor(Color.WHITE);
                        t1.setTag("y");
                        background = (TransitionDrawable) t2.getBackground();
                        if (t2.getTag().equals("y")) background.reverseTransition(200);
                        t2.setTextColor(Color.BLACK);
                        t2.setTag("n");
                        background = (TransitionDrawable) t3.getBackground();
                        if (t3.getTag().equals("y")) background.reverseTransition(200);
                        t3.setTextColor(Color.BLACK);
                        t3.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_team_2:
                    if (t2.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        t2.setTextColor(Color.WHITE);
                        t2.setTag("y");
                        background = (TransitionDrawable) t1.getBackground();
                        if (t1.getTag().equals("y")) background.reverseTransition(200);
                        t1.setTextColor(Color.BLACK);
                        t1.setTag("n");
                        background = (TransitionDrawable) t3.getBackground();
                        if (t3.getTag().equals("y")) background.reverseTransition(200);
                        t3.setTextColor(Color.BLACK);
                        t3.setTag("n");
                    }
                    setResult();
                    break;
                case R.id.write_team_3:
                    if (t3.getTag().equals("n")) {
                        TransitionDrawable background = (TransitionDrawable) v.getBackground();
                        background.startTransition(200);
                        t3.setTextColor(Color.WHITE);
                        t3.setTag("y");
                        background = (TransitionDrawable) t1.getBackground();
                        if (t1.getTag().equals("y")) background.reverseTransition(200);
                        t1.setTextColor(Color.BLACK);
                        t1.setTag("n");
                        background = (TransitionDrawable) t2.getBackground();
                        if (t2.getTag().equals("y")) background.reverseTransition(200);
                        t2.setTextColor(Color.BLACK);
                        t2.setTag("n");
                    }
                    setResult();
                    break;

            }

        }
    };

    void setResult() {
        want.setText("");
        if (w1.getTag() == "y")
            want.setText(want.getText().toString() + " " + w1.getText().toString());
        if (w2.getTag() == "y")
            want.setText(want.getText().toString() + " " + w2.getText().toString());
        if (w3.getTag() == "y")
            want.setText(want.getText().toString() + " " + w3.getText().toString());
        if (w4.getTag() == "y")
            want.setText(want.getText().toString() + " " + w4.getText().toString());
        if (w5.getTag() == "y")
            want.setText(want.getText().toString() + " " + w5.getText().toString());
        if (w6.getTag() == "y")
            want.setText(want.getText().toString() + " " + w6.getText().toString());
        if (w7.getTag() == "y")
            want.setText(want.getText().toString() + " " + w7.getText().toString());
        if (w8.getTag() == "y")
            want.setText(want.getText().toString() + " " + w8.getText().toString());
        team.setText("");
        if (t1.getTag() == "y")
            team.setText(team.getText().toString() + " " + t1.getText().toString());
        if (t2.getTag() == "y")
            team.setText(team.getText().toString() + " " + t2.getText().toString());
        if (t3.getTag() == "y")
            team.setText(team.getText().toString() + " " + t3.getText().toString());
        //if(w9.getTag()=="y") want.setText(want.getText().toString()+" "+"기타 "+rextra_txt.getText().toString());
    }

    void getElements() {
        writeTxt = findViewById(R.id.write_txt);
        backBtn = findViewById(R.id.write_backBtn);
        titleTxt = findViewById(R.id.write_title);
        textTxt = findViewById(R.id.write_text);

        w1 = findViewById(R.id.write_want_1);
        w2 = findViewById(R.id.write_want_2);
        w3 = findViewById(R.id.write_want_3);
        w4 = findViewById(R.id.write_want_4);
        w5 = findViewById(R.id.write_want_5);
        w6 = findViewById(R.id.write_want_6);
        w7 = findViewById(R.id.write_want_7);
        w8 = findViewById(R.id.write_want_8);
        w9 = findViewById(R.id.write_want_9);

        w1.setOnClickListener(onClickListener);
        w2.setOnClickListener(onClickListener);
        w3.setOnClickListener(onClickListener);
        w4.setOnClickListener(onClickListener);
        w5.setOnClickListener(onClickListener);
        w6.setOnClickListener(onClickListener);
        w7.setOnClickListener(onClickListener);
        w8.setOnClickListener(onClickListener);
        w9.setOnClickListener(onClickListener);

        want = findViewById(R.id.write_want_result);

        t1 = findViewById(R.id.write_team_1);
        t2 = findViewById(R.id.write_team_2);
        t3 = findViewById(R.id.write_team_3);

        t1.setOnClickListener(onClickListener);
        t2.setOnClickListener(onClickListener);
        t3.setOnClickListener(onClickListener);

        team = findViewById(R.id.write_team_result);


        uploadBtn = findViewById(R.id.write_uploadBtn);
    }
}
