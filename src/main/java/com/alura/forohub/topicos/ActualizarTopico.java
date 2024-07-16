package com.alura.forohub.topicos;

public record ActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        String nombreCurso
) {
}