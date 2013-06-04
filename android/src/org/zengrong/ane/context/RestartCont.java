package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.restart.AppRestart;
import org.zengrong.ane.funs.restart.AppReboot;


import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
/**
 * 重启AIR应用
 * RESTART 5秒静默时间
 * REBOOT 默认一秒重启
 * @author Rect
 * 创建日期：2013-5-20
 */
public class RestartCont extends FREContext {
	public static final String TAG = "org.zengrong.ane.context.AppRestart";
	public static enum FUNS{RESTART,REBOOT};
	@Override
	public void dispose() 
	{
		String __info = "dispose";
		Log.d(TAG, __info);
		dispatchStatusEventAsync(__info, TAG);
	}

	
	@Override
	public Map<String, FREFunction> getFunctions() 
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.RESTART.toString(), new AppRestart());
		functions.put(FUNS.REBOOT.toString(), new AppReboot());
		return functions;
	}
}
