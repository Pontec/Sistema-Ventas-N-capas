package com.codigo.msventaspro.controller;


import com.codigo.msventaspro.entities.Categoria;
import com.codigo.msventaspro.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/categorias")
@RequiredArgsConstructor
@Tag(name = "Categoria", description = "Controlador para gestionar categorías")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    @Operation(
            summary = "Crear una nueva categoría",
            description = "Crea una nueva categoría en el sistema, devolviendo la categoría creada.",
            tags = {"Categoria"}
    )
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.save(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(
            summary = "Listar todas las categorías",
            description = "Devuelve una lista de todas las categorías disponibles en el sistema.",
            tags = {"Categoria"}
    )
    public List<Categoria> listarCategorias() {
        return categoriaService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar una categoría por ID",
            description = "Elimina una categoría específica basada en su ID.",
            tags = {"Categoria"}
    )
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar una categoría por ID",
            description = "Actualiza una categoría específica basada en su ID.",
            tags = {"Categoria"}
    )
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaActualizada = categoriaService.update(id, categoria);
        return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
    }
}
