package com.codigo.msventaspro.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "MS Ventas Pro API",
                version = "1.0",
                description = "API documentation for MS Ventas Pro",
                contact = @Contact(
                        name = "Jhonatan Ponce Policio",
                        url = "www.pontecweb.com",
                        email = "jhona.pp.29@gmail.com"
        )
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "Local server"
        ),
        security =@SecurityRequirement(
                name = "Security Token"
        )
)
@SecurityScheme(
        name =  "Security Token",
        description = "Authentication using JWT",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}
