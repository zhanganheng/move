package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bw.library.base.BaseActivity;
import com.bw.library.base.BasePresenter;
import com.bw.movie.MainActivity;
import com.bw.movie.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SouActivity extends BaseActivity {


    @BindView(R.id.back_but)
    LinearLayout backBut;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_sou;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_but)
    public void onViewClicked() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
