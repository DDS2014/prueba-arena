package ui;

import applicationModel.SeguidorDeCarrera;
import com.uqbar.commons.collections.Transformer;
import domain.Materia;
import domain.Nota;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class SeguidorWindow extends SimpleWindow<SeguidorDeCarrera> {
  public SeguidorWindow(final WindowOwner parent) {
    super(parent, new Function0<SeguidorDeCarrera>() {
      public SeguidorDeCarrera apply() {
        SeguidorDeCarrera _seguidorDeCarrera = new SeguidorDeCarrera();
        return _seguidorDeCarrera;
      }
    }.apply());
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Seguidor de Carrera");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    super.createMainTemplate(mainPanel);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    Panel formPanel = _panel.setLayout(_horizontalLayout);
    this.createMateriasListPanel(formPanel);
    Panel _panel_1 = new Panel(formPanel);
    Panel _setWidth = _panel_1.setWidth(500);
    VerticalLayout _verticalLayout = new VerticalLayout();
    Panel rightPanel = _setWidth.setLayout(_verticalLayout);
    this.createMateriaInfoPanel(rightPanel);
    this.createNotasPanel(rightPanel);
  }
  
  protected Button createMateriasListPanel(final Panel mainPanel) {
    Button _xblockexpression = null;
    {
      Panel _panel = new Panel(mainPanel);
      Panel listPanel = _panel.setWidth(100);
      VerticalLayout _verticalLayout = new VerticalLayout();
      listPanel.setLayout(_verticalLayout);
      Label _label = new Label(listPanel);
      _label.setText("Materias");
      List<Materia> _list = new List<Materia>(listPanel);
      List<Materia> listaMaterias = _list;
      listaMaterias.setHeigth(200);
      listaMaterias.bindItemsToProperty("materiasDisponibles");
      listaMaterias.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
      Button _button = new Button(listPanel);
      Button _setCaption = _button.setCaption("Nueva Materia");
      _xblockexpression = (_setCaption);
    }
    return _xblockexpression;
  }
  
  protected Control createNotasPanel(final Panel panel) {
    Control _xblockexpression = null;
    {
      Panel _panel = new Panel(panel);
      Panel notasPanel = _panel;
      VerticalLayout _verticalLayout = new VerticalLayout();
      notasPanel.setLayout(_verticalLayout);
      Table<Nota> _table = new Table<Nota>(notasPanel, Nota.class);
      Table<Nota> table = _table;
      table.setHeigth(100);
      table.setWidth(200);
      ObservableProperty _observableProperty = new ObservableProperty("materiaSeleccionada.notas");
      table.bindItems(_observableProperty);
      this.describeResultsGrid(table);
      Panel _panel_1 = new Panel(notasPanel);
      ColumnLayout _columnLayout = new ColumnLayout(3);
      Panel botonesPanel = _panel_1.setLayout(_columnLayout);
      Button _button = new Button(botonesPanel);
      Button _setCaption = _button.setCaption("Editar");
      _setCaption.setWidth(70);
      Button _button_1 = new Button(botonesPanel);
      Button _setCaption_1 = _button_1.setCaption("+");
      _setCaption_1.setWidth(70);
      Button _button_2 = new Button(botonesPanel);
      Button _setCaption_2 = _button_2.setCaption("-");
      Control _setWidth = _setCaption_2.setWidth(70);
      _xblockexpression = (_setWidth);
    }
    return _xblockexpression;
  }
  
  public void describeResultsGrid(final Table<Nota> table) {
    Column<Nota> _column = new Column<Nota>(table);
    Column<Nota> _setTitle = _column.setTitle("Fecha");
    Column<Nota> _setFixedSize = _setTitle.setFixedSize(75);
    final Transformer<Nota,String> _function = new Transformer<Nota,String>() {
      public String transform(final Nota nota) {
        SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date _fecha = nota.getFecha();
        String _format = _simpleDateFormat.format(_fecha);
        return _format;
      }
    };
    _setFixedSize.<String>bindContentsToTransformer(_function);
    Column<Nota> _column_1 = new Column<Nota>(table);
    Column<Nota> _setTitle_1 = _column_1.setTitle("Descripción");
    Column<Nota> _setFixedSize_1 = _setTitle_1.setFixedSize(75);
    _setFixedSize_1.bindContentsToProperty("descripcion");
    Column<Nota> _column_2 = new Column<Nota>(table);
    Column<Nota> _setTitle_2 = _column_2.setTitle("Aprobado");
    Column<Nota> _setFixedSize_2 = _setTitle_2.setFixedSize(50);
    final Transformer<Nota,String> _function_1 = new Transformer<Nota,String>() {
      public String transform(final Nota nota) {
        String _xifexpression = null;
        boolean _isAprobado = nota.isAprobado();
        if (_isAprobado) {
          _xifexpression = "SI";
        } else {
          _xifexpression = "NO";
        }
        return _xifexpression;
      }
    };
    _setFixedSize_2.<String>bindContentsToTransformer(_function_1);
  }
  
  protected Binding<ControlBuilder> createMateriaInfoPanel(final Panel rightPanel) {
    Binding<ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(rightPanel);
      Control _setWidth = _label.setWidth(200);
      _setWidth.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
      Panel _panel = new Panel(rightPanel);
      Panel row1 = _panel;
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      row1.setLayout(_horizontalLayout);
      Label _label_1 = new Label(row1);
      _label_1.setText("Año");
      TextBox _textBox = new TextBox(row1);
      _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anio_cursada");
      CheckBox _checkBox = new CheckBox(row1);
      _checkBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.final_aprobado");
      Label _label_2 = new Label(row1);
      _label_2.setText("Final aprobado");
      Panel _panel_1 = new Panel(rightPanel);
      Panel row2 = _panel_1;
      HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
      row2.setLayout(_horizontalLayout_1);
      Label _label_3 = new Label(row2);
      _label_3.setText("Profesor de cursada");
      TextBox _textBox_1 = new TextBox(row2);
      _textBox_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesor");
      Panel _panel_2 = new Panel(rightPanel);
      Panel row3 = _panel_2;
      HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
      row3.setLayout(_horizontalLayout_2);
      Label _label_4 = new Label(row3);
      _label_4.setText("Ubicación materia");
      TextBox _textBox_2 = new TextBox(row3);
      Binding<ControlBuilder> _bindValueToProperty = _textBox_2.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
      _xblockexpression = (_bindValueToProperty);
    }
    return _xblockexpression;
  }
}
