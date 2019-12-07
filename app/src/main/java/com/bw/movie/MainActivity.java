package com.bw.movie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.library.app.App;
import com.bw.library.base.BaseActivity;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WXLoginBean;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.presenter.LoginPresenter;
import com.bw.movie.utils.EncryptUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：MainActivity 登录
 * @data（日期）: 2019/11/12
 * @time（时间）: 9:33
 * @author（作者）: 张安恒
 **/
public class MainActivity extends BaseActivity<LoginPresenter> implements LoginContract.Iview {

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.pwd)
    EditText pwd1;
    @BindView(R.id.reg_text)
    TextView regText;
    @BindView(R.id.login)
    Button login;
    //邮箱正则验证
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    @BindView(R.id.wx_login)
    Button wxLogin;
    private String encrypt1;
    private String myemail;
    private String pass;
    private String headPic;

    @Override
    public void onCreate(Bundle savedInstanceState,PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onLoginSuccess(LoginBean loginBean) {
            if (loginBean.getStatus().equals("0000")){
                Intent intent=new Intent(this, CinemaActivity.class);
                Log.i("loginBean", "onLoginSuccess: " + loginBean.getMessage());
                LoginBean.ResultBean result = loginBean.getResult();
                int userId = result.getUserId();
                String sessionId = result.getSessionId();
                SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putInt("userId", userId);
                edit.putString("sessionId", sessionId);
                edit.commit();
                startActivity( intent);
            }else {
                Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onWxLoginSuccess(WXLoginBean wxLoginBean) {
            if (wxLoginBean.getStatus().equals("0000")){
                WXLoginBean.ResultBean.UserInfoBean userInfo = wxLoginBean.getResult().getUserInfo();
                String userId = wxLoginBean.getResult().getUserId();
                int i = Integer.parseInt(userId);
                String sessionId = wxLoginBean.getResult().getSessionId();
                String headPic = userInfo.getHeadPic();
                String nickName = userInfo.getNickName();
                SharedPreferences mydata = getSharedPreferences("name", MODE_PRIVATE);
                SharedPreferences.Editor edit1 = mydata.edit();
                edit1.putString("nickName",nickName);
                edit1.putString("headPic",headPic);
                edit1.putInt("userId",i);
                edit1.putString("sessionId",sessionId);
                edit1.commit();
                startActivity(new Intent(this,CinemaActivity.class));
        }else {
            Toast.makeText(this, wxLoginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent=getIntent();
        String code = intent.getStringExtra("code");
        Log.i("22222", "initData: "+code);
        mpresenter.wxlogin(code);
    }

    @Override
    public void onFraily(String e) {

    }


    @OnClick({R.id.reg_text, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reg_text:
                Intent intent = new Intent(MainActivity.this, RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                myemail = email.getText().toString();
                pass = pwd1.getText().toString();
                String encrypt = EncryptUtil.encrypt(pass);
                if (TextUtils.isEmpty(myemail)||TextUtils.isEmpty(pass)) {
                    Toast.makeText(this, "邮箱或密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    mpresenter.logins(myemail,encrypt);
                }
                break;
        }
    }

    //校验邮箱
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.wx_login)
    public void onViewClicked() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        App.api.sendReq(req);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
