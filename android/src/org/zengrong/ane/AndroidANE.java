package org.zengrong.ane;

import org.zengrong.ane.context.IntentCont;
import org.zengrong.ane.context.PackageCont;
import org.zengrong.ane.context.PowerCont;
import org.zengrong.ane.context.PreferenceCont;
import org.zengrong.ane.context.RestartCont;
import org.zengrong.ane.context.StorageCont;
import org.zengrong.ane.context.SystemInfoCont;
import org.zengrong.ane.context.VibratorCont;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class AndroidANE implements FREExtension
{

	public static final String TAG = "org.zengrong.ane.AndroidANE";
	
	public static enum ANEContext{INTENT, VIBRATOR, STORAGE, SYSTEM_INFO, PACKAGE_INFO, PREFERENCE, POWER,RESTART};
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
		//保存和获取共享对象
		if(ANEContext.PREFERENCE.toString().equals($type)) return new PreferenceCont();
		//管理电源
		if(ANEContext.POWER.toString().equals($type)) return new PowerCont();
		//重启应用
		if(ANEContext.RESTART.toString().equals($type)) return new RestartCont();
		
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
