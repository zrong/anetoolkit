package org.zengrong.ane.funs.restart;


import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
/**
 * 服务
 * @author Rect 2013-5-17
 *
 */
public class NotificationService extends Service
{

	public static final String TAG = "org.zengrong.ane.funs.restart.NotificationService";
	
	private boolean stopService = false;

	@Override
	public void onCreate()
	{
		super.onCreate();
		Log.d(TAG, "oncreate");
		stopService=true;

	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		Log.d(TAG, "onStartCommand");
		if(stopService==true){
			Intent i  = getBaseContext().getPackageManager() 
			.getLaunchIntentForPackage(getBaseContext().getPackageName()); 
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(i);
			stopService=false;
			//2013-05-21 zrong 取消后在本地调试正常
//			stopSelf();
			//
		}

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy()
	{
		stopSelf();
		// 服务被关掉后5秒重新启动Service
		//		if(!stopService){
		//			Timer timer = new Timer();
		//			timer.schedule(task, 1000);
		//		}
		super.onDestroy();
	}

	@Override
	public void unbindService(ServiceConnection conn)
	{
		//	    stopSelf();
		super.unbindService(conn);
	}
	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}
}
