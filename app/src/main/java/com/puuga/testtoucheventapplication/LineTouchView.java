package com.puuga.testtoucheventapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by siwaweswongcharoen on 8/28/2015 AD.
 */
public class LineTouchView extends View {

    private float mX;
    private float mY;

    Paint paint;
    Line line1;
    Line line2;
    Line line3;

    public LineTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        line1 = new Line("1", false);
        line2 = new Line("2", false);
        line3 = new Line("3", true);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mX = event.getX();
                mY = event.getY();
                invalidate();
                return true;
            }
        });
    }

    @Override
    public void onDraw(Canvas canvas) {
        line1.drawLine(canvas, mY);
        line2.drawLine(canvas, mY);
        line3.drawLine(canvas, mY);
    }

    class Line {
        String name;
        Paint paint;
        boolean isActive;
        boolean isShowValue;
        float y;
        float p;

        Line(String name, boolean isShowValue) {
            this.name = name;
            isActive = false;
            this.isShowValue = isShowValue;
            paint = new Paint();
            y = 0;
        }

        void active() {
            isActive = true;
        }

        void inactive() {
            isActive = false;
        }

        void drawLine(Canvas canvas, float y) {
            if (isActive) {
                this.y = y;
            }
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setAntiAlias(true);
            canvas.drawLine(0, this.y, canvas.getWidth(), this.y, paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(40);
            p = this.y / canvas.getHeight() * 100;
            String text = "Line" + name + ": ";
            text = isShowValue ? text.concat(p + "%") : text;
            canvas.drawText(text, 0, this.y, paint);
        }
    }


}
