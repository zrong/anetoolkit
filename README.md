anetoolkit
==========

## AIR的ANE工具包

提供以下功能：

* 安装APK文件
* 调用各种设置面板
* 振动
* 管理PowerManager功能，取消休眠
* 访问SD卡状态
* 读取AIR不能读取的文件
* 向AIR不能读取的路径写入文件
* 删除AIR不能删除的文件
* 获取硬件信息，包括CPU名称、速度、内存大小、存储器大小
* 获取手机信息，包括品牌、名称等等
* 获取网络名称，包括手机号码（部分手机可用）、手机网络（GPRS/GSM/WCDMA...）
* 获取网络连通状态
* 电源管理，禁止休眠，保持屏幕常亮

文档:<http://zrong.github.com/doc/anetoolkit/>

## 编译方法

* 复制 `build/example.build.config` 为 `build/build.config`
* 修改其中的 `flex.sdk` 和 `android.sdk` 变量为正确的路径
* 运行 `ant android-ane`
