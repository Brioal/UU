package com.brioal.brioallib.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**不响应触摸滑动事件的AppBar , 不拦截子组件的任何事件
 * Created by Brioal on 2016/7/12.
 */

public class UnTouchAppBar extends CoordinatorLayout {
    public UnTouchAppBar(Context context) {
        super(context);
    }

    public UnTouchAppBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
