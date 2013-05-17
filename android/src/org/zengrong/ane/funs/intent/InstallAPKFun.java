package org.zengrong.ane.funs.intent;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 调用真正的安装APK功能
 * @author zrong
 * 创建日期：2012-6-4
 */
public class InstallAPKFun implements FREFunction
{
	public static final String TAG = "org.zengrong.ane.funs.intent.InstallAPKFun";
	
	/**
	 * 保存上下文
	 */
	private FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		String __info = "";
		if ($args == null || $args.length<1)
		{
			__info = "参数提供错误！";
			Log.e(TAG, __info);
			_context.dispatchStatusEventAsync(__info, TAG);
			return null;
		}
		try
		{
			Intent __install = new Intent(Intent.ACTION_VIEW);
			//__install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			File __file = new File($args[0].getAsString());
			__install.setDataAndType(Uri.fromFile(__file), "application/vnd.android.package-archive");
			_context.getActivity().startActivity(__install);
		} 
		catch (Exception e1)
		{
			_context.dispatchStatusEventAsync( e1.getMessage(), TAG);
		}
		return null;
	}

}
