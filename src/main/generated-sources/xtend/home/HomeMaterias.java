package home;

import com.google.common.base.Objects;
import domain.Materia;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class HomeMaterias {
  private ArrayList<Materia> materias;
  
  public HomeMaterias() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.materias = _arrayList;
    this.init();
  }
  
  public ArrayList<Materia> getMaterias() {
    return this.materias;
  }
  
  public boolean init() {
    boolean _xblockexpression = false;
    {
      this.create("Análisis 1", 2011, "Gregoret", true, "A2011");
      this.create("Álgebra", 2011, "Pustilnik", true, "A2011");
      this.create("Ingeniería y Sociedad", 2011, "Gamondés", true, "2C2011");
      _xblockexpression = this.create("Probabilidad y Estadística", 2012, "Sombielle", true, "1C2012");
    }
    return _xblockexpression;
  }
  
  public boolean create(final String nombre, final int anio_cursada, final String profesor, final boolean final_aprobado, final String ubicacion) {
    boolean _xblockexpression = false;
    {
      Materia materia = new Materia();
      materia.setNombre(nombre);
      materia.setAnio_cursada(anio_cursada);
      materia.setProfesor(profesor);
      materia.setFinal_aprobado(final_aprobado);
      materia.setUbicacion(ubicacion);
      _xblockexpression = this.create(materia);
    }
    return _xblockexpression;
  }
  
  public boolean create(final Materia materia) {
    return this.materias.add(materia);
  }
  
  public Materia buscarPorNombre(final String string) {
    final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
      public Boolean apply(final Materia m) {
        String _nombre = m.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, string));
      }
    };
    return IterableExtensions.<Materia>findFirst(this.materias, _function);
  }
}
