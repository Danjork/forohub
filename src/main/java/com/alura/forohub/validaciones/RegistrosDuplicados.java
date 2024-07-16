package com.alura.forohub.validaciones;

import com.alura.forohub.topicos.CrearTopico;
import com.alura.forohub.topicos.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrosDuplicados {
    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(CrearTopico datos){
        var titulo = datos.titulo();
        var mensaje =  datos.mensaje();

        var registroDuplicado = topicoRepository.existsByTituloAndMensaje(titulo, mensaje);

        if(registroDuplicado){
            throw new ValidationException("MensajeDuplicado en este titulo");
        }
    }
}
