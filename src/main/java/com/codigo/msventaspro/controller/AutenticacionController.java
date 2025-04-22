package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.aggregates.request.SignInRequest;
import com.codigo.msventaspro.aggregates.request.SignUpRequest;
import com.codigo.msventaspro.aggregates.response.AuthenticationResponse;
import com.codigo.msventaspro.entities.Usuario;
import com.codigo.msventaspro.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/autenticacion")
@RequiredArgsConstructor
@Tag(name = "Autenticacion", description = "Controlador para gestionar la autenticación de usuarios")
public class AutenticacionController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signupuser")
    @Operation(
            summary = "Registrar un nuevo usuario",
            description = "Registra un nuevo usuario en el sistema, devolviendo el usuario creado.",
            tags = {"Autenticacion"}
    )
    public ResponseEntity<Usuario> signUpUser(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUpUser(signUpRequest));
    }


    @PostMapping("/signupadmin")
    @Operation(
            summary = "Registrar un nuevo administrador",
            description = "Registra un nuevo administrador en el sistema, devolviendo el usuario creado.",
            tags = {"Autenticacion"}
    )
    public ResponseEntity<Usuario> signUpAdmin(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUpAdmin(signUpRequest));
    }


    @PostMapping("/signin")
    @Operation(
            summary = "Iniciar sesión",
            description = "Inicia sesión en el sistema, devolviendo un token de autenticación.",
            tags = {"Autenticacion"}
    )
    public ResponseEntity<AuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }
}
