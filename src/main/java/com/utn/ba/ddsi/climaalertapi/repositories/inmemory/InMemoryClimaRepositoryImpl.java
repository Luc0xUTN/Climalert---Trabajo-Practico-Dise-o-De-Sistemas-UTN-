package com.utn.ba.ddsi.climaalertapi.repositories.inmemory;

import com.utn.ba.ddsi.climaalertapi.domain.Clima;
import com.utn.ba.ddsi.climaalertapi.repositories.ClimaRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public final class InMemoryClimaRepositoryImpl implements ClimaRepository {
  private List<Clima> climas;

  @Override
  public void guardarClima(Clima clima) {
    this.climas.add(clima);
  }

  @Override
  public Optional<Clima> obtenerClimaMasReciente() {
    return this.climas.stream().max(Comparator.comparing(Clima::getInstanteActualizacion));
  }
}
