package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.restart.AppRestart;


import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
/**
 * 重启AIR应用 5秒静默时间
 * @author Rect
 * 创建日期：2013-5-20
 */
public class RestartCont extends FREContext {
	public static final String TAG = "org.zengrong.ane.context.AppRestart";
	public static enum FUNS{RESTART};
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		String __info = "dispose";
		Log.d(TAG, __info);
		dispatchStatusEventAsync(__info, TAG);
	}

	
	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.RESTART.toString(), new AppRestart());
		return functions;
	}

}
