package applicationModel;

import domain.Materia;
import java.util.List;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorDeCarrera {
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private List<Materia> _materiasDisponibles;
  
  public List<Materia> getMateriasDisponibles() {
    return this._materiasDisponibles;
  }
  
  public void setMateriasDisponibles(final List<Materia> materiasDisponibles) {
    this._materiasDisponibles = materiasDisponibles;
  }
}
