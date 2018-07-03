package integration.google.sunder.surfaceviewcamerapreview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        @SuppressLint("DrawAllocation")
        Bitmap _scratch = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(_scratch, canvas.getWidth()/2, canvas.getHeight()/2, null);


    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas(null);
            synchronized (holder) {
                onDraw(canvas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

}
