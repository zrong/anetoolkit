package org.zengrong.ane;

import org.zengrong.ane.context.IntentCont;
import org.zengrong.ane.context.PackageCont;
import org.zengrong.ane.context.StorageCont;
import org.zengrong.ane.context.SystemInfoCont;
import org.zengrong.ane.context.VibratorCont;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class AndroidANE implements FREExtension
{

	public static final String TAG = "org.zengrong.ane.AndroidANE";
	
	public static enum ANEContext{INTENT, VIBRATOR, STORAGE, SYSTEM_INFO, PACKAGE_INFO};
	@Override
	public FREContext createContext(String $type)
	{
		//获取存储器状态
		if(ANEContext.STORAGE.toString().equals($type)) return new StorageCont();
		//安装apk的功能
		if(ANEContext.INTENT.toString().equals($type)) return new IntentCont();
		//系统信息
		if(ANEContext.SYSTEM_INFO.toString().equals($type)) return new SystemInfoCont();
		//包信息
		if(ANEContext.PACKAGE_INFO.toString().equals($type)) return new PackageCont();
		//振动功能
		if(ANEContext.VIBRATOR.toString().equals($type)) return new VibratorCont();
		return null;
	}
	    
	@Override
	public void initialize()
	{
		Log.d(TAG, "AndroidANE initialize");
	}
	    
	@Override
	public void dispose()
	{
		Log.d(TAG, "AndroidANE dispose");
	}
}
