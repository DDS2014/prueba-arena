package applicationModel

import org.uqbar.commons.utils.Observable
import domain.Materia
import java.util.List

@Observable
class SeguidorDeCarrera 
{
	@Property Materia materiaSeleccionada;
	@Property List<Materia> materiasDisponibles;
	
	
}