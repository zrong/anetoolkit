package org.zengrong.ane.funs.intent;

import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 打开设置界面
 * @author zrong
 * 创建日期：2012-6-4
 */
public class OpenSettings implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.intent.OpenSettings";
	
	/**
	 * 保存上下文
	 */
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		String __info = "";
		if ($args == null || $args.length<1)
		{
			__info = "参数提供错误！";
			Log.e(TAG, __info);
			_context.dispatchStatusEventAsync(__info, TAG);
			return null;
		}
		try
		{
			Intent __settings = new Intent($args[0].getAsString());
			_context.getActivity().startActivity(__settings);
		} 
		catch (Exception e1)
		{
			_context.dispatchStatusEventAsync( e1.getMessage(), TAG);
		}
		return null;
	}

}
