package ui

import domain.Materia
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import applicationModel.SeguidorDeCarrera

class NuevaMateriaWindow extends Dialog<Materia>{
	
	SeguidorDeCarrera seguidor;
	
	new(WindowOwner owner, SeguidorDeCarrera seguidor) {
		super(owner, new Materia)
		this.seguidor = seguidor;
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Nueva Materia"
		
		val form = new Panel(mainPanel)
		
		new Label(form).text = "Nombre:"
		new TextBox(form)
		.setWidth(200)
		.bindValueToProperty("nombre")
		
		new Button(form)
			.setCaption("Aceptar")
			.onClick [|this.accept]
	}
	
	override executeTask() {
		seguidor.getHomeMaterias().create(modelObject)
		super.executeTask()
		seguidor.search()
	}
	
	
	
	
}