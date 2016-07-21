package com.brioal.uu.fragment;

import com.brioal.brioallib.base.BaseFragment;
import com.brioal.uu.R;

/**
 * Created by Brioal on 2016/7/19.
 */

public class UserFragment extends BaseFragment {
    private static UserFragment mFragment;

    public static UserFragment newInstance() {
        if (mFragment == null) {
            mFragment = new UserFragment();
        }
        return mFragment;
    }

    @Override
    public void initView() {
        super.initView();
        mRootView = inflater.inflate(R.layout.fra_user, container, false);
    }
}
