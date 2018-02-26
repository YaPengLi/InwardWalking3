package com.silent.fiveghost.guide.views;



import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by 农民伯伯 on 2018/1/29.
 * 圆角图片
 */
@SuppressLint("AppCompatCustomView")
public class CustomImageView extends ImageView {

 public CustomImageView(Context context) {
  super(context);
 }

 public CustomImageView(Context context, @Nullable AttributeSet attrs) {
  super(context, attrs);
 }

 public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
  super(context, attrs, defStyleAttr);
 }

 @Override
 protected void onDraw(Canvas canvas) {
  super.onDraw(canvas);
     RectF rectF = new RectF();
     rectF.left=50;
     rectF.left=400;
     rectF.left=450;
     rectF.left=600;
     Paint paint = new Paint();
     canvas.drawRoundRect(rectF,10,10,paint);
 }
}