package com.example.mytorch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class ScreenLightActivity extends Activity {

	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// �����ޱ���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.screen_light_layout);

		layout = (LinearLayout) findViewById(R.id.screen_layout);
		layout.setBackgroundColor(0xffffff);
		
		android.view.WindowManager.LayoutParams params = getWindow().getAttributes();
		params.screenBrightness = 1.0f;//�����������
		getWindow().setAttributes(params);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //������Ļ����
	}

}
