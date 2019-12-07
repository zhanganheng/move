package com.bw.movie.adapter;
/*
 *@auther:张安恒  查询地区列表
 *@Date: 2019/11/12
 *@Time:20:37
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
import com.bw.movie.bean.FindRegionBean;

import java.util.List;

public class FindregioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FindRegionBean.ResultBean> result;
    Context context;

    public FindregioAdapter(List<FindRegionBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.findregion_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                    myViewHolder.find_name.setText(result.get(i).getRegionName());

                final int regionId = result.get(i).getRegionId();
                //点击传id
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setOnclickListen.onclick(regionId);
                        }
                    });
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class  MyViewHolder extends  RecyclerView.ViewHolder {


        private final TextView find_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            find_name = itemView.findViewById(R.id.find_name);
        }
    }

    public  setOnclickListen setOnclickListen;

    public void setSetOnclickListen(FindregioAdapter.setOnclickListen setOnclickListen) {
        this.setOnclickListen = setOnclickListen;
    }

    public  interface  setOnclickListen{
        void onclick(int id);
    }
}
