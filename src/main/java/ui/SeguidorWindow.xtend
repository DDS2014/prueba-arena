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

class SeguidorWindow extends SimpleWindow<SeguidorDeCarrera>
{
	
	new(WindowOwner parent) {
		super(parent, new SeguidorDeCarrera)
	}

	
	override protected addActions(Panel actionsPanel) 
	{
		//este panel me va a quedar vacío supongo
	}
	
	override protected createFormPanel(Panel mainPanel) 
	{
		mainPanel.setLayout(new HorizontalLayout)
		
		var leftPanel = new Panel(mainPanel).setWidth(100)
		var rightPanel = new Panel(mainPanel).setWidth(500)
		
		leftPanel.setLayout(new VerticalLayout)
		new Label(leftPanel)
			.setText("Materias")
		var listaMaterias = new List<Materia>(leftPanel)
			listaMaterias.setHeigth(400)
			listaMaterias.bindItemsToProperty("materiasDisponibles")
			listaMaterias.bindValueToProperty("materiaSeleccionada")
			
		new Button(leftPanel)
			.setCaption("Nueva Materia")
		
		rightPanel.setLayout(new VerticalLayout)
		
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
			//pongo un textbox porque la verdad no veo que haya combobox en ningun lado
			
	}
	
}