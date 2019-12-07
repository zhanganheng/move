package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:19:00
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
import com.bw.movie.bean.GuancinemaBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Guan_cinema_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<GuancinemaBean.ResultBean> result;
    Context context;
    private int cinemaId;

    public Guan_cinema_Adapter(List<GuancinemaBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.guan_cinema_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.cinema_src.setImageURI(result.get(i).getLogo());
                myViewHolder.cinema_name.setText(result.get(i).getName());
                myViewHolder.cinema_address.setText(result.get(i).getAddress());
                cinemaId = result.get(i).getCinemaId();
                myViewHolder.guan_tv_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setClickListen.onclick(v,i,cinemaId+"");
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView cinema_src;
        private final TextView cinema_address;
        private final TextView cinema_name,guan_tv_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cinema_src = itemView.findViewById(R.id.cinema_src);
            cinema_address = itemView.findViewById(R.id.cinema_address);
            cinema_name = itemView.findViewById(R.id.cinema_name);
            guan_tv_delete = itemView.findViewById(R.id.guan_tv_delete);
        }
    }
    public setClickListen setClickListen;

    public void setSetClickListen(Guan_cinema_Adapter.setClickListen setClickListen) {
        this.setClickListen = setClickListen;
    }

    public interface  setClickListen{
        void  onclick(View view,int position,String id);
    }
}
