# iosMonkey
实现对屏幕的点击，滑动，特定point的点击等

### 更新

1.修复app守护进程的bug，由于时间问题导致的

2.增加返回homescreen的事件，事件概率是2%，返回手机主页5s后重新打开app

# 0、简介

- 1.maven bulid

- 2.idevicedebug 命令呼起app

- 3.根据app实际情况，增加了特殊点的处理（在有些页面，点击固定的位置才能返回，不是通用的右上角）

- 4.如果不修改直接使用，直接使用target下面的jar包，如果实现自己的方法，需要重新编译

# 1、功能
- 1.可以模拟android monkey执行的方式，在IOS APP页面点击 滑动操等作,支持 ios 9和ios10

- 2.支持多台ios一起执行


# 2、准备appium环境

### 安装usbmuxd

$ brew install usbmuxd

### 安装ios_webkit_debug_proxy

$ brew install ios_webkit_debug_proxy

### 安装ios-deploy

$ npm i ios-deploy -g

### 安装ideviceinstaller

$ brew install ideviceinstaller

### 安装carthage
$ brew install carthage

### 安装appium
$ brew install appium

### 检测macaca环境，无报错
$ appium-doctor

# 3、WebDriverAgent项目重签名

cd /usr/local/lib/node_modules/appium/node_modules/.2.12.0@appium-xcuitest-driver/WebDriverAgent/
操作项目重签名

# 4、帮助命令
如果需要多个iOS设备一起执行，需要指定 proxyport ，同时appium使用不同的端口
```
$ java -jar iosMonkey-1.0.jar -h
-u:设备的UDID
-b:测试App的Bundle
-port:appium client服务的端口，默认4327
-proxyport:usb代理端口，默认8100
```

# 5、执行iosMonkey
开一个窗口执行
$ java -jar [iosMonkey.jar Path] -u [设备的UDID] -b [测试App的BundleID] -port [macaca服务端口,可选] -proxyport[usb代理端口,可选]

# 6、修改源码重新打包方法

如果需要源码实现自定义的功能，在项目目录下执行

$ mvn assembly:assembly

最后提示如下，标示打包成功，target下生成iosMonkey-1.0.jar，可以使用最新的包
```
INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 55.557 s
[INFO] Finished at: 2017-09-12T09:49:42+08:00
[INFO] Final Memory: 53M/725M
[INFO] ------------------------------------------------------------------------

```
