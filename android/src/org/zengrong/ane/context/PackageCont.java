package org.zengrong.ane.context;

import java.util.HashMap;
import java.util.Map;

import org.zengrong.ane.funs.pack.GetPackageName;

import com.adobe.fre.FREFunction;

public class PackageCont extends ContextBase
{

	public static final String TAG = "org.zengrong.ane.context.PackageCont";
	
	/**
	 * 记录所有支持的FREFunction
	 * @author zrong
	 */
	public static enum FUNS{GET_PACKAGE_NAME};
	
	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(FUNS.GET_PACKAGE_NAME.toString(), new GetPackageName());
		return functions;
	}

	@Override
	public String getTag()
	{
		return TAG;
	}

}
