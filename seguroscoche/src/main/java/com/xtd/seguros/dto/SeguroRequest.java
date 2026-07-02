package com.xtd.seguros.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record SeguroRequest(

        @Positive(message = "La edad del conductor debe ser mayor que 0")
        int edadConductor,

        @Min(value = 0, message = "La antigüedad del carnet no puede ser negativa")
        int antiguedadCarnet,

        @Positive(message = "El valor del vehículo debe ser mayor que 0")
        double valorVehiculo,

        @NotBlank(message = "El tipo de cobertura es obligatorio")
        @Pattern(
                regexp = "TERCEROS|TERCEROS_AMPLIADO|TODO_RIESGO",
                message = "El tipo de cobertura no es válido"
        )
        String tipoCobertura,

        boolean tieneGaraje

) {}