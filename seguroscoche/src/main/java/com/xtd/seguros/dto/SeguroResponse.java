package com.xtd.seguros.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * Record que representa la respuesta del servicio de simulación
 * del seguro de coche.
 */
public record SeguroResponse(

        // Tipo de seguro que se devuelve (en este caso, "COCHE")
        @NotBlank(message = "El tipo de seguro no puede estar vacío")
        String tipoSeguro,

        // Prima anual calculada. Debe ser un valor positivo.
        @Positive(message = "La prima anual debe ser mayor que 0")
        double primaAnual

) {}