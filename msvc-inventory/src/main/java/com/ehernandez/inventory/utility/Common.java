package com.ehernandez.inventory.utility;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class Common {

    /**
     * En ambientes mas estructurados, esta funcion debería ir en una clase aparte para reutilizarla
     * @param result
     * @return
     */
    public static ResponseEntity<?> validates(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), /*"El campo " + err.getField() + " " +*/ err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
