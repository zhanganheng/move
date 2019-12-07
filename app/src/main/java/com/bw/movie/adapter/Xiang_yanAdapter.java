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

public class Xiang_yanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<XiangABean.ResultBean.MovieActorBean> movieActor;
     Context context;

    public Xiang_yanAdapter(List<XiangABean.ResultBean.MovieActorBean> movieActor, Context context) {
        this.movieActor = movieActor;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xiang_yan_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.xiang_yanname.setText(movieActor.get(i).getName());
                String role = movieActor.get(i).getRole();
                myViewHolder.xiang_yanshi.setText("饰: "+role);
                myViewHolder.xiang_yanpic.setImageURI(movieActor.get(i).getPhoto());
            }
    }

    @Override
    public int getItemCount() {
        return movieActor.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView xiang_yanpic;
        private final TextView xiang_yanname,xiang_yanshi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            xiang_yanname = itemView.findViewById(R.id.xiang_yanname);
            xiang_yanpic = itemView.findViewById(R.id.xiang_yanpic);
            xiang_yanshi = itemView.findViewById(R.id.xiang_yanshi);
        }
    }
}
