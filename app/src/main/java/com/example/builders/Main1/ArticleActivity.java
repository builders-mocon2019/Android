package com.example.builders.Main1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.Auth.UserDB;
import com.example.builders.Chat.ChatPageActivity;
import com.example.builders.Chat.RecycleModel_ChatPage;
import com.example.builders.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleActivity extends AppCompatActivity {


    TextView topText, t1, t2, t3, t4;
    LinearLayout backBtn;

    TextView name, want, team, title, text, port;
    LinearLayout chatBtn, commentBtn;

    CircleImageView profile;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        profile = findViewById(R.id.article_image);

        topText = findViewById(R.id.article_top_txt);
        t1 = findViewById(R.id.article_tv1);
        t2 = findViewById(R.id.article_tv2);
        t3 = findViewById(R.id.article_tv3);
        t4 = findViewById(R.id.article_tv4);

        Shader textShader = new LinearGradient(150, 0, 0, topText.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);

        Shader textShader2 = new LinearGradient(150, 0, 0, t1.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);

        Shader textShader3 = new LinearGradient(150, 0, 0, t2.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);

        Shader textShader4 = new LinearGradient(150, 0, 0, t3.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);

        Shader textShader5 = new LinearGradient(150, 0, 0, t4.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);

        topText.getPaint().setShader(textShader);
        t1.getPaint().setShader(textShader2);
        t2.getPaint().setShader(textShader3);
        t3.getPaint().setShader(textShader4);
        t4.getPaint().setShader(textShader5);

        backBtn = findViewById(R.id.article_backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getElements();

        final Intent getIntent = getIntent();
        name.setText(getIntent.getStringExtra("article_name"));
        want.setText(getIntent.getStringExtra("article_want"));
        team.setText(getIntent.getStringExtra("article_team"));
        title.setText(getIntent.getStringExtra("article_title"));
        text.setText(getIntent.getStringExtra("article_text"));

        String data = getIntent.getStringExtra("article_profile");

        //데이터 base64 형식으로 Decode
        String txtPlainOrg = "";
        byte[] bytePlainOrg = Base64.decode(data, 0);

        //byte[] 데이터  stream 데이터로 변환 후 bitmapFactory로 이미지 생성
        ByteArrayInputStream inStream = new ByteArrayInputStream(bytePlainOrg);
        Bitmap bm = BitmapFactory.decodeStream(inStream);

        profile.setImageBitmap(bm);


        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance(); //Firebase 현재 Auth 정보 가져오기
                UserDB userDB = new UserDB(); //현재 유저 정보가 담긴 DB 가져오기
                if(userDB.getUserName(getApplicationContext()).equals(name.getText().toString())){
                    Toast.makeText(ArticleActivity.this, "자신과는 대화를 시작할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    RecycleModel_ChatPage model = new RecycleModel_ChatPage(userDB.getUserName(getApplicationContext()),
                            name.getText().toString(), "이제 대화를 시작할 수 있습니다.",
                            "", "", userDB.getUserProfile(getApplicationContext()), getIntent.getStringExtra("article_profile")); //RecycleModel_ChatPage 양식으로 대화 시작을 알리는 메세지 작성
                    databaseReference.child("message").push().setValue(model); //작성한 대화 시작 메세지를 Firebase DB의 message 항목에 추가
                    Intent intent = new Intent(getApplicationContext(), ChatPageActivity.class); //채팅 화면으로 Intent 선언

                    //Intent에 getStringExtra에서 가져온 메세지를 보낸 사람/보낸 사람의 닉네임 첨부
                    intent.putExtra("name", name.getText());
                    intent.putExtra("profile", getIntent.getStringExtra("article_profile"));
                    startActivity(intent); //채팅 화면 Activity 실행
                    finish();
                }
            }
        });

    }

    void getElements(){
        name = findViewById(R.id.article_name);
        want = findViewById(R.id.article_want);
        team = findViewById(R.id.article_team);
        title = findViewById(R.id.article_title);
        text = findViewById(R.id.article_text);
        port = findViewById(R.id.article_port);
        chatBtn = findViewById(R.id.article_chatBtn);
        commentBtn = findViewById(R.id.article_commentBtn);
    }
}
