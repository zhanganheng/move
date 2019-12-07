package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/4
 *@Time:11:50
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
import com.bw.movie.activity.MyMessage_Activity;
import com.bw.movie.bean.MyMessageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyMessage_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyMessageBean.ResultBean> result;
    Context context;

    public MyMessage_Adapter(List<MyMessageBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mymessage_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.xin_title.setText(result.get(i).getTitle());
                myViewHolder.xin_text.setText(result.get(i).getContent());

                long time = result.get(i).getPushTime();
                Date date = new Date(time);
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                String str = format.format(date);
                myViewHolder.xin_time.setText(str);
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView xin_title;
        private final TextView xin_text;
        private final TextView xin_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            xin_title = itemView.findViewById(R.id.xin_title);
            xin_text = itemView.findViewById(R.id.xin_text);
            xin_time = itemView.findViewById(R.id.xin_time);
        }
    }
}
