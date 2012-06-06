package org.zengrong.ane.funs.storage;

import android.app.Activity;
import android.os.Environment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取内置存储器路径
 * @author zrong
 * 创建日期：2012-6-5
 */
public class GetInternal implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetInternal";
	
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
			__obj.setProperty("cacheDir", FREObject.newObject(__activity.getCacheDir().getAbsolutePath()));
			__obj.setProperty("fileDir", FREObject.newObject(__activity.getFilesDir().getAbsolutePath()));
			__obj.setProperty("dataDirectory", FREObject.newObject(Environment.getDataDirectory().getAbsolutePath()));
			__obj.setProperty("downloadCacheDirectory", FREObject.newObject(Environment.getDownloadCacheDirectory().getAbsolutePath()));
			__obj.setProperty("rootDirectory", FREObject.newObject(Environment.getRootDirectory().getAbsolutePath()));
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return __obj;
	}

}
