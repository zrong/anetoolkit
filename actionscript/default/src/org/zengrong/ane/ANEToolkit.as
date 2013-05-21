package org.zengrong.ane
{
import org.zengrong.ane.tool.IntentCont;
import org.zengrong.ane.tool.PackageInfoCont;
import org.zengrong.ane.tool.PowerCont;
import org.zengrong.ane.tool.PreferenceCont;
import org.zengrong.ane.tool.StorageCont;
import org.zengrong.ane.tool.SystemInfoCont;
import org.zengrong.ane.tool.VibratorCont;
import org.zengrong.ane.tool.RestartCont;


/**
 * 定义对ANE原生插件在Desktop平台上的调用，就是不做任何事
 * @author zrong
 * 创建日期：2013-05-20
 */
public class ANEToolkit
{
	/**
	 * 定义本地插件的ID
	 */	
	public static const EXT_ID:String = 'org.zengrong.ane.ANEToolkit';
	
	/**
	 * 获取Intent功能
	 */
	public static function get intent():IntentCont
	{
		return null;
	}
	
	/**
	 * 存储功能
	 */
	public static function get storage():StorageCont
	{
		return null;
	}
	
	/**
	 * 系统信息功能
	 */
	public static function get systemInfo():SystemInfoCont
	{
		return null;
	}
	
	/**
	 * 振动功能
	 * 需要权限：android.permission.VIBRATE<br>
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#VIBRATE
	 */
	public static function get vibrator():VibratorCont
	{
		return null;
	}
	
	/**
	 * 包信息功能
	 */
	public static function get packageInfo():PackageInfoCont
	{
		return null;
	}
	
	/**
	 * 存取Android的SharedPreference
	 */
	public static function get preference():PreferenceCont
	{
		return null;
	}
	
	/**
	 * 管理Android的电源，PowerManager
	 */
	public static function get power():PowerCont
	{
		return null;
	}

	/**
	 * 重启APP
	 */
	public static function get restart():RestartCont
	{
		return null;
	}
	
	
	protected static function get isSupported() : Boolean
	{
		return false;
	}

}
}