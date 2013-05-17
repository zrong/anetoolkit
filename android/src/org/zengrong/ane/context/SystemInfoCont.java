package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.systeminfo.BuildInfo;
import org.zengrong.ane.funs.systeminfo.ConnectivityInfo;
import org.zengrong.ane.funs.systeminfo.DisplayMetricsInfo;
import org.zengrong.ane.funs.systeminfo.HardwareInfo;
import org.zengrong.ane.funs.systeminfo.Telephony;

import com.adobe.fre.FREFunction;

/**
 * 获取系统信息功能功能的上下文
 * @author zrong
 * 创建日期：2012-6-6
 */
public class SystemInfoCont extends ContextBase
{

	public static final String TAG = "org.zengrong.ane.context.SystemInfoCont";
	
	/**
	 * 记录所有支持的FREFunction
	 * @author zrong
	 */
	public static enum FUNS{TELEPHONY, BUILD_INFO, HARDWARE_INFO, CONNECTIVITY_INFO, DISPLAY_METRICS_INFO};
	
	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.TELEPHONY.toString(), new Telephony());
		functions.put(FUNS.BUILD_INFO.toString(), new BuildInfo());
		functions.put(FUNS.HARDWARE_INFO.toString(), new HardwareInfo());
		functions.put(FUNS.CONNECTIVITY_INFO.toString(), new ConnectivityInfo());
		functions.put(FUNS.DISPLAY_METRICS_INFO.toString(), new DisplayMetricsInfo());
		return functions;
	}

	@Override
	public String getTag()
	{
		return TAG;
	}

}
