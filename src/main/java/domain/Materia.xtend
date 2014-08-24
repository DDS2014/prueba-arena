package domain

import java.util.List
import org.uqbar.commons.utils.Observable

@Observable
class Materia
{
	@Property int anio_cursada;
	@Property String profesor;
	@Property boolean final_aprobado;
	@Property String ubicacion_materia;
	@Property List<Nota> notas;	
	
}