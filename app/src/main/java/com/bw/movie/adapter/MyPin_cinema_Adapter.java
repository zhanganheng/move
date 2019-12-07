package com.bw.movie.adapter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:19:48
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
import com.bw.movie.bean.Ping_yingyuanBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

public class MyPin_cinema_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Ping_yingyuanBean.ResultBean> result;
    Context context;

    public MyPin_cinema_Adapter(List<Ping_yingyuanBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pinmy_cinema_ada_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.pincinema_img.setImageURI(result.get(i).getLogo());
                myViewHolder.pinc_name.setText(result.get(i).getCinemaName());
                myViewHolder.pinc_address.setText(result.get(i).getAddress());
                myViewHolder.pinc_km.setText(result.get(i).getDistance()+"km");
                myViewHolder.pinc_text.setText(result.get(i).getMyCommentContent());
                long commentTime = result.get(i).getCommentTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(commentTime);
                myViewHolder.pinc_time.setText(format);
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView pincinema_img;
        private final TextView pinc_name;
        private final TextView pinc_address;
        private final TextView pinc_km;
        private final TextView pinc_text;
        private final TextView pinc_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pincinema_img = itemView.findViewById(R.id.pincinema_img);
            pinc_name = itemView.findViewById(R.id.pinc_name);
            pinc_address = itemView.findViewById(R.id.pinc_address);
            pinc_km = itemView.findViewById(R.id.pinc_km);
            pinc_text = itemView.findViewById(R.id.pinc_text);
            pinc_time = itemView.findViewById(R.id.pinc_time);
        }
    }
}
