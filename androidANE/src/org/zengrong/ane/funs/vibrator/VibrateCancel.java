package org.zengrong.ane.funs.vibrator;

import android.content.Context;
import android.os.Vibrator;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class VibrateCancel implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.vibrator.VibrateCancel";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		Vibrator __vibrator = (Vibrator) _context.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
		__vibrator.cancel();
		return null;
	}

}
