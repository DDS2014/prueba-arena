package ui;

import applicationModel.SeguidorDeCarrera;
import domain.Materia;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class SeguidorWindow extends SimpleWindow<SeguidorDeCarrera> {
  public SeguidorWindow(final WindowOwner parent) {
    super(parent, new SeguidorDeCarrera());
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    mainPanel.setLayout(_horizontalLayout);
    Panel _panel = new Panel(mainPanel);
    Panel leftPanel = _panel.setWidth(100);
    Panel _panel_1 = new Panel(mainPanel);
    Panel rightPanel = _panel_1.setWidth(500);
    VerticalLayout _verticalLayout = new VerticalLayout();
    leftPanel.setLayout(_verticalLayout);
    Label _label = new Label(leftPanel);
    _label.setText("Materias");
    List<Materia> listaMaterias = new List<Materia>(leftPanel);
    listaMaterias.setHeigth(400);
    listaMaterias.bindItemsToProperty("materiasDisponibles");
    listaMaterias.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
    Button _button = new Button(leftPanel);
    _button.setCaption("Nueva Materia");
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    rightPanel.setLayout(_verticalLayout_1);
    Label _label_1 = new Label(rightPanel);
    Control _setWidth = _label_1.setWidth(200);
    _setWidth.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
    Panel row1 = new Panel(rightPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    row1.setLayout(_horizontalLayout_1);
    Label _label_2 = new Label(row1);
    _label_2.setText("Año");
    TextBox _textBox = new TextBox(row1);
    _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anio_cursada");
    CheckBox _checkBox = new CheckBox(row1);
    _checkBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.final_aprobado");
    Label _label_3 = new Label(row1);
    _label_3.setText("Final aprobado");
    Panel row2 = new Panel(rightPanel);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    row2.setLayout(_horizontalLayout_2);
    Label _label_4 = new Label(row2);
    _label_4.setText("Profesor de cursada");
    TextBox _textBox_1 = new TextBox(row2);
    _textBox_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesor");
    Panel row3 = new Panel(rightPanel);
    HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
    row3.setLayout(_horizontalLayout_3);
    Label _label_5 = new Label(row3);
    _label_5.setText("Ubicación materia");
    TextBox _textBox_2 = new TextBox(row3);
    _textBox_2.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
  }
}
