package com.brioal.uu.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.brioal.brioallib.base.BaseFragment;
import com.brioal.brioallib.util.ToastUtils;
import com.brioal.uu.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 搜索返利fra
 * Created by Brioal on 2016/7/19.
 */

public class SearchFragment extends BaseFragment implements View.OnClickListener {
    private static SearchFragment mFragment;
    @Bind(R.id.fra_search_et_content)
    EditText mEtContent;
    @Bind(R.id.fra_search_btn_search)
    Button mBtnSearch;
    @Bind(R.id.fra_search_image)
    ImageView mImage;

    public static SearchFragment newInstance() {
        if (mFragment == null) mFragment = new SearchFragment();
        return mFragment;
    }

    @Override
    public void initView() {
        super.initView();
        mRootView = inflater.inflate(R.layout.fra_search, container, false);
        ButterKnife.bind(this, mRootView);
        mEtContent.setOnClickListener(this);
        mBtnSearch.setOnClickListener(this);
        Glide.with(mContext).load(R.mipmap.ic_search_pic).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mImage.setImageDrawable(resource);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fra_search_et_content:
                ToastUtils.showToast(mContext,"进入搜索");
                break;
            case R.id.fra_search_btn_search:
                ToastUtils.showToast(mContext,"进入搜索");
                break;
        }
    }
}
