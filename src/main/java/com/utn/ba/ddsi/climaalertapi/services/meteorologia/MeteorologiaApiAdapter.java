package com.utn.ba.ddsi.climaalertapi.services.meteorologia;

import com.utn.ba.ddsi.climaalertapi.domain.Clima;

public interface MeteorologiaApiAdapter {
  Clima obtenerClimaActual(String ciudad);
}
