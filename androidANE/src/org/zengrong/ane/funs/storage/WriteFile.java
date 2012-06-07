package org.zengrong.ane.funs.storage;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;

import android.util.Log;

import com.adobe.fre.FREByteArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

/**
 * 写入文件
 * @author zrong
 * 创建日期：2012-6-7
 */
public class WriteFile implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.WriteFile";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		if ($args == null || $args.length<3)
		{
			String __info = "参数提供错误！";
			Log.e(TAG, __info);
			_context.dispatchStatusEventAsync(__info, TAG);
			return null;
		}
		try
		{
			String __filepath = $args[0].getAsString();
			//建立文件流
			FileOutputStream __outFile = new FileOutputStream(__filepath, $args[2].getAsBool());
			__outFile.write(getByteArray((FREByteArray) $args[1]));
			__outFile.close();
			return FREObject.newObject(true);
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return null;
	}
	
	/**
	 * 将FREByteArray转换成byte[]
	 * @param $ba
	 * @return
	 * @throws FREWrongThreadException 
	 * @throws FREInvalidObjectException 
	 * @throws IllegalStateException 
	 */
	public byte[] getByteArray(FREByteArray $ba) throws IllegalStateException, FREInvalidObjectException, FREWrongThreadException
	{
		//锁定参数
		$ba.acquire();
		ByteBuffer __bb = $ba.getBytes();
		//建立一个数组保存传递来的参数
		byte[] __byte = new byte[(int) $ba.getLength()];
		__bb.get(__byte);
		$ba.release();
		//获取字节数组
		return __byte;
	}

}
