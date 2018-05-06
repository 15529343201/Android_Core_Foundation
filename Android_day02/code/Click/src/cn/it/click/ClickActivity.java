package cn.it.click;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ClickActivity extends Activity implements View.OnClickListener{
	private MyOnClickListener myOnClickListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_click);
		
		myOnClickListener=new MyOnClickListener();
		/**点击事件的四种实现方式
		 * 1. 匿名内部类
		 * 2. 私有类
		 * 3. activity实现接口 View.OnClickListener
		 * 4. xml 中设置 onClick 属性
		 * 
		 */
		//1.匿名内部类
		Button anonymousBtn=(Button)findViewById(R.id.anonymous_btn);
		anonymousBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/**吐司 ： 瞬时显示提示信息
				 * Context：上下文
				 * text：提示的文本
				 * duration ：信息的显示时间多久  long ：3.5秒  short 2秒
				 */
				Toast.makeText(ClickActivity.this, "匿名类",Toast.LENGTH_SHORT).show();
			}
		});
		
		//2. 私有类
		Button innerBtn=(Button)findViewById(R.id.inner_btn);
//		innerBtn.setOnClickListener(new MyOnClickListener());
		innerBtn.setOnClickListener(myOnClickListener);
		
		//3. activity实现接口 View.OnClickListener
		Button activityBtn=(Button)findViewById(R.id.activity_btn);
		activityBtn.setOnClickListener(this);
		Button xmlBtn=(Button)findViewById(R.id.xml_btn);
		xmlBtn.setOnClickListener(this);
		
		
	}
	
	//2.  私有类
	private class MyOnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "私有类",Toast.LENGTH_SHORT).show();
		}
		
	}
    //3.activity实现接口 View.OnClickListener
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.activity_btn:
			Toast.makeText(getApplicationContext(), "Activity实现接口",Toast.LENGTH_SHORT).show();
			break;
		case R.id.xml_btn:
			Toast.makeText(getApplicationContext(), "xml实现接口+activity",Toast.LENGTH_SHORT).show();

		default:
			break;
		}
	}
	
	/**
	 * xml 中设置 onClick 属性 :点击事件 。传递该控件
	 *  要求： 1. 方法必须是public ，方法名必须与xml的android:onClick 相同， 且要带 View参数
	 *       2. 假如该控件又设置监听器，则 只回调监听器的相应的方法，而void byXml(View v) 方法则不回调
	 *       3. 不是所有的控件都支持android:onClcik 属性，比如TextView默认不支持android:onClcik 属性 
	 *            如何解决： android:clickable="true"
	 */
	public void byXml(View v){
		
		Toast.makeText(getApplicationContext(), "xml",Toast.LENGTH_SHORT).show();
		
		
	}
	public void clickTextView(View v){
		Toast.makeText(getApplicationContext(), "TextView",Toast.LENGTH_SHORT).show();
		
	}
	

}
