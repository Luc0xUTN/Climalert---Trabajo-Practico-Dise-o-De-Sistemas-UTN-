package com.utn.ba.ddsi.climaalertapi.services.notificaciones;

import com.utn.ba.ddsi.climaalertapi.domain.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Notificador {
  SenderAdapter sender;

  public Notificador(SenderAdapter sender)
  {
    this.sender = sender;
  }

  public void enviar(String email,String tema, String mensaje)
  {
    this.sender.enviar(email,tema, mensaje);
  }

}
