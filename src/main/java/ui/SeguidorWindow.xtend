package ui

import org.uqbar.arena.windows.SimpleWindow
import applicationModel.SeguidorDeCarrera
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Button
import domain.Materia
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Spinner
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.tables.Table
import domain.Nota
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.bindings.ObservableProperty
import java.text.SimpleDateFormat
import org.uqbar.arena.windows.Dialog

class SeguidorWindow extends SimpleWindow<SeguidorDeCarrera>
{
	
	new(WindowOwner parent) {
		super(parent, new SeguidorDeCarrera)
		modelObject.search()
	}

	
	override protected addActions(Panel actionsPanel) 
	{
		//este panel me va a quedar vacío supongo
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = "Seguidor de Carrera"
		
		mainPanel.setLayout(new VerticalLayout)
		
		super.createMainTemplate(mainPanel)
	}
	
	override protected createFormPanel(Panel mainPanel) 
	{
		var formPanel = new Panel(mainPanel).setLayout(new HorizontalLayout)
		
		this.createMateriasListPanel(formPanel)
		
		var rightPanel = new Panel(formPanel).setWidth(500).setLayout(new VerticalLayout)
		
		this.createMateriaInfoPanel(rightPanel)
		
		this.createNotasPanel(rightPanel)
	}
	
	def protected createMateriasListPanel(Panel mainPanel){
		
		var listPanel = new Panel(mainPanel).setWidth(100)
		listPanel.setLayout(new VerticalLayout)		
				
		new Label(listPanel)
			.setText("Materias")
		var listaMaterias = new List<Materia>(listPanel)
			listaMaterias.setHeigth(200)
			listaMaterias.bindItemsToProperty("materiasDisponibles")
			listaMaterias.bindValueToProperty("materiaSeleccionada")
			
		new Button(listPanel)
			.setCaption("Nueva Materia")
			.onClick [ | this.agregarMateria ]
	}
	
	def protected createNotasPanel(Panel panel){
		var notasPanel = new Panel(panel)
		notasPanel.setLayout(new VerticalLayout)
		
		var table = new Table<Nota>(notasPanel, typeof(Nota))
		table.heigth = 100
		table.width = 200
		table.bindItems(new ObservableProperty("materiaSeleccionada.notas"))
		this.describeResultsGrid(table)
		
		
		var botonesPanel = new Panel(notasPanel).setLayout(new ColumnLayout(3))
		
		new Button(botonesPanel)
			.setCaption("Editar")
			.onClick [ | this.editarNota ]
			
		new Button(botonesPanel)
			.setCaption("+")
			.onClick [ | modelObject.agregarNota]
			
		new Button(botonesPanel)
			.setCaption("-")
			.onClick [| modelObject.removerNotaSeleccionada]
	}
	
	
	
	def void describeResultsGrid(Table<Nota> table) {
		new Column<Nota>(table)
			.setTitle("Fecha")
			.setFixedSize(75)
			.bindContentsToTransformer([nota | new SimpleDateFormat("dd/MM/yyyy").format(nota.fecha)])	
		
		new Column<Nota>(table)
			.setTitle("Descripción")
			.setFixedSize(75)
			.bindContentsToProperty("descripcion")

		new Column<Nota>(table)
			.setTitle("Aprobado")
			.setFixedSize(50)
			.bindContentsToTransformer([nota | if (nota.aprobado) "SI" else "NO"])
			
		table.bindSelectionToProperty("notaSeleccionada")
	}
	
	def protected createMateriaInfoPanel(Panel rightPanel){
		
		new Label(rightPanel)
			.setWidth(200)
			.bindValueToProperty("materiaSeleccionada.nombre")
			
		var row1 = new Panel(rightPanel)
			row1.setLayout(new HorizontalLayout)
			
			new Label(row1).setText("Año")
			new TextBox(row1).bindValueToProperty("materiaSeleccionada.anio_cursada")
			
			new CheckBox(row1).bindValueToProperty("materiaSeleccionada.final_aprobado")
			new Label(row1).setText("Final aprobado")
		
		var row2 = new Panel(rightPanel)
			row2.setLayout(new HorizontalLayout)
			
			new Label(row2).setText("Profesor de cursada")
			new TextBox(row2).bindValueToProperty("materiaSeleccionada.profesor")
			
		var row3 = new Panel(rightPanel)
			row3.setLayout(new HorizontalLayout)
			
			new Label(row3).setText("Ubicación materia")
			new TextBox(row3).bindValueToProperty("materiaSeleccionada.ubicacion")
			//var selector = new Selector<String>(row3)
			//selector.allowNull(false)
			//selector.bindValueToProperty("materiaSeleccionada.ubicacion")
			//pongo un textbox porque la verdad no veo que haya combobox en ningun lado
	}
	
	
def void agregarMateria() {
		this.openDialog(new NuevaMateriaWindow(this))
	}	

def void editarNota(){	
		this.openDialog(new EditarNotaWindow(this,modelObject.notaSeleccionada))
}

def agregarNota() {
		modelObject.materiaSeleccionada.notas.add(new Nota)
	}



def openDialog(Dialog<?> dialog) {
	
		dialog.open
	}
	
}