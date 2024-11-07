package com.apodlatov.test.respak.сonfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI() {
        List<Server> servers = Collections.singletonList(
                new Server().url("http://localhost:8091"));

        Info info = new Info().title("Technics registry");

        return new OpenAPI()
                .servers(servers)
                .info(info);
    }
}