package com.example.builders.Main1;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.builders.Main.ArticleModel;
import com.example.builders.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter_Main1 extends RecyclerView.Adapter<RecycleHolder_Main1> {

    //Main1 탭의 RecyclerView Adapter

    List<ArticleModel> items = new ArrayList<>(); //RecyclerView에 들어갈 아이템 저장 ArrayList 선언

    public List<ArticleModel> getItems() {
        return items;
    } //List의 아이템을 반환하는 함수

    public void add(ArticleModel data){ //리스트에 값을 추가하는 함수
        items.add(data); //리스트에 com.example.builders.Main.ArticleModel 양식으로 전달받은 값 추가
        notifyDataSetChanged(); //RecyclerView 갱신
    }

    @NonNull
    @Override
    public RecycleHolder_Main1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main_article, parent, false); //RecyclerView에 뿌려줄 아이템 뷰 설정
        return new RecycleHolder_Main1(v); //뷰 반환
    }

//    View.OnClickListener clickListener;
//
//    public void setOnItemClickListener(View.OnClickListener clickListener) {
//        this.clickListener = clickListener;
//    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder_Main1 holder, int position) {

        final ArticleModel item = items.get(position); //리스트의 position 위치 값을 com.example.builders.Main.ArticleModel 양식으로 가져오기

        //가져온 값을 holder에 대입
        holder.name.setText(item.getName());
        holder.want.setText(item.getWant());
        holder.team.setText(item.getTeam());
        holder.title.setText(item.getTitle());
        holder.getLikeButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        holder.getMoreButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ArticleActivity.class);

                intent.putExtra("article_name", item.getName());
                intent.putExtra("article_want", item.getWant());
                intent.putExtra("article_team", item.getTeam());
                intent.putExtra("article_title", item.getTitle());
                intent.putExtra("article_text", item.getText());

                view.getContext().startActivity(intent);
            }
        });

//        holder.itemView.setOnClickListener(clickListener);

    }

    @Override
    public int getItemCount() {
        return items.size(); //리스트 크기 반환
    }



}
