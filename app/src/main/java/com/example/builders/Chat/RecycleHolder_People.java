package com.example.builders.Chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.builders.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleHolder_People extends RecyclerView.ViewHolder{

    //TextView, ImageView 선언
    public TextView name, text, time;
    public CircleImageView profile;

    //ViewHolder
    public RecycleHolder_People(View itemView) {
        super(itemView);
        //각 아이템들을 RecyclerView 아이템 뷰의 항목과 연결
        name = itemView.findViewById(R.id.people_name);
        text = itemView.findViewById(R.id.people_text);
        time = itemView.findViewById(R.id.people_time);
        profile = itemView.findViewById(R.id.people_profile);
    }
}
