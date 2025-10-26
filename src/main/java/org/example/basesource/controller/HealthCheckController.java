package org.example.basesource.controller;

import org.example.basesource.config.serialize.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/health-check")
@RequiredArgsConstructor
public class HealthCheckController {

    @GetMapping()
    public ApiResponse<String> getHealthCheck() {
        return ApiResponse.success("health check is ok!");
    }
}
