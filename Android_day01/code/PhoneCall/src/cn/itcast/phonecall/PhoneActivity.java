package cn.itcast.phonecall;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends Activity {
    // Activity的生命周期方法， 当Activity实例创建的时候会回调该方法
	@Override
	protected void onCreate(Bundle savedInstanceState) {     
		super.onCreate(savedInstanceState);
		 /**Activity作用：
		  *   展示界面-与用户交互
		  * 设置Activity要展示的内容视图  
		  *  通过该方法，把布局中描述的控件View会转换为视图对象
		  */
		setContentView(R.layout.activity_phone);
		
		//电话呼叫功能， 调用系统的打电话的应用CallActivity 实现功能   男  女  人
		//findViewById方法 ，通过控件的id来引用 子控件     findViewById是View的方法
		final EditText numberEditText=(EditText)this.findViewById(R.id.number_et);
		//对该控件监听,点击事件的监听
		Button callButton=(Button)findViewById(R.id.call_btn);
//		String number=numberEditText.getText().toString().trim();//取得用户输入的电话号码
		callButton.setOnClickListener(new View.OnClickListener() {
			 //当点击了呼叫Button，则android框架会回调该方法 ，实现与用户的交互
			@Override
			public void onClick(View v) {
				// 打电话
				String number=numberEditText.getText().toString().trim();//取得用户输入的电话号码
				//调用系统的应用 实现电话呼叫
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_CALL);//设置动作
				intent.setData(Uri.parse("tel:"+number));//设置要传递的数据 uri格式的数据 同意资源标识符 url
				intent.addCategory(Intent.CATEGORY_DEFAULT);//添加类别
				startActivity(intent);//执行意图
			}
		});
		
	}

}
