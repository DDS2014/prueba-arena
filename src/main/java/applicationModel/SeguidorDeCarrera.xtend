package applicationModel

import domain.Materia
import domain.Nota
import home.HomeMaterias
import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import java.util.Date

@Observable
class SeguidorDeCarrera 
{
	HomeMaterias homeMaterias;
	
	new()
	{
		homeMaterias = new HomeMaterias();
		this.materiasDisponibles = homeMaterias.getMaterias();
	}
	
	@Property Materia materiaSeleccionada;
	@Property ArrayList<Materia> materiasDisponibles;
	@Property Nota notaSeleccionada
	
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
	
	
}