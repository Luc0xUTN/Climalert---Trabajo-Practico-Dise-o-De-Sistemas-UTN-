package com.utn.ba.ddsi.climaalertapi.services.impls;

import com.utn.ba.ddsi.climaalertapi.domain.Clima;
import com.utn.ba.ddsi.climaalertapi.repositories.ClimaRepository;
import com.utn.ba.ddsi.climaalertapi.services.ClimaService;
import com.utn.ba.ddsi.climaalertapi.services.meteorologia.Meteorologo;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class ClimaServiceImpl implements ClimaService {
  private final Meteorologo meteorologo;
  private final ClimaRepository climaRepository;

  public ClimaServiceImpl(Meteorologo meteorologo, ClimaRepository climaRepository)
  {
    this.meteorologo = meteorologo;
    this.climaRepository = climaRepository;
  }


  @Override
  public void actualizarClima() {
    Clima clima = this.meteorologo.obtenerClimaActual("Buenos Aires");
    Optional<Clima> climaAnterior = this.climaRepository.obtenerClimaMasReciente();

    if (climaAnterior.isPresent() && climaAnterior.get().igualInstante(clima))
        return;

    this.climaRepository.guardarClima(clima);
  }
}
