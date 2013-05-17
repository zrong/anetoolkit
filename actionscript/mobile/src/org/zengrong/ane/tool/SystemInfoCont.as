package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;

import org.zengrong.ane.enum.SystemInfoFunction;

/**
 * 获取系统信息
 * @author zrong
 * 创建日期：2012-6-6
 */
public class SystemInfoCont extends ToolBase
{
	public function SystemInfoCont($context:ExtensionContext)
	{
		super($context);
	}
	
	/**
	 * 获取Build信息
	 */
	public function getBuildInfo():Object
	{
		return _extension.call(SystemInfoFunction.BUILD_INFO);
	}
	
	/**
	 * 获取硬件信息<br>
	 */
	public function getHardwareInfo():Object
	{
		return _extension.call(SystemInfoFunction.HARDWARE_INFO);
	}
	
	/**
	 * 获取电话信息
	 * 需要权限：android.permission.READ_PHONE_STATE<br>
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#READ_PHONE_STATE
	 */
	public function getTelephony():Object
	{
		return _extension.call(SystemInfoFunction.TELEPHONY);
	}
	
	/**
	 * 获取当前连接的网络信息<br>
	 * AIR能够获取网络的状态，但不能判断网络的类型（是WIFI还是Mobile）<br>
	 * 需要权限：android.permission.ACCESS_NETWORK_STATE<br>
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#ACCESS_NETWORK_STATE
	 */
	public function getConnectivityInfo():Object
	{
		return _extension.call(SystemInfoFunction.CONNECTIVITY_INFO);
	}
	
	/**
	 * 获取显示尺寸，某些情况下可能需要自行计算<br>
	 * 其实AIR已经提供了这些功能，建议使用AIR的功能。
	 */
	public function getDisplayMetricsInfo():Object
	{
		return _extension.call(SystemInfoFunction.DISPLAY_METRICS_INFO);
	}
}
}