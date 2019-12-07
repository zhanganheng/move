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
import com.bw.movie.bean.XiangABean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Xiang_yugaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<XiangABean.ResultBean.ShortFilmListBean> shortFilmList;
     Context context;

    public Xiang_yugaoAdapter(List<XiangABean.ResultBean.ShortFilmListBean> shortFilmList, Context context) {
        this.shortFilmList = shortFilmList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xiang_yugao_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
              myViewHolder.xiang_yugao.setUp(shortFilmList.get(i).getVideoUrl(),"");

            }
    }

    @Override
    public int getItemCount() {
        return shortFilmList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final JCVideoPlayer xiang_yugao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            xiang_yugao = itemView.findViewById(R.id.xiang_yugao);

        }
    }
}
