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
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.XiangABean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Xiang_daoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<XiangABean.ResultBean.MovieDirectorBean> movieDirector;
     Context context;

    public Xiang_daoAdapter(List<XiangABean.ResultBean.MovieDirectorBean> movieDirector, Context context) {
        this.movieDirector = movieDirector;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xiang_dao_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.xiang_daoname.setText(movieDirector.get(i).getName());
                myViewHolder.xiang_daopic.setImageURI(movieDirector.get(i).getPhoto());
            }
    }

    @Override
    public int getItemCount() {
        return movieDirector.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView xiang_daopic;
        private final TextView xiang_daoname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            xiang_daopic = itemView.findViewById(R.id.xiang_daopic);
            xiang_daoname = itemView.findViewById(R.id.xiang_daoname);
        }
    }
}
