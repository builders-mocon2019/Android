package com.example.builders.Main;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.builders.Chat.ChatActivity;
import com.example.builders.Dialog.SearchActivity;
import com.example.builders.Main1.MainFragment1;
import com.example.builders.Main2.MainFragment2;
import com.example.builders.Main3.MainFragment3;
import com.example.builders.Main4.MainFragment4;
import com.example.builders.R;
import com.example.builders.Write.WriteActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ImageView actionChat, actionWrite, actionSearch;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

//        final ActionBar abar = getSupportActionBar();
//        //abar.setBackgroundDrawable(getResources().getDrawable("#ffffff"));//line under the action bar
//        View viewActionBar = getLayoutInflater().inflate(R.layout.toolbar_layout, null);
//        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
//                ActionBar.LayoutParams.WRAP_CONTENT,
//                ActionBar.LayoutParams.MATCH_PARENT,
//                Gravity.CENTER);
        TextView textviewTitle = findViewById(R.id.action_title);

        Shader textShader = new LinearGradient(150, 0, 0, textviewTitle.getPaint().getTextSize(),
                new int[]{getColor(R.color.gradientOrange), getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        textviewTitle.getPaint().setShader(textShader);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setBackgroundResource(R.color.colorWhite);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.action_1:
                        selectedFragment = MainFragment1.newInstance();
                        break;
                    case R.id.action_2:
                        selectedFragment = MainFragment2.newInstance();
                        break;
                    case R.id.action_3:
                        selectedFragment = MainFragment3.newInstance();
                        break;
                    case R.id.action_4:
                        selectedFragment = MainFragment4.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, MainFragment1.newInstance());
        transaction.commit();

        actionChat = findViewById(R.id.action_chat);
        actionChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        actionWrite = findViewById(R.id.action_write);
        actionWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });

        actionSearch = findViewById(R.id.action_search);
        actionSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });


    }
}

