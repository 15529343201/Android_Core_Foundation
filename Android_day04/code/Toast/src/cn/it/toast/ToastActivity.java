package cn.it.toast;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity {
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast);
		context = this;
	}

	// 代码自定义吐司界面
	public void byCode(View v) {
		// 构建一个吐司
		Toast toast = new Toast(context);

		// 准备一个布局
		LinearLayout layout = new LinearLayout(context);
		// 默认的宽和高，可以自己设置宽和高
		// ViewGroup.LayoutParams layoutParams=new
		// ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
		// LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layout.setLayoutParams(layoutParams);// 设置布局参数，宽和高
		layout.setOrientation(LinearLayout.HORIZONTAL);// 设置方向
		layout.setBackgroundResource(R.drawable.bg_yellow);// 设置背景
		ImageView imageView = new ImageView(context);
		// 对于代码可以不设置宽和高 ，默认的宽和高 wrap_content
		imageView.setImageResource(R.drawable.btn_up_normal);// 设置ImageView前景图片

		// 把ImageView添加到布局中
		layout.addView(imageView);

		// 构建一个textView
		TextView textView = new TextView(context);
		textView.setText("天津爆炸");
		textView.setTextSize(20);

		layout.addView(textView);
		// 在父控件中把子控件移除
		// layout.removeView(imageView);
		toast.setView(layout);// 设置toast的显示界面视图
		/**
		 * 设置位置 gravity:位置 xOffset： x方向的偏移量 yOffset： y方向的偏移量
		 */
		toast.setGravity(Gravity.TOP | Gravity.CLIP_HORIZONTAL, -50, 80);
		toast.setDuration(Toast.LENGTH_SHORT);// 设置消息的显示持续时间
		toast.show();// 显示吐司
	}
	// xml自定义吐司界面
	public void ByXml(View v) {
		// 构建一个吐司
		Toast toast = new Toast(context);
		/**
		 * View是来自xml转换的View对象
		 * 1.准备xml文件
		 * 2. 把xml文件转换为View对象 
		 * 
		 */
		/**LayoutInflater：把布局xml文件实例化为View对象，好比打气筒的形式，逐步把布局转为为具有层次性的View对象
		 * resource：要转换的xml布局的资源id
		 * root：转换后的布局对象是否要假如到父控件中
		 * attachToRoot: 是否把xml转换的View对象添加到root父控件中
		    root： 
		         1.布局 （线性、相对、帧等）
		         2. AdapterView 它也是一个容器，也可以作为父控件，但是它的子控件通过Adapter来装配,不是通过addView的方式来添加子控件
		            而LayoutInflate 添加到父控件中，是采用addView的方式添加的
		 * return:假如有父控件，则返回父控件
                                     假如父控件为空，则返回转换的xml的根节点对象
		 * 
		 */
		View layoutView=LayoutInflater.from(context).inflate(R.layout.toast, null);
//		View layoutView=LayoutInflater.from(context).inflate(resource, ListView, true);
//		View layoutView=LayoutInflater.from(context).inflate(resource, root,false);
//		View layoutView=LayoutInflater.from(context).inflate(resource, null);
//		this.getLayoutInflater().inflate(resource, root);
//		View.inflate(context, resource, root)
		
		//通过父控件来引用子控件
		
		ImageView iconIv=(ImageView) layoutView.findViewById(R.id.icon_iv);
		iconIv.setImageResource(R.drawable.mood_photo);
		
//		TextView titleTv=(TextView)ToastActivity.this.findViewById(R.id.title_tv);//为空指针异常，因为Activity关联的布局没有该控件
		TextView titleTv=(TextView)layoutView.findViewById(R.id.title_tv);
		titleTv.setText("底层开发！");
		
		toast.setView(layoutView);
		
		toast.setGravity(Gravity.TOP | Gravity.CLIP_HORIZONTAL, -50, 80);
		toast.setDuration(Toast.LENGTH_SHORT);// 设置消息的显示持续时间
		toast.show();// 显示吐司
	}
}
