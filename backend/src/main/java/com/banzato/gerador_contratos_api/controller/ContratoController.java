package com.banzato.gerador_contratos_api.controller;

import com.banzato.gerador_contratos_api.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    @Autowired
    private ContratoService service;

    @PostMapping("/gerar")
    public String gerar(@RequestBody Map<String, String> dados) {
        return service.gerarContrato(dados);
    }
}