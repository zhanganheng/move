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
import com.bw.movie.adapter.TuicinemaAdapter;
import com.bw.movie.bean.TuicinemaBean;
import com.bw.movie.contract.TuicinemaContract;
import com.bw.movie.presenter.TuicinemaPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @describe(描述)：TuiFragment 推荐影院
 * @data（日期）: 2019/11/15
 * @time（时间）: 8:44
 * @author（作者）: 张安恒
 **/
public class TuiFragment extends BaseFragment<TuicinemaPresenter> implements TuicinemaContract.Iview {

    int count = 10;
    @BindView(R.id.tui_view)
    XRecyclerView tuiView;
    Unbinder unbinder;
    @BindView(R.id.tui_layout)
    RelativeLayout tuiLayout;

    @Override
    protected TuicinemaPresenter providePresenter() {
        return new TuicinemaPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_tui;
    }


    @Override
    protected void initData() {
        super.initData();


        tuiView.setPullRefreshEnabled(true);
        tuiView.setLoadingMoreEnabled(true);
        tuiView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                count = 10;
                mPresenter.tuicinema(1, count);
                tuiView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                count++;
                mPresenter.tuicinema(1, count);
                tuiView.loadMoreComplete();

            }
        });
        mPresenter.tuicinema(1, 10);
    }

    @Override
    public void TuicinemaSuccess(TuicinemaBean tuicinemaBean) {
        Log.i("tuicinemaBean", "TuicinemaSuccess: " + tuicinemaBean.message);
        List<TuicinemaBean.ResultBean> result = tuicinemaBean.result;
        if (result!=null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
            tuiView.setLayoutManager(linearLayoutManager);
            TuicinemaAdapter tuicinemaAdapter = new TuicinemaAdapter(result, getActivity());
            tuiView.setAdapter(tuicinemaAdapter);
        }else {
            tuiView.setVisibility(View.GONE);
            tuiLayout.setVisibility(View.VISIBLE);
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
