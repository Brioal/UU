package com.brioal.uu.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.RelativeLayout;

import com.brioal.brioallib.base.BaseActivity;
import com.brioal.brioallib.view.bottomlayout.BottomBaseAdapter;
import com.brioal.brioallib.view.bottomlayout.ButtomTabLayout;
import com.brioal.uu.R;
import com.brioal.uu.fragment.HomeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.main_rl_container)
    RelativeLayout mViewPager;
    @Bind(R.id.main_tab_layout)
    ButtomTabLayout mTabLayout;

    private FragmentManager mFragmentManager;
    private String[] mTitles = new String[]{
            "首页",
            "搜返利",
            "商城",
            "趣逛逛",
            "用户",
    };
    private int[] mIcons = new int[]{
            R.mipmap.ic_home,
            R.mipmap.ic_search,
            R.mipmap.ic_shop,
            R.mipmap.ic_shoping,
            R.mipmap.ic_user
    };

    @Override
    public void initData() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.initData();
    }

    @Override
    public void initBar() {
        super.initBar();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        initTabLayout();
        mFragmentManager.beginTransaction().add(R.id.main_rl_container, HomeFragment.newInstance()).commit();
    }

    private void initTabLayout() {
        mTabLayout.setBackgroundColor(Color.WHITE);
        mTabLayout.setmCurrentCheck(0);
        mTabLayout.setSelectItem(new ButtomTabLayout.onSelectItem() {
            @Override
            public void onSelectedItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = HomeFragment.newInstance();
                        break;
//                    case 1:
//                        fragment = FindFragment.getInstance();
//                        break;
//                    case 2:
//                        fragment = OrderFragment.getInstance();
//                        break;
//                    case 3:
//                        fragment = UserFragment.getInstance();
//                        break;
                }
                if (fragment == null) {
                    return;
                }
                if (fragment.isAdded()) {
                    mFragmentManager.beginTransaction().replace(R.id.main_rl_container, fragment).commit();
                } else {
                    mFragmentManager.beginTransaction().add(R.id.main_rl_container, fragment).commit();
                }
            }
        });
        mTabLayout.setmCheckedPerscent(1.1f);
        mTabLayout.setmCheckedColor(getResources().getColor(R.color.colorAccent));
        mTabLayout.setmNormalColor(Color.GRAY);
        mTabLayout.setmAdapter(new BottomBaseAdapter() {
            @Override
            public int getItemCount() {
                return mTitles.length;
            }

            @Override
            public Drawable getDrawable(int position) {
                return getResources().getDrawable(mIcons[position]);
            }

            @Override
            public CharSequence getText(int position) {
                return mTitles[position];
            }
        });
    }

    @Override
    public void loadDataLocal() {
        super.loadDataLocal();
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


    public static final void enterMain(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }
}
