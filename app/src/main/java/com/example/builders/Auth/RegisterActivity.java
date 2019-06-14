package com.example.builders.Auth;

import android.content.Intent;
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

import com.example.builders.R;

public class RegisterActivity extends AppCompatActivity {

    Button nextBtn;
    TextView regiIndi, regiName, regiBirth, regiId, regiPw, regiCan, regiWant, regiTeam;

    ProgressBar progressBar;

    private int nowFrag;

    private String name, birth, id, pw, can, want, team;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        switchFragment(0);

        regiIndi = findViewById(R.id.regiIndiTxt);
        progressBar = findViewById(R.id.regi_progress);

        nowFrag = 0;
        nextBtn = findViewById(R.id.regi_nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (nowFrag){
                    case 0:
                        getRegi1();
                        switchFragment(1);
                        nowFrag = 1;
                        break;
                    case 1:
                        getRegi2();
                        switchFragment(2);
                        nowFrag = 2;
                        break;
                    case 2:
                        getRegi3();
                        switchFragment(3);
                        nowFrag = 3;
                        break;
                    case 3:
                        getRegi4();
                        switchFragment(4);
                        nowFrag = 4;
                        break;
                    case 4:
                        getRegi5();
                        Log.d("결과", name+" "+birth+" "+id+" "+pw+" "+can+" "+want+" "+team);
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
        switch (frag){
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
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.regiFragment, fr);
        fragmentTransaction.commit();


    }

    void getRegi1(){
        regiName = findViewById(R.id.regi_name);
        name = regiName.getText().toString();
        regiBirth = findViewById(R.id.regi1_result);
        birth = regiBirth.getText().toString();
    }
    void getRegi2(){
        regiId = findViewById(R.id.regi_id);
        id= regiId.getText().toString();
        regiPw = findViewById(R.id.regi_password);
        pw = regiPw.getText().toString();
    }
    void getRegi3(){
        regiCan = findViewById(R.id.regi3_result);
        can = regiCan.getText().toString();
    }
    void getRegi4(){
        regiWant = findViewById(R.id.regi4_result);
        want = regiWant.getText().toString();
    }
    void getRegi5(){
        regiTeam = findViewById(R.id.regi5_result);
        team = regiTeam.getText().toString();
    }


}
