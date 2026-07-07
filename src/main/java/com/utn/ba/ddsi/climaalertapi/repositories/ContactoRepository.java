package com.utn.ba.ddsi.climaalertapi.repositories;

import com.utn.ba.ddsi.climaalertapi.domain.Contacto;
import java.util.List;
import java.util.Optional;

public interface ContactoRepository {
  void guardarContacto(Contacto contacto);
  List<Contacto> obtenerContactos();
}
