package cn.it.dialog;

import android.R.anim;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import cn.it.dialog.util.ToastUtil;

public class DialogActivity extends Activity implements View.OnClickListener {
	private Context context;
	private DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
		/**当点击了对话框的确定按钮，则回调该方法
		 * dialog： AlertDialog
		 * which：你点了哪一个按钮
		 */
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case -2:
				ToastUtil.show(context, "取消");
				break;
			case -1:
				ToastUtil.show(context, "确定");
				break;

			default:
				break;
			}
			
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
		context=this;
		
		//通过父控件来引用子控件，再绑定点击监听事件
		RelativeLayout layout=(RelativeLayout) findViewById(R.id.layout);
		int size=layout.getChildCount();//取得子节点的数量
		for(int i=0;i<size;i++){
			View childView = layout.getChildAt(i);
			//设置点击监听事件
			childView.setOnClickListener(this);
		}
		
//		
//		Button dialogButton=(Button)findViewById(R.id.normal_btn);
//		dialogButton.setOnClickListener(this);
//		//菜单对话框
//		dialogButton=(Button)findViewById(R.id.menu_btn);
//		dialogButton.setOnClickListener(this);
//		//复合对话框
//		dialogButton=(Button)findViewById(R.id.mul_btn);
//		dialogButton.setOnClickListener(this);
//		//自定义对话框
//		dialogButton=(Button)findViewById(R.id.diy_btn);
//		dialogButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog, menu);
		return true;
	}
   
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.normal_btn://显示标准对话框
			normalDialog();
			break;
		case R.id.menu_btn://显示菜单式对话框
			menuDialog();
			break;
		case R.id.mul_btn://显示复选对话框
			multiDialog();
			break;
		case R.id.diy_btn:
			diyDialog();//显示自定义对话框
			
			break;

		default:
			break;
		}
		
	}
	//显示自定义对话框
	
	private void diyDialog() {
		/**自定义对话框实现步骤：
		 * 1.xml来设置对话框界面
		 * 2. 构建一个对话框，并且设置自定义对话框界面
		 * 3. 获取 类别编辑框和 确定按钮
		 * 4. 对确定按钮添加点击事件监听，当点击按钮时，获取到用户输入的类别信息
		 */
		//构建一个对话框 ,默认会添加一个主题
//		final Dialog dialog=new Dialog(context,android.R.style.Theme_Dialog);
//		final Dialog dialog=new Dialog(context);
		final Dialog dialog=new Dialog(context,R.style.MyDialogTheme);
//		View dialogView = LayoutInflater.from(context).inflate(R.layout.diy_dialog, null);
		//设置对话框的内容视图       构建一个对话框，并且设置自定义对话框界面
		dialog.setContentView(R.layout.diy_dialog);
//		dialog.setContentView(dialogView);
		//通过父控件引用子控件
//		dialogView.findViewById(R.id.type_et);
		final EditText typeEdt=(EditText) dialog.findViewById(R.id.type_et);
		Button okBtn=(Button)dialog.findViewById(R.id.ok_btn);
		//设置点击监听事件
		okBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String type = typeEdt.getText().toString().trim();
				dialog.dismiss();//消失，解雇 ，dialog显示要依赖Activtiy
				ToastUtil.show(context, type);
			}
		});
		dialog.show();//显示对话框
	}

	//显示复选对话框
	private void multiDialog() {
//		  final String[] versions = getResources().getStringArray(R.array.android_versions);
		   //链式编程
		   new AlertDialog.Builder(context)
		   .setIcon(R.drawable.emoji_099)
		   .setTitle("复选对话框")
		   /**设置复选项
		    *itemsId：复选项的资源id
		    * checkedItems： 复选项的初始值   可以设置null ，即所有的复选项默认为false  ， 也可以具体设置值，但是必须与复选项的长度对应
		    */
		   .setMultiChoiceItems(R.array.android_versions,  new boolean[]{true,true,false,false,false,false,false}, 
				   new DialogInterface.OnMultiChoiceClickListener() {
					/**当点击复选项时回调该方法
					 * dialog： AlertDialog
					 * which ：你点击了哪一个复选项，好比复选项数据在装配中的数据的位置 position
					 * isChecked：当前操作的复选项的状态
					 */
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						AlertDialog alertDialog=(AlertDialog) dialog;
						
//						String itemStr=versions[which];
						
						//复选对话框的复选项是由ListView来实现的  ，通过ListView获取adapter，再通过适配器来获取数据
						String itemStr=alertDialog.getListView().getAdapter().getItem(which).toString();
						
						ToastUtil.show(context, itemStr+isChecked);
					}
				})
				.setPositiveButton(R.string.perform, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
                        //当点击复选对话框的确定按钮，则应该获取所有的复选项
						//取得复选框的ListView
						AlertDialog alertDialog=(AlertDialog) dialog;
						ListView listView = alertDialog.getListView();
						//通过listView取得稀疏布尔数组
						SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
						/**SparseBooleanArray：好比hashmap ：key(integer:position)  value(boolean:复选项的状态)
						 * 遍历稀疏布尔数组  
						 */
						int size = checkedItemPositions.size();
						StringBuilder sb=new StringBuilder("");
						for(int i=0;i<size;i++){
							if(checkedItemPositions.valueAt(i)){
								//依据保存的位置position来获取复选项复选文本
								int position=checkedItemPositions.keyAt(i);
								String selectStr = listView.getAdapter().getItem(position).toString();
								sb.append(selectStr);
							}
						}
						ToastUtil.show(context, sb.toString());
					}
				})
				.setNegativeButton(R.string.cancel, null)
		   .create()
		   .show();
	}
// 显示菜单式对话框
   private void menuDialog() {
	   //通过数组资源id获取数组
//	   getString(resId)
//	   getResources().getString(id)
	   final String[] versions = getResources().getStringArray(R.array.android_versions);
	   
	   //链式编程
	   new AlertDialog.Builder(context)
	   .setIcon(R.drawable.emoji_062)
	   .setTitle("菜单对话框")
	   .setItems(R.array.android_versions, new DialogInterface.OnClickListener() {
		/**当点击对话框的item项时，回调该方法
		 * which：点击了哪一个条目，哪一个项，哪一个菜单 
		 */
		@Override
		public void onClick(DialogInterface dialog, int which) {
			ToastUtil.show(context, versions[which]);
		}
	   })
	   .create()
	   .show();
		
	}

	//显示标准对话框
	private void normalDialog() {
		// 采用工程设计模式 ,创建一个对话框的构建器
		AlertDialog.Builder builder=new AlertDialog.Builder(context);
		builder.setIcon(R.drawable.emoji_059);//设置对话框图标
		builder.setTitle("标准对话框");//设置标题
		builder.setMessage("你什么时候还钱");//设置消息
		builder.setCancelable(false);//设置是否可以中断对话框 ,即点击Activity的其他界面，而不显示对话框
		builder.setPositiveButton(R.string.perform,listener);//设置积极的按钮 ，即确定按钮
		builder.setNegativeButton(R.string.cancel, listener);//取消按钮
		AlertDialog dialog = builder.create();//创建对话框
		dialog.show();//显示对话框
	}

}
