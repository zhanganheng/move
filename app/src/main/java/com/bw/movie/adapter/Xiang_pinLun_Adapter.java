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
import com.bw.movie.bean.PinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

public class Xiang_pinLun_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<PinBean.ResultBean> result;
     Context context;

    public Xiang_pinLun_Adapter(List<PinBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xiang_pinlun_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                myViewHolder.pin_img.setImageURI(result.get(i).getCommentHeadPic());
                myViewHolder.pin_name.setText(result.get(i).getCommentUserName());
                myViewHolder.pin_text.setText(result.get(i).getCommentContent()+"");
                myViewHolder.pin_number.setText(result.get(i).getGreatNum()+"");
                myViewHolder.pin_fen.setText(result.get(i).getScore()+"分");
                int replyNum = result.get(i).getReplyNum();
                Log.i("assss", "onBindViewHolder: "+replyNum);
                myViewHolder.pin_people.setText("等"+replyNum+"人进行了回复");
                long commentTime = result.get(i).getCommentTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(commentTime);
                myViewHolder.pin_time.setText(format);
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {


        private final SimpleDraweeView pin_img;
        private final TextView pin_name,pin_text,pin_number,pin_fen,pin_people,pin_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pin_img = itemView.findViewById(R.id.pin_img);
            pin_name = itemView.findViewById(R.id.pin_name);
            pin_text = itemView.findViewById(R.id.pin_text);
            pin_number = itemView.findViewById(R.id.pin_number);
            pin_fen = itemView.findViewById(R.id.pin_fen);
            pin_people = itemView.findViewById(R.id.pin_people);
            pin_time = itemView.findViewById(R.id.pin_time);

        }
    }
}
