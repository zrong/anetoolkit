package org.zengrong.ane.tool 
{ 
	import flash.external.ExtensionContext;
	
	import org.zengrong.ane.enum.AppRestart;
	
	/**
	 * 重启AIR应用
	 * @author Rect  2013-5-20 
	 * 
	 */
	public class RestartCont extends ToolBase 
	{ 
		public function RestartCont($context:ExtensionContext)
		{
			super($context);
		} 
		
		/**
		 * 重启AIR
		 * @param $key 
		 */
		public function restartApp($key:int = 0):void
		{
			_extension.call(AppRestart.RESTART, $key);
		}
	} 
}