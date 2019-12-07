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
import com.bw.movie.bean.FindAddressBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Chose_cinemaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FindAddressBean.ResultBean> result;
     Context context;

    public Chose_cinemaAdapter(List<FindAddressBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chose_cinema_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.chose_name.setText(result.get(i).getName());
                myViewHolder.chose_add.setText(result.get(i).getAddress());
                myViewHolder.chose_money.setText(result.get(i).getPrice()+"元");

                myViewHolder.chose_src.setImageURI(result.get(i).getLogo());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int cinemaId = result.get(i).getCinemaId();
                        setOnClickListen.onClick(cinemaId+"");
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView chose_src;
        private final TextView chose_name,chose_add,chose_money;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            chose_src = itemView.findViewById(R.id.chose_src);
            chose_name = itemView.findViewById(R.id.chose_name);
            chose_add = itemView.findViewById(R.id.chose_add);
            chose_money = itemView.findViewById(R.id.chose_money);
        }
    }


    public void setSetOnClickListen(Chose_cinemaAdapter.setOnClickListen setOnClickListen) {
        this.setOnClickListen = setOnClickListen;
    }

    public setOnClickListen setOnClickListen;
  public   interface  setOnClickListen{
        void  onClick(String id);
    }
}
