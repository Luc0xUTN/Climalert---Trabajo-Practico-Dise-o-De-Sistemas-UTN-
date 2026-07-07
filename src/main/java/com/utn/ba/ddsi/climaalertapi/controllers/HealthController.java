package com.utn.ba.ddsi.climaalertapi.controllers;

import com.utn.ba.ddsi.climaalertapi.dtos.ResponseHealth;
import java.time.OffsetTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/health")
class HealthController {
  @GetMapping()
  ResponseEntity<ResponseHealth> getHealth() {
    ResponseHealth response = new ResponseHealth("UP", OffsetTime.now());
    return ResponseEntity.ok(response);
  }

}
