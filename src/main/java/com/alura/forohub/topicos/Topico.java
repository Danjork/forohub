package com.alura.forohub.topicos;


import com.alura.forohub.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Estado status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autorx_id")
    private Usuario autorx;

    private String nombreCurso;

    public Topico(
            String titulo,
            String mensaje,
            Estado status,
            Usuario autorx,
            String nombreCurso
    ) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.autorx = autorx;
        this.nombreCurso = nombreCurso;
        this.fecha = LocalDateTime.now();

    }

    public void actualizarDatos(ActualizarTopico actualizarTopico) {
        if (actualizarTopico.titulo() != null) {
            this.titulo = actualizarTopico.titulo();
        }
        if (actualizarTopico.mensaje() != null) {
            this.mensaje = actualizarTopico.mensaje();
        }
        if (actualizarTopico.nombreCurso() != null) {
            this.nombreCurso = actualizarTopico.nombreCurso();
        }
    }
}