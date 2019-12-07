package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/11/12
 *@Time:20:37
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
import com.bw.movie.bean.CCinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CrecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CCinemaBean.ResultBean> result;
    Context context;

    public CrecycleAdapter(List<CCinemaBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ccinema_adapter, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.text_name3.setText(result.get(i).getName());
                myViewHolder.img_src3.setImageURI(result.get(i).getImageUrl());

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
    class  MyViewHolder extends  RecyclerView.ViewHolder {

        private final SimpleDraweeView img_src3;
        private final TextView text_name3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_src3 = itemView.findViewById(R.id.img_src3);
            text_name3 = itemView.findViewById(R.id.text_name3);


        }
    }
}
