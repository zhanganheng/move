package com.bw.movie;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.library.base.BaseActivity;
import com.bw.library.base.BasePresenter;
import com.bw.movie.server.DownloadIntentService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SettingActivity extends BaseActivity {

    private static final int DOWNLOADAPK_ID = 10;
    @BindView(R.id.banben_text)
    TextView banbenText;
    @BindView(R.id.banben_button)
    Button banbenButton;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initData() {
        super.initData();
        Unbinder bind = ButterKnife.bind(this);
    }



    @OnClick({R.id.banben_text, R.id.banben_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.banben_text:
                finish();
                break;
            case R.id.banben_button:
                if (isServiceRunning(DownloadIntentService.class.getName())) {
                    Toast.makeText(SettingActivity.this, "正在下载", Toast.LENGTH_SHORT).show();
                    return;
                }
                //String downloadUrl = http://sqdd.myapp.com/myapp/qqteam/tim/down/tim.apk;
                String downloadUrl = "/media/movie.apk";
                Intent intent = new Intent(SettingActivity.this, DownloadIntentService.class);
                Bundle bundle = new Bundle();
                bundle.putString("download_url", downloadUrl);
                bundle.putInt("download_id", DOWNLOADAPK_ID);
                bundle.putString("download_file", downloadUrl.substring(downloadUrl.lastIndexOf('/') + 1));
                intent.putExtras(bundle);
                startService(intent);
                break;
        }
    }
    /**
     * 用来判断服务是否运行.
     *
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    private boolean isServiceRunning(String className) {

        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) this
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(Integer.MAX_VALUE);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
        }
}
