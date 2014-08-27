package applicationModel;

import domain.Materia;
import domain.Nota;
import home.HomeMaterias;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorDeCarrera {
  private HomeMaterias homeMaterias;
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private ArrayList<Materia> _materiasDisponibles;
  
  public ArrayList<Materia> getMateriasDisponibles() {
    return this._materiasDisponibles;
  }
  
  public void setMateriasDisponibles(final ArrayList<Materia> materiasDisponibles) {
    this._materiasDisponibles = materiasDisponibles;
  }
  
  private Nota _notaSeleccionada;
  
  public Nota getNotaSeleccionada() {
    return this._notaSeleccionada;
  }
  
  public void setNotaSeleccionada(final Nota notaSeleccionada) {
    this._notaSeleccionada = notaSeleccionada;
  }
  
  public SeguidorDeCarrera() {
    HomeMaterias _homeMaterias = new HomeMaterias();
    this.homeMaterias = _homeMaterias;
  }
  
  public void search() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.setMateriasDisponibles(_arrayList);
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    List<Materia> _all = _homeMaterias.getAll();
    this.setMateriasDisponibles(((ArrayList<Materia>) _all));
  }
  
  public void removerNotaSeleccionada() {
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    ArrayList<Nota> _notas = _materiaSeleccionada.getNotas();
    Nota _notaSeleccionada = this.getNotaSeleccionada();
    _notas.remove(_notaSeleccionada);
  }
  
  public boolean agregarNota() {
    boolean _xblockexpression = false;
    {
      Nota notaNueva = new Nota();
      Date _date = new Date();
      notaNueva.setFecha(_date);
      notaNueva.setDescripcion("TP");
      notaNueva.setAprobado(true);
      Materia _materiaSeleccionada = this.getMateriaSeleccionada();
      ArrayList<Nota> _notas = _materiaSeleccionada.getNotas();
      _xblockexpression = _notas.add(notaNueva);
    }
    return _xblockexpression;
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
}
