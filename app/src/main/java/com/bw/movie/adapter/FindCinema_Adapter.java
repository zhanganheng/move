package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/11/18
 *@Time:19:37
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.XiangAActivity;
import com.bw.movie.activity.XiangCinemaActivity;
import com.bw.movie.bean.FindCinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class FindCinema_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FindCinemaBean.ResultBean> result;
     Context context;

    public FindCinema_Adapter(List<FindCinemaBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.find_cinema_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.find_name.setText(result.get(i).getName());
                myViewHolder.find_daoname.setText("导演:"+result.get(i).getDirector());
                String starring = result.get(i).getStarring();
                myViewHolder.find_zhuname.setText("主演:"+starring);
                double score = result.get(i).getScore();
                myViewHolder.find_num.setText("评分:"+score+"分");
                myViewHolder.find_src.setImageURI(result.get(i).getImageUrl());
                //点击跳转
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, XiangAActivity.class);
                        int movieId = result.get(i).getMovieId();
                        intent.putExtra("movieId",movieId+"");
                        context.startActivity(intent);
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView find_src;
        private final TextView find_name,find_daoname,find_zhuname,find_num;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            find_src = itemView.findViewById(R.id.find_src);
            find_name = itemView.findViewById(R.id.find_name);
            find_daoname = itemView.findViewById(R.id.find_daoname);
            find_zhuname = itemView.findViewById(R.id.find_zhuname);
            find_num = itemView.findViewById(R.id.find_num);

        }
    }
}
