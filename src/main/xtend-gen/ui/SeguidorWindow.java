package ui;

import applicationModel.SeguidorDeCarrera;
import domain.Materia;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
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
    listaMaterias.bindItemsToProperty("materiasDisponibles");
    listaMaterias.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
    Button _button = new Button(leftPanel);
    _button.setCaption("Nueva Materia");
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    rightPanel.setLayout(_verticalLayout_1);
    Label _label_1 = new Label(rightPanel);
    Control _setWidth = _label_1.setWidth(200);
    _setWidth.<ControlBuilder>bindValueToProperty("materiaSeleccionadaName");
  }
}
