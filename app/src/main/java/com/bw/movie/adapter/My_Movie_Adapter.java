package com.bw.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.MyTicket_Activity;
import com.bw.movie.bean.MyTicketBean;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name APP
 * @class name：com.bw.movie.view.adapter.my_adapter
 * @class describe
 * @anthor 24673
 * @time 2019/12/2 14:09
 * @change
 * @chang time
 * @class describe
 */
public class My_Movie_Adapter extends RecyclerView.Adapter {
    List<MyTicketBean.ResultBean> result;
    private Context context;
    private Date date;
    private int id;

    public My_Movie_Adapter(List<MyTicketBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_movie_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;

        holder.text_cinema.setText(result.get(position).getCinemaName());
        holder.text_name.setText(result.get(position).getMovieName());
        holder.text_screeningHall.setText(result.get(position).getScreeningHall());
        holder.text_zuo.setText(result.get(position).getSeat());
        //设置时间戳
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        long time = result.get(position).getCreateTime();
        date = new Date(time);
        String str = format.format(date);
        holder.text_date.setText(str);

        String beginTime = result.get(position).getBeginTime();
        holder.text_time.setText(beginTime);
        //接口回调
        id = result.get(position).getId();
        Log.i("erweimaid", "onBindViewHolder: "+ id);
        holder.bt_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClicketListen.onclick(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private Button bt_reservation;
        private TextView text_time, text_date, text_screeningHall, text_cinema, text_zuo, text_name;

        public MyViewHolder( View itemView) {
            super(itemView);
            bt_reservation = itemView.findViewById(R.id.bt_reservation);
            text_time = itemView.findViewById(R.id.text_time);
            text_date = itemView.findViewById(R.id.text_date);
            text_screeningHall = itemView.findViewById(R.id.text_screeningHall);
            text_cinema = itemView.findViewById(R.id.text_cinema);
            text_zuo = itemView.findViewById(R.id.text_zuo);
            text_name = itemView.findViewById(R.id.text_name);
        }
    }
    public  setClicketListen setClicketListen;

    public void setSetClicketListen(My_Movie_Adapter.setClicketListen setClicketListen) {
        this.setClicketListen = setClicketListen;
    }

    public interface  setClicketListen{
        void  onclick(int id);
    }
}
