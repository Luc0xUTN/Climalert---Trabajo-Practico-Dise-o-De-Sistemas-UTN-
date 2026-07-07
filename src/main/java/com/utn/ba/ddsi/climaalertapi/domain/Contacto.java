package com.utn.ba.ddsi.climaalertapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contacto {
  private String email;
  private Criterio criterio;

  public Contacto(Contacto contacto) {
    this.email = contacto.getEmail();
    this.criterio = contacto.getCriterio();
  }

  public Contacto(String email, Criterio criterio){
    this.email = email;
    this.criterio = criterio;
  }
}
