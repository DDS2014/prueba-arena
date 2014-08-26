package ui

import domain.Nota
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Button

class EditarNotaWindow extends Dialog<Nota>{
	
	new(WindowOwner owner, Nota model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title= "Editar Nota"
		
		var row1 = new Panel(mainPanel).setLayout(new HorizontalLayout)	
			new Label(row1).setText("Fecha:")
			new TextBox(row1)
			.setWidth(150)
			.bindValueToProperty("fecha")
			
		var row2 = new Panel(mainPanel).setLayout(new HorizontalLayout)
			new Label(row2).setText("Descripcion:")
			new TextBox(row2)
			.setWidth(150)
			.bindValueToProperty("descripcion")
			
		var row3 = new Panel(mainPanel).setLayout(new HorizontalLayout)
			new CheckBox(row3).bindValueToProperty("aprobado")
			new Label(row3).setText("Aprobado")
			
		new Button(mainPanel)
			.setCaption("Aceptar")
			.onClick [|this.accept]
	}
	
}