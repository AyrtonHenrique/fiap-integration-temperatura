package com.fiap.integration.fiapintegrationmicroservice.controllers;

import com.fiap.integration.fiapintegrationmicroservice.modules.IMedicoesAppService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/medicoes")
public class MedicoesController {
    private IMedicoesAppService _appService;

    public MedicoesController(IMedicoesAppService appService) {

        _appService = appService;
    }

    @GetMapping()
    public String get() {
        // _appService.AtualizarMedicoes();
        return "ola mundoaaaaaaaaaaaaaaaaa";
    }
}
