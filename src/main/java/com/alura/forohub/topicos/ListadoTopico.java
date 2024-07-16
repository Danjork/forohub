package com.alura.forohub.topicos;

import com.alura.forohub.usuarios.Usuario;
import java.time.LocalDateTime;

public record ListadoTopico (
        Long id,
        String titulo,
        String mensaje,
        Estado status,
        String autorx,
        String nombreCurso,
        LocalDateTime fecha){
    public ListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getStatus(),topico.getAutorx().getUsername(),topico.getNombreCurso(),topico.getFecha());
    }
}

