package applicationModel

import domain.Materia
import home.HomeMaterias
import java.util.ArrayList
import org.uqbar.commons.utils.Observable

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

	
	
}