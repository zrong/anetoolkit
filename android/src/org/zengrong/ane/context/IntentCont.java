package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.intent.InstallAPKFun;
import org.zengrong.ane.funs.intent.OpenSettings;


import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

/**
 * 实现Intent的功能的上下文
 * @author zrong
 * 创建日期：2012-6-5
 */
public class IntentCont extends FREContext
{
	public static final String TAG = "org.zengrong.ane.context.IntentCont";
	
	/**
	 * 记录所有支持的FREFunction
	 * @author zrong
	 */
	public static enum FUNS{INSTALL_APK, OPEN_SETTINGS};
	
	@Override
	public void dispose()
	{
		String __info = "IntentCont dispose";
		Log.d(TAG, __info);
		dispatchStatusEventAsync(__info, TAG);
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.INSTALL_APK.toString(), new InstallAPKFun());
		functions.put(FUNS.OPEN_SETTINGS.toString(), new OpenSettings());
		return functions;
	}

}
