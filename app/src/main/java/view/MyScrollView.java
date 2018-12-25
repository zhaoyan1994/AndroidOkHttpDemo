package view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * Created by 2FZ on 2018/9/13.
 */

public class MyScrollView extends ScrollView{

    private VelocityTracker velocityTracker; //速度计算
    private GestureDetector gestureDetector; //手势检测


    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }

        if (gestureDetector == null){
            gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent e) {
                    Toast.makeText(getContext(),"onDown()",Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public void onShowPress(MotionEvent e) {
                    Toast.makeText(getContext(),"onShowPress()",Toast.LENGTH_SHORT).show();
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    Toast.makeText(getContext(),"onSingleTapUp()",Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    Toast.makeText(getContext(),"onScroll()",Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    Toast.makeText(getContext(),"onLongPress()",Toast.LENGTH_SHORT).show();
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    Toast.makeText(getContext(),"onFling()",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            gestureDetector.setIsLongpressEnabled(false);
        }
        gestureDetector.onTouchEvent(event);

        switch(MotionEvent.ACTION_MOVE){

            case MotionEvent.ACTION_DOWN:
                if (velocityTracker == null) {
                    velocityTracker = VelocityTracker.obtain();
                } else {
                    velocityTracker.clear();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                velocityTracker.addMovement(event);
                velocityTracker.computeCurrentVelocity(1000);

                float Vx = velocityTracker.getXVelocity();
                float Vy = velocityTracker.getYVelocity();
                Log.e("Test", "Vx=" + Vx + ",Vy=" + Vy);
                if ((Vx != 0) && (Vy != 0))
//                    Toast.makeText(getContext(), "Vx=" + Vx + ",Vy=" + Vy, Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onTouchEvent(event);
    }

}
