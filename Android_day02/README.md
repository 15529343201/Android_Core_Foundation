# 布局管理与事件驱动机制
www.github.com //开源框架  xutils - smartImageView -afinal  
## 一、Activity、Window、View、ViewGroup关系
### 1. Activity
&emsp;&emsp;Activity android的四大组件之一，唯一能展示界面的组件，用于展示一个与用户交互的界面，它遵循MVC模式 ，Activity扮演Controller 控制器角色<br>
- 展示界面  ：通过内部Widnow.setContentView()展示
- 交互 ： View捕获事件，由WindowManger传递消息（控件，事件的类型），android框架再回调Activity的相应方式，实现与用户的交互
### 2. Window
&emsp;&emsp;Window是Android中的窗口，表示顶级窗口，也就是主窗口，每一个主窗口都拥有一个View，称之为DecorView(装饰视图)，它是主窗口的顶级View(DecorView必须是一个布局容器，因为它要容纳其它的View)。 当Activtity调用setContentView()时，实际就是调用Window对象的setContentView()方法，执行该方法，把用户定义的View添加到DecorView中，最终完成对View的展示。<br>
### 3. View
&emsp;&emsp;视图，是用户接口组件的基本构建块，它在屏幕中占用一个矩形区域，它是所有UI控件的基类，如一个按钮或文本框。View负责图形界面渲染及事件处理，Android为我们提供了一系列的标准UI控件供我们直接使用，同时，我们也可以通过继承于View或View的子类，来实现自定义控件<br>
&emsp;&emsp;对View常用的操作:<br>
```
Set properties       设置属性  
Set focus            设置焦点
Set listeners        设置监听（点击、长按、触摸）
Set visibility       设置是否可见
        visible： 可见
        invisible：不可见，但是分配空间
        gone： 不可以，不分配空间，但是还存在的
```
### 4. ViewGroup
&emsp;&emsp;ViewGroup：视图组，它是特殊的View，能够容纳其他的View(子控件),分为:<br>
- 1.布局：界面布局
- 2.特殊的容器，特殊的功能

```
ViewPager
ViewGroup常用的方法
       addView(): 向视图组添加View
       removeView():从视图组移去View
       getChildCount：获得视图组子控件的数量
       getChildAt()  : 获得具体某个子控件
```
## 二、常用系统UI控件
### 1. 有layout与无layout属性修饰
- 有layout，它是布局属性的修饰，参照的是其他的控件或者父控件
- 没有layout，它是对本身内部的元素的属性修饰

```
    layout_gravity
    gravity
```
## 三、布局
### 1.  布局的实现方式 
- xml方式

```java
    设置xml界面
		attribute ：属性  id 、属性等
        gravity ：位置, 上下左右中
        size，margin，padding ：大小 50dp 、外边距、内边距
    加载xml布局文件
        Activity.setContentView(layoutResId)
```
- 代码方式

```Java
    ImageView view=new ImageView(this);
	view.setImageResource(R.drawable.pic8);//设置图片的前景   android:src 
	//view.setBackgroundResource(resid) // android:backgroud
	setContentView(view);
```

### 2.  布局的两种类型
      * common layout :通用布局 ，静态布局
         以唯一的方式来显示潜入到该布局中的子控件，一般用于前期可以确定的界面设置
        线性、相对、帧布局、 表格、网格、webView ：web视图
      * building layout by adapter ：动态构建布局
         前期不能确定界面
       实现 ： AdapterView（适配器视图）与Adapter组合展示一个动态的布局，它设计也是遵循mvc模式
          V: AdapterView ：它的子类： ListView、GridView、Spinner 
              展示界面，监听列表项
          C： Adapter： 装配数据，装配布局，数据一般从数据库或者网络中来
          Model ： List<Contact> 
                   List<Map>  key1=id   key2=name  key3=icon
           
## 四、常用布局

   1.LinearLayout 
      以单一的行或者列来排列子控件，具有方向性，子控件不能重叠，可以设置权重
      - 假如设置的水平方向，则子控件位置不能水平位置调整，应该按水平方向顺序排列，但可以设置垂直方向的位置：上、下、垂直中
      - 假如设置的垂直方向，则子控件位置不能垂直位置调整，应该按水平方向顺序排列，但可以设置水平方向的位置： 左、水平中、右
    
　　*　权重
     它是线性布局或者它的子类所特有的属性修饰，它针对的是子控件的宽和高的设置先预留出没有设置权重的控件的宽或者高，之后对相对于父控件剩余的空间(宽或者高)按权重(比例)分配
	    1. 权重是分配宽度还是高度依据的是直接父控件的方向，水平方向分配的是宽，垂直是高
	    2. 假如设置了权重，则该控件的宽或者高设置0dp 
    
   2.FrameLayout ：帧布局 ，好比gif动画
       帧布局被设计成在一个屏幕区域显示一个单一的项(single item)。通常FrameLayout显示一个单一的子控件，它支持的布局属性不够丰富，一般通过layout_gravity来设置子控件的位置。FrameLayout的子控件被绘制在一个堆栈中，最近添加进来的子控件在堆栈的顶部
         - 子控件移进与移出非常便捷、迅速
         - 布局属性不够丰富、一般用layout_gravity
         - 一般只拥有一个直接子控件（布局），子控件可以重叠
   3.RelativeLayout
     最灵活的，最建议使用的，业界采用最多的布局
     子控件的位置关系可以通过子控件与父控件、子控件与子控件来确定，子控件之间位置可以重叠，拓展性好，灵活方便，是使用最多的布局方式
      注意：引用的子控件要设置id
   
   
   4.TableLayout ：表格布局
     以行和列的形式来组织子控件
      表格布局，是LinearLayout的子类，以行和列的形式存放子控件，它通常由多个TableRow布局控件组成，TableRow由多个单元格(cell)组成，每个cell设置为View对象 ，表格布局的子控件可以设置权重，但是不能设置方向

   5.GridLayout ：网格布局
    网格布局，android 4.0以后出现，布局使用虚细线将布局划分为行、列和单元格，也支持控件在行、列上都有交错排列。有方向性，默认为水平方向，相对于TableLayout，渲染速度更快，更灵活。
      更灵活： 交错排列
      渲染速度更快： GridLayout它不是LinearLayout的子类
      要求： 在android 4.0版本以后出现的，用于取代TableLayout

   6.AbsoluteLayout ：绝对布局
     用绝对坐标来定位子控件，拓展性不好，不建议使用


 android 概述 、 UI控件、布局 ，交互

## 五、事件驱动机制

   1. 手机交互的方式
       - 事件驱动机制，事件监听器
       - 菜单-actionBar（操作栏）
       - 传感器： 重力传感器 、gps 、光线传感器
       - 人工智能 
   2. 事件监听器
      一个事件监听器是View类中一个包含单一回调方法的接口。当注册了监听器的View发生了对应的监听事件时，Android框架就会回调相应的监听方法
   3. 常见的监听事件类型
      - 点击事件 
        点击事件的实现方式： 四种实现方式
         
      - 选择事件（单选、复选、下拉）
      - 长按
      - 触摸事件、触屏事件
        - 托放
        - 缩放
      - 按键事件 

重点：
  1. 理解 Activity-Window-ViewGroup-View
  2. 布局： 线性、相对、帧布局
  3. 事件监听器
     点击事件的四种实现方式

练习：
   1.发短信 ： 相对布局
   2. 相对布局小例子
作业：微信界面设计
   
      
