package org.zengrong.ane.funs.power;

import android.view.WindowManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 使用 WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON的方法来保持当前Activity常亮
 * @author zrong
 * 创建日期：2013-01-25
 */
public class FlagKeepScreenOn implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.power.FlagKeepScreenOn";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $content, FREObject[] $args)
	{
		_context = $content;
		_context.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		return null;
	}

}
