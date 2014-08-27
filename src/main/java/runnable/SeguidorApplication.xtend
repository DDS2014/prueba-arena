package runnable

import org.uqbar.arena.Application
import ui.SeguidorWindow
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import home.HomeMaterias
import domain.Materia
import org.uqbar.commons.utils.ApplicationContext

class SeguidorApplication extends Application implements WindowOwner
{
	def static void main (String [] args)
	{
		new SeguidorApplication().start()
	}
	
	override protected Window<?> createMainWindow() 
	{
		ApplicationContext.instance.configureSingleton(typeof(Materia), new HomeMaterias);
		return new SeguidorWindow(this);
	}
	
}