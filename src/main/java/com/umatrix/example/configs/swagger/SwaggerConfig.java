package com.umatrix.example.configs.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "example project",
                version = "v0.0.1",
                description = "this project is an example project",
                termsOfService = "runcodenow",
                contact = @Contact(
                        name = "mr Umar",
                        email = "umatrix001@gmail.com"
                        // url - web sites i made
                ),
                license = @License(
                        name = "licence",
                        url = "runecodenow"
                )
        )/*,
        security = {
                @SecurityRequirement(name = "bearerAuth")
        }*/
)
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "bearerAuth",
        description = "you have to add JWT token",
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
}
