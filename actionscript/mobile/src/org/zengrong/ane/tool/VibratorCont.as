package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;

import org.zengrong.ane.enum.VibratorFunction;
/**
 * 振动功能
 * @author zrong
 * 创建日期：2012-6-6
 */
public class VibratorCont extends ToolBase
{
	public function VibratorCont($context:ExtensionContext)
	{
		super($context);
	}
	
	/**
	 * 振动
	 * @param $ms 振动的毫秒数
	 */
	public function vibrate($ms:uint=50):void
	{
		if($ms == 0) throw new RangeError('请提供一个大于0的整数！');
		_extension.call(VibratorFunction.VIBRATE, $ms);
	}
	
	/**
	 * 重复振动 
	 * @param $pattern 振动的节奏。数组的第一个元素代表振动毫秒，第二个代表停止毫秒，依此类推
	 * @param $repeat 重复次数，-1为不重复
	 */	
	public function vibrateRepeat($pattern:Vector.<int>, $repeat:int=-1):void
	{
		if($pattern.length==0) throw new RangeError('请提供一个正确的Vector!');
		_extension.call(VibratorFunction.VIBRATE_REPEAT, $pattern, $repeat);
	}
	
	/**
	 * 取消振动
	 */
	public function vibrateCancel():void
	{
		_extension.call(VibratorFunction.VIBRATE_CANCEL);
	}
}
}