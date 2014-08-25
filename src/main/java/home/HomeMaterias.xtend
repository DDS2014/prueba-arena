package home

import java.util.ArrayList
import domain.Materia
import domain.Nota
import java.util.Date

class HomeMaterias
{
	ArrayList<Materia> materias;
	ArrayList<String> ubicaciones;
	
	new()
	{
		this.materias = new ArrayList()
		this.ubicaciones = new ArrayList()
		this.init()
	}
	
	def getMaterias()
	{
		return materias;
	}
	
	def getubicaciones()
	{
		return ubicaciones;
	}
	
	def init() 
	{
		this.create("Análisis 1", 2011, "Gregoret", true, "A2011");
		this.create("Álgebra", 2011, "Pustilnik", true, "A2011");
		this.create("Ingeniería y Sociedad", 2011, "Gamondés", true, "2C2011")
		this.create("Probabilidad y Estadística", 2012, "Sombielle", true, "1C2012")
		
		this.createUbicacion("A2011")
		this.createUbicacion("1C2011")
		this.createUbicacion("2C011")
		this.createUbicacion("A2012")
		this.createUbicacion("1C2012")
		this.createUbicacion("2C2012")
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
		
		this.createMateria(materia)
	}
	
	def createMateria(Materia materia)
	{
		this.materias.add(materia);
	}
	
	def createUbicacion(String ubicacion){
		this.ubicaciones.add(ubicacion);
	}
	
	def Materia buscarPorNombre(String string) 
	{
		this.materias.findFirst[m | m.nombre == string]
	}
	
}