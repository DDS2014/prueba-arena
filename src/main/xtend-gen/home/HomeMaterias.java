package home;

import com.google.common.base.Objects;
import domain.Materia;
import domain.Nota;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("Análisis 1", 2011, "Gregoret", true, "A2011");
    this.create("Álgebra", 2011, "Pustilnik", true, "A2011");
    this.create("Ingeniería y Sociedad", 2011, "Gamondés", true, "2C2011");
    this.create("Probabilidad y Estadística", 2012, "Sombielle", true, "1C2012");
  }
  
  public void create(final String nombre, final int anio_cursada, final String profesor, final boolean final_aprobado, final String ubicacion) {
    Materia materia = new Materia();
    materia.setNombre(nombre);
    materia.setAnio_cursada(anio_cursada);
    materia.setProfesor(profesor);
    materia.setFinal_aprobado(final_aprobado);
    materia.setUbicacion(ubicacion);
    Nota nota = new Nota();
    Date _date = new Date();
    nota.setFecha(_date);
    nota.setDescripcion("TP");
    nota.setAprobado(true);
    ArrayList<Nota> _notas = materia.getNotas();
    _notas.add(nota);
    this.create(materia);
  }
  
  protected Predicate<Materia> getCriterio(final Materia arg0) {
    return null;
  }
  
  public Materia createExample() {
    return new Materia();
  }
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
  
  public boolean match(final Object expectedValue, final Object realValue) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(expectedValue, null);
      if (_equals) {
        return true;
      }
      boolean _equals_1 = Objects.equal(realValue, null);
      if (_equals_1) {
        return false;
      }
      String _string = realValue.toString();
      String _lowerCase = _string.toLowerCase();
      String _string_1 = expectedValue.toString();
      String _lowerCase_1 = _string_1.toLowerCase();
      _xblockexpression = _lowerCase.contains(_lowerCase_1);
    }
    return _xblockexpression;
  }
  
  public List<Materia> getAll() {
    List<Materia> _allInstances = this.allInstances();
    return IterableExtensions.<Materia>toList(_allInstances);
  }
}
