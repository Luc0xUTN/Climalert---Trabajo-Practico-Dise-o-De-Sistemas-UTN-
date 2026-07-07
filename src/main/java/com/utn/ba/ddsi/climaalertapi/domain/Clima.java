package com.utn.ba.ddsi.climaalertapi.domain;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clima {
  private Instant instanteActualizacion;
  private double  temperatura;
  private int humedad;

  public Clima(Instant instanteActualizacion, double temperatura, int humedad) {
    this.instanteActualizacion = instanteActualizacion;
    this.temperatura = temperatura;
    this.humedad = humedad;
  }

  public boolean igualInstante(Clima clima)
  {
    return this.instanteActualizacion.equals(clima.getInstanteActualizacion());
  }
}
