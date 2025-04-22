package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.entities.Cliente;
import com.codigo.msventaspro.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/cliente")
@RequiredArgsConstructor
@Tag(name = "Cliente", description = "Controlador para gestionar clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Crea un nuevo cliente en el sistema, devolviendo el cliente creado con su ID asignado.",
            tags = {"Cliente"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Detalles del cliente a crear",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Cliente creado exitosamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Cliente.class)
                            )
                    )
            }
    )
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.save(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(
            summary = "Listar todos los clientes",
            description = "Devuelve una lista de todos los clientes disponibles en el sistema.",
            tags = {"Cliente"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de clientes obtenida exitosamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Cliente.class)
                            )
                    )
            }
    )
    public List<Cliente> listarClientes() {
        return clienteService.findAll();
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener un cliente por ID",
            description = "Devuelve un cliente específico basado en su ID.",
            tags = {"Cliente"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cliente encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Cliente.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cliente no encontrado"
                    )
            }
    )
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar un cliente por ID",
            description = "Elimina un cliente específico basado en su ID.",
            tags = {"Cliente"}
    )
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar un cliente",
            description = "Actualiza un cliente existente en el sistema, devolviendo el cliente actualizado.",
            tags = {"Cliente"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Detalles del cliente a actualizar",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cliente actualizado exitosamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Cliente.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cliente no encontrado"
                    )
            }
    )
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.update(id, cliente);
        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }
}
