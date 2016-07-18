package com.brioal.brioallib.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brioal.brioallib.interfaces.FragmentFormat;
import com.brioal.brioallib.klog.KLog;


/**
 * Fragment基类
 * Created by mm on 2016/6/4.
 */

public class BaseFragment extends Fragment implements FragmentFormat {
    protected final int TYPE_INIT_VIEW = 0;
    protected final int TYPE_UPDATE_VIEW = 1;
    protected Activity mContext;
    protected View mRootView;
    protected LayoutInflater inflater;
    protected ViewGroup container;
    protected Bundle saveInstanceState;
    protected Runnable mRunnableLocal = new Runnable() {
        @Override
        public void run() {
            KLog.i("Run loadDataLocal");
            loadDataLocal();
        }
    };
    protected Runnable mRunnableNet = new Runnable() {
        @Override
        public void run() {
            KLog.i("Run loadDataNet");
            loadDataNet();      //加载数据
        }
    };

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == TYPE_INIT_VIEW) {
                setView(); //数据显示到布局
                KLog.i(mContext.getClass().getName(), "setView");
            } else if (msg.what == TYPE_UPDATE_VIEW) {
                updateView();
                KLog.i(mContext.getClass().getName(), "updateView");
            }
        }
    };


    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        mContext = context;
        KLog.i(mContext.getClass().getName(), "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KLog.i(mContext.getClass().getName(), "onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        KLog.i(mContext.getClass().getName(), "onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        KLog.i(mContext.getClass().getName(), "onDestory");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        KLog.i(mContext.getClass().getName(), "onDestroyView");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        KLog.i(mContext.getClass().getName(), "onCreateView");
        this.inflater = inflater;
        this.container = container;
        this.saveInstanceState = savedInstanceState;
        initData();
        initView();
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        KLog.i(mContext.getClass().getName(), "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        new Thread(mRunnableLocal).start();
        new Thread(mRunnableNet).start();
    }

    @Override
    public void initData() {
        KLog.i(mContext.getClass().getName(), "initData");
    }

    @Override
    public void initView() {
        KLog.i(mContext.getClass().getName(), "initView");
    }

    @Override
    public void loadDataLocal() {
        KLog.i(mContext.getClass().getName(), "loadDataLocal");
    }

    @Override
    public void loadDataNet() {
        KLog.i(mContext.getClass().getName(), "loadDataNet");
    }

    @Override
    public void setView() {
        KLog.i(mContext.getClass().getName(), "setView");
    }

    @Override
    public void updateView() {
        KLog.i(mContext.getClass().getName(), "updateView");

    }

    @Override
    public void saveDataLocal() {
        KLog.i(mContext.getClass().getName(), "saveDataLocal");
    }
}
