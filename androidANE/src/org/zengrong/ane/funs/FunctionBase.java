package org.zengrong.ane.funs;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

abstract public class FunctionBase implements FREFunction
{

	@Override
	abstract public FREObject call(FREContext arg0, FREObject[] arg1);
	

}
