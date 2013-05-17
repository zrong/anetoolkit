package org.zengrong.ane.funs.power;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 强制系统休眠
 * @author zrong
 * 创建日期：2012-11-12
 */
public class GoToSleep implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.vibrator.GoToSleep";
	
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
			PowerManager __pm = (PowerManager) _context.getActivity().getSystemService(Context.POWER_SERVICE);
			__pm.goToSleep((long)__flags);
			Log.i(TAG, "GotoSleep:"+__flags);
		}
		catch (Exception $e)
		{
			$e.printStackTrace();
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}

}
