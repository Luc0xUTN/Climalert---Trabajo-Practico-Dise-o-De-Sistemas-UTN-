package com.utn.ba.ddsi.climaalertapi.dtos.weather.WeatherAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
    @JsonProperty("tz_id")
    String timezoneId
) {
}
