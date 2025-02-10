package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.VideojuegosEntity;
import com.practice.service.VideojuegosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideojuegosController {

    @Autowired
    private VideojuegosService videojuegosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VideojuegosEntity> listarVideojuegos() {
        return videojuegosService.getAllVideojuegos();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity obtenerVideojuego(@PathVariable("id") Integer id) {
        return videojuegosService.getVideojuegoById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity guardarVideojuego(@RequestBody VideojuegosEntity videojuego) {
        return videojuegosService.saveVideojuego(videojuego);
    }
    
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity actualizarVideojuego(@PathVariable Integer id, @RequestBody VideojuegosEntity videojuego) {
        videojuego.setId(id);
        return videojuegosService.updateVideojuego(videojuego);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarVideojuego(@PathVariable Integer id) {
        videojuegosService.deleteVideojuego(id);
        }

}
