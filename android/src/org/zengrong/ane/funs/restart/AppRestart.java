package org.zengrong.ane.funs.restart;

import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/**
 * 重启AIR应用功能  需要在XML中注册服务  自行注册服务重启
 * @author Rect
 * 创建日期：2013-5-20
 */
public class AppRestart implements FREFunction {
	
	public static final String TAG = "org.zengrong.ane.funs.restart.AppRestart";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		Log.e(TAG, "开始重启A");  
		//--------------------------------
		Intent intent = new Intent( "com.android.rect.restart.airApp" );
		_context.getActivity().sendBroadcast(intent);
		return result;
	}

}
