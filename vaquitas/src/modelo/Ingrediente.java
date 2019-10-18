package modelo;

public class Ingrediente {

  private String clasificacion;
  private double tnd;
  private double em;
  private double proteina;
  private double calcio;
  private double lisina;
  private double metionina;
  private String nombre;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getClasificacion() {
    return clasificacion;
  }

  public void setClasificacion(String clasificacion) {
    this.clasificacion = clasificacion;
  }

  public double getTnd() {
    return tnd;
  }

  public void setTnd(double tnd) {
    this.tnd = tnd;
  }

  public double getEm() {
    return em;
  }

  public void setEm(double em) {
    this.em = em;
  }

  public double getProteina() {
    return proteina;
  }

  public void setProteina(double proteina) {
    this.proteina = proteina;
  }

  public double getCalcio() {
    return calcio;
  }

  public void setCalcio(double calcio) {
    this.calcio = calcio;
  }

  public double getLisina() {
    return lisina;
  }

  public void setLisina(double lisina) {
    this.lisina = lisina;
  }

  public double getMetionina() {
    return metionina;
  }

  public void setMetionina(double metionina) {
    this.metionina = metionina;
  }
}
