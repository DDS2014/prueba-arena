package ui

import org.uqbar.arena.windows.SimpleWindow
import applicationModel.SeguidorDeCarrera
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner

class SeguidorWindow extends SimpleWindow<SeguidorDeCarrera>
{
	
	new(WindowOwner parent, SeguidorDeCarrera model) {
		super(parent, new SeguidorDeCarrera)
	}
	
	override protected addActions(Panel arg0) 
	{
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel arg0) 
	{
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}