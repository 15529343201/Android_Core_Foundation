package cn.it.widgets;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

public class OtherActivity  extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//设置Activity展示的界面
		/**context:
		 *  1- 作用： 
		 *     获取系统的服务  
		 *       context.getSystemService(Context.NOTIFICATION_SERVICE);
		 *     取得系统或者项目的资源
		 *     String appName=getResources().getString(R.string.app_name);
		 *  2. 类别： 
		 *     - 组件级别的上下文，比如Activity，Service，它的生命周期与组件对象的生命周期是一致的
		 *     - 应用级别的上下文， 比如Application ，该上下文与应用的生命周期是一致的
		 *  3. 使用：
		 *     一般使用组件级别的上下文，比如控件对象构建，使用的是当前的Activity
		 *     注意： View控件使用的上下文，必须要求该控件的生命周期小于或者等于使用的上下文
		 */
		//布局中要设置layout_width和layout_height ,代码中默认设置了宽和高 wrap_content
		ImageView view=new ImageView(this);
		view.setImageResource(R.drawable.pic8);//设置图片的前景   android:src 
//		view.setBackgroundResource(resid) // android:backgroud
		setContentView(view);
	}

}
