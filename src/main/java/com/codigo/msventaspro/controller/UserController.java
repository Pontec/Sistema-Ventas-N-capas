package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.entities.Usuario;
import com.codigo.msventaspro.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Controlador para gestionar usuarios")
public class UserController {

    private final UsuarioService usuarioService;

    @GetMapping("/hola")
    @Operation(
            summary = "Saludo para el usuario",
            description = "Devuelve un saludo para el usuario.",
            tags = {"Usuario"}
    )
    public ResponseEntity<String> saludoAdmin(){
        return ResponseEntity.ok("Hola Usuario");
    }

    @GetMapping("/todos")
    @Operation(
            summary = "Listar todos los usuarios",
            description = "Devuelve una lista de todos los usuarios disponibles en el sistema.",
            tags = {"Usuario"}
    )
    public ResponseEntity<List<Usuario>> todos(){
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }
}
