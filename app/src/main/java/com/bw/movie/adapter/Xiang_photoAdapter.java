package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/11/18
 *@Time:19:37
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Xiang_photoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> posterList;
     Context context;

    public Xiang_photoAdapter(List<String> posterList, Context context) {
        this.posterList = posterList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xiang_photo_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.xiang_photo.setImageURI(posterList.get(i));

            }
    }

    @Override
    public int getItemCount() {
        return posterList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView xiang_photo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            xiang_photo = itemView.findViewById(R.id.xiang_photo);

        }
    }
}
