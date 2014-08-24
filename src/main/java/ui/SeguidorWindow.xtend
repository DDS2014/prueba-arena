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
		new List<Materia>(leftPanel)
		new Button(leftPanel)
			.setCaption("Nueva Materia")
		
		rightPanel.setLayout(new VerticalLayout)

		
	}
	
}