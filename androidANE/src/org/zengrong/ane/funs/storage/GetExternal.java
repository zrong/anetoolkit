package org.zengrong.ane.funs.storage;

import android.app.Activity;
import android.os.Environment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取系统中的存储路径
 * @author zrong
 * 创建日期：2012-6-5
 */
public class GetExternal implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetExternal";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		Activity __activity = _context.getActivity();
		FREObject __obj = null;
		try
		{
			__obj = FREObject.newObject("Object", null);
			__obj.setProperty("externalFilesDir", FREObject.newObject(__activity.getExternalFilesDir(null).getAbsolutePath()));
			__obj.setProperty("externalCacheDir", FREObject.newObject(__activity.getExternalCacheDir().getAbsolutePath()));
			__obj.setProperty("externalStorageDirectory", FREObject.newObject(Environment.getExternalStorageDirectory().getAbsolutePath()));
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return __obj;
	}
}
