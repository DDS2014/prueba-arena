package applicationModel;

import domain.Materia;
import home.HomeMaterias;
import java.util.ArrayList;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorDeCarrera {
  private HomeMaterias homeMaterias;
  
  public SeguidorDeCarrera() {
    HomeMaterias _homeMaterias = new HomeMaterias();
    this.homeMaterias = _homeMaterias;
    ArrayList<Materia> _materias = this.homeMaterias.getMaterias();
    this.setMateriasDisponibles(_materias);
  }
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  private ArrayList<Materia> _materiasDisponibles;
  
  public ArrayList<Materia> getMateriasDisponibles() {
    return this._materiasDisponibles;
  }
  
  public void setMateriasDisponibles(final ArrayList<Materia> materiasDisponibles) {
    this._materiasDisponibles = materiasDisponibles;
  }
  
  private String _materiaSeleccionadaName;
  
  public String getMateriaSeleccionadaName() {
    return this._materiaSeleccionadaName;
  }
  
  public void setMateriaSeleccionadaName(final String materiaSeleccionadaName) {
    this._materiaSeleccionadaName = materiaSeleccionadaName;
  }
  
  public void setMateriaSeleccionada(final Materia materia) {
    this._materiaSeleccionada = materia;
    String _string = materia.toString();
    this.setMateriaSeleccionadaName(_string);
  }
}
