package com.brioal.uu;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.brioal.brioallib.base.BaseActivity;
import com.brioal.uu.activity.MainActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LauncherActivity extends BaseActivity {

    @Bind(R.id.act_launcher_iv_back)
    ImageView mIvBack;

    @Override
    public void initData() {
        setTheme(R.style.AppTheme_NoActionBar);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.initData();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setContentView(R.layout.act_launcher);
        ButterKnife.bind(this);
        Glide.with(mContext).load(R.mipmap.ic_launcher_back).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mIvBack.setImageDrawable(glideDrawable);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        MainActivity.enterMain(mContext);
                        finish();
                    }
                }, 1000);
            }
        });

    }

}
