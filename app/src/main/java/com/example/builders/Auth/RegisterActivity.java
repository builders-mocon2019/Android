package com.example.builders.Auth;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.example.builders.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    Button nextBtn;
    TextView regiIndi, regiName, regiBirth, regiId, regiPw, regiPwCheck, regiCan, regiWant, regiTeam;

    TextView errorName, errorId, errorPw, errorPwCheck;
    RoundCornerProgressBar progressBar;

    private int nowFrag;

    private String name, birth, id, pw, pwcheck, can, want, team;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        switchFragment(0);

        regiIndi = findViewById(R.id.regiIndiTxt);
        progressBar = findViewById(R.id.regi_progress);

        progressBar.setClipToOutline(true);
        //progressBar.setProgressColor(Color.);

        nowFrag = 0;
        nextBtn = findViewById(R.id.regi_nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (nowFrag) {
                    case 0:
                        getRegi1();
                        break;
                    case 1:
                        getRegi2();
                        break;
                    case 2:
                        getRegi3();
                        break;
                    case 3:
                        getRegi4();
                        break;
                    case 4:
                        getRegi5();
                        break;
                }
            }
        });


    }

    void switchFragment(int frag) {
        regiIndi = findViewById(R.id.regiIndiTxt);
        progressBar = findViewById(R.id.regi_progress);
        nextBtn = findViewById(R.id.regi_nextBtn);
        Fragment fr;
        switch (frag) {
            case 0:
                fr = new RegiFragment1();
                regiIndi.setText("5단계 중 1단계");
                progressBar.setProgress(1);
                break;
            case 1:
                fr = new RegiFragment2();
                regiIndi.setText("5단계 중 2단계");
                progressBar.setProgress(2);
                break;
            case 2:
                fr = new RegiFragment3();
                regiIndi.setText("5단계 중 3단계");
                progressBar.setProgress(3);
                break;
            case 3:
                fr = new RegiFragment4();
                regiIndi.setText("5단계 중 4단계");
                progressBar.setProgress(4);
                break;
            case 4:
                fr = new RegiFragment5();
                regiIndi.setText("5단계 중 5단계");
                progressBar.setProgress(5);
                nextBtn.setText("완료");
                break;
            default:
                fr = new RegiFragment1();
                regiIndi.setText("5단계 중 1단계");
                progressBar.setProgress(1);
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if(frag!=0) fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.regiFragment, fr);
        fragmentTransaction.commit();


    }

    void getRegi1() {
        regiName = findViewById(R.id.regi_name);
        name = regiName.getText().toString();
        regiBirth = findViewById(R.id.regi1_result);
        birth = regiBirth.getText().toString();

        errorName = findViewById(R.id.regierror_name);
        if (!name.equals("")) {
            switchFragment(1);
            nowFrag = 1;
        } else errorName.setVisibility(View.VISIBLE);
    }

    void getRegi2() {
        regiId = findViewById(R.id.regi_id);
        id = regiId.getText().toString();
        regiPw = findViewById(R.id.regi_password);
        pw = regiPw.getText().toString();
        regiPwCheck = findViewById(R.id.regi_passwordcheck);
        pwcheck = regiPwCheck.getText().toString();

        errorId = findViewById(R.id.regierror_id);
        errorPw = findViewById(R.id.regierror_pw);
        errorPwCheck = findViewById(R.id.regierror_pwcheck);
        errorId.setVisibility(View.GONE);
        errorPw.setVisibility(View.GONE);
        errorPwCheck.setVisibility(View.GONE);
        if (!id.equals("") && !pw.equals("") && !pwcheck.equals("")) {
            if (isValidPasswd(pw)&&isValidEmail(id)) {
                if(pw.equals(pwcheck)){
                    switchFragment(2);
                    nowFrag = 2;
                }
                else {
                    errorPwCheck.setVisibility(View.VISIBLE);
                    errorPwCheck.setText("비밀번호가 일치하지 않습니다.");
                }
            } else {
                if(!isValidEmail(id)){
                    errorId.setVisibility(View.VISIBLE);
                    errorId.setText("이메일 형식이 올바르지 않습니다.");
                }
                if(!isValidPasswd(pw)){
                    errorPw.setVisibility(View.VISIBLE);
                    errorPw.setText("비밀번호 형식이 올바르지 않습니다.");
                }


            }
        } else {
            if(id.equals("")) {
                errorId.setVisibility(View.VISIBLE);
                errorId.setText("필수 항목입니다.");
            }
            if(pw.equals("")) {
                errorPw.setVisibility(View.VISIBLE);
                errorPw.setText("필수 항목입니다.");
            }
            if(pwcheck.equals("")) {
                errorPw.setVisibility(View.VISIBLE);
                errorPw.setText("필수 항목입니다.");
            }
        }
    }

    void getRegi3() {
        regiCan = findViewById(R.id.regi3_result);
        can = regiCan.getText().toString();

        if (!can.equals("")) {
            switchFragment(3);
            nowFrag = 3;
        } else Toast.makeText(this, "최소 1개의 항목을 선택해주세요", Toast.LENGTH_SHORT).show();
    }

    void getRegi4() {
        regiWant = findViewById(R.id.regi4_result);
        want = regiWant.getText().toString();

        if (!want.equals("")) {
            switchFragment(4);
            nowFrag = 4;
        } else Toast.makeText(this, "최소 1개의 항목을 선택해주세요", Toast.LENGTH_SHORT).show();
    }

    void getRegi5() {
        regiTeam = findViewById(R.id.regi5_result);
        team = regiTeam.getText().toString();

        if (!team.equals("")) {
            nextBtn.setTextColor(getColor(R.color.colorPrimary));
            final TransitionDrawable background = (TransitionDrawable) nextBtn.getBackground();
            background.startTransition(300);
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();// FireBase 현재 Auth 정보 가져오기
            firebaseAuth.createUserWithEmailAndPassword(id, pw) //Firebase에 회원가입 요청
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() { //작업 완료 리스너
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) { //회원가입에 성공했다면
                                UserModel model = new UserModel(name, birth, id, can, want, team); //UserModel 양식에 회원가입 정보 추가
                                databaseReference.child("user").push().setValue(model); //작성한 model 양식을 Firebase DB에 등록
                                Toast.makeText(getApplicationContext(), "환영합니다, " + id + "!", Toast.LENGTH_SHORT).show(); //회원가입 성공 토스트
                                RegisterDialog registerDialog = new RegisterDialog(RegisterActivity.this);
                                registerDialog.setCancelable(false);
                                registerDialog.show();

                            } else { //회원가입에 실패했다면
                                Toast.makeText(getApplicationContext(), "회원가입 실패, 이미 가입된 계정인지 확인하세요", Toast.LENGTH_SHORT).show(); //회원가입 실패 토스트
                                nextBtn.setTextColor(getColor(R.color.colorWhite));
                                background.reverseTransition(300);
                            }
                        }
                    });
            Log.d("결과", name + " " + birth + " " + id + " " + pw + " " + can + " " + want + " " + team);
        } else Toast.makeText(this, "최소 1개의 항목을 선택해주세요", Toast.LENGTH_SHORT).show();

    }

    private boolean isValidEmail(String target) { //Email 유효성 검사 함수
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches(); //Email 유효성 검사 결과 반환
    }

    private boolean isValidPasswd(String target) { //패스워드 유효성 검사 함수
        Pattern p = Pattern.compile("(^.*(?=.{6,50})(?=.*[0-9])(?=.*[a-z]).*$)"); //패스워드 검사 정규식. 6~50자, 알파벳+숫자
        Matcher m = p.matcher(target); //정규식 대입 검사
        return m.find() && !target.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"); //정규식 검사값이 옳고 한글이 포함되지 않았다면 true 반환
    }



}
