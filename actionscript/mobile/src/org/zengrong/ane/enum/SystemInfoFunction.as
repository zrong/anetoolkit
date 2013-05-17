package org.zengrong.ane.enum
{
/**
 * Andorid设备返回的外部存储器的状态枚举
 * @author zrong
 * 创建日期：2012-6-6
 */
public class SystemInfoFunction
{
	/**
	 * 代表电话信息的枚举
	 * @see http://developer.android.com/reference/android/telephony/TelephonyManager.html
	 */
	public static const TELEPHONY:String = 'TELEPHONY';
	
	/**
	 * 代表build信息的枚举
	 * @see http://developer.android.com/reference/android/os/Build.html
	 */
	public static const BUILD_INFO:String = 'BUILD_INFO';
	
	/**
	 * 代表硬件信息的枚举
	 */
	public static const HARDWARE_INFO:String = 'HARDWARE_INFO';
	
	/**
	 * 当前连接的状态
	 * @see http://developer.android.com/reference/android/net/ConnectivityManager.html
	 */
	public static const CONNECTIVITY_INFO:String = 'CONNECTIVITY_INFO';
	
	/**
	 * 显示尺寸
	 * @see http://developer.android.com/reference/android/util/DisplayMetrics.html
	 */
	public static const DISPLAY_METRICS_INFO:String = 'DISPLAY_METRICS_INFO';
}
}