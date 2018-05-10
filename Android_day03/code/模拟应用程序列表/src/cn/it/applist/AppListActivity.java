package cn.it.applist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class AppListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_list);
		//引用列表视图
		ListView appListView=(ListView)findViewById(R.id.app_lstView);
		/**用ListView展示结构相同的批量数据实现步骤：
		 * 1. 列表项布局
		 * 2. 初始数据  List<Map>  
		 * 3. 适配器 Adapter
		 * 4. ListView设置适配器 ，展示列表项
		 * 5. 监听列表项
		 */
		final List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		//2. 初始数据  List<Map>  
		for(int i=0;i<12;i++){
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("icon", R.drawable.emoji_054+i);
			map.put("name", "应用"+(i+1));
			map.put("size", 5);
			data.add(map);
		}
		/**3. 准备适配器  
		 *   - 用系统的Adapter  （SimpleAdapter： 简单适配器  、ArrayAdapter：数组适配器）
		 * 
		 */
		/**数组适配器  ，要求： 数据必须填充到一个TextView中  
		 * context：上下文
		 * resource： 列表项的布局的资源id ，该布局必须拥有一个TextView控件
		 * textViewResourceId :textView控件的资源id 
		 * String[] \List<String> 
		 */
//		ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//				new String[]{"a","b","c","d","e"});
		
		
		/**简单适配器 
		 * context:上下文
		 * data：要装配到列表项中的数据
		 * resource：列表项的布局的资源id
		 * from:数据从哪里来 data  从map中的相应的key中来
		 * to ：数据填充到哪个控件中去： 
		 */
		SimpleAdapter  simpleAdapter=new SimpleAdapter
				       (
						this, 
						data, 
						R.layout.app_item, 
						new String[]{"icon","name"}, 
						new int[]{R.id.icon_iv,R.id.name_tv});
		
		
		//4. ListView设置适配器 ，展示列表项
		appListView.setAdapter(simpleAdapter);
		
		//5. 监听列表项
		//点击列表项
		appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**当点击列表项时回调该方法
             * parent： ListView
             * view：当前点击的列表项视图对象
             * position：当前点击的列表项的数据在适配器中的位置
             * id： 当前点击的列表项的数据的行号 属性 
             * 
             */
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//根据位置获取当前操作的列表项的数据
				Map<String, Object> map = data.get(position);
				Toast.makeText(AppListActivity.this, map.get("name").toString()+"点击", Toast.LENGTH_SHORT).show();
				
				
				
			}
		});
		
		//长按列表项
		appListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//根据位置获取当前操作的列表项的数据
				Map<String, Object> map = data.get(position);
				Toast.makeText(AppListActivity.this, map.get("name").toString()+"长按", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
		
		
	}



}
