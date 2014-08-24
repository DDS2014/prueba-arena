package ui;

import applicationModel.SeguidorDeCarrera;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class SeguidorWindow extends SimpleWindow<SeguidorDeCarrera> {
  public SeguidorWindow(final WindowOwner parent, final SeguidorDeCarrera model) {
    super(parent, new SeguidorDeCarrera());
  }
  
  protected void addActions(final Panel arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected void createFormPanel(final Panel arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
