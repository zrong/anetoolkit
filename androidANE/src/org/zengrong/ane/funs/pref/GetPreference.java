package org.zengrong.ane.funs.pref;

import android.content.SharedPreferences;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class GetPreference implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.pref.GetPreference";
	
	private FREContext _context;
	
	@Override
	/**
	 * @param $arg 第一个参数是共享对象的名称；第二个参数是键类型；第三个参数为要获取的键名
	 */
	public FREObject call(FREContext $context, FREObject[] $arg)
	{
		_context = $context;
		Log.i(TAG, "getPreference call");
		try
		{
			String __name = $arg[0].getAsString();
			String __keyType = $arg[1].getAsString();
			String __key = $arg[2].getAsString();
			FREObject __obj;
			String __strvalue;
			SharedPreferences __setting = _context.getActivity().getSharedPreferences(__name, 0);
			if(__keyType.equals(PreferenceType.INT))
			{
				int __intvalue = getIntValue(__setting, __key);
				__strvalue = Integer.toString(__intvalue);
				__obj = FREObject.newObject(__intvalue);
			}
			//其他类型都作为String
			else
			{
				__strvalue = getStringValue(__setting, __key);
				__obj = FREObject.newObject(__strvalue);
			}
			Log.i(TAG, "call:"+",keyType:"+__keyType+",key:"+__key+",value:"+__strvalue);
			return __obj;
		} 
		catch (Exception $e)
		{
			Log.e(TAG, $e.getMessage());
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
	
	public int getIntValue(SharedPreferences $setting, String $key)
	{
		return $setting.getInt($key, 0);
	}
	
	public String getStringValue(SharedPreferences $setting, String $key)
	{
		return $setting.getString($key, "");
	}
}
