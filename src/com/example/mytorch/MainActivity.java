package com.example.mytorch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button screenBtn;
	Button cameraBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initViews() {
		screenBtn = (Button) findViewById(R.id.my_screen_light);
		cameraBtn = (Button) findViewById(R.id.my_camera_light);

		screenBtn.setOnClickListener(listener);
		cameraBtn.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {
		Intent intent;

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.my_screen_light:
				intent = new Intent(MainActivity.this,ScreenLightActivity.class);
				startActivity(intent);
				break;
			case R.id.my_camera_light:
				intent = new Intent(MainActivity.this, CameraActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
	};
}
