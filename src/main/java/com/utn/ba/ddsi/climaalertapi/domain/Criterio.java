package com.utn.ba.ddsi.climaalertapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criterio {
  private float temperatura;
  private float humedad;

  public Criterio(Criterio criterio) {
    this.temperatura = criterio.getTemperatura();
    this.humedad = criterio.getHumedad();
  }

  public Criterio(float temperatura, float humedad) {
    this.temperatura = temperatura;
    this.humedad = humedad;
  }

  public boolean cumple(Clima clima) {
    return clima.getHumedad() > this.humedad && clima.getTemperatura() > this.temperatura;
  }
}
