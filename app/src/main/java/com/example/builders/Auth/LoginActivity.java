package com.example.builders.Auth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.MainActivity;
import com.example.builders.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends Activity {

    //Login 기능을 수행하는 Activity

    //EditText, ProgressBar, Button 선언
    EditText id, password;
    ProgressBar loginProgress;
    Button loginBtn;
    TextView regiBtn, loginTxt;
    LinearLayout idBox, pwBox;

    //Firebase Authentication 가져오기
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //StatusBar 없애기
        setContentView(R.layout.activity_login);

        loginTxt = findViewById(R.id.login_txt);
        Shader textShader=new LinearGradient(150, 0, 0, loginTxt.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange),getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        loginTxt.getPaint().setShader(textShader);

        firebaseAuth = FirebaseAuth.getInstance(); //Firebase 현재 Auth 정보 가져오기

        //자동 로그인 구현
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) { //Auth 상태 변경 감지
                FirebaseUser user = firebaseAuth.getCurrentUser(); //현재 유저 정보 가져오기

                if(user != null){ //만약 유저 상태가 null이 아니라면(로그인이 되어있는 상태)
                    Toast.makeText(getApplicationContext(), "안녕하세요, "+user.getEmail()+"!", Toast.LENGTH_SHORT).show(); //로그인 성공 토스트
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish(); //DBLoadActivity로 이동 후 종료

                }
                else{ //로그인이 되어 있지 않은 상태
                    //Toast.makeText(getApplicationContext(), "로그인을 해주세요", Toast.LENGTH_SHORT).show(); //로그인 요청 토스트
                }

            }
        };

        //Button findViewById
        loginBtn = findViewById(R.id.btn_login);
        regiBtn = findViewById(R.id.btn_newaccount);

        //EditText findViewById
        id = findViewById(R.id.login_id);
        password = findViewById(R.id.login_password);

        password.setTransformationMethod(new AsteriskPasswordTransformationMethod()); //패스워드 문자를 '*'로 변경

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Login 버튼이 클릭되었을 때
                if(!id.getText().toString().equals("") && !password.getText().toString().equals("")){ //만약 비워진 항목이 없다면
                    login(id.getText().toString(), password.getText().toString()); //입력한 ID와 PW로 로그인 요청
                }
                else{
                    Toast.makeText(getApplicationContext(), "정보를 입력해주세요", Toast.LENGTH_SHORT).show(); //빈칸 기입 요청 토스트
                }
            }
        });


        regiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Register 버튼이 클릭되었을 때
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class)); //RegisterActivity 실행
            }
        });


        idBox = findViewById(R.id.id_box);
        pwBox = findViewById(R.id.pw_box);

        idBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id.requestFocus();
            }
        });
        pwBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.requestFocus();
            }
        });
    }

    @Override
    protected void onStart() { //LoginActivity가 시작할 때
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener); //Auth 상태 변경에 리스너 생성
    }

    @Override
    protected void onStop() { //LoginActivity가 끝날 때
        super.onStop();
        if (authStateListener != null) { //만약 Auth 상태 변경 리스너가 남아있는 상태라면
            firebaseAuth.removeAuthStateListener(authStateListener); //리스너 제거
        }
    }

    private void login(String email, String password) { //로그인 함수

        loginProgress = findViewById(R.id.progress_login);//ProgressBar findViewById
        loginProgress.setVisibility(View.VISIBLE); //ProgressBar 표시
        firebaseAuth.signInWithEmailAndPassword(email, password) //FireBase에 로그인 요청
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() { //작업 완료 리스너
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) { //로그인에 성공했다면
                            Toast.makeText(getApplicationContext(), "안녕하세요, "+id.getText().toString()+"!", Toast.LENGTH_SHORT).show(); //로그인 성공 토스트
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish(); //DBLoadActivity 실행 후 종료
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show(); //로그인 실패 토스트
                            loginProgress.setVisibility(View.GONE); //ProgressBar 숨기기
                        }
                    }
                });
    }


    //SOF change-edittext-password-mask-character-to-asterisk
    public static class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        static class PasswordCharSequence implements CharSequence {
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
}
