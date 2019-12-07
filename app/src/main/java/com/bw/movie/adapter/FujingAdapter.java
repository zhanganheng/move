package com.bw.movie.adapter;
/*
 *@auther:张安恒  附近电影
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
import com.bw.movie.activity.XiangCinemaActivity;
import com.bw.movie.bean.FujingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class FujingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FujingBean.ResultBean> result;
   private Context context;

    public FujingAdapter(List<FujingBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fujing_adapter, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.fujing_name.setText(result.get(i).getName());
                myViewHolder.fujing_address.setText(result.get(i).getAddress());
                int followCinema = result.get(i).getFollowCinema();
                myViewHolder.fujing_size.setText(followCinema+"千米");
                myViewHolder.fujing_img.setImageURI(result.get(i).getLogo());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, XiangCinemaActivity.class);
                        intent.putExtra("id",result.get(i).getId()+"");
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

        private SimpleDraweeView fujing_img;
        private TextView fujing_name;
        private  TextView fujing_address,fujing_size;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fujing_img = itemView.findViewById(R.id.fujing_img);
            fujing_name = itemView.findViewById(R.id.fujing_name);
            fujing_address = itemView.findViewById(R.id.fujing_address);
            fujing_size = itemView.findViewById(R.id.fujing_size);
        }
    }
    public  setOnClickListen setOnClickListen;

    public void setSetOnClickListen(FujingAdapter.setOnClickListen setOnClickListen) {
        this.setOnClickListen = setOnClickListen;
    }

    public interface  setOnClickListen{
        void  cinemaid(String id);
    }
}
