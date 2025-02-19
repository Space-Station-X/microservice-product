package com.practice.service;

import java.util.List;

import com.practice.entity.VideojuegosEntity;

public interface VideojuegosService {
    List<VideojuegosEntity> getAllVideojuegos();
    VideojuegosEntity getVideojuegoById(Integer id);
    VideojuegosEntity saveVideojuego(VideojuegosEntity videojuegos);
    VideojuegosEntity updateVideojuego(VideojuegosEntity videojuegos);
    void deleteVideojuego(Integer id);
}
