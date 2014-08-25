package runnable;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import ui.SeguidorWindow;

@SuppressWarnings("all")
public class SeguidorApplication extends Application implements WindowOwner {
  public static void main(final String[] args) {
    SeguidorApplication _seguidorApplication = new SeguidorApplication();
    _seguidorApplication.start();
  }
  
  protected Window<?> createMainWindow() {
    return new SeguidorWindow(this);
  }
}
