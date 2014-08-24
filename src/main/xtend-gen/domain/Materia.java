package domain;

import domain.Nota;
import java.util.List;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia {
  private int _anio_cursada;
  
  public int getAnio_cursada() {
    return this._anio_cursada;
  }
  
  public void setAnio_cursada(final int anio_cursada) {
    this._anio_cursada = anio_cursada;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private boolean _final_aprobado;
  
  public boolean isFinal_aprobado() {
    return this._final_aprobado;
  }
  
  public void setFinal_aprobado(final boolean final_aprobado) {
    this._final_aprobado = final_aprobado;
  }
  
  private String _ubicacion_materia;
  
  public String getUbicacion_materia() {
    return this._ubicacion_materia;
  }
  
  public void setUbicacion_materia(final String ubicacion_materia) {
    this._ubicacion_materia = ubicacion_materia;
  }
  
  private List<Nota> _notas;
  
  public List<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final List<Nota> notas) {
    this._notas = notas;
  }
}
