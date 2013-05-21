package org.zengrong.ane.funs.restart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/***
 * 注册服务
 * @author Rect 2013-5-17
 *
 */
public class BootSystemReceiver extends BroadcastReceiver
{

	public static final String TAG = "org.zengrong.ane.funs.restart.BootSystemReceiver";
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.d(TAG, "停止  BootSystemReceiver");
		
		Intent serviceIntent = new Intent(context, NotificationService.class);
		if(AppRestart.isRstart == 1)
		{
			Log.d(TAG, "开启  服务");
			context.startService(serviceIntent);
		}
		else 
		{
			Log.d(TAG, "停止  服务");
			context.stopService(serviceIntent);
		}
	}
}