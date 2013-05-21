package org.zengrong.ane.enum
{
/**
 * 网络类型
 * @see http://developer.android.com/reference/android/telephony/TelephonyManager.html#getNetworkType()
 */
public class NetworkType
{
	public static const NETWORK_TYPE_UNKNOWN:int = 0;
	public static const NETWORK_TYPE_GPRS:int = 1;
	public static const NETWORK_TYPE_EDGE:int = 2;
	public static const NETWORK_TYPE_UMTS:int = 3;
	public static const NETWORK_TYPE_HSDPA:int = 8;
	public static const NETWORK_TYPE_HSUPA:int = 9;
	public static const NETWORK_TYPE_HSPA:int = 10;
	public static const NETWORK_TYPE_CDMA:int = 4;
	public static const NETWORK_TYPE_EVDO_0:int = 5;
	public static const NETWORK_TYPE_EVDO_A:int = 6;
	public static const NETWORK_TYPE_EVDO_B:int = 12;
	public static const NETWORK_TYPE_1xRTT:int = 7;
	public static const NETWORK_TYPE_IDEN:int = 11;
	public static const NETWORK_TYPE_LTE:int = 13;
	public static const NETWORK_TYPE_EHRPD:int = 14;
	public static const NETWORK_TYPE_HSPAP:int = 15;
}
}