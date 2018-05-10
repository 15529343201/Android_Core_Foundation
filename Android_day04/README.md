    
# 消息提示机制

## android 概述 ，UI控件 ，布局（静态布局：线性、相对、帧； 动态布局） ，事件驱动-监听 转账 
    消息反馈、消息提示
   
   
  
## 一 、Android消息提示机制介绍
    1. logcat ：日志猫 ，维护，开发人员
    2. Toast  ：吐司 
    3. Dialog  ： 对话框
    4. Notification ： 通知管理
 
## 二、Logcat
    Logcat ：日志猫
     * 显示视图界面  
        pid ：process id ：进程id     tid：thread id：线程id
         假如tid==pid 则该tid 为主线程 ，或者成为ui线性
     * Level : 
       - verbose :级别最低 混淆级别
       - debug ：调试级别
       - info ：信息级别
       - warn ：警告
       - error ：级别最高  错误
     * 过滤器
        session filter ：会话过滤，只针对某个项目的过滤
        
     * 与System.out.println()区别
       1. system.out.println"
          tag: System.out   level :info 
          默认System.out.print是不会输出，输出到缓存中，需要刷缓存

   
## 三、Toast  ：瞬时提示机制
     Toast通知是一种浮现在屏幕上层的消息提醒，它只填充消息所需要的空间，而当前正在运行的活动仍然保持其自身的可见性和交互性。这种通知自动淡入淡出且不接受交互事件
      - 系统的Toast.makeText ： 白加黑
         Toast.makeText(context,text,duration).show()
      - 自定义吐司 
        1. 代码自定义 Toast显示界面
        2. xml自定义 Toast显示界面   
## 四、Dialog
       对话框通常是一种显示在当前活动之上的小窗口，这时候下层的活动将失去焦点，由对话框来实现与用户的交互，常用于添加简单的数据或对操作进一步确认等，比如删除联系人信息、添加类别等，但对话框不宜过多，会影响用户体验
     对话框类型：
       1. 标准对话框
       2. 菜单式对话框
       3. 复合对话框
       4. 自定义对话框
          // 构建一个Dialog 对象  遇到的问题 1. 当点击按钮时，对话框不能自动消失  ， 对话框界面多了一个背景面板 ，对按钮设置选择器 

## 五、Notification 



## 六、样式与主题
    作用： 统一风格 ，简化操作 
    语法： 通过 values ：设置style类别 来定义样式与主题
    样式与主题的联系与区别：
      - 定义的语法都是一样的
      - 使用场景不同 
         1. 样式针对的是控件  ：Button、ProgressBar --style    xml属性 ：style
         2. 主题针对的是组件，比如Activity、Application、 Dialog    xml属性： android：theme 


重点： 
   1. Toast 
      - 代码自定义布局
      - Xml自定义
         LayoutInfalte.infalte  （layoutResId，root）
          LayoutInfalte.infalte  （layoutResId，root，false） ：AdpaterView
           root：容器 ViewGroup ： 布局（线性、相对、帧、表格、网格等）  ，AdpaterView 
           把xml转换为view对象 
   2. 对话框
      - 标准对话框
      - 复选对话框
      - 自定义对话框
   3. 样式与主题
   

 练习： 
   1. Toast
   2. Dialog

  作业：GridView

预习： 移动存储

