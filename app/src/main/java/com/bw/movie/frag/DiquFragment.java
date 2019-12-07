package com.bw.movie.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.FindCAdapter;
import com.bw.movie.adapter.FindregioAdapter;
import com.bw.movie.bean.FindChildBean;
import com.bw.movie.bean.FindRegionBean;
import com.bw.movie.contract.FindRegionContract;
import com.bw.movie.presenter.FindRegionPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @describe(描述)：DiquFragment 影院地区
 * @data（日期）: 2019/11/15
 * @time（时间）: 8:44
 * @author（作者）: 张安恒
 **/
public class DiquFragment extends BaseFragment<FindRegionPresenter> implements FindRegionContract.Iview {


    @BindView(R.id.find_adapter)
    RecyclerView findAdapter;
    Unbinder unbinder;
    @BindView(R.id.findC_adapter)
    RecyclerView findCAdapter1;
    @BindView(R.id.fu_layout)
    RelativeLayout fuLayout;

    @Override
    protected FindRegionPresenter providePresenter() {
        return new FindRegionPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_diqu;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.findregion();

    }

    @Override
    public void onFindRegionSuccess(FindRegionBean findRegionBean) {
        Log.i("findRegionBean", "onFindRegionSuccess: " + findRegionBean.getMessage());
        List<FindRegionBean.ResultBean> result = findRegionBean.getResult();
        if (result!=null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            findAdapter.setLayoutManager(linearLayoutManager);
            FindregioAdapter findregioAdapter = new FindregioAdapter(result, getActivity());
            findAdapter.setAdapter(findregioAdapter);
            findregioAdapter.setSetOnclickListen(new FindregioAdapter.setOnclickListen() {
                @Override
                public void onclick(int id) {
                    mPresenter.findchild(id + "");
                }
            });
        }else {
            findAdapter.setVisibility(View.GONE);
            fuLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFindChildSuccess(FindChildBean findChildBean) {
        List<FindChildBean.ResultBean> result = findChildBean.getResult();
        if (result!=null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            findCAdapter1.setLayoutManager(linearLayoutManager);
            FindCAdapter findCAdapter = new FindCAdapter(result, getActivity());
            findCAdapter1.setAdapter(findCAdapter);
        }else {
            findCAdapter1.setVisibility(View.GONE);
            fuLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFraily(String e) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
