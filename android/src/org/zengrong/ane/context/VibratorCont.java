package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.vibrator.Vibrate;
import org.zengrong.ane.funs.vibrator.VibrateCancel;
import org.zengrong.ane.funs.vibrator.VibrateRepeat;

import com.adobe.fre.FREFunction;
/**
 * 支持振动功能的上下文
 * @author zrong
 * 创建日期：2012-6-6
 */
public class VibratorCont extends ContextBase
{
	public static final String TAG = "org.zengrong.ane.context.VibratorCont";
	
	/**
	 * 记录所有支持的FREFunction
	 * @author zrong
	 */
	public static enum FUNS{VIBRATE, VIBRATE_REPEAT, VIBRATE_CANCEL};
	

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.VIBRATE.toString(), new Vibrate());
		functions.put(FUNS.VIBRATE_REPEAT.toString(), new VibrateRepeat());
		functions.put(FUNS.VIBRATE_CANCEL.toString(), new VibrateCancel());
		return functions;
	}


	@Override
	public String getTag()
	{
		return TAG;
	}

}
