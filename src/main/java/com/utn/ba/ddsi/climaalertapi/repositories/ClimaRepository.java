package com.utn.ba.ddsi.climaalertapi.repositories;

import com.utn.ba.ddsi.climaalertapi.domain.Clima;
import java.util.Optional;

public interface ClimaRepository {
  void guardarClima(Clima clima);
  Optional<Clima> obtenerClimaMasReciente();
}
