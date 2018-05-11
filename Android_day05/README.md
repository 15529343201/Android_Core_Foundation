#    单元测试与移动存储

## 一、消息提示方式 
    1. logcat
    2. Toast
    3. dialog
    4. Notification ：通知
       组成 ： 通知的内容框    通知的状态栏
       早期版本： Notification notification=new Notication（）
                  Notification.Builder  : level  16版本及以后
      自定义通知界面：
       RemoteViews  
   
      
## 二、Android测试

    1. 测试分类
    
     - 依据是否知道源代码
       1. 白盒测试 ： 知道源码，依据代码的逻辑编程测试用例 来进行测试
       2. 黑盒测试 ：不知道源码，依据功能测试输出
     - 依据测试的粒度 ：测试的程度
       - 方法测试 
       - 单元测试 ： 封装了junit 单元测试  ：apache 
       - 集成测试
       - 系统测试  依赖支付宝支持--银行支付系统-发短信
     - 依据测试暴力程度 
       1. 压力测试 ：服务端，单位时间内，访问次数 、点击次数
          monkey测试 （压力测试、功能测试）  ：请一个猴子来帮我点击 
            adb 要配置环境变量
            在环境变量中配置  path=E:\Android\adt-bundle-x86-32\sdk\platform-tools;
           进入到linux shell环境中：

            命令行： adb shell  
            # ： moneky -p <包名> count 
                 money -p cn.itcast.weixin  1000
       2. 冒烟测试 ：硬件 
     - 适配测试
       1. 分辨率测试  
       2. 手机系统版本的测试
       3. 不同手机（android 二次开发）的测试 
    2.Android单元测试 
      - android 单元测试 很好的封装了 Junit框架 ，是对业务方法的测试 
       单元测试的实现步骤：
        1. 准备业务类，编写测试类，继承AndroidTestCast，编写测试方法
        2. 在AndroidManifest.xml  application节点中添加测试类库
        3. 在AndroidManifest.xml  设置测试环境
      -  状态：
        1. 绿条 ：测试成功
        2. 红条 
           - 蓝叉  ：期望值与实际值不匹配，可能是业务逻辑写错了
           - 红叉  ： 运行中有异常 
        3. 断言 取得if else
        4. 获取上下文 getContext
      - 单独创建一个用于做测试的项目  android test project

     
   
## 三、移动存储介绍


## 四、手机内部存储
 

1. 手机内部存储的特点：
	  * 存放本应用中的私有数据 
	  * 当应用卸载时，/data/data/<包名> 这个目录会同步删除，即手机内部存储的文件会删除
	  * 存放位置： /data/data/<包名>/files

2. 关注点：
      * Context.openFileOutput(String name, int mode) 
         - 作用： 打开一个文件，返回一个FileOutputSteam，写数据到文件中
         - name ： 文件名，有则打开，无则创建
         - mode ：文件的操作模式 private： 默认模式 ，私有模式，覆盖模式   append ：追加模式，私有模式
         - 文件的存储的位置：/data/data/<包名>/files ，存放的是私有数据
         - return： FileOutputSteam
      * Context.openFileInput(String name) 从手机内部存储中读取文件
         - 作用：从手机内部存储中读取文件
         - name ：文件名
         - FileInputStream
      * context.getCacheDir()	方法用于获取/data/data/<package name>/cache目录
         - 返回的是File对象  （文件夹）
      * context.getFilesDir() 	方法用于获取/data/data/<package name>/files目录
          - 返回的是File对象  （文件夹）

## 五、手机外部存储 
 
      所有兼容Android的设备都支持一个可共享的“外部存储(external storage)”,可用来保存文件。这可以是一个可移动的存储设备（比如SD卡）或者一个内部的（不可移动的）存储。保存在外部存储的文件是可全局读写的。
1. Sdcard存储的特点(外部存储)：
    * 依赖于Sdcard，使用SDCard存储，需先检测其状态，能够挂载成功
    * 存在Sdcard的文件是可全局读写的
    * 写入Sdcard时，需要权限
2. 关注点：
    * Environment.getExternalStorageState()  取得外部存储状态   //环境
    * Environment.getExternalStorageDirectory() 取得外部存储根路径 //  
    * 写入外部存储的权限
       android.permission.MOUNT_UNMOUNT_FILESYSTEMS  //挂载、卸载文件系统
       android.permission.WRITE_EXTERNAL_STORAGE  //写外部存储权限
       android.permission.READ_EXTERNAL_STORAGE //读外部存储的权限
        在android 4.0以后，假如你的外部存储的路径不规范，则需要该权限
3. 外部存储路径描述
      1.取得外存的公共共享的存储路径
        取目录：Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
         /mnt/sdcard/downloads/ 
      2.在外存中存放应用的私有数据，但是该数据可以全局读写，当应用删除时，该内容会同步删除 ：
        取目录：context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
	   目录/mnt/sdcard/android/data/<包名>/files/<类型>/
      3.在外存中存放应用的私有缓存文件 ,当应用删除时，该内容会同步删除
        取目录: context.getExternalCacheDir()
        目录 /mtn/sdcard/android/data/<包名>/cache
      4.取得外存的根路径
        取目录：Environment.getExternalStorageDirectory()
           /mnt/sdcard
## 六、SharedPreferences  :共享偏好设置存储
     SharedPreferences，是一个非常轻量的数据存储方式，
     以xml的形式存取简单的键值对数据，存放基本的数据。
     数据类型包括（ints,floats,boolean,strings,longs,Set<String>(android 11以后)），
     存放位置：/data/data/<包名>/shared_prefs，存放的是应用私有的数据，
     主要用于软件偏好设置，简单信息存取、数据缓存等
    
   1. 如何取得SharedPreferences对象
       -  context.getSharedPreferences(name,Mode)
         - 返回的是SharedPreferences对象，通过该对象存储简单的键值对数据到该对象关联的xml文件中
         - name ：文件名，不需要写扩展名，默认是*.xml  :有则打开，无则创建
         - mode :在android 4.0版本 以后，只支持mode_private 
       - Activity.getPreferences(name)
         - name ：默认的名字，以当前的Activity的类名作为文件名

   2. get values 
      -  SharedPreferences.getString(key,defvalue) ,取字符串类型的数据，假如key不存在，则返回  defvule ： null
      -  SharedPreferences.getInt(key,defvalue) ,取整数类型的数据，假如key不存在，则返回  defvule ： 0
      -  -  SharedPreferences.getBoolean(key,defvalue) ,取字符串类型的数据，假如key不存在，则返回  defvule ： false

   3. save values  
      实现步骤：
        1. 取得编辑器 Editor editor=SharedPreferences.edit()
        2.  editor.putString(key,value)
            editor.putInt(key,value)
            editor.putBoolean(key,value)
        3. editor.commit();//提交数据，把键值对数据更新到xml文件中
        
  小案例 ：运用SharedPreferences保存用户登录信息
    要求：
    1.账号密码验证成功，则进入另一个Activity：SystemActivity
    2.选中复选框，则用户登录时，把账户及密码信息以SharedPreferences存储xml文件中
    3.应用下次启动，依据存储的复选框状态值，决定是否填充账户与密码信息
    4.对存入SharedPreference的值对信息加密 
          des ：对称加密 ： 加密和解密密钥是相同的 ，把密文还原成原文
          aes 对des加强版


重点：
  1. 通知 
  2. 手机内存存储、手机外部存储
  3. SharedPrefenrencs

练习：
   1. SharedPrefenrencs
   2. FileStore 项目： 从sdcard读数据
   3. 通知 

