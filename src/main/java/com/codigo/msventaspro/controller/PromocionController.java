package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.entities.Promocion;
import com.codigo.msventaspro.service.PromocionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/promocion")
@RequiredArgsConstructor
@Tag(name = "Promocion", description = "Controlador para gestionar promociones")
public class PromocionController {

    private final PromocionService promocionService;

    @PostMapping
    @Operation(
            summary = "Crear una nueva promoción",
            description = "Crea una nueva promoción en el sistema, devolviendo la promoción creada.",
            tags = {"Promocion"}
    )
    public ResponseEntity<Promocion> crearPromocion(@RequestBody Promocion promocion) {
        Promocion nuevaPromocion = promocionService.save(promocion);
        return new ResponseEntity<>(nuevaPromocion, HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(
            summary = "Listar todas las promociones",
            description = "Devuelve una lista de todas las promociones disponibles en el sistema.",
            tags = {"Promocion"}
    )
    public List<Promocion> listarPromociones() {
        return promocionService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Promocion> obtenerPromocion(@PathVariable Long id) {
        Promocion promocion = promocionService.findById(id);
        return new ResponseEntity<>(promocion, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar una promoción por ID",
            description = "Elimina una promoción específica basada en su ID.",
            tags = {"Promocion"}
    )
    public ResponseEntity<Void> eliminarPromocion(@PathVariable Long id) {
        promocionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar una promoción por ID",
            description = "Actualiza una promoción específica basada en su ID.",
            tags = {"Promocion"}
    )
    public ResponseEntity<Promocion> actualizarPromocion(@PathVariable Long id, @RequestBody Promocion promocion) {
        Promocion promocionActualizada = promocionService.update(id, promocion);
        return new ResponseEntity<>(promocionActualizada, HttpStatus.OK);
    }
}
