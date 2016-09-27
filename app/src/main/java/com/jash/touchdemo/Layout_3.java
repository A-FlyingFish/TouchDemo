package com.jash.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class Layout_3 extends FrameLayout {
    public static final String TAG = Layout_3.class.getSimpleName();
    public Layout_3(Context context) {
        super(context);
    }

    public Layout_3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout_3(Context context, AttributeSet attrs, int defStyleAttr) {
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
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + MotionEvent.actionToString(event.getAction()));
        return true;
    }
}
