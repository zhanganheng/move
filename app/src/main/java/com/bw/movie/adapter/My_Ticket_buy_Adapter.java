package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:19:00
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.BuyTicket_xiangActivity;
import com.bw.movie.bean.BuyTicketBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class My_Ticket_buy_Adapter extends RecyclerView.Adapter {
    List<BuyTicketBean.ResultBean> result;
    Context context;
    private String orderId;

    public My_Ticket_buy_Adapter(List<BuyTicketBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(  ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_ticket_buy, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.ticket_src.setImageURI(result.get(position).getImageUrl());
        myViewHolder.ticket_name.setText(result.get(position).getMovieName());
        myViewHolder.ticket_address.setText(result.get(position).getOrderId());
        orderId = result.get(position).getOrderId();
        myViewHolder.ticket_tv_xiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BuyTicket_xiangActivity.class);
                intent.putExtra("orderId",orderId);
                context.startActivity(intent);
            }
        });

        //设置时间戳
        long time = result.get(position).getCreateTime();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String str = format.format(date);
        myViewHolder.ticket_tv_delete.setText(str);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private  SimpleDraweeView ticket_src;
        private  TextView ticket_name,ticket_address,ticket_tv_delete,ticket_tv_xiang;

        public MyViewHolder( View itemView) {
            super(itemView);
            ticket_src = itemView.findViewById(R.id.ticket_src);
            ticket_address = itemView.findViewById(R.id.ticket_address);
            ticket_tv_delete = itemView.findViewById(R.id.ticket_tv_delete);
            ticket_name = itemView.findViewById(R.id.ticket_name);
            ticket_tv_xiang = itemView.findViewById(R.id.ticket_tv_xiang);
        }
    }
}