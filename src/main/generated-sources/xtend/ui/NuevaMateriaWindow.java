package ui;

import applicationModel.SeguidorDeCarrera;
import domain.Materia;
import home.HomeMaterias;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class NuevaMateriaWindow extends Dialog<Materia> {
  private SeguidorDeCarrera seguidor;
  
  public NuevaMateriaWindow(final WindowOwner owner, final SeguidorDeCarrera seguidor) {
    super(owner, new Materia());
    this.seguidor = seguidor;
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Nueva Materia");
    final Panel form = new Panel(mainPanel);
    Label _label = new Label(form);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(form);
    Control _setWidth = _textBox.setWidth(200);
    _setWidth.<ControlBuilder>bindValueToProperty("nombre");
    Button _button = new Button(form);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        NuevaMateriaWindow.this.accept();
      }
    };
    _setCaption.onClick(_function);
  }
  
  public void executeTask() {
    HomeMaterias _homeMaterias = this.seguidor.getHomeMaterias();
    Materia _modelObject = this.getModelObject();
    _homeMaterias.create(_modelObject);
    super.executeTask();
    this.seguidor.search();
  }
}
