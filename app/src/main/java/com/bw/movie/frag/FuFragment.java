package com.bw.movie.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.FujingAdapter;
import com.bw.movie.bean.FujingBean;
import com.bw.movie.contract.FujingContract;
import com.bw.movie.presenter.FujingPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @describe(描述)：FuFragment 附近影院
 * @data（日期）: 2019/11/15
 * @time（时间）: 8:44
 * @author（作者）: 张安恒
 **/
public class FuFragment extends BaseFragment<FujingPresenter> implements FujingContract.Iview {

    @BindView(R.id.tickets_layout)
    RelativeLayout ticketsLayout;
    private int pagei = 1;
    @BindView(R.id.fujing_view)
    XRecyclerView fujingView;
    Unbinder unbinder;
    private List<FujingBean.ResultBean> result;

    @Override
    protected FujingPresenter providePresenter() {
        return new FujingPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_fu;
    }

    @Override
    protected void initData() {
        super.initData();

        fujingView.setLoadingMoreEnabled(true);
        fujingView.setPullRefreshEnabled(true);
        fujingView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pagei = 1;
                result.clear();
                mPresenter.fujing(pagei, 10);
                result.addAll(result);
                fujingView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                pagei++;
                mPresenter.fujing(pagei, 10);
                fujingView.refreshComplete();
            }
        });
        mPresenter.fujing(pagei, 10);
    }


    @Override
    public void FujingSuccess(FujingBean fujingBean) {
        Log.i("fujingBean", "FujingSuccess: " + fujingBean.getMessage());
        result = fujingBean.getResult();
        if (result != null) {
            FujingAdapter fujingAdapter = new FujingAdapter(result, getActivity());
            fujingView.setAdapter(fujingAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
            fujingView.setLayoutManager(linearLayoutManager);
        } else {
            fujingView.setVisibility(View.GONE);
            ticketsLayout.setVisibility(View.VISIBLE);
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
