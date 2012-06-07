package org.zengrong.ane.funs;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

abstract public class FunctionBase implements FREFunction
{

	private FREContext _context;
	
	abstract protected int getArgNum();
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		return null;

	}
	
	protected void checkArgs(FREObject[] $args)
	{

	}
	

}
