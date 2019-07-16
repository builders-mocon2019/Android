package com.example.builders.Chat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.builders.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter_People extends RecyclerView.Adapter<RecycleHolder_People> {

    //People 탭의 RecyclerView Adapter

    List<RecycleModel_Chat> items = new ArrayList<>(); //RecyclerView에 들어갈 아이템 저장 ArrayList 선언

    public List<RecycleModel_Chat> getItems() {
        return items;
    } //List의 아이템을 반환하는 함수

    public void add(RecycleModel_Chat data){ //리스트에 값을 추가하는 함수
        items.add(data); //리스트에 RecycleModel_Chat 양식으로 전달받은 값 추가
        notifyDataSetChanged(); //RecyclerView 갱신
    }

    public void delete(int position){ //리스트에서 값을 제거하는 함수
        items.remove(items.get(position)); //리스트의 position 위치에 있는 아이템 삭제
        notifyDataSetChanged(); //RecyclerView 갱신
    }

    @NonNull
    @Override
    public RecycleHolder_People onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_people, parent, false); //RecyclerView에 뿌려줄 아이템 뷰 설정
        return new RecycleHolder_People(v); //뷰 반환
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder_People holder, int position) {

        RecycleModel_Chat item = items.get(position); //리스트의 position 위치 값을 RecycleModel_Chat 양식으로 가져오기

        //가져온 값을 holder에 대입
        holder.name.setText(item.getName());
        holder.text.setText(item.getText());
        holder.time.setText(item.getTime());

        String data = item.getProfile();

        //데이터 base64 형식으로 Decode
        String txtPlainOrg = "";
        byte[] bytePlainOrg = Base64.decode(data, 0);

        //byte[] 데이터  stream 데이터로 변환 후 bitmapFactory로 이미지 생성
        ByteArrayInputStream inStream = new ByteArrayInputStream(bytePlainOrg);
        Bitmap bm = BitmapFactory.decodeStream(inStream) ;

        holder.profile.setImageBitmap(bm);
        //holder.profile.setImageDrawable(new ColorDrawable(item.getProfilenum()));
    }

    @Override
    public int getItemCount() {
        return items.size(); //리스트 크기 반환
    }
}
