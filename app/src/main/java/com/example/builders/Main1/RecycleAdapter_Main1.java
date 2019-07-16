package com.example.builders.Main1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.builders.Auth.UserDB;
import com.example.builders.Chat.ChatPageActivity;
import com.example.builders.Chat.RecycleModel_ChatPage;
import com.example.builders.Main.ArticleModel;
import com.example.builders.R;
import com.example.builders.Write.LikeModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter_Main1 extends RecyclerView.Adapter<RecycleHolder_Main1> {

    //Main1 탭의 RecyclerView Adapter

    List<ArticleModel> items = new ArrayList<>(); //RecyclerView에 들어갈 아이템 저장 ArrayList 선언
    List<LikeModel> likeList = new ArrayList<>();

    public List<ArticleModel> getItems() {
        return items;
    } //List의 아이템을 반환하는 함수

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseAuth firebaseAuth;

    boolean likeCheck = false;

    public void add(ArticleModel data) { //리스트에 값을 추가하는 함수
        items.add(data); //리스트에 com.example.builders.Main.ArticleModel 양식으로 전달받은 값 추가
        notifyDataSetChanged(); //RecyclerView 갱신
    }

    public void addWithLike(ArticleModel data) { //리스트에 값을 추가하는 함수
        likeCheck = true;
        items.add(data); //리스트에 com.example.builders.Main.ArticleModel 양식으로 전달받은 값 추가
        notifyDataSetChanged(); //RecyclerView 갱신
    }

    public void deleteAll() { //리스트에서 값을 제거하는 함수
        items.clear(); //리스트의 아이템 삭제
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
    public void onBindViewHolder(@NonNull final RecycleHolder_Main1 holder, int position) {

        final ArticleModel item = items.get(position); //리스트의 position 위치 값을 com.example.builders.Main.ArticleModel 양식으로 가져오기

        //가져온 값을 holder에 대입
        holder.name.setText(item.getName());
        holder.want.setText(item.getWant());
        holder.team.setText(item.getTeam());
        holder.title.setText(item.getTitle());

        UserDB userDB = new UserDB();

        String data = item.getProfile();

        //데이터 base64 형식으로 Decode
        String txtPlainOrg = "";
        byte[] bytePlainOrg = Base64.decode(data, 0);

        //byte[] 데이터  stream 데이터로 변환 후 bitmapFactory로 이미지 생성
        ByteArrayInputStream inStream = new ByteArrayInputStream(bytePlainOrg);
        Bitmap bm = BitmapFactory.decodeStream(inStream) ;

        holder.profile.setImageBitmap(bm);

        if (likeCheck) {
            holder.likeTxt.setTextColor(holder.itemView.getResources().getColor(R.color.colorPrimary));
            holder.likeIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
            holder.likeBtn.setTag("y");
            likeCheck=false;
        }

//        databaseReference.child("like").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                LikeModel model = dataSnapshot.getValue(LikeModel.class);
//                likeList.add(model);
//                UserDB userDB = new UserDB();
//                for(int i=0;i<likeList.size();i++){
//                    if(likeList.get(i).getKey().equals(userDB.getUserName(holder.itemView.getContext())+item.getNum())){
//                        Log.d("asd", "onChildAdded: "+userDB.getUserName(holder.itemView.getContext())+item.getNum());
//                        holder.likeTxt.setTextColor(holder.itemView.getResources().getColor(R.color.colorPrimary));
//                        holder.likeIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
//                        holder.likeBtn.setTag("y");
//                    }
//                }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


        holder.getLikeButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.likeBtn.getTag().equals("n")) {
                    UserDB userDB = new UserDB();
                    LikeModel model = new LikeModel(userDB.getUserName(view.getContext()), item.getNum(), userDB.getUserName(view.getContext()) + item.getNum()); //RecycleModel_ChatPage 양식으로 대화 시작을 알리는 메세지 작성
                    databaseReference.child("like").push().setValue(model); //작성한 대화 시작 메세지를 Firebase DB의 message 항목에 추가
                    holder.likeTxt.setTextColor(view.getResources().getColor(R.color.colorPrimary));
                    holder.likeIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
                    view.setTag("y");
                } else {
                    UserDB userDB = new UserDB();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    Query query = ref.child("like").orderByChild("key").equalTo(userDB.getUserName(view.getContext()) + item.getNum());

                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                snapshot.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    holder.likeTxt.setTextColor(Color.parseColor("#808080"));
                    holder.likeIcon.setImageResource(R.drawable.ic_favorite_gray_24dp);
                    view.setTag("n");
                }
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
                intent.putExtra("article_profile", item.getProfile());

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
