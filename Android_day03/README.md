# 事件驱动机制与高级UI控件

## 复习回顾
  1. Activity-Window-ViewGroup-View
  2. Context 上下文
  3. 监听事件

## 一、Android事件驱动机制
### 1. 事件监听器
&emsp;&emsp;一个事件监听器是View类中一个包含单一回调方法的接口。当注册了监听器的View发生了对应的监听事件时，Android框架就会回调相应的监听方法，实现与用户的交互。
### 2.常见的事件类型
#### 点击事件
```
        控件： View 
        接口： View.OnClickListener
	     实现方式：
	     1. 匿名内部类
		 2. 私有内部类
		 3. xml中设置onClick属性
		 4. Activity实现点击监听接口
```
#### 选择事件(单选、复选、下拉选择)
```
	     1. 复选 :
	        控件： CheckBox 
            接口： CompoundButton.OnCheckedChangeListener   状态改变的监听
                CompoundButton:复合按钮，它是抽象类 ，它是 CheckBox、RadioButton、ToggleButton的父类
            案例： 明密文切换  ： wifi 密码 ：显示密码和不显示密码 ****
	     2. 单选
	        控件 ： RadioGroup与RadioButton组合实现互斥
            接口：  RadioGroup.OnCheckedChangeListener
            小例子： 字符集选择
	     3. 下拉选择
	        控件 ： Spinner 
            接口： AdapterView.OnItemSelecedListener 
```
#### 触摸、长按 
```
        1. 触摸
           - 控件  View
           - 接口  View.OnTouchLisener
        2. 长按
           - 控件 ： View
           - 接口 ：View.OnLongClickListener
        小案例： 通过长按图片 设置手机壁纸 
       3. 三种监听事件的回调顺序：  触摸--》长按 ---》点击
```
#### 按键事件
```
         它是实现KeyEvent.CallBack接口 回调方法
       - onKeyDown() //按键事件
         它是Activity定义的方法
       - onBackPressed()//按下返回键
       - 小案例： 再按一次退出系统   两秒钟之内按返回键退出系统
```
    
## 二、高级UI控件
### 1.ToggleButton 
```
    开关按钮 ，它是CompundButton的子类 
    接口： CompundButton.OnCheckedChangeListener 
            开关按钮关闭、打开 状态的提示文本  
     xml属性： android:textOff=""
             android:textOn=""
    方法： toggle() :  取反
```
### 2.ProgressBar  ：进度条 
```
     setMax(10) ：设置进度的最大值
```
### 3.ScrollView   ：滚屏视图
```
    它是FrameLayout的子类，而且只能拥有一个直接的子节点（子控件），它只支持垂直滚屏
   对于水平滚屏：HorizontalScrollView  ，它是FrameLayout的子类，只支持水平滚屏

  
界面、ui控件， 布局，固定的布局
```
### 4.ListView :列表视图
```
    动态布局： 用AdapterView与Adapter展示一个动态的布局
    ListView：列表视图 ，它是AdapterView的派生类 ，是非常重要的控件，在开发中经常使用
    作用： 与Adapter展示一个结构相同的批量（动态）的数据
      - 展示列表项
      - 监听列表项
```


##  练习 ：
``` 
    选择器 (图片选择器-颜色选择器)
    进度条 
```	

## 三、选择器 
### 1. 图片选择器
```
     控件有很多种状态，依据控件的不同状态赋予相应属性不同的图片 
     其实选择器也是Drawable ，即也是图片，只是图片列表 
    注意： 选择器的文件名不能与图片名相同
```
### 2. 颜色选择器
```
    控件有很多种状态，依据控件的不同状态赋予相应属性不同的颜色值 
     其实选择器也是Color ，即也是图片，只是颜色列表 
    注意： 选择器的文件名不能与颜色属性名相同
   颜色值描述：argb ：a： alpha   r ：红    g  ：绿   b：蓝
     四种格式 ： #RGB, #ARGB, #RRGGBB or #AARRGGBB 
```
## 四 .9格式图片设置
```
    .9格式的图片，是为了解决当图片拉伸时，边角不会失真
  转换工具：
   E:\Android\adt-bundle-x86-32\sdk\tools\draw9path.bat
```


## 重点：

  1. 事件类型及监听
    
        1. 复选 :
	        控件： CheckBox 
            接口： CompoundButton.OnCheckedChangeListener   状态改变的监听
                CompoundButton:复合按钮，它是抽象类 ，它是 CheckBox、RadioButton、ToggleButton的父类
            案例： 明密文切换  ： wifi 密码 ：显示密码和不显示密码 ****
	     2. 单选
	        控件 ： RadioGroup与RadioButton组合实现互斥
            接口：  RadioGroup.OnCheckedChangeListener
            小例子： 字符集选择
	     3. 下拉选择
	        控件 ： Spinner 
            接口： AdapterView.OnItemSelecedListener 
     * 触摸、长按 
        1. 触摸
           - 控件  View
           - 接口  View.OnTouchLisener
        2. 长按
           - 控件 ： View
           - 接口 ：View.OnLongClickListener

  2. 选择器 、.9.png格式设置

  3. ListView
  

练习：
   1. ToggleButton（选择器）<br>
作业：<br>
   gridView<br>
  android:numColumns设置列数<br>

















ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"a","b","c","d","e","f"});


