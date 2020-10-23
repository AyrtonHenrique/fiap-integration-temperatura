package com.fiap.integration.fiapintegrationmicroservice.controllers;

import java.util.ArrayList;
import java.util.List;

import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;
import com.fiap.integration.fiapintegrationmicroservice.modules.IMedicoesAppService;
import com.fiap.integration.fiapintegrationmicroservice.repositories.MedicoesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/medicoes")
public class MedicoesController {
    private IMedicoesAppService _appService;
    
    @Autowired
    private MedicoesRepository _medicoesRepository;

    public MedicoesController(IMedicoesAppService appService) {

        _appService = appService;
    }

    @GetMapping()
    public List<Medicao> get() {
        List<Medicao> aa = _medicoesRepository.findAll();
        return aa;
    }
}
