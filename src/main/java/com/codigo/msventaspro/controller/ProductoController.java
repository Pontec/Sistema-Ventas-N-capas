package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.entities.Calzado;
import com.codigo.msventaspro.service.CalzadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/calzado")
@RequiredArgsConstructor
@Tag(name = "Calzado", description = "Controlador para gestionar calzados")
public class ProductoController {

    private final CalzadoService calzadoService;

    @PostMapping
    @Operation(
            summary = "Crear un nuevo calzado",
            description = "Crea un nuevo calzado en el sistema, devolviendo el calzado creado.",
            tags = {"Calzado"}
    )
    public ResponseEntity<Calzado> crearCalzado(@RequestBody Calzado calzado) {
        Calzado nuevoCalzado = calzadoService.save(calzado);
        return new ResponseEntity<>(nuevoCalzado, HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(
            summary = "Listar todos los calzados",
            description = "Devuelve una lista de todos los calzados disponibles en el sistema.",
            tags = {"Calzado"}
    )
    public List<Calzado> listarCalzados() {
        return calzadoService.findAll();
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener un calzado por ID",
            description = "Devuelve un calzado específico basado en su ID.",
            tags = {"Calzado"}
    )
    public ResponseEntity<Calzado> obtenerCalzado(@PathVariable Long id) {
        Calzado calzado = calzadoService.findById(id);
        return new ResponseEntity<>(calzado, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar un calzado por ID",
            description = "Elimina un calzado específico basado en su ID.",
            tags = {"Calzado"}
    )
    public ResponseEntity<Void> eliminarCalzado(@PathVariable Long id) {
        calzadoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar un calzado por ID",
            description = "Actualiza un calzado específico basado en su ID.",
            tags = {"Calzado"}
    )
    public ResponseEntity<Calzado> actualizarCalzado(@PathVariable Long id, @RequestBody Calzado calzado) {
        Calzado calzadoActualizado = calzadoService.update(id, calzado);
        return new ResponseEntity<>(calzadoActualizado, HttpStatus.OK);
    }
}
