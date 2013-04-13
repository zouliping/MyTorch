package com.example.mytorch;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class CameraActivity extends Activity {

	private FlashLight flashLight;
	private ImageView img;
	private boolean isLighted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置无标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.camera_light_layout);

		flashLight = (FlashLight) findViewById(R.id.surfaceview);
		img = (ImageView) findViewById(R.id.img);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (MotionEvent.ACTION_UP == event.getAction()) {
			if (isLighted) {
				flashLight.setCameraLight(false);
				isLighted = false;
				img.setImageResource(R.drawable.off);
			} else {
				flashLight.setCameraLight(true);
				isLighted = true;
				img.setImageResource(R.drawable.camera);
			}
		}
		return super.onTouchEvent(event);
	}

}
