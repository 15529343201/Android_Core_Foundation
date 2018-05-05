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







