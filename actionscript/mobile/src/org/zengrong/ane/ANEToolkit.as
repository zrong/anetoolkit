package org.zengrong.ane
{
import flash.external.ExtensionContext;
import flash.system.Capabilities;

import org.zengrong.ane.enum.ANEContext;
import org.zengrong.ane.tool.IntentCont;
import org.zengrong.ane.tool.PackageInfoCont;
import org.zengrong.ane.tool.PowerCont;
import org.zengrong.ane.tool.PreferenceCont;
import org.zengrong.ane.tool.StorageCont;
import org.zengrong.ane.tool.SystemInfoCont;
import org.zengrong.ane.tool.VibratorCont;

/**
 * 定义对ANE原生插件的调用
 * @author zrong
 * 创建日期：2012-6-3
 */
public class ANEToolkit
{
	/**
	 * 定义本地插件的ID
	 */	
	public static const EXT_ID:String = 'org.zengrong.ane.ANEToolkit';
	
	protected static var _intentCont:IntentCont= null;
	protected static var _storageCont:StorageCont= null;
	protected static var _systemInfoCont:SystemInfoCont = null;
	protected static var _vibratorCont:VibratorCont = null;
	protected static var _packageInfoCont:PackageInfoCont= null;
	protected static var _preferenceCont:PreferenceCont= null;
	protected static var _powerCont:PowerCont = null;
	
	/**
	 * 获取Intent功能
	 */
	public static function get intent():IntentCont
	{
		if(!_intentCont)
		{
			checkSuppored();
			_intentCont = new IntentCont(ExtensionContext.createExtensionContext(EXT_ID, ANEContext.INTENT));
		}
		return _intentCont;
	}
	
	/**
	 * 存储功能
	 */
	public static function get storage():StorageCont
	{
		if(!_storageCont)
		{
			checkSuppored();
			_storageCont = new StorageCont(ExtensionContext.createExtensionContext(EXT_ID, ANEContext.STORAGE));
		}
		return _storageCont;
	}
	
	/**
	 * 系统信息功能
	 */
	public static function get systemInfo():SystemInfoCont
	{
		if(!_systemInfoCont)
		{
			checkSuppored();
			_systemInfoCont = new SystemInfoCont(ExtensionContext.createExtensionContext(EXT_ID, ANEContext.SYSTEM_INFO));
		}
		return _systemInfoCont;
	}
	
	/**
	 * 振动功能
	 * 需要权限：android.permission.VIBRATE<br>
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#VIBRATE
	 */
	public static function get vibrator():VibratorCont
	{
		if(!_vibratorCont)
		{
			checkSuppored();
			_vibratorCont = new VibratorCont(ExtensionContext.createExtensionContext(EXT_ID, ANEContext.VIBRATOR));
		}
		return _vibratorCont;
	}
	
	/**
	 * 包信息功能
	 */
	public static function get packageInfo():PackageInfoCont
	{
		if(!_packageInfoCont)
		{
			checkSuppored();
			_packageInfoCont = new PackageInfoCont(ExtensionContext.createExtensionContext(EXT_ID, ANEContext.PACKAGE_INFO));
		}
		return _packageInfoCont;
	}
	
	/**
	 * 存取Android的SharedPreference
	 */
	public static function get preference():PreferenceCont
	{
		if(!_preferenceCont)
		{
			checkSuppored();
			_preferenceCont = new PreferenceCont(ExtensionContext.createExtensionContext(EXT_ID, ANEContext.PREFERENCE));
		}
		return _preferenceCont;
	}
	
	/**
	 * 管理Android的电源，PowerManager
	 */
	public static function get power():PowerCont
	{
		if(!_powerCont)
		{
			checkSuppored();
			_powerCont= new PowerCont(ExtensionContext.createExtensionContext(EXT_ID, ANEContext.POWER));
		}
		return _powerCont;
	}
	
	
	protected static function get isSupported() : Boolean
	{
		return (Capabilities.os.indexOf("Linux") >= 0);
	}
	
	private static function checkSuppored():void
	{
		if(!isSupported) throw new TypeError('The native extension is not supported on this device!');
	}
}
}