package org.zengrong.ane.enum
{
/**
 * 定义Sim卡状态
 * @see http://developer.android.com/reference/android/telephony/TelephonyManager.html#getSimState()
 */
public class SimState
{
	public static const SIM_STATE_ABSENT:int = 1;
	public static const SIM_STATE_NETWORK_LOCKED:int = 4;
	public static const SIM_STATE_PIN_REQUIRED:int = 2;
	public static const SIM_STATE_PUK_REQUIRED:int = 3;
	public static const SIM_STATE_READY:int = 5;
	public static const SIM_STATE_UNKNOWN:int = 0;
}
}