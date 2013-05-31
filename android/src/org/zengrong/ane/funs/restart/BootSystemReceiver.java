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
public class BootSystemReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.e("BootSystemReceiver", "注册  BootSystemReceiver"); 
		System.out.println("注册  BootSystemReceiver");
		Intent serviceIntent = new Intent(context,
				NotificationService.class);
		context.startService(serviceIntent);
	}
}
