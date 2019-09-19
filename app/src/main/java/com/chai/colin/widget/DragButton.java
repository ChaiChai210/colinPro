package com.chai.colin.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;

@SuppressLint("AppCompatCustomView")
public class DragButton extends ImageButton {
    private Context mContext;
    private boolean isDrag;
    private float lastX;
    private float lastY;
    private float parentHeight;
    private float parentWidth;

    public DragButton(Context context) {
        this(context, null);
    }

    public DragButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

    }

    private boolean isNotDrag() {
        return (!isDrag) && ((getX() == 0f) || (getX() == parentWidth - getWidth()));
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (getParent() != null) {
            parentHeight = ((ViewGroup) getParent()).getHeight();
            parentWidth = ((ViewGroup) getParent()).getWidth();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int f4 = (int) event.getRawX();
        int f5 = (int) event.getRawY();
        boolean flag = true;
        float f2 = 0.0F;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                setPressed(true);
                isDrag = false;
                getParent().requestDisallowInterceptTouchEvent(true);
                this.lastX = f4;
                this.lastY = f5;

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                float dx = f4 - this.lastX;
                float dy = f5 - this.lastY;
                double d = Math.sqrt(dx * dx + dy * dy);
                if (d > 10.0D) {
                    float f3 = dx + getX();
                    if (f3 < 0.0F) {
                        dx = 0.0F;
                    } else {
                        dx = f3;
                        if (f3 > this.parentWidth - getWidth())
                            dx = this.parentWidth - getWidth();
                    }
                    if (getY() >= 0.0F) {
                        if (getY() + getHeight() > parentHeight)
                            f2 = parentHeight - getHeight();
                        else
                            f2 = dy + getY();
                    }
                    setX(dx);
                    setY(f2);
                    this.lastX = f4;
                    this.lastY = f5;
                } else {
                    isDrag = false;
                }

                break;
            }
            case MotionEvent.ACTION_UP:
                if (!isNotDrag()) {
                    setPressed(false);
                    if (f4 >= this.parentWidth / 2.0F) {
                        animate().setInterpolator(new DecelerateInterpolator()).setDuration(500L).xBy(this.parentWidth - getWidth() - getX()).start();
                    } else {
                        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "x", getX(), 0.0F);
                        animator.setInterpolator(new DecelerateInterpolator());
                        animator.setDuration(500L);
                        animator.start();
                    }
                }
                break;

        }
        if (isNotDrag()) {
            if (super.onTouchEvent(event)) {
                return true;
            }
            flag = false;
        }
        return flag;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
