package org.zengrong.ane.funs.power;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 使用者激活设备
 * @author zrong
 * 创建日期：2012-11-12
 */
public class UserActivity implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.power.UserActivity";
	
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
			long __when = (long) $args[0].getAsInt();
			boolean __noChangeLights = $args[1].getAsBool();
			PowerManager __pm = (PowerManager) _context.getActivity().getSystemService(Context.POWER_SERVICE);
			__pm.userActivity(__when, __noChangeLights);
			Log.i(TAG, "UserActivity:"+__when+","+__noChangeLights);
		}
		catch (Exception $e)
		{
			$e.printStackTrace();
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
}
