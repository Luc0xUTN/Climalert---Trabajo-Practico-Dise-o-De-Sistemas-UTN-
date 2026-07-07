package com.utn.ba.ddsi.climaalertapi.schedules;

import com.utn.ba.ddsi.climaalertapi.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaSchedule {
  private final ClimaService climaService;

  public ClimaSchedule(ClimaService climaService) {
    this.climaService = climaService;
  }

  @Scheduled(cron = "${schedule.clima.interval}")
  public void actualizarClima() {
    this.climaService.actualizarClima();
  }
}
