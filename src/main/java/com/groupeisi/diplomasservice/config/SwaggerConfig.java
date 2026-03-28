package com.groupeisi.diplomasservice.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Diplomas Service API")
                        .description("Gestion des diplômes")
                        .version("1.0"));
    }
}