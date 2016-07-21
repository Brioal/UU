package com.brioal.uu.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.brioal.brioallib.base.BaseFragment;
import com.brioal.uu.R;
import com.brioal.uu.adapter.ShopViewPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商城列表
 * Created by Brioal on 2016/7/19.
 */

public class ShopFragment extends BaseFragment {
    static {
        TAG = "ShopFragment";
    }
    private static ShopFragment mFragment;
    @Bind(R.id.fra_shop_tab)
    TabLayout mShopTab;
    @Bind(R.id.fra_shop_viewpager)
    ViewPager mViewpager;

    private ShopViewPagerAdapter mShopViewPagerAdapter;

    public static ShopFragment newInstance() {
        if (mFragment == null) mFragment = new ShopFragment();
        return mFragment;
    }

    @Override
    public void initView() {
        super.initView();
        mRootView = inflater.inflate(R.layout.fra_shop, container, false);
        ButterKnife.bind(this, mRootView);
        mShopViewPagerAdapter = new ShopViewPagerAdapter(getChildFragmentManager());
        mViewpager.setAdapter(mShopViewPagerAdapter);
        mShopTab.setupWithViewPager(mViewpager);
    }

    @Override
    public void loadDataNet() {
        super.loadDataNet();
    }

    @Override
    public void setView() {
        super.setView();
    }

    @Override
    public void updateView() {
        super.updateView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
