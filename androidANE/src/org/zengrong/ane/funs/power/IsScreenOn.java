package org.zengrong.ane.funs.power;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

/**
 * 返回屏幕当前是不是亮着
 * @author zrong
 * 创建日期：2012-11-12
 * 需要DEVICE_POWER权限
 * @see http://developer.android.com/reference/android/Manifest.permission.html#DEVICE_POWER
 */
public class IsScreenOn implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.vibrator.IsScreenOn";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $content, FREObject[] $args)
	{
		_context = $content;
		PowerManager __pm = (PowerManager) _context.getActivity().getSystemService(Context.POWER_SERVICE);
		boolean __isScreenOn = __pm.isScreenOn();
		try
		{
			FREObject __obj = FREObject.newObject(__isScreenOn);
			Log.i(TAG, "IsScreenOn:"+__isScreenOn);
			return __obj;
		} 
		catch (FREWrongThreadException $e)
		{
			$e.printStackTrace();
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
}
