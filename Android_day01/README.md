# Android 概述及UI布局
# 一、概述
## 1.移动互联开发
### 移动互联特点
- 方便、快捷
- 与互联网紧密结合,"无所不能"
- 是it当前最热门的方向

&emsp;&emsp;云计算(云存储、web发布的云中,租赁oracle)<br>
&emsp;&emsp;物联网(快递、brt、智慧城市、智慧小区、智能家居)<br>
### 移动互联开发
- 硬件(手机、基站)
- 软件

&emsp;&emsp;移动平台的服务器(PHP、JEE、.NET)<br>
&emsp;&emsp;客户端、单机开发<br>
&emsp;&emsp;嵌入式开发<br>
### 移动智能操作系统平台
- Andorid:java,78%
- IOS:objective-c
- Window phone:1%

## 2.Andorid历史与发展
### Android大事件
- 2005年google收购了android公司
- 2007年开放手机联盟成立,13家大公司联盟
- 2008年底,第一款android手机 g1推出
### Android版本进化
- 1.x版本:入门级版本,只针对手机
- 2.x版本:趋于成熟版本,只针对手机
- 3.x版本:趋于成熟版本,针对平板
- 4.x版本:趋于成熟版本,但是对手机和平板进行整合,想解决版本碎片化的问题,对安全加强
- 5.x版本:趋于成熟版本,重点在平台的整合(手机、平板、电视、穿戴设备、嵌入设备),支持64位cpu,默认在art虚拟机中运行,解决版本碎片化,原声版本(小米、华为、联想、htc)
### Android应用场景
- 手机、平板、嵌入式等
## 3.Android体系结构
### 体系结构
### JVM/DVM/ART 虚拟机
- jvm与dvm

&emsp;&emsp;相同点:都是在虚拟机运行,运行的都是字节码<br>
&emsp;&emsp;不同点:<br>
&emsp;&emsp;&emsp;程序结构不同:jvm运行的是class字节码,而dvm运行的是dex字节码<br>
&emsp;&emsp;&emsp;系统架构不同:jvm基于内存的,基于堆栈,而dvm基于的是寄存器,及基于cpu<br>
- dvm和art虚拟机:ART模式是Android runtime的简称,在Android4.4版本后出现,通过在安装应用程序时,自动对程序进行代码预读取编译,让程序直接编译成机器语言,并且把它保存起来,免去了Dalvik模式要时时转换代码,实现高效率、省电、手机运行流畅。ART是虚拟机,只是在安装apk时,提前编译而已。
# 二、搭建开发环境
## 1.开发准备
### 工具
- jdk,eclipse,adt,android sdk（soft develper kit)目前业界使用最多,android bundle for windows:合集版
- android studio:耗内存、通过maven来管理android项目 png-->>.9.png格式,拉伸时边角不会失真
### sdk的更新
### sdk目录结构
## 2.创建AVD模拟器
- android标准模拟器
- hax:技术,虚拟加速技术
- genymotion超级模拟器
- 真机
## 3.手机参数
- 分辨率:480*800 768*1280 1080*1920 1024*600(平板)
- 屏幕尺寸(对角线,斜边):3.5 4.0 4.3 4.7 5 5.5
- 屏幕密度:desity ppi:p-per-inch ldpi:120 mdpi:160 hdpi:240 xhdpi:320 480 640 标清:mdpi:160
- 手机制式:1G(模拟信息 波形图)->2G->3G(wcdma,cdma2000,td-scdma)->4G(fdd-lte,td-lte)->5G 
- cpu,内存
# 三、第一个Android应用程序
## 1.创建应用流程
- 设计界面
- 写代码、实现功能
- 打包、安装、测试、部署
## 2.Android应用程序结构介绍
- android应用程序结构由四大组件构成(acitvity,Service,ContentProvider,BroadcastReceiver),每一个模块都是相互独立的,有着不同的入口,android框架依据这些入口,进入到该应用中,在AndroidManifest.xml中注册,它们松耦合的组合在一起,从而定义应用的整体功能
## 3.项目工程目录分析
## 4.Android应用运行流程
- 编译打包生成apk:java-->class-->classes.dex(de.bat)-->apk(aapt)-->apk(签名,默认debug签名)
- 通过adb(android debug bridge:android调试条)把apk上传到模拟器或者真机中,位置:/data/app/目录
- 再解析AndroidManifest.xml文件,获取包名,版本信息,组件信息,权限信息,支持的最低版本与最高版本,再创建文件夹/data/data/<当前的package>,用于存放该应用的私有数据
- 把包等信息写入到/data/system/packages.xml文件中,实现注册
- 运行:Android系统是一个多用户的Linux系统,应用一旦安装,系统为每个应用分配一个独立的Linux用户ID,当用户点击应用程序图标或者导航到该应用的组件,Android框架会创建一个虚拟机实例,开启一个进程,创建一个主线程(UI线程),再实例化入口组件,进入组件的生命周期
# 四、应用体验:电话拨号器
- 1.设置界面
- 2.实现交互
- 3.安装、运行
# 五、ddms与adb







