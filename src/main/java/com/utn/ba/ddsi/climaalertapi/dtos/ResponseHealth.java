package com.utn.ba.ddsi.climaalertapi.dtos;

import java.time.OffsetTime;

public record ResponseHealth(String status, OffsetTime timestamp) {
}
