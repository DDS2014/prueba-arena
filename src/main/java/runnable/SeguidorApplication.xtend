package runnable

import org.uqbar.arena.Application
import ui.SeguidorWindow
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner


class SeguidorApplication extends Application implements WindowOwner
{
	def static void main (String [] args)
	{
		new SeguidorApplication().start()
	}
	
	override protected Window<?> createMainWindow() 
	{
		return new SeguidorWindow(this);
	}
	
}