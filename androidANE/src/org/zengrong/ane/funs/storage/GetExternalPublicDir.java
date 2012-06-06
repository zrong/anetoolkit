package org.zengrong.ane.funs.storage;

import android.os.Environment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取外部存储公开路径
 * @author zrong
 * 创建日期：2012-6-5
 */
public class GetExternalPublicDir implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetExternalPublicDir";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		FREObject __obj = null;
		if($args.length<1)
		{
			_context.dispatchStatusEventAsync("参数提供错误！", TAG);
			return null;
		}
		try
		{
			__obj = FREObject.newObject(Environment.getExternalStoragePublicDirectory($args[0].getAsString()).getAbsolutePath());
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return __obj;
	}

}
