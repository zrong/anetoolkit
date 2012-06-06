package org.zengrong.ane.funs.systeminfo;

import android.os.Build;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 获取版本信息
 * @author zrong
 * 创建日期：2012-6-6
 */
public class BuildInfo implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.systeminfo.BuildInfo";
	
	protected FREContext _context;

	@Override
	public FREObject call(FREContext $context, FREObject[] $arg)
	{
		_context = $context;
		try
		{
			FREObject __obj = FREObject.newObject("Object", null);
			FREObject __versionObj = FREObject.newObject("Object", null);
			__versionObj.setProperty("CODENAME", FREObject.newObject(Build.VERSION.CODENAME));
			__versionObj.setProperty("INCREMENTAL", FREObject.newObject(Build.VERSION.INCREMENTAL));
			__versionObj.setProperty("RELEASE", FREObject.newObject(Build.VERSION.RELEASE));
			__versionObj.setProperty("SDK_INT", FREObject.newObject(Build.VERSION.SDK_INT));
			__obj.setProperty("VERSION", __versionObj);
			__obj.setProperty("BOARD", FREObject.newObject(Build.BOARD));
			__obj.setProperty("BOOTLOADER", FREObject.newObject(Build.BOOTLOADER));
			__obj.setProperty("BRAND", FREObject.newObject(Build.BRAND));
			__obj.setProperty("CPU_ABI", FREObject.newObject(Build.CPU_ABI));
			__obj.setProperty("CPU_ABI2", FREObject.newObject(Build.CPU_ABI2));
			__obj.setProperty("DEVICE", FREObject.newObject(Build.DEVICE));
			__obj.setProperty("DISPLAY", FREObject.newObject(Build.DISPLAY));
			__obj.setProperty("FINGERPRINT", FREObject.newObject(Build.FINGERPRINT));
			__obj.setProperty("HARDWARE", FREObject.newObject(Build.HARDWARE));
			__obj.setProperty("HOST", FREObject.newObject(Build.HOST));
			__obj.setProperty("ID", FREObject.newObject(Build.ID));
			__obj.setProperty("MANUFACTURER", FREObject.newObject(Build.MANUFACTURER));
			__obj.setProperty("MODEL", FREObject.newObject(Build.MODEL));
			__obj.setProperty("PRODUCT", FREObject.newObject(Build.PRODUCT));
			__obj.setProperty("RADIO", FREObject.newObject(Build.RADIO));
			//for api 9
			//__obj.setProperty("RADIO", FREObject.newObject(Build.getRadioVersion()));
			__obj.setProperty("TAGS", FREObject.newObject(Build.TAGS));
			__obj.setProperty("TIME", FREObject.newObject(Build.TIME));
			__obj.setProperty("TYPE", FREObject.newObject(Build.TYPE));
			__obj.setProperty("USER", FREObject.newObject(Build.USER));
			//for api 9
			//__obj.setProperty("SERIAL", FREObject.newObject(Build.SERIAL));
			return __obj;
		}
		catch(Exception $e)
		{
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}

}
