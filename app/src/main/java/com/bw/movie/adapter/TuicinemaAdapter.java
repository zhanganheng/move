package com.bw.movie.adapter;
/*
 *@auther:张安恒  推荐电影
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
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.XiangCinemaActivity;
import com.bw.movie.bean.TuicinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;


import java.util.ArrayList;
import java.util.List;

public class TuicinemaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private List<TuicinemaBean.ResultBean> result = new ArrayList<>();
   private Context context;

    public TuicinemaAdapter(List<TuicinemaBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tui_adapter, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.tui_name.setText(result.get(i).name);
                myViewHolder.tui_address.setText(result.get(i).address);
                myViewHolder.tui_img.setImageURI(result.get(i).logo);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, XiangCinemaActivity.class);
                        intent.putExtra("id",result.get(i).id+"");
                        int id = result.get(i).id;
                        SharedPreferences sp = context.getSharedPreferences("cinemaid", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putInt("id",id).commit();
                        context.startActivity(intent);
                    }
                });

            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class  MyViewHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView tui_img;
        private TextView tui_name;
        private  TextView tui_address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tui_img = itemView.findViewById(R.id.tui_img);
            tui_name = itemView.findViewById(R.id.tui_name);
            tui_address = itemView.findViewById(R.id.tui_address);
        }
    }
    public  setOnClickListen setOnClickListen;

    public void setSetOnClickListen(TuicinemaAdapter.setOnClickListen setOnClickListen) {
        this.setOnClickListen = setOnClickListen;
    }

    public interface  setOnClickListen{
        void  cinemaid(String id);
    }
}
