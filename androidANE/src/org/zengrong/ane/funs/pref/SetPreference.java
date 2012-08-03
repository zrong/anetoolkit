package org.zengrong.ane.funs.pref;

import android.content.SharedPreferences;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class SetPreference implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.pref.SetPreference";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		try
		{
			String __name = $args[0].getAsString();
			String __keyType = $args[1].getAsString();
			String __key = $args[2].getAsString();
			if(__keyType.equals(PreferenceType.INT))
			{
				setIntValue(_context.getActivity().getSharedPreferences(__name, 0), __key, $args[3].getAsInt());
				Log.i(TAG, "call:"+__name+",int,key:"+__key+",value:"+Integer.toString($args[3].getAsInt()));
			}
			else
			{
				setStringValue(_context.getActivity().getSharedPreferences(__name, 0), __key, $args[3].getAsString());
				Log.i(TAG, "call:"+__name+",int,key:"+__key+",value:"+$args[3].getAsString());
			}
		}
		catch(Exception $e)
		{
			Log.e(TAG, $e.getMessage());
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
	
	public void setStringValue(SharedPreferences $setting, String $key, String $value)
	{
		$setting.edit().putString($key, $value).commit();
	}
	
	public void setIntValue(SharedPreferences $setting, String $key, int $value)
	{
		$setting.edit().putInt($key, $value).commit();
	}
}
