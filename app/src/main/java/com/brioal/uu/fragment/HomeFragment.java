package com.brioal.uu.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.brioal.brioallib.base.BaseFragment;
import com.brioal.brioallib.interfaces.OnLoadCompleteListener;
import com.brioal.brioallib.util.ExtraToast;
import com.brioal.brioallib.util.ToastUtils;
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
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

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
    @Bind(R.id.fra_home_recyclerview)
    XRecyclerView mRecyclerview;

    private BGABanner mBanner;
    private ImageView mIvLeft;
    private ImageView mIvRightTop;
    private ImageView mIvBottomLeft;
    private ImageView mIvBottomRight;

    private final int TYPE_REFRESH_COMPLETE = 1;
    private final int TYPE_LOAD_MORE_COMPLETE = 2;

    private View mHeadView;

    private List<HomeAdEntity> mAds; //广告数据源
    private HomeItemBigEntity mBigEntity; //首页大图片数据源
    private List<HomeContentEntity> mList; //首页商品列表数据源
    private HomeAdapter mAdapter; //首页商品列表适配器


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
        mHeadView = LayoutInflater.from(mContext).inflate(R.layout.ic_home_head, container, false);
        mBanner = (BGABanner) mHeadView.findViewById(R.id.fra_home_banner);
        mIvLeft = (ImageView) mHeadView.findViewById(R.id.fra_home_iv_l);
        mIvRightTop = (ImageView) mHeadView.findViewById(R.id.fra_home_iv_rt);
        mIvBottomLeft = (ImageView) mHeadView.findViewById(R.id.fra_home_iv_bl);
        mIvBottomRight = (ImageView) mHeadView.findViewById(R.id.fra_home_iv_br);
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
                final int finalI = i;
                Glide.with(mContext).load(mAds.get(i).getImageUrl()).into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        imageView.setImageDrawable(glideDrawable);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtils.showToast(mContext, mAds.get(finalI).getContentUrl(), ExtraToast.LENGTH_SHORT);
                            }
                        });
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
                mIvLeft.setImageDrawable(glideDrawable);
                mIvLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast(mContext, mBigEntity.getContentUrLeft());
                    }
                });
            }
        }); //左边图片
        Glide.with(mContext).load(mBigEntity.getImageUrlRT()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvRightTop.setImageDrawable(resource);
                mIvRightTop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast(mContext, mBigEntity.getContentRT());
                    }
                });
            }
        }); //右上图片
        Glide.with(mContext).load(mBigEntity.getImageRBL()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvBottomLeft.setImageDrawable(resource);
                mIvBottomLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast(mContext, mBigEntity.getContentRBL());
                    }
                });
            }
        }); //左下图片
        Glide.with(mContext).load(mBigEntity.getImageRBR()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvBottomRight.setImageDrawable(resource);
                mIvBottomRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showToast(mContext, mBigEntity.getContentRBR());
                    }
                });
            }
        }); //右下图片

//        //商品列表
//        if (mAdapter == null) {
        mAdapter = new HomeAdapter(mContext, mList);
        mRecyclerview.setLayoutManager(new GridLayoutManager(mContext, 2));
        mRecyclerview.setAdapter(mAdapter);
        if (!headAdded) {
            mRecyclerview.addHeaderView(mHeadView);
            headAdded = true;
        }
        mRecyclerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);
        mRecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadDataNet();
                    }
                }).start();
            }

            @Override
            public void onLoadMore() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadMore();
                    }
                }).start();
            }
        });
//        } else {
//            mAdapter.notifyDataSetChanged();
//        }

        mRecyclerview.refreshComplete();
    }

    private boolean headAdded = false;

    public void loadMore() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(TYPE_UPDATE_VIEW);
            }
        }, 3000);
    }

    @Override
    public void updateView() {
        super.updateView();
        mAdapter.notifyDataSetChanged();
        mRecyclerview.loadMoreComplete();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
