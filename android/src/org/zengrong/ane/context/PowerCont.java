package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.power.Acquire;
import org.zengrong.ane.funs.power.GoToSleep;
import org.zengrong.ane.funs.power.IsScreenOn;
import org.zengrong.ane.funs.power.Reboot;
import org.zengrong.ane.funs.power.Release;
import org.zengrong.ane.funs.power.UserActivity;

import com.adobe.fre.FREFunction;
/**
 * 支持振动功能的上下文
 * @author zrong
 * 创建日期：2012-6-6
 */
public class PowerCont extends ContextBase
{
	public static final String TAG = "org.zengrong.ane.context.PowerCont";
	
	/**
	 * 记录所有支持的FREFunction
	 * @author zrong
	 */
	public static enum FUNS{ACQUIRE, RELEASE, GO_TO_SLEEP, IS_SCREEN_ON, REBOOT, USER_ACTIVITY};
	

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.ACQUIRE.toString(), new Acquire());
		functions.put(FUNS.RELEASE.toString(), new Release());
		functions.put(FUNS.GO_TO_SLEEP.toString(), new GoToSleep());
		functions.put(FUNS.IS_SCREEN_ON.toString(), new IsScreenOn());
		functions.put(FUNS.USER_ACTIVITY.toString(), new UserActivity());
		functions.put(FUNS.REBOOT.toString(), new Reboot());
		return functions;
	}


	@Override
	public String getTag()
	{
		return TAG;
	}

}
