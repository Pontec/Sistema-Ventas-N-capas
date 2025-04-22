package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.entities.Venta;
import com.codigo.msventaspro.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/venta")
@RequiredArgsConstructor
@Tag(name = "Venta", description = "Controlador para gestionar ventas")
public class VentaController {

    private final VentaService ventaService;

    @PostMapping
    @Operation(
            summary = "Crear una nueva venta",
            description = "Crea una nueva venta en el sistema, devolviendo la venta creada.",
            tags = {"Venta"}
    )
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        try {
            Venta nuevaVenta = ventaService.save(venta);
            return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // No hay suficiente stock
        }
    }


    @GetMapping
    @Operation(
            summary = "Listar todas las ventas",
            description = "Devuelve una lista de todas las ventas disponibles en el sistema.",
            tags = {"Venta"}
    )
    public List<Venta> listarVentas() {
        return ventaService.findAll();
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener una venta por ID",
            description = "Devuelve una venta específica basada en su ID.",
            tags = {"Venta"}
    )
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Long id) {
        Venta venta = ventaService.findById(id);
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar una venta por ID",
            description = "Elimina una venta específica basada en su ID.",
            tags = {"Venta"}
    )
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        ventaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
