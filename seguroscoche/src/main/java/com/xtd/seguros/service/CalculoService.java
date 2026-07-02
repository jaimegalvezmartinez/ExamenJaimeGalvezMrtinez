package com.xtd.seguros.service;

import com.xtd.seguros.dto.SeguroRequest;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de calcular la prima anual
 * de un seguro de coche.
 */
@Service
public class CalculoService {

    /**
     * Calcula la prima anual del seguro según las
     * reglas establecidas en el enunciado.
     *
     * @param request Datos del conductor y del vehículo.
     * @return Prima anual calculada.
     */
    public double calcularPrima(SeguroRequest request) {

        // Prima base
        double prima = 300.0;

        // ==========================
        // Edad del conductor
        // ==========================

        // Menor de 25 años: +150 €
        if (request.edadConductor() < 25) {
            prima += 150;
        }
        // Mayor de 65 años: +100 €
        else if (request.edadConductor() > 65) {
            prima += 100;
        }
        // Entre 25 y 65 años no se modifica la prima.

        // ==========================
        // Antigüedad del carnet
        // ==========================

        // Menos de 2 años: +200 €
        if (request.antiguedadCarnet() < 2) {
            prima += 200;
        }
        // Entre 2 y 9 años: +50 €
        else if (request.antiguedadCarnet() >= 2 && request.antiguedadCarnet() < 10) {
            prima += 50;
        }
        // Con 10 años o más no se suma nada.

        // ==========================
        // Valor del vehículo
        // ==========================

        // Se añade el 2 % del valor del vehículo.
        prima += request.valorVehiculo() * 0.02;

        // ==========================
        // Tipo de cobertura
        // ==========================

        switch (request.tipoCobertura()) {

            case "TERCEROS":
                break;

            case "TERCEROS_AMPLIADO":
                prima += 150;
                break;

            case "TODO_RIESGO":
                prima += 400;
                break;

            default:
                throw new IllegalArgumentException("Tipo de cobertura no válido.");
        }

        // ==========================
        // Descuento por garaje
        // ==========================

        // Si el vehículo duerme en garaje,
        // se aplica un descuento del 10 %.
        if (request.tieneGaraje()) {
            prima -= prima * 0.10;
        }

        // Se devuelve la prima final.
        return prima;
    }
}