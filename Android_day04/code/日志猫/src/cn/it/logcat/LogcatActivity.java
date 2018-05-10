package cn.it.logcat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class LogcatActivity extends Activity {

	private static final String TAG = "LogcatActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logcat);
		Log.v(TAG, "verbose");//混淆级别
		Log.d(TAG, "debug");//调试级别
		Log.i("lijun", "info");//信息级别
		Log.w(TAG, "warn");//警告级别
		Log.e(TAG, "error");//错误级别
		System.out.println("System.out.println");
		System.out.print("System.out.print");//默认输出在缓存中，需要刷缓存
		System.out.flush();//刷缓存
	}

}
