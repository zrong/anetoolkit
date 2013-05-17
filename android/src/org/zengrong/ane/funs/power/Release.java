package org.zengrong.ane.funs.power;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 释放电源控制
 * @author zrong
 * 创建日期：2012-11-12
 */
public class Release implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.power.Release";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $content, FREObject[] $args)
	{
		_context = $content;
		if($args.length<1)
		{
			_context.dispatchStatusEventAsync("参数不正确！", TAG);
			return null;
		}
		try
		{
			int __flags = $args[0].getAsInt();
			Log.i(TAG, "Release:"+__flags);
			PowerManager __pm = (PowerManager) _context.getActivity().getSystemService(Context.POWER_SERVICE);
			PowerManager.WakeLock __wl = __pm.newWakeLock(__flags, Acquire.TAG);
			__wl.release();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			_context.dispatchStatusEventAsync("无法获取flag！", TAG);
		}
		return null;
	}
}
