package com.example.mytorch;

import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class FlashLight extends SurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder surfaceHolder;
	private Camera camera;
	private Camera.Parameters parameters;

	public FlashLight(Context context, AttributeSet attrs) {
		super(context, attrs);
		surfaceHolder = this.getHolder();
		surfaceHolder.addCallback(this);
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		parameters = camera.getParameters();
		if (parameters != null)
			parameters.setPictureFormat(PixelFormat.JPEG);
		List<Camera.Size> sizeList = parameters.getSupportedPreviewSizes();
		Iterator<Camera.Size> iterator = sizeList.iterator();
		while (iterator.hasNext()) {
			Camera.Size cur = iterator.next();
			Log.i("size", cur.width + " " + cur.height);
		}
		parameters.setPreviewSize(800, 480);
		parameters.setPictureSize(800, 480);
		camera.setParameters(parameters);
		camera.startPreview();
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		try {
			camera = Camera.open();
			camera.setPreviewDisplay(surfaceHolder);
		} catch (Exception e) {
			if (camera != null)
				camera.release();
			camera = null;
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		if (camera == null)
			return;
		camera.stopPreview();
		camera.release();
		camera = null;
	}

	/**
	 * 设置手电筒的开关状态
	 * 
	 * @param isOn
	 */
	public void setCameraLight(boolean isOn) {
		if (camera == null)
			return;
		if (parameters == null)
			parameters = camera.getParameters();
		if (isOn)
			parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
		else
			parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
		camera.setParameters(parameters);
	}
}
