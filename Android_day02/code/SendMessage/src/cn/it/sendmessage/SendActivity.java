package cn.it.sendmessage;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
		//通过findViewById引用布局中的相应控件对象
		final EditText numberEditText=(EditText)this.findViewById(R.id.number_et);
		final EditText bodyEditText=(EditText)findViewById(R.id.body_et);
		Button sendButton=(Button)findViewById(R.id.send_btn);
		//设置点击监听，通过匿名内部类的形式来实现
		sendButton.setOnClickListener(new View.OnClickListener() {
			/**点击该控件，回调该方法
			 * 事件：点击事件
			 * v：点击的控件
			 */
			@Override
			public void onClick(View v) {
				//发送短信
				String number=numberEditText.getText().toString().trim();//取得用户输入的电话号码
				String body=bodyEditText.getText().toString(); //取得短信内容
				SmsManager smsManager=SmsManager.getDefault();//取得短信管理器
				/**发简单文本短信
				 * destinationAddress：目标地址：发给谁
				 * scAddress：来源地址：谁发的
				 * text:要发的信息体
				 * sentIntent： 发送广播意图 ，返回的是发送状态
				 * deliveryIntent：分销广播意图 ：返回的是分销的状态
				 */
				smsManager.sendTextMessage(number, null, body, null, null);
				//发短信要钱  ，流量    ，要权限， 使用系统的某个功能，android定义了权限
//				Manifest.permission.SEND_SMS //查询使用某些功能权限
			}
		});
		
	}


}
