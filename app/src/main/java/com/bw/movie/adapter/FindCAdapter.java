package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/11/12
 *@Time:20:37
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.XiangCinemaActivity;
import com.bw.movie.bean.FindChildBean;

import java.util.List;

public class FindCAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FindChildBean.ResultBean> result;
    Context context;

    public FindCAdapter(List<FindChildBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.findcadapter_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                Log.i("aaaaaa", "onBindViewHolder: "+result.get(i).getName());
                myViewHolder.findc_name.setText(result.get(i).getName());
                myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = result.get(i).getId();
                        Intent intent=new Intent(context, XiangCinemaActivity.class);
                        intent.putExtra("id",id+"");
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


        private final TextView findc_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            findc_name = itemView.findViewById(R.id.findc_name);
        }
    }


}
