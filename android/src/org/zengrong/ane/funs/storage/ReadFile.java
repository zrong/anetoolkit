package org.zengrong.ane.funs.storage;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

import android.util.Log;

import com.adobe.fre.FREByteArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/**
 * 读取文件，返回AS ByteArray对象
 * @author zrong
 * 创建日期：2012-6-7
 */
public class ReadFile implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.storage.ReadFile";
	
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		if ($args == null || $args.length<1)
		{
			String __info = "参数提供错误！";
			Log.e(TAG, __info);
			_context.dispatchStatusEventAsync(__info, TAG);
			return null;
		}
		try
		{
			String __filepath = $args[0].getAsString();
			File __file = new File(__filepath);
			if(__file.exists() && __file.isFile())
			{
				FileInputStream __inputFile = new FileInputStream(__file);
				byte[] __byte = new byte[(int) __file.length()];
				__inputFile.read(__byte);
				__inputFile.close();
				FREByteArray __ba = FREByteArray.newByteArray();
				//必须先设置length，否则写入数据不会成功
				__ba.setProperty("length", FREObject.newObject(__file.length()));
				__ba.acquire();
				ByteBuffer __bb = __ba.getBytes();
				__bb.put(__byte);
				__ba.release();
				return __ba;
			}
		} 
		catch (Exception e)
		{
			_context.dispatchStatusEventAsync(e.getMessage(), TAG);
		}
		return null;
	}
}
