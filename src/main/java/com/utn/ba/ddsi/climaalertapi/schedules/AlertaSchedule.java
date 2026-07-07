package com.utn.ba.ddsi.climaalertapi.schedules;

import com.utn.ba.ddsi.climaalertapi.services.AlertasService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaSchedule {
  private final AlertasService alertasService;

  public AlertaSchedule(AlertasService alertasService)
  {
    this.alertasService = alertasService;
  }

  @Scheduled(cron = "${schedule.alerta.interval}")
  public void generarAlertas() {
    this.alertasService.alertarCambioClima();
  }
}
