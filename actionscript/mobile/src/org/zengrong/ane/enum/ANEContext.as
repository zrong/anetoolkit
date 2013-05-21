package org.zengrong.ane.enum
{
/**
 * 整个ANE的上下文枚举定义 
 * @author zrong
 * 创建日期：2012-11-12
 */
public class ANEContext
{
	/**
	 * 实现Intent功能的上下文
	 */
	public static const INTENT:String = 'INTENT';
	
	/**
	 * 实现振动功能的上下文
	 */
	public static const VIBRATOR:String = 'VIBRATOR';
	
	/**
	 * 实现存储功能的上下文
	 */
	public static const STORAGE:String = 'STORAGE';
	
	/**
	 * 获取系统信息功能的上下文
	 */
	public static const SYSTEM_INFO:String = 'SYSTEM_INFO';
	
	/**
	 * 获取包信息功能的上下文
	 */
	public static const PACKAGE_INFO:String = 'PACKAGE_INFO';
	
	/**
	 * 获取包信息功能的上下文
	 */
	public static const PREFERENCE:String = 'PREFERENCE';
	
	/**
	 * 获取电源管理功能的上下文
	 */
	public static const POWER:String = 'POWER';
	
	/**
	 *重启应用 
	 */	
	public static const RESTART:String = 'RESTART';
}
}