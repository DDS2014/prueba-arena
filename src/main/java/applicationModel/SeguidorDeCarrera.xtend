package applicationModel

import domain.Materia
import domain.Nota
import home.HomeMaterias
import org.uqbar.commons.utils.Observable
import java.util.Date
import org.uqbar.commons.utils.ApplicationContext
import java.util.ArrayList

@Observable
class SeguidorDeCarrera 
{
	HomeMaterias homeMaterias;
	@Property Materia materiaSeleccionada;
	@Property ArrayList<Materia> materiasDisponibles;
	@Property Nota notaSeleccionada
	
	new()
	{
		homeMaterias = new HomeMaterias();
	}
	
	
	
	
	def void search()
	{
		materiasDisponibles = new ArrayList<Materia>
		materiasDisponibles = (getHomeMaterias()).getAll() as ArrayList<Materia>
		
	}
	def void removerNotaSeleccionada() {
		materiaSeleccionada.notas.remove(notaSeleccionada)
	}
	
	def agregarNota() {
		var notaNueva = new Nota
		notaNueva.fecha = new Date
		notaNueva.descripcion = "TP"
		notaNueva.aprobado = true
		materiaSeleccionada.notas.add(notaNueva)
	}
	
	def HomeMaterias getHomeMaterias()
	{
		ApplicationContext.instance.getSingleton(typeof(Materia))
	}
	
	
}