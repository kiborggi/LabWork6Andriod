package com.example.labwork6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View{
        Paint p;
        RectF rectF;
        Rect rect;
        float[] points;
        float[] star;
        float[] points1;
        StringBuilder stringBuilder;

        public DrawView(Context context) {
            super(context);
            stringBuilder = new StringBuilder();
            p = new Paint();
            rectF = new RectF(700,100,800,150);
            rect = new Rect(500,600,600,700);
            star = new float[]{900,980,930,870};
            points = new float[]{100,50,150,100,150,200,50,200,50,100};
            points1 = new float[]{300,200,600,200,300,300,600,300,400,100,400,400,500,100,500,400};
        }

        @Override
        protected void onDraw(Canvas canvas){
            canvas.drawARGB(80,102,204,255);

            p.setColor(Color.RED);
            p.setStrokeWidth(10);
            canvas.drawPoints(points,p);
            canvas.drawLines(points1,p);

            p.setColor(Color.GREEN);

            canvas.drawRoundRect(rectF,20,20,p);

            rectF.offset(0,150);
            canvas.drawOval(rectF,p);

            rectF.offsetTo(900,100);
            rectF.inset(0,-25);

            canvas.drawArc(rectF,90,270,true,p);

            rectF.offset(0,150);

            canvas.drawArc(rectF,90,270,false,p);

            p.setStrokeWidth(5);

            canvas.drawLine(150,450,150,600,p);

            p.setColor(Color.BLUE);

            p.setTextSize(50);

            canvas.drawText("left",150,500,p);

            p.setTextAlign(Paint.Align.CENTER);

            canvas.drawText("center",150,525,p);

            p.setTextAlign(Paint.Align.RIGHT);

            canvas.drawText("right",150,550,p);

            canvas.drawText("width = " + canvas.getWidth() + " height = " + canvas.getHeight(),
                    900,900,p);

            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect,p);
            rect.offset(140,0);

            p.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rect,p);
            rect.offset(140,0);

            p.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(rect,p);
            rect.offset(140,0);

            canvas.drawLines(star,p);

        }
    }
}