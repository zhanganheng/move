package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.bean.MyDataBean;
import com.bw.movie.bean.MypicBean;
import com.bw.movie.bean.UpbitthdayBean;
import com.bw.movie.contract.MyDataContract;
import com.bw.movie.presenter.MyDataPresenter;
import com.bw.movie.utils.ImageUtil;
import com.dyhdyh.support.glide.transformations.CircleTransformation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MyData_Activity extends BaseActivity<MyDataPresenter> implements MyDataContract.Iview {


    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.my_src)
    ImageView mySrc;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_sex)
    TextView mySex;
    @BindView(R.id.my_day)
    TextView myDay;
    @BindView(R.id.my_phone)
    TextView myPhone;
    private int userId;
    private String sessionId;
    private static SimpleDateFormat format;
    private TimePickerView timePickerView;
    private String nickName;
    private String headPic;

    @Override
    protected MyDataPresenter providePresenter() {
        return new MyDataPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_data_;
    }

    //修改生日
    public static String getTime(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @Override
    protected void initData() {
        super.initData();

        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        nickName = sp.getString("nickName", null);
        headPic = sp.getString("headPic", null);
        mpresenter.mydata(userId + "", sessionId);

        //点击修改头像
        mySrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 10);
            }
        });
        myDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerView = new TimePickerView(MyData_Activity.this, TimePickerView.Type.YEAR_MONTH_DAY);
                // 设置是否循环
                timePickerView.setCyclic(true);
                timePickerView.setTime(new Date());
                timePickerView.setCyclic(false);
                timePickerView.setCancelable(true);
                //时间选择后回调
                timePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

                    @Override
                    public void onTimeSelect(Date date) {

                        myDay.setText(getTime(date));

                        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        mpresenter.upday(userId+"",sessionId,dateStr);
                    }
                });
                timePickerView.show();
            }
        });

        myDay.setText(format+"");

        //性别
        mySex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<String> sexList = new ArrayList<>();
                //选项选择器
                OptionsPickerView<String> pvOptions = new OptionsPickerView(MyData_Activity.this);
                sexList.add("男");
                sexList.add("女");

                pvOptions.setPicker(sexList);
                // 设置选项单位
                pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        String sex = sexList.get(options1);
                        myDay.setText(sex);
                        Toast.makeText(MyData_Activity.this, sex, Toast.LENGTH_SHORT).show();
                    }
                });
                pvOptions.show();
            }
        });

    }

    @Override
    public void MyData(MyDataBean myDataBean) {
        Log.i("myDataBean", "MyData: " + myDataBean.getMessage());
        MyDataBean.ResultBean result = myDataBean.getResult();
        /*//存头像名字
        String nickName = result.getNickName();
        String headPic = result.getHeadPic();
        SharedPreferences mydata = getSharedPreferences("mydata", MODE_PRIVATE);
        SharedPreferences.Editor edit1 = mydata.edit();
        edit1.putString("nickName",nickName);
        edit1.putString("headPic",headPic);
        edit1.commit();*/

        myName.setText(result.getNickName());
        if (myDataBean.getResult().getSex()==1){
            mySex.setText("男");
        }else{
            mySex.setText("女");
        }

        Glide.with(this).load(result.getHeadPic()) .into(mySrc);

        myPhone.setText(result.getEmail());
        //设置时间戳
        long time = result.getLastLoginTime();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.");
        String str = format.format(date);
        myDay.setText(str);
    }

    @Override
    public void MyPict(MypicBean mypicBean) {

    }

    @Override
    public void Upday(UpbitthdayBean upbitthdayBean) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 & resultCode == RESULT_OK) {
            Uri uri = data.getData();
            if (uri != null) {
                //用一个工具类获取图片的绝对路径,我会粘到下方
                String path = ImageUtil.getPath(this, uri);
                if (path != null) {
                    //转换为file类型
                    File file1 = new File(path);
                    //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                    RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                    MultipartBody.Part image1 = MultipartBody.Part.createFormData("image", file1.getName(), requestBody1);
                    //调用P层
                    mpresenter.mypict(userId+"",sessionId,image1);

                }
            }
        }

    }

    @Override
    public void onFraily(String e) {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.find_letf)
    public void onViewClicked() {
        finish();
    }
}
