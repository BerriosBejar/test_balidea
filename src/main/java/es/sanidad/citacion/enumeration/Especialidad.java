package es.sanidad.citacion.enumeration;

public enum Especialidad  {
  MEDICINA_GENERAL ("102"),
  CARDIOLOGIA ("103"),
  CIRUGIA ("104");

  private final String constante;

  Especialidad(String constante)
  {
    this.constante = constante;
  }

}
