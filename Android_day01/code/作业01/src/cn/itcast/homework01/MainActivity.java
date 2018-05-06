package cn.itcast.homework01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText mNumberEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mNumberEditText=(EditText)findViewById(R.id.number_et);
	}
	//View ：当前点击的视图控件
	public void onclick(View v){
		String telNumber=mNumberEditText.getText().toString().trim();//取得已经输入的电话号码
		Button btn=(Button)v;//强制转为Button
		String sysbom=btn.getText().toString().trim();//取得按下去的数字
		telNumber=telNumber+sysbom;
		mNumberEditText.setText(telNumber);//重新信息编辑框的内容
		mNumberEditText.setSelection(telNumber.length());//设置输入光标的位置
	}
	//删除字符
	public void delete(View v){
		String telNumber=mNumberEditText.getText().toString().trim();//取得已经输入的电话号码
		telNumber=telNumber.substring(0, telNumber.length()-1);
		mNumberEditText.setText(telNumber);//重新信息编辑框的内容
		mNumberEditText.setSelection(telNumber.length());//设置输入光标的位置
	}
	//呼叫
	public void call(View v){
		String telNumber=mNumberEditText.getText().toString().trim();//取得已经输入的电话号码
		Intent intent=new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel://"+telNumber));
		startActivity(intent);
	}

}
