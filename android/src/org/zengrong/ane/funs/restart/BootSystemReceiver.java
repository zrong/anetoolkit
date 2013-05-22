package org.zengrong.ane.funs.restart;

import java.util.ArrayList;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
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
	public static final String severName = "org.zengrong.ane.funs.restart.NotificationService";
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
			ActivityManager myManager=(ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
			ArrayList<RunningServiceInfo> runningService = (ArrayList<RunningServiceInfo>) myManager.getRunningServices(30);
			for(int i = 0 ; i<runningService.size();i++)
			{
				if(runningService.get(i).service.getClassName().toString().equals(severName))
				{
					Log.d(TAG, "执行停止");
					context.stopService(serviceIntent);
					break;
				}
			}
		}
	}
}