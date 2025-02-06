package com.practice.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "video_juegos")
public class VideojuegosEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_video_juego")
    private Integer idVideoJuego;
    @Column(name = "de_nombre")
    private String nombre;
    @Column(name = "de_descripcion")
    private String descripcion;
    @Column(name = "co_plataforma")
    private String plataforma;
    @Column(name = "de_imagen")
    private String imagen;
    @Column(name = "nu_copias")
    private int nuCopias;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fe_reg")
    private LocalDateTime feReg;
    @Column(name = "st_activo")
    private String stActivo;
    @Column(name = "im_precio_venta")
    private double imPrecioVenta;
}
