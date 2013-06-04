package org.zengrong.ane.funs.restart;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 调用系统服务重启
 * @author Rect
 * @version  Time：2013-5-31 
 */
public class AppReboot implements FREFunction {

	private String TAG = "org.zengrong.ane.funs.restart.AppReboot";
	private FREContext _context;
	@Override
	public FREObject call(FREContext context, FREObject[] paramArrayOfFREObject)
	{
		Log.e(TAG, " called - AndroidReboot by MB");
		_context = context;
		try
		{
			int delayTime = paramArrayOfFREObject[0].getAsInt();
			Activity localActivity = _context.getActivity();
			Intent localIntent = new Intent(localActivity, localActivity.getClass());
			//FLAG_ONE_SHOT Constant Value: 1073741824 (0x40000000)
			PendingIntent localPendingIntent = PendingIntent.getActivity(localActivity, 0, localIntent, PendingIntent.FLAG_ONE_SHOT);
			AlarmManager localAlarmManager = (AlarmManager)localActivity.getSystemService(Activity.ALARM_SERVICE);
			long nowTime = System.currentTimeMillis();
			long l2 = delayTime;
			long rebootTime =  nowTime+l2;
			//AlarmManager.RTC = 1
			localAlarmManager.set(AlarmManager.RTC, rebootTime, localPendingIntent);
			return null;
		}
		catch (Exception localException)
		{
			_context.dispatchStatusEventAsync(TAG, localException.getMessage());
		}
		
		return null;
	}

}
