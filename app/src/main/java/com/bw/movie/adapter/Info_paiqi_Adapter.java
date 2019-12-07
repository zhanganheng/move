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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindWatchTimeBean;

import java.util.List;

public class Info_paiqi_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FindWatchTimeBean.ResultBean> result;
     Context context;

    public Info_paiqi_Adapter(List<FindWatchTimeBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.info_paiqi_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                String screeningHall = result.get(i).getScreeningHall();
                Log.i("shuju", "onBindViewHolder: "+result);
                myViewHolder.paiqi_name.setText(screeningHall);
                myViewHolder.paiqi_time.setText(result.get(i).getBeginTime());
                myViewHolder.paiqi_time2.setText(result.get(i).getEndTime());
                Log.i("screeningHall", "onBindViewHolder: "+screeningHall);
                final int hallId = result.get(i).getHallId();
            //    int id = result.get(i).getId();
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setonClicklist.onClick(i);
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView paiqi_name,paiqi_time,paiqi_time2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            paiqi_name = itemView.findViewById(R.id.paiqi_name);
            paiqi_time = itemView.findViewById(R.id.paiqi_time);
            paiqi_time2 = itemView.findViewById(R.id.paiqi_time2);
        }
    }

    public void setSetonClicklist(Info_paiqi_Adapter.setonClicklist setonClicklist) {
        this.setonClicklist = setonClicklist;
    }

    public setonClicklist setonClicklist;
    public  interface  setonClicklist{
        void onClick(int postition);
    }
}
