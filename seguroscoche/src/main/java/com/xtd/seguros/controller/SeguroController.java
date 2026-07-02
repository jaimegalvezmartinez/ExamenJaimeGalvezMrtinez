package com.xtd.seguros.controller;

import com.xtd.seguros.dto.SeguroRequest;
import com.xtd.seguros.dto.SeguroResponse;
import com.xtd.seguros.service.CalculoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seguros/coche")
public class SeguroController {

    private final CalculoService calculoService;

    public SeguroController(CalculoService calculoService) {
        this.calculoService = calculoService;
    }
    
    @PostMapping("/simular")
    public SeguroResponse simular(@Valid @RequestBody SeguroRequest request) {
        double prima = calculoService.calcularPrima(request);
        return new SeguroResponse("COCHE", prima);
    }

}				