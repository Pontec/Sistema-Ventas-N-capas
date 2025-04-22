package com.codigo.msventaspro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@Tag(name = "Admin", description = "Controlador para gestionar la administración")
public class AdminController {

    @GetMapping("/hola")
    @Operation(
            summary = "Saludo para el administrador",
            description = "Devuelve un saludo para el administrador.",
            tags = {"Admin"}
    )
    public ResponseEntity<String> saludoAdmin(){
        return ResponseEntity.ok("Hola admin");
    }

}
