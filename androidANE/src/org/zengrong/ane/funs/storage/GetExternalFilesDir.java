package org.zengrong.ane.funs.storage;

import android.app.Activity;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取当前应用的绝对路径
 * @author zrong
 * 创建日期：2012-6-5
 */
public class GetExternalFilesDir implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetExternalFilesDir";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		if($args.length<1)
		{
			_context.dispatchStatusEventAsync("参数提供错误！", TAG);
			return null;
		}
		Activity __activity = _context.getActivity();
		FREObject __obj = null;
		try
		{
			__obj = FREObject.newObject(__activity.getExternalFilesDir($args[0].getAsString()).getAbsolutePath());
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return __obj;
	}
}