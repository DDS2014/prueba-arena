package home;

import com.google.common.base.Objects;
import domain.Materia;
import domain.Nota;
import java.util.ArrayList;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class HomeMaterias {
  private ArrayList<Materia> materias;
  
  private ArrayList<String> ubicaciones;
  
  public HomeMaterias() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.materias = _arrayList;
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.ubicaciones = _arrayList_1;
    this.init();
  }
  
  public ArrayList<Materia> getMaterias() {
    return this.materias;
  }
  
  public ArrayList<String> getubicaciones() {
    return this.ubicaciones;
  }
  
  public boolean init() {
    boolean _xblockexpression = false;
    {
      this.create("Análisis 1", 2011, "Gregoret", true, "A2011");
      this.create("Álgebra", 2011, "Pustilnik", true, "A2011");
      this.create("Ingeniería y Sociedad", 2011, "Gamondés", true, "2C2011");
      this.create("Probabilidad y Estadística", 2012, "Sombielle", true, "1C2012");
      this.createUbicacion("A2011");
      this.createUbicacion("1C2011");
      this.createUbicacion("2C011");
      this.createUbicacion("A2012");
      this.createUbicacion("1C2012");
      boolean _createUbicacion = this.createUbicacion("2C2012");
      _xblockexpression = (_createUbicacion);
    }
    return _xblockexpression;
  }
  
  public boolean create(final String nombre, final int anio_cursada, final String profesor, final boolean final_aprobado, final String ubicacion) {
    boolean _xblockexpression = false;
    {
      Materia _materia = new Materia();
      Materia materia = _materia;
      materia.setNombre(nombre);
      materia.setAnio_cursada(anio_cursada);
      materia.setProfesor(profesor);
      materia.setFinal_aprobado(final_aprobado);
      materia.setUbicacion(ubicacion);
      Nota _nota = new Nota();
      Nota nota = _nota;
      Date _date = new Date();
      nota.setFecha(_date);
      nota.setDescripcion("TP");
      nota.setAprobado(true);
      ArrayList<Nota> _notas = materia.getNotas();
      _notas.add(nota);
      boolean _createMateria = this.createMateria(materia);
      _xblockexpression = (_createMateria);
    }
    return _xblockexpression;
  }
  
  public boolean createMateria(final Materia materia) {
    boolean _add = this.materias.add(materia);
    return _add;
  }
  
  public boolean createUbicacion(final String ubicacion) {
    boolean _add = this.ubicaciones.add(ubicacion);
    return _add;
  }
  
  public Materia buscarPorNombre(final String string) {
    final Function1<Materia,Boolean> _function = new Function1<Materia,Boolean>() {
      public Boolean apply(final Materia m) {
        String _nombre = m.getNombre();
        boolean _equals = Objects.equal(_nombre, string);
        return Boolean.valueOf(_equals);
      }
    };
    Materia _findFirst = IterableExtensions.<Materia>findFirst(this.materias, _function);
    return _findFirst;
  }
}
