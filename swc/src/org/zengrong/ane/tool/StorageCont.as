package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;

import org.zengrong.ane.enum.StorageFunction;

/**
 * 存储功能
 * @author zrong
 * 创建日期：2012-6-5
 */
public class StorageCont extends ToolBase
{
	
	public function StorageCont($context:ExtensionContext)
	{
		super($context);
	}
	/**
	 * 获取内置存储器的信息
	 */
	public function getInternal():Object
	{
		return _extension.call(StorageFunction.GET_INTERNAL);
	}
	
	/**
	 * 获取外部存储器的信息
	 */
	public function getExternal():Object
	{
		return _extension.call(StorageFunction.GET_EXTERNAL);
	}
	
	/**
	 * 获取外部存储路径中当前应用的file目录
	 */
	public function getExternalFilesDir($name:String):String
	{
		return _extension.call(StorageFunction.GET_EXTERNAL_FILES_DIR, $name) as String;
	}
	
	/**
	 * 获取外部存储器中公用目录
	 */
	public function getExternalPublicDir($type:String):String
	{
		return _extension.call(StorageFunction.GET_EXTERNAL_PUBLIC_DIR, $type) as String;
	}
	
	/**
	 * 获取外部存储器的状态
	 */
	public function getExternalState():String
	{
		return _extension.call(StorageFunction.GET_EXTERNAL_STATE) as String;
	}
	
	/**
	 * 删除一个文件
	 */
	public function delFile($path:String):Boolean
	{
		return _extension.call(StorageFunction.DEL_FILE, $path) as Boolean;
	}
}
}