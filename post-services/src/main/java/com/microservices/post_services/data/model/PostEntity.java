package com.microservices.post_services.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String contenido;
    private String tag;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeModificacion;
    private int numeroDeCometarios;

    public PostEntity(String titulo, String contenido, String tag, LocalDateTime fechaDeCreacion, LocalDateTime fechaDeModificacion, int numeroDeCometarios) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.tag = tag;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.numeroDeCometarios = numeroDeCometarios;
    }

    public PostEntity(Long id, String titulo, String contenido, String tag, LocalDateTime fechaDeCreacion, LocalDateTime fechaDeModificacion, int numeroDeCometarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.tag = tag;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.numeroDeCometarios = numeroDeCometarios;
    }

    public PostEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public LocalDateTime getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public void setFechaDeModificacion(LocalDateTime fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public int getNumeroDeCometarios() {
        return numeroDeCometarios;
    }

    public void setNumeroDeCometarios(int numeroDeCometarios) {
        this.numeroDeCometarios = numeroDeCometarios;
    }
}
