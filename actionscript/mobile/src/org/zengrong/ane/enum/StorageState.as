package org.zengrong.ane.enum
{
/**
 * Andorid设备返回的外部存储器的状态枚举
 * @author zrong
 * 创建日期：2012-6-6
 * @see http://developer.android.com/reference/android/os/Environment.html
 */
public class StorageState
{
	public static const MEDIA_BAD_REMOVAL:String = 'bad_removal';
	public static const MEDIA_CHECKING:String = 'checking';
	public static const MEDIA_MOUNTED:String = 'mounted';
	public static const MEDIA_MOUNTED_READ_ONLY:String = 'mounted_ro';
	public static const MEDIA_NOFS:String = 'nofs';
	public static const MEDIA_REMOVED:String = 'removed';
	public static const MEDIA_SHARED:String = 'shared';
	public static const MEDIA_UNMOUNTABLE:String = 'unmountable';
	public static const MEDIA_UNMOUNTED:String = 'unmounted';
}
}