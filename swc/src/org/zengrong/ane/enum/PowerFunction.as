package org.zengrong.ane.enum
{
/**
 * 定义电源功能相关的枚举
 * @author zrong
 * 创建日期：2012-11-12
 */
public class PowerFunction
{
	/**
	 * 执行电源设置
	 */
	public static const ACQUIRE:String = "ACQUIRE";
	
	/**
	 * 释放对电源进行的设置
	 */
	public static const RELEASE:String = "RELEASE";
	
	/**
	 * 重启设备
	 */
	public static const REBOOT:String = "REBOOT";
	
	/**
	 * 屏幕是否处于点亮状态
	 */
	public static const IS_SCREEN_ON:String = "IS_SCREEN_ON";
	
	/**
	 * 用户激活设备
	 */
	public static const USER_ACTIVITY:String = "USER_ACTIVITY";
	
	/**
	 * 切换到睡眠状态
	 */
	public static const GO_TO_SLEEP:String = "GO_TO_SLEEP";
}
}