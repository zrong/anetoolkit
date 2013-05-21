package org.zengrong.ane.funs.restart;

import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/**
 * 重启AIR应用功能  需要在XML中注册服务
 * @author Rect
 * 创建日期：2013-5-20
 */
public class AppRestart implements FREFunction {
	
	public static final String TAG = "org.zengrong.ane.funs.restart.AppRestart";
	
	private FREContext _context;
	public static int isRstart;
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		FREObject result = null; 
		
		try
		{
			FREObject messageObject = $args[0];
		    isRstart = messageObject.getAsInt();
		}
		catch (Exception e)
	    {
			_context.dispatchStatusEventAsync(TAG, "传入参数错误！");
	    }
		//--------------------------------
		Log.e(TAG, "开始重启");  
		//--------------------------------
		
		Intent intent = new Intent( "com.android.rect.restart.airApp" );
		_context.getActivity().sendBroadcast(intent);
		
	
		
		return result;
	}

}
