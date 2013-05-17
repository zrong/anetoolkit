package org.zengrong.ane.funs.power;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 重启设备
 * @author zrong
 * 创建日期：2012-11-12
 * 重启需要REBOOT权限
 * @see http://developer.android.com/reference/android/Manifest.permission.html#REBOOT
 */
public class Reboot implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.power.Reboot";
	
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
			String __reason = $args[0].getAsString();
			PowerManager __pm = (PowerManager) _context.getActivity().getSystemService(Context.POWER_SERVICE);
			__pm.reboot(__reason);
			Log.i(TAG, "Reboot");
		}
		catch (Exception $e)
		{
			$e.printStackTrace();
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
}
