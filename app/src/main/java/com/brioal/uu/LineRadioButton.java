package com.brioal.uu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * 选中后左边出现一个短线条
 * Created by Brioal on 2016/7/19.
 */

public class LineRadioButton extends RadioButton {
    private Paint mPaint;

    public LineRadioButton(Context context) {
        this(context, null);
    }

    public LineRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));

    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(0, 0, 10, getMeasuredHeight());
        if (isChecked()) {
            setBackgroundColor(getResources().getColor(R.color.colorLightWhite));
            mPaint.setColor(getResources().getColor(R.color.colorAccent));
            canvas.drawRect(rectF, mPaint);
        } else {
            setBackgroundColor(Color.WHITE);
            mPaint.setColor(Color.WHITE);
            canvas.drawRect(rectF, mPaint);
        }
        super.onDraw(canvas);
    }
}
