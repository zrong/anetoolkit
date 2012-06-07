package org.zengrong.ane.funs.storage;

import java.io.File;

import android.app.Activity;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/**
 * 获取一个目录
 * 如果有外置存储器，优先使用外置存储器，返回外置存储器中分配给当前应用的路径
 * 如果有没有外置存储器，使用内置存储器
 * @author zrong
 * 创建日期：2012-6-7
 */
public class GetDir implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetDir";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		String __info = "参数提供错误！";
		if ($args == null || $args.length<2)
		{
			Log.e(TAG, __info);
			_context.dispatchStatusEventAsync(__info, TAG);
			return null;
		}
		try
		{
			int __mode = $args[1].getAsInt();
			if(__mode<0 || __mode>2)
			{
				Log.e(TAG, __info);
				_context.dispatchStatusEventAsync(__info, TAG);
				return null;
			}
			_context = $context;
			Activity __activity = _context.getActivity();
			File __dir = __activity.getDir($args[0].getAsString(), __mode);
			return FREObject.newObject(__dir.getAbsolutePath());
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return null;
	}
}