package com.brioal.uu.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.brioal.brioallib.base.BaseFragment;
import com.brioal.brioallib.interfaces.OnLoadCompleteListener;
import com.brioal.brioallib.view.bgabanner.BGABanner;
import com.brioal.uu.R;
import com.brioal.uu.adapter.HomeAdapter;
import com.brioal.uu.entity.HomeAdEntity;
import com.brioal.uu.entity.HomeContentEntity;
import com.brioal.uu.entity.HomeItemBigEntity;
import com.brioal.uu.util.DataLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页fra
 * Created by Brioal on 2016/7/18.
 */

public class HomeFragment extends BaseFragment {
    private static HomeFragment mFragment;
    @Bind(R.id.fra_home_et_search)
    EditText mEtSearch;
    @Bind(R.id.fra_home_btn_search)
    Button mBtnSearch;
    @Bind(R.id.fra_home_recycler)
    RecyclerView mRecycler;
    @Bind(R.id.fra_home_refresh)
    SwipeRefreshLayout mRefresh;
    @Bind(R.id.fra_home_banner)
    BGABanner mBanner;
    @Bind(R.id.fra_home_iv_l)
    ImageView mIvL;
    @Bind(R.id.fra_home_iv_rt)
    ImageView mIvRt;
    @Bind(R.id.fra_home_iv_bl)
    ImageView mIvBl;
    @Bind(R.id.fra_home_iv_br)
    ImageView mIvBr;
    @Bind(R.id.fra_home_scroll)
    ScrollView mScrollView;


    private List<HomeAdEntity> mAds; //广告数据源
    private HomeItemBigEntity mBigEntity; //首页大图片数据源
    private List<HomeContentEntity> mList; //首页商品列表数据源
    private HomeAdapter mAdapter; //首页商品列表适配器
    private boolean isScrolled = false;


    public static HomeFragment newInstance() {
        if (mFragment == null) {
            mFragment = new HomeFragment();
        }
        return mFragment;
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();
        mRootView = inflater.inflate(R.layout.fra_home, container, false);
        ButterKnife.bind(this, mRootView);
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScrollView.scrollTo(0, 0);
            }
        });
        isScrolled = false;
    }

    @Override
    public void loadDataNet() {
        super.loadDataNet();
        //获取广告数据
        DataLoader.newInstance(mContext).getHomeList(new OnLoadCompleteListener() {
            @Override
            public void onSuccess(List list) {
                mAds = list;
                mHandler.sendEmptyMessage(TYPE_INIT_VIEW);
            }

            @Override
            public void onFailed(String message) {

            }
        });

        //获取大图片数据
        DataLoader.newInstance(mContext).getHomeBigContent(new OnLoadCompleteListener() {
            @Override
            public void onSuccess(List list) {
                mBigEntity = (HomeItemBigEntity) list.get(0);
                mHandler.sendEmptyMessage(TYPE_INIT_VIEW);
            }

            @Override
            public void onFailed(String message) {

            }
        });
        //获取物品列表
        DataLoader.newInstance(mContext).getHomeContents(new OnLoadCompleteListener() {
            @Override
            public void onSuccess(List list) {
                if (mList == null) {
                    mList = new ArrayList<HomeContentEntity>();
                } else {
                    mList.clear();
                }
                for (int i = 0; i < list.size(); i++) {
                    mList.add((HomeContentEntity) list.get(i));
                }
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
        //实例化Banner
        if (mAds != null && mAds.size() != 0) {
            List<View> views = new ArrayList<>();
            for (int i = 0; i < mAds.size(); i++) {
                final ImageView imageView = new ImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(mContext).load(mAds.get(i).getImageUrl()).into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        imageView.setImageDrawable(glideDrawable);
                    }
                });
                views.add(imageView);
            }
            mBanner.setViews(views);
        }
        //显示大的物品图片
        Glide.with(mContext).load(mBigEntity.getImageUrlLeft()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvL.setImageDrawable(glideDrawable);
            }
        }); //左边图片
        Glide.with(mContext).load(mBigEntity.getImageUrlRT()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvRt.setImageDrawable(resource);
            }
        }); //右上图片
        Glide.with(mContext).load(mBigEntity.getImageRBL()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvBl.setImageDrawable(resource);
            }
        }); //左下图片
        Glide.with(mContext).load(mBigEntity.getImageRBR()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvBr.setImageDrawable(resource);
            }
        }); //右下图片

        //商品列表
        if (mAdapter == null) {
            mAdapter = new HomeAdapter(mContext, mList);
            mRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            mRecycler.setAdapter(mAdapter);
            mRecycler.setNestedScrollingEnabled(false);
        } else {
            mAdapter.notifyDataSetChanged();
        }


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                    mScrollView.scrollTo(0, 0);


            }
        }, 1000);

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
