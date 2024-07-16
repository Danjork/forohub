package com.alura.forohub.topicos;

import java.time.LocalDateTime;

public record DetalleTopico (
        Long id,
        Long idUsuario,
        String titulo,
        String mensaje,
        String nombreCurso,
        LocalDateTime fecha
){
    public DetalleTopico(Topico topico){
        this(topico.getId(), topico.getAutorx().getId(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso(),topico.getFecha());
    }
}
