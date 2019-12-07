package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/11/12
 *@Time:20:37
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.XiangAActivity;
import com.bw.movie.bean.BCinemaBean;
import com.bw.movie.bean.MyYuyueBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.contract.MyYuyueContract;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class BrecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>   {
    List<BCinemaBean.ResultBean> result;
    Context context;
    private int movieId;

    public BrecycleAdapter(List<BCinemaBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bcinema_adapter, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.text_name2.setText(result.get(i).getName());
                myViewHolder.text_time2.setText(result.get(i).getDirector());
                myViewHolder.text_count2.setText(result.get(i).getScore()+"");
               myViewHolder.img_src2.setImageURI(result.get(i).getImageUrl());

               myViewHolder.yuyue_but1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       setonClickListe.onclick();
                   }
               });
                //点击跳转
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, XiangAActivity.class);
                        BrecycleAdapter.this.movieId = result.get(i).getMovieId();
                        intent.putExtra("movieId", BrecycleAdapter.this.movieId +"");
                        Log.i("moviedb", "onClick: "+ BrecycleAdapter.this.movieId);

                        SharedPreferences sp = context.getSharedPreferences("movieId", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putInt("movieId",movieId);
                        edit.commit();
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

        private final SimpleDraweeView img_src2;
        private final Button yuyue_but1;
        private final TextView text_name2,text_time2,text_count2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_src2 = itemView.findViewById(R.id.img_src2);
            text_name2 = itemView.findViewById(R.id.text_name2);
            text_time2 = itemView.findViewById(R.id.text_time2);
            text_count2 = itemView.findViewById(R.id.text_count2);
            yuyue_but1 = itemView.findViewById(R.id.yuyue_but1);
        }
    }
    public setonClickListe setonClickListe;

    public void setSetonClickListe(BrecycleAdapter.setonClickListe setonClickListe) {
        this.setonClickListe = setonClickListe;
    }

    public  interface  setonClickListe{
        void  onclick();
    }
}
