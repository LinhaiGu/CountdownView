package com.boohee.countdownview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

public class CountDownTextView extends android.support.v7.widget.AppCompatTextView {

    private int mDuration = 5000;
    private int mSweepAngle = 360;
    private float mStrokePadding = 4;

    private boolean mShowNumber = false;
    private boolean mShowStroke = true;

    private ValueAnimator mValueAnimator;

    private RectF mRectF = new RectF();

    private Paint mPaint;

    private ICountdownListener mICountdownListener;

    public CountDownTextView(Context context) {
        this(context, null);
    }

    public CountDownTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.CountdownStyle);
        float strokeWidth = dip2px(getContext(), 2);
        int strokeColor = Color.WHITE;
        if (typedArray != null) {
            strokeWidth = typedArray.getDimension(R.styleable.CountdownStyle_stroke_width, 2);
            strokeColor = typedArray.getColor(R.styleable.CountdownStyle_stroke_color, Color.WHITE);
            mStrokePadding = typedArray.getDimension(R.styleable.CountdownStyle_stroke_padding, 4);
            mShowStroke = typedArray.getBoolean(R.styleable.CountdownStyle_stroke_show, true);
            typedArray.recycle();
        }
        if(mShowStroke) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStrokeWidth(strokeWidth);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(strokeColor);
        }
    }

    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            mSweepAngle = (int) animation.getAnimatedValue();
            if (mShowStroke) {
                invalidate();
            }
            if (mShowNumber) {
                int duration = (mDuration - (int) (animation.getAnimatedFraction() * mDuration)) / 1000;
                setText(String.valueOf(duration));
            }
        }
    };

    private ValueAnimator.AnimatorListener mAnimatorListener = new ValueAnimator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {
            if (mICountdownListener != null) {
                mICountdownListener.start();
            }
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (mICountdownListener != null) {
                mICountdownListener.end();
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        if (mShowStroke) {
            int padding = dip2px(getContext(), mStrokePadding);
            mRectF.left = padding;
            mRectF.top = padding;
            mRectF.right = getWidth() - padding;
            mRectF.bottom = getHeight() - padding;
            canvas.drawArc(mRectF, -90, mSweepAngle, false, mPaint);
        }
        super.onDraw(canvas);
    }


    @Override
    protected void onDetachedFromWindow() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.removeUpdateListener(mAnimatorUpdateListener);
        }
        if (this.mICountdownListener != null) {
            this.mICountdownListener = null;
        }
        this.mValueAnimator = null;
        super.onDetachedFromWindow();
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //开始倒计时
    public void start() {
        if (mSweepAngle != 360) {
            return;
        }
        mValueAnimator = ValueAnimator.ofInt(mSweepAngle).setDuration(mDuration);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.addUpdateListener(mAnimatorUpdateListener);
        mValueAnimator.addListener(mAnimatorListener);
        mValueAnimator.start();
    }

    //设置倒计时时间
    public void setDuration(int duration) {
        this.mDuration = duration;
    }

    //是否显示倒计时数字
    public void showNumber(boolean show) {
        this.mShowNumber = show;
    }

    //设置倒计时开始与结束的监听
    public void setCountdownListener(ICountdownListener listener) {
        this.mICountdownListener = listener;
    }

}
