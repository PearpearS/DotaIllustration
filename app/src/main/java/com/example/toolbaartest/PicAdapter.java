package com.example.toolbaartest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */

public class PicAdapter extends RecyclerView.Adapter<PicAdapter.ViewHolder> {
    private Context mContext;
    private List<Picture>mPictureList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView picImage;
        TextView picName;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            picImage=(ImageView)view.findViewById(R.id.pic_id);
            picName=(TextView) view.findViewById(R.id.pic_name);
        }
    }
    public PicAdapter(List<Picture>PictureList)
    {
        mPictureList=PictureList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.pic_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Picture picture=mPictureList.get(position);
                Intent intent=new Intent(mContext,HeroActivity.class);
                intent.putExtra(HeroActivity.HERO_NAME,picture.getName());
                intent.putExtra(HeroActivity.HERO_IMAGE_ID,picture.getImageId());
                mContext.startActivity(intent);
            }
        });
        //return new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picture picture=mPictureList.get(position);
        holder.picName.setText(picture.getName());
        Glide.with(mContext).load(picture.getImageId()).into(holder.picImage);
    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
}
