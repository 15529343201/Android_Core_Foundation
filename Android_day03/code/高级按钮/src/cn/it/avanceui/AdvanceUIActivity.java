package cn.it.avanceui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AdvanceUIActivity extends Activity {
	private ToggleButton mVoiceToggleButton;
	private ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advance_ui);
		
		mVoiceToggleButton=(ToggleButton)findViewById(R.id.voice_tb);
		mVoiceToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			/** 当开关按钮状态发生改变时，回调该方法
			 * buttonView:ToggleButton
			 * isChecked: 开关按钮的状态 
			 */
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), isChecked?"声音开":"声音关", 0).show(); 
			}
		});
		
		//引用布局的进度条对象
		mProgressBar=(ProgressBar)findViewById(R.id.progressbar2);
		mProgressBar.setMax(10);//该进度的最大值是10  当前进度  5
	}
	
	//通过文本框TextView 设置点击监听事件
	public void setVoice(View view){
		//对开关按钮取反
		mVoiceToggleButton.toggle();//取反
	}
	
	//增加进度 
	public void add(View v){
		//取得当前的进度
		int currentProcess=mProgressBar.getProgress();
		//设置进度值
		mProgressBar.setProgress(currentProcess+1);
		
	}


}
