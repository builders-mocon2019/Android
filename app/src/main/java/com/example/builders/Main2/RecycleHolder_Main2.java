package com.example.builders.Main2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.builders.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleHolder_Main2 extends RecyclerView.ViewHolder{

    //People 탭의 RecyclerView ViewHolder

    //TextView, ImageView 선언
    public TextView name, want, team, title, likeTxt;
    public LinearLayout likeBtn, moreBtn;
    public ImageView likeIcon;
    public CircleImageView profile;

    //ViewHolder
    public RecycleHolder_Main2(View itemView) {
        super(itemView);
        //각 아이템들을 RecyclerView 아이템 뷰의 항목과 연결
        name = itemView.findViewById(R.id.main1_item_name);
        want = itemView.findViewById(R.id.main1_item_want);
        team = itemView.findViewById(R.id.main1_item_team);
        title = itemView.findViewById(R.id.main1_item_title);
        likeBtn = itemView.findViewById(R.id.main1_item_like);
        likeTxt = itemView.findViewById(R.id.main1_like_text);
        likeIcon = itemView.findViewById(R.id.main1_like_icon);
        moreBtn = itemView.findViewById(R.id.main1_item_more);
        profile = itemView.findViewById(R.id.main1_item_profile);
    }

    public LinearLayout getLikeButton() {
        return likeBtn;
    }
    public LinearLayout getMoreButton() {
        return moreBtn;
    }


}
