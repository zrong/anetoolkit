package org.zengrong.ane.funs.vibrator;

import android.content.Context;
import android.os.Vibrator;

import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/**
 * 重复调用振动功能
 * @author zrong
 * 创建日期：2012-6-6
 */
public class VibrateRepeat implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.vibrator.VibrateRepeat";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		if($args.length<1)
		{
			_context.dispatchStatusEventAsync("参数不正确！", TAG);
			return null;
		}
		Vibrator __vibrator = (Vibrator) _context.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
		/* for api 11
		if(__vibrator.hashCode())
		{
			_context.dispatchStatusEventAsync("不支持振动！", TAG);
		}
		*/
		try
		{
			FREArray __array = (FREArray) $args[0];
			int __len = (int)__array.getLength();
			long[] __pattern = new long[__len];
			for (int i = 0; i < __len; i++)
			{
				__pattern[i] = __array.getObjectAt(i).getAsInt();
			}
			int __repeat = ($args.length<2) ? -1 : $args[1].getAsInt();
			__vibrator.vibrate(__pattern, __repeat);
		}
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return null;
	}

}
