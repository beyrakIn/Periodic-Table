package com.example.chemistry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

public class AtomView extends View {
    private Path path;
    private Paint paint;
    private Paint strokePaint;
    // Var
    private int width;
    private int height;
    private float degree = 10f;
    private List<Integer> shells;
    private String symbol;
    private int color;
    private int strokeColor;
    private int electronRadius;
    private int strokeWidth;


    public AtomView(Context context) {
        super(context);
        path = new Path();
        paint = new Paint();
        paint.setAntiAlias(true);
        strokePaint = new Paint();
        strokePaint.setAntiAlias(true);
    }

    public AtomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        GetAttributes(attrs);
        path = new Path();
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public AtomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void GetAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.AtomView, 0, 0);
        try {
            color = typedArray.getColor(R.styleable.AtomView_color, Color.RED);
            strokeColor = typedArray.getColor(R.styleable.AtomView_strokeColor, Color.BLACK);
            symbol = typedArray.getString(R.styleable.AtomView_symbol);
            electronRadius = typedArray.getInt(R.styleable.AtomView_electronRadius, 10);
            strokeWidth = typedArray.getInt(R.styleable.AtomView_strokeBold, 2);
        } finally {
            typedArray.recycle();
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        invalidate();
        requestLayout();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = this.getWidth();
        height = this.getHeight();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        final int atomRadius = 50;
        final int textSize = 60;
        int orbitRadius = 45;
        final int orbitDistance = 35;

        int[] shells = {2, 8, 18, 19, 9, 2};
        //BG
        paint.setColor(Color.TRANSPARENT);
        paint.setStrokeWidth(strokeWidth);

        //Center
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        canvas.drawCircle(x, y, atomRadius, paint);
//        paint.setColor(Color.BLACK);
//        paint.setTextSize(50f);
//        canvas.drawText("Mg", x - 25f, y + 25f, paint);

        //Electrons
        for (int i : shells) {
            int distance = orbitRadius += orbitDistance;
            drawOrbit(x, y, distance, orbitRadius, electronRadius, i, canvas);
        }

        invalidate();
    }

    private void drawOrbit(int x, int y, int distance, int orbitRadius, int electronRadius, int i, Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(strokeColor);
        canvas.drawCircle(x, y, distance, paint);
        canvas.rotate(degree++ / 10, x, y);

        for (int j = 0; j < i; j++) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(color);
            canvas.drawCircle(x, y - orbitRadius, electronRadius, paint);
            canvas.rotate(360 / i, x, y);
        }
    }


}
