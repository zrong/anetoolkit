package org.zengrong.ane.funs.pack;

import android.app.Activity;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取当前应用的包名
 * @author zrong
 * 创建日期：2012-6-5
 */
public class GetPackageName implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.pack.GetPackageName";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		Activity __activity = _context.getActivity();
		FREObject __obj = null;
		try
		{
			__obj = FREObject.newObject(__activity.getPackageName());
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return __obj;
	}
}
