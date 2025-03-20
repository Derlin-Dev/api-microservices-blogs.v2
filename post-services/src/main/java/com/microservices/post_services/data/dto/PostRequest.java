package com.microservices.post_services.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


public class PostRequest {
    private String titulo;
    private String contenido;
    private String tag;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeModificacion;
    private int numeroDeCometarios;

    public PostRequest(String titulo, String contenido, String tag, LocalDateTime fechaDeCreacion, LocalDateTime fechaDeModificacion, int numeroDeCometarios) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.tag = tag;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.numeroDeCometarios = numeroDeCometarios;
    }

    public PostRequest(){}

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
