package org.zengrong.ane.funs.systeminfo;

import android.util.DisplayMetrics;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取显示尺寸信息
 * @author zrong
 * 创建日期：2012-6-6
 */
public class DisplayMetricsInfo implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.systeminfo.DisplayMetricsInfo";
	
	protected FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		try
		{
			DisplayMetrics __dm = _context.getActivity().getResources().getDisplayMetrics();
			FREObject __obj = FREObject.newObject("Object", null);
			__obj.setProperty("desity", FREObject.newObject(__dm.density));
			__obj.setProperty("densityDPI", FREObject.newObject(__dm.densityDpi));
			__obj.setProperty("widthPixels", FREObject.newObject(__dm.widthPixels));
			__obj.setProperty("heightPixels", FREObject.newObject(__dm.heightPixels));
			return __obj;
		}
		catch(Exception $e)
		{
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
}
