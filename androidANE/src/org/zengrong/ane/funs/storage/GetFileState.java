package org.zengrong.ane.funs.storage;

import java.io.File;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 判断一个文件的状态
 * @author zrong
 * 创建日期：2012-6-7
 */
public class GetFileState implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetFileState";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		if ($args == null || $args.length<1)
		{
			String __info = "参数提供错误！";
			Log.e(TAG, __info);
			_context.dispatchStatusEventAsync(__info, TAG);
			return null;
		}
		try
		{
			FREObject __obj = FREObject.newObject("Object", null);
			File __file = new File($args[0].getAsString());
			FREObject[] __fileArgs = new FREObject[1];
			__fileArgs[0] = FREObject.newObject(_context.getActivity().getCacheDir().getAbsolutePath());
			__obj.setProperty("exists", FREObject.newObject(__file.exists()));
			__obj.setProperty("isDirectory", FREObject.newObject(__file.isDirectory()));
			__obj.setProperty("isFile", FREObject.newObject(__file.isFile()));
			return __obj;
		}
		catch(Exception $e)
		{
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
}
