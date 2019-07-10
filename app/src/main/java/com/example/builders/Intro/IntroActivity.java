package com.example.builders.Intro;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.builders.Auth.LoginActivity;
import com.example.builders.R;

public class IntroActivity extends AppCompatActivity {

    TextView intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        intro = findViewById(R.id.intro_txt);
        Shader textShader=new LinearGradient(150, 0, 0, intro.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange),getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        intro.getPaint().setShader(textShader);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.fade_in_s, R.anim.fade_out_s); //화면 전환 효과
                finish();
            }
        }, 1500);
    }
}
