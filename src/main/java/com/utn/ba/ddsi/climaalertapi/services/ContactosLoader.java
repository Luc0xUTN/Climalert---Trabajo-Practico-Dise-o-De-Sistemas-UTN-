package com.utn.ba.ddsi.climaalertapi.services;

import com.utn.ba.ddsi.climaalertapi.domain.Contacto;
import com.utn.ba.ddsi.climaalertapi.domain.Criterio;
import com.utn.ba.ddsi.climaalertapi.repositories.ContactoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ContactosLoader implements CommandLineRunner {
  private final ContactoRepository contactoRepository;

  public ContactosLoader(ContactoRepository contactoRepository)
  {
    this.contactoRepository = contactoRepository;
  }

  @Override
  public void run(String... args){
    Criterio criterio = new Criterio(35, 60);
    this.contactoRepository.guardarContacto(new Contacto("admin@clima.com", criterio));
    this.contactoRepository.guardarContacto(new Contacto("emergencias@clima.com", criterio));
    this.contactoRepository.guardarContacto(new Contacto("meteorologia@clima.com", criterio));
  }
}
