package com.example.builders;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WriteActivity extends AppCompatActivity {

    TextView writeTxt;
    LinearLayout backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);


        writeTxt = findViewById(R.id.write_txt);
        Shader textShader = new LinearGradient(150, 0, 0, writeTxt.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        writeTxt.getPaint().setShader(textShader);

        backBtn = findViewById(R.id.write_backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
