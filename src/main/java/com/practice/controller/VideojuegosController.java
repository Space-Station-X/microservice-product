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

    @GetMapping(value = "/{idVideoJuego}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity obtenerVideojuego(@PathVariable("idVideoJuego") Integer idVideoJuego) {
        return videojuegosService.getVideojuegoById(idVideoJuego);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity guardarVideojuego(@RequestBody VideojuegosEntity videojuego) {
        return videojuegosService.saveVideojuego(videojuego);
    }
    
    @PutMapping(value = "/{idVideoJuego}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VideojuegosEntity actualizarVideojuego(@PathVariable Integer idVideoJuego, @RequestBody VideojuegosEntity videojuego) {
        videojuego.setIdVideoJuego(idVideoJuego);
        return videojuegosService.updateVideojuego(videojuego);
    }

    @DeleteMapping(value = "/{idVideoJuego}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarVideojuego(@PathVariable Integer idVideoJuego) {
        videojuegosService.deleteVideojuego(idVideoJuego);
        }

}
