package com.alura.forohub.topicos;

import java.time.LocalDateTime;

public record RespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado status,
        String autorx,
        String nombreCurso,
        LocalDateTime fecha
) {
}
