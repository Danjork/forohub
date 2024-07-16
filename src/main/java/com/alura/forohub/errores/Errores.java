package com.alura.forohub.errores;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.validation.FieldError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Errores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().
                map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidandoIntegridad.class)
    public ResponseEntity errorHandlerValidandoIntegridad(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity errorHandlerValidacionesDelNegocio(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
