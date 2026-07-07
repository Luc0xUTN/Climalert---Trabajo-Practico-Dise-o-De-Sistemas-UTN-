package com.utn.ba.ddsi.climaalertapi.services.impls;

import com.utn.ba.ddsi.climaalertapi.domain.Alerta;
import com.utn.ba.ddsi.climaalertapi.domain.Clima;
import com.utn.ba.ddsi.climaalertapi.domain.Contacto;
import com.utn.ba.ddsi.climaalertapi.repositories.AlertaRepository;
import com.utn.ba.ddsi.climaalertapi.repositories.ClimaRepository;
import com.utn.ba.ddsi.climaalertapi.repositories.ContactoRepository;
import com.utn.ba.ddsi.climaalertapi.services.AlertasService;
import com.utn.ba.ddsi.climaalertapi.services.notificaciones.Notificador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class AlertasServiceImpl implements AlertasService {
  private final ContactoRepository contactoRepository;
  private final AlertaRepository alertaRepository;
  private final ClimaRepository climaRepository;
  private final Notificador notificador;

  public AlertasServiceImpl(ContactoRepository contactoRepository, AlertaRepository alertaRepository, ClimaRepository climaRepository, Notificador notificador)
  {
    this.contactoRepository = contactoRepository;
    this.alertaRepository = alertaRepository;
    this.climaRepository = climaRepository;
    this.notificador = notificador;
  }

  @Override
  public void alertarCambioClima() {
    Optional<Clima> climaOptional = this.climaRepository.obtenerClimaMasReciente();

    if (climaOptional.isPresent()) {
      Clima clima = climaOptional.get();

      List<Contacto> contactos = this.contactoRepository.obtenerContactos();
      List<Contacto> contactosAAlertar = contactos.stream().filter(contacto -> contacto.getCriterio().cumple(clima)).toList();

      contactosAAlertar.forEach(contacto -> {
        Optional<Alerta> ultimaAlerta = this.alertaRepository.obtenerUltimaAlerta(contacto);
        if (ultimaAlerta.isEmpty() || !ultimaAlerta.get().getClima().igualInstante(clima)) {

          this.notificador.enviar(contacto.getEmail(),"Alerta Meteorologica", "Se detecto una temperatura de " + clima.getTemperatura() + " y humedad de " + clima.getHumedad() + "%");

          Alerta alerta = new Alerta(contacto, clima);
          this.alertaRepository.guardarAlerta(alerta);
        }
      });
    }
  }
}
