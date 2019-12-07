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
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.XiangCinemaActivity;
import com.bw.movie.bean.MohuAddressBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Findmohu_Address_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MohuAddressBean.ResultBean> result;
    Context context;

    public Findmohu_Address_Adapter(List<MohuAddressBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.find_mohu_address_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                Log.i("aaaaaa", "onBindViewHolder: "+result.get(i).getName());

                myViewHolder.mohu_img.setImageURI(result.get(i).getLogo());
                myViewHolder.mohu_name.setText(result.get(i).getName());
                myViewHolder.mohu_address.setText(result.get(i).getAddress());
                myViewHolder.mohu_size.setText(result.get(i).getFollowCinema()+"");
                myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, XiangCinemaActivity.class);
                        int id = result.get(i).getId();
                        intent.putExtra("id",id+"");
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
    class  MyViewHolder extends  RecyclerView.ViewHolder {


        private final SimpleDraweeView mohu_img;
        private final TextView mohu_name,mohu_size,mohu_address;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mohu_img = itemView.findViewById(R.id.mohu_img);
            mohu_name = itemView.findViewById(R.id.mohu_name);
            mohu_address = itemView.findViewById(R.id.mohu_address);
            mohu_size = itemView.findViewById(R.id.mohu_size);
        }
    }


}
