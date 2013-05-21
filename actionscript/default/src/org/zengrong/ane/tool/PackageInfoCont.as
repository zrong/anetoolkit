package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;

import org.zengrong.ane.enum.PackageInfoFunction;

/**
 * 获取包信息
 * @author zrong
 * 创建日期：2012-6-6
 */
public class PackageInfoCont extends ToolBase
{
	public function PackageInfoCont($context:ExtensionContext)
	{
		super($context);
	}
	
	/**
	 * 获取应用的包名
	 */
	public function getPackageName():String
	{
		return _extension.call(PackageInfoFunction.GET_PACKAGE_NAME) as String;
	}}
}