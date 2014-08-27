package home


import domain.Materia
import domain.Nota
import java.util.Date
import org.uqbar.commons.model.CollectionBasedHome
import org.apache.commons.collections15.Predicate
import org.uqbar.commons.utils.Observable

@Observable
class HomeMaterias extends CollectionBasedHome<Materia>
{

	
	new()
	{
		this.init()
	}
	

	
	def init() 
	{
		this.create("Análisis 1", 2011, "Gregoret", true, "A2011");
		this.create("Álgebra", 2011, "Pustilnik", true, "A2011");
		this.create("Ingeniería y Sociedad", 2011, "Gamondés", true, "2C2011")
		this.create("Probabilidad y Estadística", 2012, "Sombielle", true, "1C2012")
		

	}
	
	def create(String nombre, int anio_cursada, String profesor, boolean final_aprobado, String ubicacion)
	{
		var materia = new Materia()
		materia.nombre = nombre
		materia.anio_cursada = anio_cursada
		materia.profesor = profesor
		materia.final_aprobado = final_aprobado
		materia.ubicacion = ubicacion
		
		var nota = new Nota
		nota.fecha = new Date
		nota.descripcion = "TP"
		nota.aprobado = true
		
		materia.notas.add(nota)
		
		this.create(materia)
	}


	

	
	override protected Predicate <Materia> getCriterio(Materia arg0) 
	{
		null
	}
	
	override createExample() 
	{
		new Materia
	}
	
	override getEntityType() 
	{
		typeof(Materia)
	}
	
	
	def getAll() 
	{
		allInstances.toList
	}
	
}