package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:15:54
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.XiangAActivity;
import com.bw.movie.bean.Guanzhu_dianyin;
import com.bw.movie.bean.MyAPinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

public class Guan_movie_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Guanzhu_dianyin.ResultBean> result;
    Context context;
    private int movieId;

    public Guan_movie_Adapter(List<Guanzhu_dianyin.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.guan_movie_layout, null);
        return new MyViewHoldere(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHoldere myViewHoldere= (MyViewHoldere) viewHolder;
            if (viewHolder instanceof  MyViewHoldere){
                myViewHoldere.movie_src.setImageURI(result.get(i).getImageUrl());
                myViewHoldere.movie_name.setText(result.get(i).getName());
                myViewHoldere.movie_dao.setText("导演:"+result.get(i).getDirector());
                myViewHoldere.movie_zhu.setText("主演:"+result.get(i).getStarring());
                myViewHoldere.movie_pin.setText("平分:"+result.get(i).getScore()+"分");
                movieId = result.get(i).getMovieId();
                myViewHoldere.guan_tv_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setClickListen.onclick(v,i,movieId+"");
                    }
                });
                //点击跳转电影详情
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
    class MyViewHoldere extends RecyclerView.ViewHolder {

        private final SimpleDraweeView movie_src;
        private final TextView movie_name,movie_dao,movie_zhu,movie_pin,guan_tv_delete;

        public MyViewHoldere(@NonNull View itemView) {
            super(itemView);
            movie_src = itemView.findViewById(R.id.guan_src);
            movie_name = itemView.findViewById(R.id.guan_name);
            movie_dao = itemView.findViewById(R.id.guan_dao);
            movie_zhu = itemView.findViewById(R.id.guan_zhu);
            movie_pin = itemView.findViewById(R.id.guan_pin);
            guan_tv_delete = itemView.findViewById(R.id.guan_tv_delete);
        }
    }
    public setClickListen setClickListen;

    public void setSetClickListen(Guan_movie_Adapter.setClickListen setClickListen) {
        this.setClickListen = setClickListen;
    }

    public interface  setClickListen{
        void  onclick(View view,int position,String id);
    }
}
