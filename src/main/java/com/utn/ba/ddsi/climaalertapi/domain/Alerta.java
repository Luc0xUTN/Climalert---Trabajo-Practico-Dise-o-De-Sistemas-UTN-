package com.utn.ba.ddsi.climaalertapi.domain;

import java.time.Instant;
import lombok.Getter;

@Getter
public class Alerta {
  private Instant instanteGenerado;
  private Contacto contacto;
  private Clima clima;

  public Alerta(Contacto contacto, Clima clima) {
    this.instanteGenerado = Instant.now();
    this.contacto = contacto;
    this.clima = clima;
  }
}
