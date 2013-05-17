package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;

import org.zengrong.ane.enum.PowerFunction;
import org.zengrong.ane.enum.VibratorFunction;

/**
 * 振动功能
 * @author zrong
 * 创建日期：2012-6-6
 */
public class PowerCont extends ToolBase
{
	public function PowerCont($context:ExtensionContext)
	{
		super($context);
	}
	
	/**
	 * 释放对电源的设置
	 */
	public function release($flags:int):void
	{
		if($flags<=0) throw new RangeError('请提供一个正确的flags!');
		_extension.call(PowerFunction.RELEASE, $flags);
	}
	
	/**
	 * 执行对电源的设置
	 * @param $flags 要设置的电源模式，具体使用方法见：http://developer.android.com/reference/android/os/PowerManager.html
	 * @param $timeout 如果为大于0，则为超时锁，否则为永久锁。
	 * @see http://developer.android.com/reference/android/os/PowerManager.html
	 * 需要WAKE_LOCK权限
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#WAKE_LOCK
	 */	
	public function acquire($flags:int, $timeout:int=0):void
	{
		if($flags<=0) throw new RangeError('请提供一个正确的flags!');
		_extension.call(PowerFunction.ACQUIRE, $flags, $timeout);
	}
	
	/**
	 * 重启设备
	 * @param $reson 重启的原因
	 * 重启需要REBOOT权限
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#REBOOT
	 */
	public function reboot($reason:String=""):void
	{
		_extension.call(PowerFunction.REBOOT, $reason);
	}
	
	/**
	 * 切换到睡眠状态
	 * @param $time 持续时间
	 */
	public function goToSleep($time:int):void
	{
		_extension.call(PowerFunction.GO_TO_SLEEP, $time);
	}
	
	/**
	 * 屏幕是否是亮的<br>
	 * 需要DEVICE_POWER权限
	 * @see http://developer.android.com/reference/android/Manifest.permission.html#REBOOT
	 */
	public function isScreenOn():Boolean
	{
		return _extension.call(PowerFunction.IS_SCREEN_ON);
	}
	
	/**
	 * 模拟用户激活设备
	 * @param $when 何时激活
	 * @param $noChangeLights 是否改变电源灯的状态
	 */
	public function userActivity($when:int, $noChangeLights:Boolean):void
	{
		_extension.call(PowerFunction.USER_ACTIVITY, $when, $noChangeLights);
	}
}
}