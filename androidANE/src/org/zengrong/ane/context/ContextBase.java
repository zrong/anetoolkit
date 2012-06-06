package org.zengrong.ane.context;

import java.util.Map;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

abstract public class ContextBase extends FREContext
{

	@Override
	public void dispose()
	{
		String __info = "dispose";
		Log.d(getTag(), __info);
		dispatchStatusEventAsync(__info, getTag());
	}
	
	abstract public String getTag();
	
	@Override
	public Map<String, FREFunction> getFunctions()
	{
		return null;
	}

}
