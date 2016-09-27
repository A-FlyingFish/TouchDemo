package com.jash.touchdemo;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class Layout_2 extends FrameLayout {
    public static final String TAG = Layout_2.class.getSimpleName();
    public Layout_2(Context context) {
        super(context);
    }

    public Layout_2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout_2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: ");
        View view = getChildAt(0);
        if (!new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()).contains((int)ev.getX(), (int) ev.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);
    }
}
