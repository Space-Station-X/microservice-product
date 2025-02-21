package com.practice.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.VideojuegosEntity;
import com.practice.service.VideojuegosService;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/videojuegos")
@Tag(name = "VideoJuegos", description = "VideoJuegos  API")
public class VideojuegosController {

    @Autowired
    private VideojuegosService videojuegosService;

    @Operation(summary = "Obtener todo los VideoJuegos", description = "Devuelve todo los VideoJuegos")
    @ApiResponse(responseCode = "200", description = "VideoJuegos obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron VideoJuegos")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VideojuegosEntity> listarVideojuegos() {
        return videojuegosService.getAllVideojuegos();
    }

    @Operation(summary = "Obtener  videojuego por ID", description = "Devuelve videojuego por ID")
    @ApiResponse(responseCode = "200", description = "Cliente obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el videojuego")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity obtenerVideojuego(@PathVariable("id") Integer id) {
        return videojuegosService.getVideojuegoById(id);
    }

    @Operation(summary = "Crear un videojuego", description = "Crea  un  videojuego")
    @ApiResponse(responseCode = "200", description = "Cliente creado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo crear el videojuego")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity guardarVideojuego(@RequestBody VideojuegosEntity videojuego) {
        return videojuegosService.saveVideojuego(videojuego);
    }

    @Operation(summary = "Actualiza un videojuego", description = "Actualiza  un videojuego por ID")
    @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo actualizar el videojuego")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity actualizarVideojuego(@PathVariable Integer id, @RequestBody VideojuegosEntity videojuego) {
        videojuego.setId(id);
        return videojuegosService.updateVideojuego(videojuego);
    }

    @Operation(summary = "Elimina un videojuego por ID", description = "Elimina un videojuego por ID")
    @ApiResponse(responseCode = "200", description = "Cliente eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el videojuego")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarVideojuego(@PathVariable Integer id) {
        videojuegosService.deleteVideojuego(id);
    }

}
