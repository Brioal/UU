package com.brioal.brioallib.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.brioal.brioallib.interfaces.ActivityFormat;
import com.brioal.brioallib.klog.KLog;


/**
 * Activity的基类
 * Created by mm on 2016/6/4.
 */

public class BaseActivity extends AppCompatActivity implements ActivityFormat {
    protected final int TYPE_SET_VIEW = 0;
    protected final int TYPE_UPDATE_VIEW = 1;
    protected Activity mContext;
    protected Runnable mThreadLocal = new Runnable() {
        @Override
        public void run() {
            loadDataLocal();
        }
    };
    protected Runnable mThreadNet = new Runnable() {
        @Override
        public void run() {
            loadDataNet();
        }
    };
    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == TYPE_SET_VIEW) {
                KLog.i(mContext.getClass().getName(), "SetView");
                setView();
            } else if (msg.what == TYPE_UPDATE_VIEW) {
                KLog.i(mContext.getClass().getName(), "UpdateView");
                updateView();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        KLog.i(mContext.getClass().getName(),"onCreate");
        initData();
        initView(savedInstanceState);
        initBar();
        new Thread(mThreadLocal).start();
        new Thread(mThreadNet).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        KLog.i(mContext.getClass().getName(),"onResume");
        initTheme();
    }

    @Override
    protected void onStart() {
        super.onStart();
        KLog.i(mContext.getClass().getName(),"onStart");
    }

    @Override

    protected void onPause() {
        super.onPause();
        KLog.i(mContext.getClass().getName(),"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        KLog.i(mContext.getClass().getName(),"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KLog.i(mContext.getClass().getName(),"onDestory");
        saveDataLocal();
    }

    @Override
    public void initData() {
        KLog.i(mContext.getClass().getName(),"initData");

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        KLog.i(mContext.getClass().getName(),"initView");

    }

    @Override
    public void initBar() {
        KLog.i(mContext.getClass().getName(),"initBar");

    }

    @Override
    public void initTheme() {
        KLog.i(mContext.getClass().getName(),"initTheme");
    }

    @Override
    public void loadDataLocal() {
        KLog.i(mContext.getClass().getName(),"loadDataLocal");
    }

    @Override
    public void loadDataNet() {
        KLog.i(mContext.getClass().getName(),"loadDataNet");
    }

    @Override
    public void setView() {
        KLog.i(mContext.getClass().getName(),"setView");
    }

    @Override
    public void updateView() {
        KLog.i(mContext.getClass().getName(), "UpdateView");
    }

    @Override
    public void saveDataLocal() {
        KLog.i(mContext.getClass().getName(),"saveDataLocal");
    }

}
