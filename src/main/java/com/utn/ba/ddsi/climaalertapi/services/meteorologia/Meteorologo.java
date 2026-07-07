package com.utn.ba.ddsi.climaalertapi.services.meteorologia;

import com.utn.ba.ddsi.climaalertapi.domain.Clima;
import org.springframework.stereotype.Component;

@Component
public class Meteorologo {
  private final MeteorologiaApiAdapter meteorologiaApiAdapter;

  public Meteorologo(MeteorologiaApiAdapter meteorologiaApiAdapter) {
    this.meteorologiaApiAdapter = meteorologiaApiAdapter;
  }

  public Clima obtenerClimaActual(String ciudad) {
    return this.meteorologiaApiAdapter.obtenerClimaActual(ciudad);
  }
}
