package org.zengrong.ane.tool
{
import flash.events.EventDispatcher;
import flash.events.StatusEvent;
import flash.external.ExtensionContext;

public class ToolBase extends EventDispatcher
{
	public function ToolBase($context:ExtensionContext)
	{
		_extension = $context;
		if(!_extension) throw new TypeError('必须提供ExtensionContext实例！');
		_extension.addEventListener(StatusEvent.STATUS, handler_status);
	}
	
	protected var _extension:ExtensionContext;
	
	public function get extension():ExtensionContext
	{
		if(!_extension) throw new TypeError('ExtensionContext为空！');
		return _extension;
	}
	
	protected function handler_status($evt:StatusEvent):void
	{
		if(!$evt) return;
		this.dispatchEvent($evt);
	}
	
	public function dispose():void
	{
		if(_extension)
		{
			_extension.removeEventListener(StatusEvent.STATUS, handler_status);
			_extension.dispose();
			_extension = null;
		}
	}
}
}