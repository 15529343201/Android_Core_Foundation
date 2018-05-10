package cn.it.dialog.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast的工具类
 * @author Administrator
 *
 */
public class ToastUtil {
	public static void show(Context context ,String text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
	public static void show(Context context ,int textResId){
		Toast.makeText(context, textResId, Toast.LENGTH_SHORT).show();
	}

}
