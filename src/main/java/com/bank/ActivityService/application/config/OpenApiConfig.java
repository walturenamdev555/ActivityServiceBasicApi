package com.bank.ActivityService.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class OpenApiConfig {
  private static final String MESSAGE = "File could not load";

  private final String location;

  public OpenApiConfig(@Value("app.api-resource.api-location") String location) {
    this.location = location;
    System.out.println(location);
  }

  @Bean
  public OpenAPI apiInfo() {
     return Optional.ofNullable(new OpenAPIV3Parser().read("api/resources/static/activity-api.yaml"))
    .orElseThrow(RuntimeException::new);
  }
}
