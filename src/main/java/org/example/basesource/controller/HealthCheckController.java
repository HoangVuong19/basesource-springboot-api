package org.example.basesource.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public ResponseEntity<?> getHealthCheck() {
        return ResponseEntity.ok("health check is ok!");
    }
}
