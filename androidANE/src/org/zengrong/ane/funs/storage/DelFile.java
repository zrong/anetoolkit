package org.zengrong.ane.funs.storage;

import java.io.File;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 删除文件
 * @author zrong
 * 创建日期：2012-6-5
 */
public class DelFile implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.DelFile";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		FREObject __obj = null;
		if ($args == null || $args.length<1)
		{
			String __info = "参数提供错误！";
			Log.e(TAG, __info);
			_context.dispatchStatusEventAsync(__info, TAG);
			return null;
		}
		try
		{
			File __file = new File($args[0].getAsString());
			__obj = FREObject.newObject(__file.delete());
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return __obj;
	}
}
