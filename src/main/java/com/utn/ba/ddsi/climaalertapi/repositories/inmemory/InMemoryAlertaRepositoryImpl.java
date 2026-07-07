package com.utn.ba.ddsi.climaalertapi.repositories.inmemory;

import com.utn.ba.ddsi.climaalertapi.domain.Alerta;
import com.utn.ba.ddsi.climaalertapi.domain.Contacto;
import com.utn.ba.ddsi.climaalertapi.repositories.AlertaRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public final class InMemoryAlertaRepositoryImpl implements AlertaRepository {
  private List<Alerta> alertas;

  @Override
  public void guardarAlerta(Alerta alerta) {
    this.alertas.add(alerta);
  }

  @Override
  public Optional<Alerta> obtenerUltimaAlerta(Contacto contacto) {
    return this.alertas.stream().filter(alerta -> alerta.getContacto().equals(contacto)).max(Comparator.comparing(Alerta::getInstanteGenerado));
  }


}
