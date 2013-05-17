package org.zengrong.ane.enum
{
/**
 * 定义存储器上下文中所有功能的枚举
 * @author zrong
 * 创建日期：2012-6-5
 */
public class StorageFunction
{
	/**
	 * 获取外部存储器状态的命令枚举
	 */
	public static const GET_EXTERNAL_STATE:String = 'GET_EXTERNAL_STATE';
	
	/**
	 * 获取内部存储器路径的命令枚举
	 */
	public static const GET_INTERNAL:String = 'GET_INTERNAL';
	
	/**
	 * 获取外部存储器路径的命令枚举
	 */
	public static const GET_EXTERNAL:String = 'GET_EXTERNAL';
	
	/**
	 * 获取外部存储路径中当前应用的file目录
	 */
	public static const GET_EXTERNAL_FILES_DIR:String = 'GET_EXTERNAL_FILES_DIR';
	
	/**
	 * 获取外部存储器中公用目录
	 */
	public static const GET_EXTERNAL_PUBLIC_DIR:String = 'GET_EXTERNAL_PUBLIC_DIR';

	/**
	 * 删除文件
	 */
	public static const DEL_FILE:String = 'DEL_FILE';
	
	/**
	 * 获取文件状态
	 */
	public static const GET_FILE_STATE:String = 'GET_FILE_STATE';
	
	/**
	 * 写入文件
	 */
	public static const WRITE_FILE:String = 'WRITE_FILE';
	
	/**
	 * 读取文件
	 */
	public static const READ_FILE:String = 'READ_FILE';
	
	/**
	 * 获取可用的目录
	 */
	public static const GET_AVAILABLE_FILES_DIR:String = 'GET_AVAILABLE_FILES_DIR';
	
	/**
	 * 获取目录
	 */
	public static const GET_DIR:String = 'GET_DIR';
}
}