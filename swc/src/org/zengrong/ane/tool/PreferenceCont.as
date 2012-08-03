package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;

import org.zengrong.ane.enum.IntentFunction;
import org.zengrong.ane.enum.PreferenceFunction;

/**
 * 提供对Android中的SharedPreference的调用方法<br>
 * AIR中的SharedObject保存的格式对于Android来说无法识别。<br>
 * AIR和Android都需要访问的共享数据，应该使用SHaredPreference来保存。
 * @author zrong
 * 创建日期：2012-08-02
 */
public class PreferenceCont extends ToolBase
{
	public function PreferenceCont($context:ExtensionContext)
	{
		super($context);
	}
	
	/**
	 * 获取保存的值
	 * @param $settingName 保存的对象的名称
	 * @param $keyType 值的类型
	 * @param $keyName 值的名称
	 */	
	public function getValue($settingName:String, $keyType:String, $keyName:String):*
	{
		return _extension.call(PreferenceFunction.GET_PREFERENCE, $settingName, $keyType, $keyName);
	}
	
	/**
	 * 获取保存的值
	 * @param $settingName 保存的对象的名称
	 * @param $keyType 值的类型
	 * @param $keyName 值的名称
	 * @param $value 要保存的值
	 */	
	public function setValue($settingName:String, $keyType:String, $keyName:String, $value:*):void
	{
		_extension.call(PreferenceFunction.SET_PREFERENCE, $settingName, $keyType, $keyName, $value);
	}
}
}