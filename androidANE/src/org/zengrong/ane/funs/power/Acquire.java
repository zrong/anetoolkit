package org.zengrong.ane.funs.power;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 开启电源控制
 * @author zrong
 * 创建日期：2012-11-12
 * 需要WAKE_LOCK权限
 * @see http://developer.android.com/reference/android/Manifest.permission.html#WAKE_LOCK
 */
public class Acquire implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.vibrator.Acquire";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $content, FREObject[] $args)
	{
		_context = $content;
		if($args.length<2)
		{
			_context.dispatchStatusEventAsync("参数不正确！", TAG);
			return null;
		}
		try
		{
			int __flags = $args[0].getAsInt();
			long __timeout = (long) $args[1].getAsInt();
			PowerManager __pm = (PowerManager) _context.getActivity().getSystemService(Context.POWER_SERVICE);
			PowerManager.WakeLock __wl = __pm.newWakeLock(__flags, TAG);
			if(__timeout > 0)
			{
				__wl.acquire(__timeout);
			}
			else
			{
				__wl.acquire();
			}
			Log.i(TAG, "Acauire:"+__flags+","+__timeout);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			_context.dispatchStatusEventAsync("无法获取flag！", TAG);
		}
		return null;
	}

}
