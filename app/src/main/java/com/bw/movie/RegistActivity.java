package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.library.base.BaseActivity;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegistContract;
import com.bw.movie.presenter.RegistPresenter;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：RegistActivity 注册
 * @data（日期）: 2019/11/12
 * @time（时间）: 9:33
 * @author（作者）: 张安恒
 **/
public class RegistActivity extends BaseActivity<RegistPresenter> implements RegistContract.Iview {


    @BindView(R.id.edit_name)
    EditText edit_name;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.get_yan)
    Button getYan;
    @BindView(R.id.but_zhu)
    Button butZhu;
    @BindView(R.id._fanhui)
    TextView Fanhui;
    //邮箱正则验证
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    @Override
    protected RegistPresenter providePresenter() {
        return new RegistPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    public void onemailSuccess(RegisterBean registerBean) {
        Log.i("registerBean", "onemailSuccess: " + registerBean.getMessage());
    }

    @Override
    public void onRegistSuccess(RegisterBean registerBean) {
        Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (registerBean.getMessage().equals("注册成功")) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistActivity.this, MainActivity.class);
            startActivity(intent);
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

    @OnClick({R.id.get_yan, R.id.but_zhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_yan:
                String string = editEmail.getText().toString();
                Log.d("email", string);
                mpresenter.email(string);
                break;
            case R.id.but_zhu:
                String name = edit_name.getText().toString();
                String emal = editEmail.getText().toString();
                String pwd = editPwd.getText().toString();
                String yz = editCode.getText().toString();
                boolean email = isEmail(emal);
                if (email==false){
                    Toast.makeText(this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
                }else {
                    mpresenter.regist(name, emal, pwd, yz);
                }
                break;
        }
    }

    @OnClick(R.id._fanhui)
    public void onViewClicked() {
        startActivity(new Intent(RegistActivity.this,MainActivity.class));
    }
    //校验邮箱
    public static boolean isEmail(String email){
        return Pattern.matches(REGEX_EMAIL, email);
    }
}
