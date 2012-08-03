package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.pref.GetPreference;
import org.zengrong.ane.funs.pref.SetPreference;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

/**
 * 保存共享对象
 * @author zrong
 * 创建日期：2012-08-02
 */
public class PreferenceCont extends FREContext
{

	public static final String TAG = "org.zengrong.ane.context.PreferenceCont";
	
	public static enum FUNS{SET_PREFERENCE, GET_PREFERENCE};
	
	@Override
	public void dispose()
	{
		String __info = "preference dispose";
		Log.d(TAG, __info);
		dispatchStatusEventAsync(__info, TAG);
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> _functions = new HashMap<String, FREFunction>();
		_functions.put(FUNS.SET_PREFERENCE.toString(), new SetPreference());
		_functions.put(FUNS.GET_PREFERENCE.toString(), new GetPreference());
		return _functions;
	}
}
