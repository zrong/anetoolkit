package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;

import org.zengrong.ane.enum.IntentFunction;

/**
 * 提供Android中Intent的安装相关功能
 * @author zrong
 * 创建日期：2012-6-5
 */
public class IntentCont extends ToolBase
{
	public function IntentCont($context:ExtensionContext)
	{
		super($context);
	}
	
	/**
	 * 安装APK
	 * 需要权限：android.permission.INSTALL_PACKAGES<br>
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#INSTALL_PACKAGES
	 * @param $path apk文件的绝对路径
	 */	
	public function installAPK($path:String):void
	{
		_extension.call(IntentFunction.INSTALL_APK, $path);
	}
	
	/**
	 * 打开设置面板，可用的面板类型见 http://developer.android.com/reference/android/provider/Settings.html
	 * @param $settingsName 面板的类型
	 */
	public function openSettings($settingsType:String):void
	{
		_extension.call(IntentFunction.OPEN_SETTINGS, $settingsType);
	}
}
}