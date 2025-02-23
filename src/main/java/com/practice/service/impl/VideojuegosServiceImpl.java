package com.practice.service.impl;

import java.util.List;

import com.practice.exceptions.VideoJuegoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.VideojuegosEntity;
import com.practice.repository.VideojuegosRepository;
import com.practice.service.VideojuegosService;

@Service
public class VideojuegosServiceImpl implements VideojuegosService {

    @Autowired
    private VideojuegosRepository videojuegosRepository;


    @Override
    public List<VideojuegosEntity> getAllVideojuegos() {
        return videojuegosRepository.findAll();
    }

    @Override
    public VideojuegosEntity getVideojuegoById(Integer id) {
        return videojuegosRepository.findById(id).orElseThrow(() -> new VideoJuegoNotFoundException("Video Juego con id :" + id + "no encontrado"));
    }

    @Override
    public VideojuegosEntity saveVideojuego(VideojuegosEntity videojuegos) {
        return videojuegosRepository.save(videojuegos);
    }

    @Override
    public VideojuegosEntity updateVideojuego(VideojuegosEntity videojuegos) {
        return videojuegosRepository.save(videojuegos);
    }

    @Override
    public void deleteVideojuego(Integer id) {
        videojuegosRepository.deleteById(id);
    }

}
