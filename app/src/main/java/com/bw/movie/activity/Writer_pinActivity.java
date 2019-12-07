package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.bean.WriterpinBean;
import com.bw.movie.contract.WriterPinAContract;
import com.bw.movie.presenter.WriterPinPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Writer_pinActivity extends BaseActivity<WriterPinPresenter> implements WriterPinAContract.Iview {


    @BindView(R.id.img_yp_back)
    ImageView imgYpBack;
    @BindView(R.id.tv_yp_name)
    TextView tvYpName;
    @BindView(R.id.tv_pingfen)
    TextView tvPingfen;
    @BindView(R.id.rb_yp_pingfen)
    RatingBar rbYpPingfen;
    @BindView(R.id.et_yp_movie)
    EditText etYpMovie;
    @BindView(R.id.bt_yp_push)
    Button btYpPush;
    private String name;
    private String s;
    private int userId;
    private String sessionId;
    private int movieId;


    @Override
    protected WriterPinPresenter providePresenter() {
        return new WriterPinPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_writer_pin;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent=getIntent();
        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        movieId = intent.getIntExtra("movieId", 0);
        name = intent.getStringExtra("name");
        Log.i("movieIdxxx", "initData: "+ movieId);
        Log.i("namexxx", "initData: "+name);
        tvYpName.setText(name);
        btYpPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = etYpMovie.getText().toString();
                mpresenter.writerpin(userId+"",sessionId,movieId+"",s,"4.5");
                finish();
            }
        });
    }

    @Override
    public void WriterSuccess(WriterpinBean writerpinBean) {

        Log.i("writerpinBean", "WriterSuccess: "+writerpinBean.getMessage());
        Toast.makeText(this,writerpinBean.getMessage() , Toast.LENGTH_SHORT).show();
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


}
