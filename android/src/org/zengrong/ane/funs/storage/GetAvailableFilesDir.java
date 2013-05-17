package org.zengrong.ane.funs.storage;

import java.io.File;

import android.os.Environment;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取一个可用的文件路径
 * 如果有外置存储器，优先使用外置存储器，返回外置存储器中分配给当前应用的路径
 * 如果有没有外置存储器，使用内置存储器
 * @author zrong
 * 创建日期：2012-6-7
 */
public class GetAvailableFilesDir implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetAvailableFilesDir";
	
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
			File __file = null;
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
			{
				__file = _context.getActivity().getExternalFilesDir(null);
			}
			else
			{
				__file = _context.getActivity().getFilesDir();
			}
			File __file2 = new File(__file, $args[0].getAsString());
			return FREObject.newObject(__file2.getAbsolutePath());
		}
		catch(Exception $e)
		{
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}

}
