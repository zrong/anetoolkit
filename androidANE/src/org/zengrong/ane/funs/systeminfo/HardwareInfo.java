package org.zengrong.ane.funs.systeminfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
/**
 * 获取硬件信息
 * @author zrong
 * 创建日期：2012-6-6
 * 部分内容来自：
 * <ol>
 * <li>http://gqdy365.iteye.com/blog/1066113</li>
 * <li>http://hi.baidu.com/lzlsha/blog/item/ac584e22c3b085bb4723e80d.html</li>
 * </ol>
 */
public class HardwareInfo implements FREFunction
{

	public static final String TAG = "org.zengrong.ane.funs.systeminfo.HardwareInfo";
	
	protected FREContext _context;
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		try
		{
			FREObject __obj = FREObject.newObject("Object", null);
			__obj.setProperty("availableMemory", FREObject.newObject(getAvailMemory()));
			__obj.setProperty("availableInternalStorage", FREObject.newObject(getAvailableInternalStorageSize()));
			__obj.setProperty("availableExternalStorage", FREObject.newObject(getAvailableExternalStorageSize()));
			__obj.setProperty("totalMemory", FREObject.newObject(getTotalMemory()));
			__obj.setProperty("totalInternalStorage", FREObject.newObject(getTotalInternalStorageSize()));
			__obj.setProperty("totalExternalStorage", FREObject.newObject(getTotalExternalStorageSize()));
			__obj.setProperty("cpuMaxFreq", FREObject.newObject(getCPUMaxFreq()));
			__obj.setProperty("cpuMinFreq", FREObject.newObject(getCPUMinFreq()));
			__obj.setProperty("cpuCurFreq", FREObject.newObject(getCPUCurFreq()));
			__obj.setProperty("cpuName", FREObject.newObject(getCpuName()));
			return __obj;
		}
		catch(Exception $e)
		{
			_context.dispatchStatusEventAsync($e.getMessage(), TAG);
		}
		return null;
	}
	
	/**
	 * 获取CPU的最大频率
	 * @return
	 */
    public long getCPUMaxFreq() {
        String result = "";
        long __speed = 0;
        ProcessBuilder cmd;
        try {
                String[] args = { "/system/bin/cat",
                                "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" };
                cmd = new ProcessBuilder(args);
                Process process = cmd.start();
                InputStream in = process.getInputStream();
                byte[] re = new byte[24];
                while (in.read(re) != -1) {
                        result = result + new String(re);
                }
                in.close();
                __speed = Integer.valueOf(result.trim()).longValue();
        } catch (IOException $e) {
	        	_context.dispatchStatusEventAsync($e.getMessage(), TAG);
        }
        return __speed;
	}
	
    /**
     * 获取CPU的最小频率
     */
	public long getCPUMinFreq() 
	{
	        String result = "";
	        long __speed = 0;
	        ProcessBuilder cmd;
	        try {
	                String[] args = { "/system/bin/cat",
	                                "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" };
	                cmd = new ProcessBuilder(args);
	                Process process = cmd.start();
	                InputStream in = process.getInputStream();
	                byte[] re = new byte[24];
	                while (in.read(re) != -1) {
	                        result = result + new String(re);
	                }
	                in.close();
	                __speed = Integer.valueOf(result.trim()).longValue();
	        } catch (IOException $e) 
	        {
	        	_context.dispatchStatusEventAsync($e.getMessage(), TAG);
	        }
	        return __speed;
	}
	
	/**
	 * 获取当前CPU频率
	 * @return
	 */
	public long getCPUCurFreq() {
	        long __speed = 0;
	        try {
	                FileReader fr = new FileReader(
	                                "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
	                BufferedReader br = new BufferedReader(fr);
	                String text = br.readLine();
	                __speed = Integer.valueOf(text.trim()).longValue();
	                br.close();
	        } catch (Exception $e) {
	        	_context.dispatchStatusEventAsync($e.getMessage(), TAG);
	        }
	        return __speed;
	}
	
	/**
	 * 获取CPU名称
	 */
	public String getCpuName() {
	        try {
	                FileReader fr = new FileReader("/proc/cpuinfo");
	                BufferedReader br = new BufferedReader(fr);
	                String text = br.readLine();
	                String[] array = text.split(":\\s+", 2);
	                br.close();
	                return array[1];
	        } catch (Exception $e) {
		        _context.dispatchStatusEventAsync($e.getMessage(), TAG);
	        }
	        return null;
	}
	
	/**
	 * 返回总内存大小
	 * @return
	 * @throws IOException 
	 */
	private long getTotalMemory() throws IOException
	{  
		final String __mem = "/proc/meminfo";  
        String __info="";  
        try 
        {  
		     FileReader __fr = new FileReader(__mem);  
	        BufferedReader __bf = new BufferedReader(__fr, 8192);  
	        //总内存位于第一行，因此只需要获取第一行即可
	        __info = __bf.readLine();
//            while ((__info = __bf.readLine()) != null)
//            {  
//            	break;
//            }  
	        __bf.close();
	    	__fr.close();
	    	//提取字符串中的数字，由于是KB值，要乘以1024
	    	Pattern __p = Pattern.compile("\\D+(\\d+)\\D+");
			Matcher __m  = __p.matcher(__info);
			if(__m.matches()) return Integer.valueOf(__m.group(1)).longValue() * 1024;
        }
        catch (IOException $e)
        {  
        	_context.dispatchStatusEventAsync($e.getMessage(), TAG);
        }  
    	return 0;
    }
	
	/**
	 * 返回可用内存大小
	 */
	public long getAvailMemory()
	{  
        ActivityManager __am = (ActivityManager) _context.getActivity().getSystemService(Context.ACTIVITY_SERVICE);  
        ActivityManager.MemoryInfo __mi = new ActivityManager.MemoryInfo();  
        __am.getMemoryInfo(__mi);  
        return __mi.availMem;  
    }  
	
	/**
	 * 返回内部存储器可用大小
	 * @return
	 */
	public long getAvailableInternalStorageSize() 
	{
		//Available rom memory
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		return blockSize * availableBlocks;
	}

	/**
	 * 返回内部存储器总大小
	 */
	public long getTotalInternalStorageSize()
	{
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long totalBlocks = stat.getBlockCount();
		return totalBlocks * blockSize;
	}
	
	/**
	 * 返回外部存储器可用大小
	 * @return
	 */
	public long getAvailableExternalStorageSize() 
	{
		String __state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(__state)) 
		{
			File __sdcardDir = Environment.getExternalStorageDirectory();
			StatFs __sf = new StatFs(__sdcardDir.getPath());
			return __sf.getBlockSize() * __sf.getAvailableBlocks();
		}
		return 0;
	}
	
	/**
	 * 返回外部存储器总大小
	 * @return
	 */
	public long getTotalExternalStorageSize()
	{
		String __state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(__state)) 
		{
			File __sdcardDir = Environment.getExternalStorageDirectory();
			StatFs __sf = new StatFs(__sdcardDir.getPath());
			return __sf.getBlockSize() * __sf.getBlockCount();
		}
		return 0;
	}

}
