package com.example.chemistry.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.example.chemistry.R;

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
//    private int textSize;
//    private int textColor;


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
        strokePaint = new Paint();
        strokePaint.setAntiAlias(true);
    }

    public AtomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = width / 2;
        int y = height / 2;
        final int atomRadius = 50;
        int orbitRadius = 45;
        final int orbitDistance = 35;

        //BG
        paint.setColor(Color.TRANSPARENT);
        paint.setStrokeWidth(strokeWidth);

        //Center
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        canvas.drawCircle(x, y, atomRadius, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50f);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.anton));
        try {
            canvas.drawText(symbol, canvas.getWidth() / 2, y + 21f, paint);
        } catch (Exception e) {

        }


        //Electrons
        orbitRadius = shells.size() * 35 + atomRadius + orbitRadius - 10;
        for (int i = shells.size() - 1; i >= 0; i--) {
            int k = shells.get(i);
            int distance = orbitRadius -= orbitDistance;
            drawOrbit(x, y, distance, orbitRadius, electronRadius, k, canvas);
        }

        invalidate();
    }


    private void drawOrbit(int x, int y, int distance, int orbitRadius, int electronRadius, int i, Canvas canvas) {
        int divide = (shells.size() > 3) ? 30 : 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(strokeColor);
        canvas.drawCircle(x, y, distance, paint);
        canvas.rotate(degree++ / divide, x, y);

        for (int j = 0; j < i; j++) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(color);
            canvas.drawCircle(x, y - orbitRadius, electronRadius, paint);
            canvas.rotate(360 / i, x, y);
        }
    }


    private void GetAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.AtomView, 0, 0);
        try {
            color = typedArray.getColor(R.styleable.AtomView_color, Color.RED);
            strokeColor = typedArray.getColor(R.styleable.AtomView_strokeColor, color);
            symbol = typedArray.getString(R.styleable.AtomView_symbol);
            electronRadius = typedArray.getInt(R.styleable.AtomView_electronRadius, 10);
            strokeWidth = typedArray.getInt(R.styleable.AtomView_strokeBold, 2);
//            textSize = typedArray.getInt(R.styleable.AtomView_android_textSize, 50);
//            textColor = typedArray.getInt(R.styleable.AtomView_android_textColor, Color.BLACK);
        } finally {
            typedArray.recycle();
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        width = this.getWidth();
//        height = this.getHeight();
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
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

    public List<Integer> getShells() {
        return shells;
    }

    public void setShells(List<Integer> shells) {
        this.shells = shells;
        invalidate();
        requestLayout();
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        invalidate();
        requestLayout();
    }

    public int getElectronRadius() {
        return electronRadius;
    }

    public void setElectronRadius(int electronRadius) {
        this.electronRadius = electronRadius;
        invalidate();
        requestLayout();
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        invalidate();
        requestLayout();
    }

}
