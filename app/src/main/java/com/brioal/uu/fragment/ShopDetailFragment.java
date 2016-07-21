package com.brioal.uu.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.brioal.brioallib.base.BaseFragment;
import com.brioal.brioallib.interfaces.OnLoadCompleteListener;
import com.brioal.brioallib.util.ToastUtils;
import com.brioal.uu.R;
import com.brioal.uu.adapter.ShopDetailBaseAdapter;
import com.brioal.uu.entity.ShopDetailEntity;
import com.brioal.uu.util.DataLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商家分类fra
 * Created by Brioal on 2016/7/19.
 */

public class ShopDetailFragment extends BaseFragment {
    @Bind(R.id.fra_shop_detail_gridview)
    GridView mGridview;
    private String mIndex; //所属分类

    private List<ShopDetailEntity> mList;
    private ShopDetailBaseAdapter mAdapter;


    public static ShopDetailFragment newInstance(String index) {
        ShopDetailFragment mFragment = new ShopDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Index", index);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public void initData() {
        super.initData();
        mIndex = getArguments().getString("Index");
    }

    @Override
    public void initView() {
        super.initView();
        mRootView = inflater.inflate(R.layout.fra_shop_detail, container, false);
        ButterKnife.bind(this, mRootView);
    }

    @Override
    public void loadDataNet() {
        super.loadDataNet();
        DataLoader.newInstance(mContext).getShopDetail(mIndex, new OnLoadCompleteListener() {
            @Override
            public void onSuccess(List list) {
                mList = list;
                mHandler.sendEmptyMessage(TYPE_INIT_VIEW);
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    @Override
    public void setView() {
        super.setView();
        if (mAdapter == null) {
            mAdapter = new ShopDetailBaseAdapter(mContext, mList);
            mGridview.setAdapter(mAdapter);
            mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String url = mList.get(position).getShopUrl();
                    ToastUtils.showToast(mContext, url);
                }
            });
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
