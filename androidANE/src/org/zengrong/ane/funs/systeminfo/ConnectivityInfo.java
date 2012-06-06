package org.zengrong.ane.funs.systeminfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取连接状态 
 * @author zrong
 * 创建日期：2012-6-6
 */
public class ConnectivityInfo implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.systeminfo.ConnectivityInfo";
	
	protected FREContext _context;

	@Override
	public FREObject call(FREContext $context, FREObject[] $arg)
	{
		_context = $context;
		try
		{
			ConnectivityManager __cm = (ConnectivityManager) _context.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo __activityNet = __cm.getActiveNetworkInfo();
//			NetworkInfo __mobileNet = __cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//			NetworkInfo __wifiNet = __cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			FREObject __obj = FREObject.newObject("Object", null);
			__obj.setProperty("state", FREObject.newObject(__activityNet.getState().toString()));
			__obj.setProperty("type", FREObject.newObject(__activityNet.getType()));
			__obj.setProperty("typeName", FREObject.newObject(__activityNet.getTypeName()));
			__obj.setProperty("extraInfo", FREObject.newObject(__activityNet.getExtraInfo()));
			__obj.setProperty("reason", FREObject.newObject(__activityNet.getReason()));
			__obj.setProperty("subType", FREObject.newObject(__activityNet.getSubtype()));
			__obj.setProperty("subTypeName", FREObject.newObject(__activityNet.getSubtypeName()));
			__obj.setProperty("isAvailable", FREObject.newObject(__activityNet.isAvailable()));
			__obj.setProperty("isConnected", FREObject.newObject(__activityNet.isConnected()));
			__obj.setProperty("isConnectedOrConnecting", FREObject.newObject(__activityNet.isConnectedOrConnecting()));
			return __obj;
		}
		catch(Exception $e)
		{
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}

}
