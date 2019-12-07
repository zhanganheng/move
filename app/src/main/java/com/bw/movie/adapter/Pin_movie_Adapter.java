package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:15:54
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MyAPinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

public class Pin_movie_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyAPinBean.ResultBean> result;
    Context context;

    public Pin_movie_Adapter(List<MyAPinBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pin_movie_layout, null);
        return new MyViewHoldere(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHoldere myViewHoldere= (MyViewHoldere) viewHolder;
            if (viewHolder instanceof  MyViewHoldere){
                myViewHoldere.movie_src.setImageURI(result.get(i).getImageUrl());
                myViewHoldere.movie_name.setText(result.get(i).getMovieName());
                myViewHoldere.movie_dao.setText("导演:"+result.get(i).getDirector());
                myViewHoldere.movie_zhu.setText("主演:"+result.get(i).getStarring());
                myViewHoldere.movie_text.setText(result.get(i).getMyCommentContent());
                myViewHoldere.movie_pin.setText("评分:"+result.get(i).getMovieScore()+"");
                myViewHoldere.movie_fen.setText("("+result.get(i).getMyCommentScore()+"分)");
                long commentTime = result.get(i).getCommentTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(commentTime);
                myViewHoldere.movie_time.setText(format);
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHoldere extends RecyclerView.ViewHolder {

        private final SimpleDraweeView movie_src;
        private final TextView movie_name,movie_dao,movie_zhu,movie_fen,movie_text,movie_time,movie_pin;

        public MyViewHoldere(@NonNull View itemView) {
            super(itemView);
            movie_src = itemView.findViewById(R.id.movie_src);
            movie_name = itemView.findViewById(R.id.movie_name);
            movie_dao = itemView.findViewById(R.id.movie_dao);
            movie_zhu = itemView.findViewById(R.id.movie_zhu);
            movie_fen = itemView.findViewById(R.id.movie_fen);
            movie_text = itemView.findViewById(R.id.movie_text);
            movie_time = itemView.findViewById(R.id.movie_time);
            movie_pin = itemView.findViewById(R.id.movie_pin);
        }
    }
}
