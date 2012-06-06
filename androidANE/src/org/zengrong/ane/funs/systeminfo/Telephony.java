package org.zengrong.ane.funs.systeminfo;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/**
 * 获取电话信息
 * @author zrong
 * 创建日期：2012-6-6
 */
public class Telephony implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.systeminfo.Telephony";
	
	protected FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $arg)
	{
		_context = $context;
		try
		{
			TelephonyManager __tm = (TelephonyManager) _context.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
			FREObject __obj = FREObject.newObject("Object", null);
			__obj.setProperty("callState", FREObject.newObject(__tm.getCallState()));
			__obj.setProperty("dataActivity", FREObject.newObject(__tm.getDataActivity()));
			__obj.setProperty("dataState", FREObject.newObject(__tm.getDataState()));
			__obj.setProperty("deviceId", FREObject.newObject(__tm.getDeviceId()));
			__obj.setProperty("deviceSoftwareVersion", FREObject.newObject(__tm.getDeviceSoftwareVersion()));
			__obj.setProperty("line1Number", FREObject.newObject(__tm.getLine1Number()));
			__obj.setProperty("networkCountryIso", FREObject.newObject(__tm.getNetworkCountryIso()));
			__obj.setProperty("networkOperator", FREObject.newObject(__tm.getNetworkOperator()));
			__obj.setProperty("networkOperatorName", FREObject.newObject(__tm.getNetworkOperatorName()));
			__obj.setProperty("networkType", FREObject.newObject(__tm.getNetworkType()));
			__obj.setProperty("phoneType", FREObject.newObject(__tm.getPhoneType()));
			__obj.setProperty("simCountryIso", FREObject.newObject(__tm.getSimCountryIso()));
			__obj.setProperty("simOperator", FREObject.newObject(__tm.getSimOperator()));
			__obj.setProperty("simOperatorName", FREObject.newObject(__tm.getSimOperatorName()));
			__obj.setProperty("simSerialNumber", FREObject.newObject(__tm.getSimSerialNumber()));
			__obj.setProperty("simState", FREObject.newObject(__tm.getSimState()));
			__obj.setProperty("subscriberId", FREObject.newObject(__tm.getSubscriberId()));
			__obj.setProperty("voiceMailAlphaTag", FREObject.newObject(__tm.getVoiceMailAlphaTag()));
			__obj.setProperty("voiceMailNumber", FREObject.newObject(__tm.getVoiceMailNumber()));
			__obj.setProperty("hasIccCard", FREObject.newObject(__tm.hasIccCard()));
			__obj.setProperty("isNetworkRoaming", FREObject.newObject(__tm.isNetworkRoaming()));
			return __obj;
		}
		catch(Exception $e)
		{
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}

}
