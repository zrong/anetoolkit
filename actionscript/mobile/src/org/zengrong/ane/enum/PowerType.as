package org.zengrong.ane.enum
{
/**
 * 对Android PowerManager操作的flags的枚举值
 * @see http://developer.android.com/reference/android/os/PowerManager.html
 * @author zrong
 * 创建日期：2012-11-12
 */
public class PowerType
{
	public static const ACQUIRE_CAUSES_WAKEUP:int = 0x10000000;
	public static const ON_AFTER_RELEASE:int = 0x20000000;
		
	public static const FULL_WAKE_LOCK:int = 0x0000001a;
	public static const PARTIAL_WAKE_LOCK:int = 0x00000001;
	public static const SCREEN_BRIGHT_WAKE_LOCK:int = 0x0000000a;
	public static const SCREEN_DIM_WAKE_LOCK:int = 0x00000006;
}
}