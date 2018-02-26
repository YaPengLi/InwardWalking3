package com.silent.fiveghost.guide.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.silent.fiveghost.guide.interfaces.AlphaChangeListener;

/**
 * Created by 农民伯伯 on 2018/2/1.
 */

public class XScrollView extends ScrollView {
    int height;

    public void setAlphaChangeListener(AlphaChangeListener alphaChangeListener) {
        this.alphaChangeListener = alphaChangeListener;
    }

    AlphaChangeListener alphaChangeListener;
    public XScrollView(Context context) {
        this(context,null);
    }

    public XScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public XScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        height=getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (alphaChangeListener!=null) {
            if (t<=height/4){
                float a=1-t*4.0f/height;
                alphaChangeListener.alphaChanging(a);
            }
        }
    }
}
