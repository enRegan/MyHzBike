package wdx.com.myhzbike.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import butterknife.OnClick;
import wdx.com.myhzbike.R;
import wdx.com.myhzbike.utils.MyLogUtil;

/**
 * Created by Administrator on 2016/12/19.
 */
public class OclockView extends View{
    Oclock oclock;

    public OclockView(Context context) {
        super(context);
    }
    public OclockView(Context context, Oclock oclock) {
        super(context);
        this.oclock = oclock;
    }
    public OclockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint ciclePaint = new Paint();
        ciclePaint.setAntiAlias(true);
        ciclePaint.setStyle(Paint.Style.STROKE);
        ciclePaint.setStrokeWidth(3);
        ciclePaint.setColor(getResources().getColor(R.color.oclock_cicle));
        float centerX = 500;
        float centerY = 500;
        float inRadius = 250;
        float lenght = 50;
        float outRadius = inRadius + lenght;

        canvas.drawCircle(centerX, centerY, inRadius - 50, ciclePaint);

        ciclePaint.setStrokeWidth(5);
        float startX = centerX;
        float stopX = centerX;
        float startY = centerY - inRadius;
        float stopY = centerY - outRadius;
        float degreeX = 0;
        float degreeY = 0;
        int count = 180;
        for(int i = 0; i < count; i++){
            degreeX = (float)Math.sin(Math.toRadians(i * (360 / count)));
            degreeY = (float)Math.cos(Math.toRadians(i * (360 / count)));
            startX = startX + (inRadius * degreeX);
            stopX = stopX + (outRadius * degreeX);
            startY = startY + (inRadius - inRadius * degreeY);
            stopY = stopY + (outRadius - outRadius * degreeY);
            canvas.drawLine(startX, startY, stopX, stopY, ciclePaint);
            MyLogUtil.LogD("wdx", " startX : " + startX);
            MyLogUtil.LogD("wdx", " stopX : " + stopX);
            MyLogUtil.LogD("wdx", " startY : " + startY);
            MyLogUtil.LogD("wdx", " stopY : " + stopY);
            MyLogUtil.LogD("wdx", " degreeX : " + degreeX);
            MyLogUtil.LogD("wdx", " degreeY : " + degreeY);
            MyLogUtil.LogD("wdx", " \n");

            startX = centerX;
            stopX = centerX;
            startY = centerY - inRadius;
            stopY = centerY - outRadius;
//            degreeX = 0;
//            degreeY = 0;
//            canvas.rotate(1);
        }

    }

}
