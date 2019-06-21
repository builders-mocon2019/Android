package com.example.builders;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ChatActivity extends AppCompatActivity {

    TextView title;
    LinearLayout backBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        title = findViewById(R.id.chat_txt);
        Shader textShader = new LinearGradient(150, 0, 0, title.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange), getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        title.getPaint().setShader(textShader);

        backBtn = findViewById(R.id.chat_backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
