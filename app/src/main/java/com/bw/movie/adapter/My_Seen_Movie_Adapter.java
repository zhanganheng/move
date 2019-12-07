package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:19:00
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.bw.movie.R;
import com.bw.movie.activity.MyWatch_Activity;
import com.bw.movie.activity.Writer_pinActivity;
import com.bw.movie.bean.MyWatchBean;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class My_Seen_Movie_Adapter extends RecyclerView.Adapter {
    List<MyWatchBean.ResultBean> result;
    Context context;
    private int movieId;
    private String movieName;

    public My_Seen_Movie_Adapter(List<MyWatchBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_seenmovie_guanzhu, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.seen_src.setImageURI(result.get(position).getImageUrl());
        myViewHolder.seen_name.setText(result.get(position).getMovieName());
        movieId = result.get(position).getMovieId();
        movieName = result.get(position).getMovieName();

        //点击按钮评价
        myViewHolder.pinjia_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Writer_pinActivity.class);
                intent.putExtra("movieId",movieId);
                intent.putExtra("name",movieName);
                context.startActivity(intent);
            }
        });
        //设置时间戳
        long time = result.get(position).getEndTime();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:MM:SS" + "观影");
        String str = format.format(date);
        myViewHolder.seen_time.setText(str);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView seen_src;
        private Button pinjia_but;
        private TextView seen_time, seen_name;

        public MyViewHolder( View itemView) {
            super(itemView);
            seen_src = itemView.findViewById(R.id.seen_src);
            seen_time = itemView.findViewById(R.id.seen_time);
            seen_name = itemView.findViewById(R.id.seen_name);
            pinjia_but = itemView.findViewById(R.id.pinjia_but);
        }
    }
}
