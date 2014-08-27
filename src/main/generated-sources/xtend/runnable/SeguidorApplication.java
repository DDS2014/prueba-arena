package runnable;

import domain.Materia;
import home.HomeMaterias;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import ui.SeguidorWindow;

@SuppressWarnings("all")
public class SeguidorApplication extends Application implements WindowOwner {
  public static void main(final String[] args) {
    SeguidorApplication _seguidorApplication = new SeguidorApplication();
    _seguidorApplication.start();
  }
  
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
    return new SeguidorWindow(this);
  }
}
