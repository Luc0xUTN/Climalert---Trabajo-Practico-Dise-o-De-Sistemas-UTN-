package com.utn.ba.ddsi.climaalertapi.repositories.inmemory;

import com.utn.ba.ddsi.climaalertapi.domain.Contacto;
import com.utn.ba.ddsi.climaalertapi.repositories.ContactoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class InMemoryContactoRepositoryImpl implements ContactoRepository {
  private List<Contacto> contactos = new ArrayList<>();

  @Override
  public void guardarContacto(Contacto contacto) {
    this.contactos.add(contacto);
  }

  @Override
  public List<Contacto> obtenerContactos() {
    return new ArrayList<>(contactos);
  }
}
