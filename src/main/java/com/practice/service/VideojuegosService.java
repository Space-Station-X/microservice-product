package com.practice.service;

import java.util.List;

import com.practice.entity.VideojuegosEntity;

public interface VideojuegosService {
    public List<VideojuegosEntity> getAllVideojuegos();
    public VideojuegosEntity getVideojuegoById(Integer id);
    public VideojuegosEntity saveVideojuego(VideojuegosEntity videojuegos);
    public VideojuegosEntity updateVideojuego(VideojuegosEntity videojuegos);
    public void deleteVideojuego(Integer id);
}
