package com.utn.ba.ddsi.climaalertapi.services.notificaciones;

public interface SenderAdapter {

  void enviar(String formaContacto,String tema, String mensaje);
}
