package com.alura.forohub.topicos;

import com.alura.forohub.errores.ValidandoIntegridad;
import com.alura.forohub.usuarios.UsuarioRepository;
import com.alura.forohub.usuarios.Usuario;
import com.alura.forohub.validaciones.ValidacionDeTopicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudTopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    List<ValidacionDeTopicos> validadores;

    public DetalleTopico crear(CrearTopico datos) {
        if (datos.idUsuario() != null && !usuarioRepository.existsById(datos.idUsuario())) {
            throw new ValidandoIntegridad("Id de usuario no encontrado");
        }
        validadores.forEach(v -> v.validar(datos));
        var usuario = usuarioRepository.findById(datos.idUsuario()).get();
        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                usuario,
                datos.nombreCurso()
        );
        topicoRepository.save(topico);
        return new DetalleTopico(topico);
    }
}
