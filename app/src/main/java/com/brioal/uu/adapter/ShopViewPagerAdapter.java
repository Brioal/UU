package com.brioal.uu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.brioal.uu.fragment.ShopDetailFragment;

/**
 * Created by Brioal on 2016/7/19.
 */

public class ShopViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{
            "最热商城",
            "团购返利",
            "图书音像",
            "母婴用品",
            "家庭生活",
            "美容化妆",
            "数码家电",
            "服装服饰",
            "综合商城",
            "鞋包配饰",
            "旅行酒店",
            "虚拟商品",
            "食品饮料",

    };

    public ShopViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ShopDetailFragment.newInstance(mTitles[position]);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
