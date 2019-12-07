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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.bw.movie.R;
import com.bw.movie.bean.FindInfoBean;

import java.util.ArrayList;
import java.util.List;

public class Info_chose_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FindInfoBean.ResultBean> result;
     Context context;
    private String s;
    private String join;
    ArrayList<String> list = new ArrayList<>();
    private String row;
    private String seat;

    public Info_chose_Adapter(List<FindInfoBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.info_chose_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

            final MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            if (viewHolder instanceof  MyViewHolder){
                final int status = result.get ( i ).getStatus ();
                if (status==2){
                    myViewHolder.chose_checkbox.setEnabled ( false );
                    myViewHolder.chose_checkbox.setBackgroundResource ( R.drawable.screen_checkboxy );
                }

                myViewHolder.chose_checkbox.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        boolean checked = myViewHolder.chose_checkbox.isChecked ();
                        if (checked==true){
                            myViewHolder.chose_checkbox.setBackgroundResource ( R.drawable.screen_checkboxd );
                           result.get(i).setStatus(3);
                            join = TextUtils.join(",", list);
                        }else {

                            list.remove(s);
                            myViewHolder.chose_checkbox.setBackgroundResource ( R.drawable.screen_checkbox );
                        }
                    }
                } );
                //把座位信息传到activity
                myViewHolder.chose_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        row = result.get ( i ).getRow ();
                        seat = result.get ( i ).getSeat ();
                        if (myViewHolder.chose_checkbox.isChecked()){
                            result.get(i).setStatus(3);
                            s = row + "-" + seat;
                            list.add(s);
                            setColor.getString(list);
                            setColor.getBack(result.get(i).getRow() + "排" + result.get(i).getSeat() + "座");
                        }else {
                         result.get(i).setStatus(1);
                         setColor.getBack("取消选座");
                         list.remove(s);
                         setColor.getString(list);
                        }
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox chose_checkbox;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            chose_checkbox = itemView.findViewById(R.id.chose_checkbox);

        }
    }

    public  SetColor setColor;

    public void setSetColor(SetColor setColor) {
        this.setColor = setColor;
    }

    public interface SetColor{
        void getBack(String s);
        void  getString(ArrayList<String> list);
    }
}
