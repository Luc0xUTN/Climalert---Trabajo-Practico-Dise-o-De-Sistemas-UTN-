package com.utn.ba.ddsi.climaalertapi.services.meteorologia;

import com.utn.ba.ddsi.climaalertapi.domain.Clima;
import com.utn.ba.ddsi.climaalertapi.dtos.weather.WeatherAPI.ResponseCurrentWeather;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherAPI implements MeteorologiaApiAdapter{
  private final RestClient restClient;
  private final String apiKey;
  private final UriComponentsBuilder baseUrl;

  public WeatherAPI(@Value("${weather.api.key}") String apiKey, @Value("${weather.api.url}") String url, RestClient restClient)
  {
    this.apiKey = apiKey;
    this.restClient = restClient;
    this.baseUrl = UriComponentsBuilder.fromUriString(url);
  }

  @Override
  public Clima obtenerClimaActual(String ciudad) {
    URI uri = baseUrl.path("/current.json").queryParam("key", apiKey).queryParam("q", ciudad).build().toUri();

    ResponseCurrentWeather responseCurrentWeather = this.restClient.get().uri(uri).retrieve().body(ResponseCurrentWeather.class);

    ZoneId zoneId = ZoneId.of(responseCurrentWeather.location().timezoneId());

    LocalDateTime localDateTime = LocalDateTime.parse(
        responseCurrentWeather.current().actualizacion(),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    );
    Instant instante = localDateTime.atZone(zoneId).toInstant();

    return new Clima(instante, responseCurrentWeather.current().temperatura(), responseCurrentWeather.current().humedad());
  }
}
