package com.example.chemistry.api.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import java.util.List;

public class AtomView extends View {
    Paint paint = null;
    Path path = null;
    List<Integer> shells;
    String symbol;


    public AtomView(Context context) {
        super(context);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        final int atomRadius = 50;
        final int textSize = 60;
        int orbitRadius = 45;
        final int orbitDistance = 35;
        final int electronRadius = 10;

        int[] shells = {2, 8, 18, 32, 32, 18, 8, 1};
        //BG
        paint.setColor(Color.TRANSPARENT);
        paint.setStrokeWidth(2);
        canvas.drawPaint(paint);

        //Center
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawCircle(x / 2, y / 2, atomRadius, paint);
//        paint.setTextSize(textSize);
//        paint.setColor(getResources().getColor(R.color.white));
//        canvas.drawText("Mg", x / 2 - textSize / 2, y / 2 + textSize / 3, paint);


        //Electrons
        for (int i : shells) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLACK);
            canvas.drawCircle(x / 2, y / 2, orbitRadius += orbitDistance, paint);
//            canvas.rotate(90, x / 2, y / 2);
            for (int j = 0; j < i; j++) {
                paint.setColor(Color.RED);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(x / 2, y / 2 - orbitRadius, electronRadius, paint);
                canvas.rotate(360 / i, x / 2, y / 2);
                invalidate();
            }
        }

    }

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable update = new Runnable() {
        public void run() {
            invalidate();
            handler.postDelayed(this, 500);
        }
    };


    public List<Integer> getShells() {
        return shells;
    }

    public void setShells(List<Integer> shells) {
        this.shells = shells;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
