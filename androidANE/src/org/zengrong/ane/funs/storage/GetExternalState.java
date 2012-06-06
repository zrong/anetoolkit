package org.zengrong.ane.funs.storage;

import android.os.Environment;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取外部存储器的状态
 * @author zrong
 * 创建日期：2012-6-5
 */
public class GetExternalState implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.GetExternalState";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		FREObject __obj = null;
		try
		{
			__obj = FREObject.newObject(Environment.getExternalStorageState());
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return __obj;
	}

}
