package org.zengrong.ane.tool
{
import flash.external.ExtensionContext;
import flash.utils.ByteArray;

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
	 * 获取外部存储器的状态，状态的枚举见<pre>org.zengrong.ane.enum.StorageState</pre>
	 * @see org.zengrong.ane.enum.StorageState
	 */
	public function getExternalState():String
	{
		return _extension.call(StorageFunction.GET_EXTERNAL_STATE) as String;
	}
	
	/**
	 * 获取文件的状态，形如：<br>
	 * <pre>
	 * {exists:fale, isDirectory:false, isFile:false}
	 * </pre>
	 */
	public function getFileState($path:String):Object
	{
		if(!$path) throw TypeError('必须提供文件的完整路径！');
		return _extension.call(StorageFunction.GET_FILE_STATE, $path);
	}
	
	/**
	 * 返回当前应用的专用存储目录。<br>
	 * 如果有外置存储器，返回外置存储器中分配给当前应用的路径。一般位于<pre>/mnt/sdcard/Android/data/[app id]/files</pre><br>
	 * 如果没有外置存储器，返回内置存储器中分配给当前应用的路径。一般位于<pre>/data/data/[app id]/files</pre><br>
	 */
	public function getAvailableFilesDir($path:String):String
	{
		if(!$path) throw TypeError('必须提供文件的完整路径！');
		return _extension.call(StorageFunction.GET_AVAILABLE_FILES_DIR, $path) as String;
	}
	
	/**
	 * 读取一个文件，返回文件的ByteArray数据<br>
	 * AIR对内部存储器中的文件有读取限制，这个方法能解除这个限制。
	 */
	public function readFile($path:String):ByteArray
	{
		if(!$path) throw TypeError('必须提供文件的完整路径！');
		return _extension.call(StorageFunction.READ_FILE, $path) as ByteArray;
	}
	
	/**
	 * 将ByteArray数据写入一个文件。<br>
	 * AIR对内部存储器中的文件有读取限制，这个方法能解除这个限制。
	 * @param $path 要写入文件的绝对路径，这个路径可以通过本类中的其他get方法得到。
	 * @param $ba 要写入的文件数据。
	 * @param $append 是否使用增量写入。增量写入会将数据插入到已存在文件尾部，否则会直接替换文件。如果该文件不存在，会自动创建。
	 * @return true写入成功,false写入失败。失败的可能性包括无法成功创建文件，或者无法替换现有文件。
	 */	
	public function writeFile($path:String, $ba:ByteArray, $append:Boolean=false):ByteArray
	{
		if(!$path || !$ba || $ba.length==0) throw TypeError('必须提供文件的完整路径和内容！');
		return _extension.call(StorageFunction.WRITE_FILE, $path, $ba, $append) as ByteArray;
	}
	
	/**
	 * 删除一个文件，返回删除成功true或者失败false。
	 */
	public function delFile($path:String):Boolean
	{
		if(!$path) throw TypeError('必须提供文件的完整路径！');
		return _extension.call(StorageFunction.DEL_FILE, $path) as Boolean;
	}
	
	/**
	 * 在内置存储器的程序文件夹下建立一个文件夹<br>
	 * 默认路径为/data/data/[app id]/app_[$name]<br>
	 * @param $name 文件名
	 * @param $mode 建立的目录的权限，1代表771权限，2代表775权限，3代表777权限
	 * @return 创建的文件夹的绝对路径
	 */	
	public function getDir($name:String, $mode:int=0):String
	{
		if(!$name) throw TypeError('必须提供目录名称！');
		if($mode <0 || $mode>2) throw TypeError('mode的值只能是0/1/2!');
		return _extension.call(StorageFunction.GET_DIR, $name, $mode) as String;
	}
}
}