package com.utn.ba.ddsi.climaalertapi.repositories;

import com.utn.ba.ddsi.climaalertapi.domain.Alerta;
import com.utn.ba.ddsi.climaalertapi.domain.Contacto;
import java.util.Optional;

public interface AlertaRepository {
  void guardarAlerta(Alerta alerta);
  Optional<Alerta> obtenerUltimaAlerta(Contacto contacto);
}
