package ui;

import domain.Nota;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class EditarNotaWindow extends Dialog<Nota> {
  public EditarNotaWindow(final WindowOwner owner, final Nota model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Editar Nota");
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    Panel row1 = _panel.setLayout(_horizontalLayout);
    Label _label = new Label(row1);
    _label.setText("Fecha:");
    TextBox _textBox = new TextBox(row1);
    Control _setWidth = _textBox.setWidth(150);
    _setWidth.<ControlBuilder>bindValueToProperty("fecha");
    Panel _panel_1 = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    Panel row2 = _panel_1.setLayout(_horizontalLayout_1);
    Label _label_1 = new Label(row2);
    _label_1.setText("Descripcion:");
    TextBox _textBox_1 = new TextBox(row2);
    Control _setWidth_1 = _textBox_1.setWidth(150);
    _setWidth_1.<ControlBuilder>bindValueToProperty("descripcion");
    Panel _panel_2 = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    Panel row3 = _panel_2.setLayout(_horizontalLayout_2);
    CheckBox _checkBox = new CheckBox(row3);
    _checkBox.<ControlBuilder>bindValueToProperty("aprobado");
    Label _label_2 = new Label(row3);
    _label_2.setText("Aprobado");
    Button _button = new Button(mainPanel);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        EditarNotaWindow.this.accept();
      }
    };
    _setCaption.onClick(_function);
  }
}
