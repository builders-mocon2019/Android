package com.example.builders.Auth;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.builders.R;

public class RegisterActivity extends AppCompatActivity {

    Button nextBtn;
    TextView regiIndi;
    ProgressBar progressBar;

    private int nowFrag;

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
                        switchFragment(1);
                        nowFrag = 1;
                        break;
                    case 1:
                        switchFragment(2);
                        nowFrag = 2;
                        break;
                    case 2:
                        switchFragment(3);
                        nowFrag = 3;
                        break;
                    case 3:
                        switchFragment(4);
                        nowFrag = 4;
                        break;
                    case 4:
                        break;
                }
            }
        });
    }
    void switchFragment(int frag) {
        regiIndi = findViewById(R.id.regiIndiTxt);
        progressBar = findViewById(R.id.regi_progress);
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
                break;
            default:
                fr = new RegiFragment1();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.regiFragment, fr);
        fragmentTransaction.commit();
    }


}
