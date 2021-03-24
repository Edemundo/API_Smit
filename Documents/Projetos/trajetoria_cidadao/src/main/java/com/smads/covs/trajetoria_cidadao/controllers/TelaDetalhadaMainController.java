package com.smads.covs.trajetoria_cidadao.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smads.covs.trajetoria_cidadao.models.info_pessoal.DimCidadao;

@Controller
public class TelaDetalhadaMainController {

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();

    private final PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController;

    public TelaDetalhadaMainController( PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController) {
        this.pessoalSaudeFinancasEducacaoDataController = pessoalSaudeFinancasEducacaoDataController;
    }

    @PostMapping("/cidadao/detalhes")
    @ResponseBody
    public ResponseEntity<?> detalhesCidadao(@RequestBody DimCidadao dimCidadao) throws IOException, JSONException {
        Map<String, Object> strPSFEData = pessoalSaudeFinancasEducacaoDataController.PSFEDataController(dimCidadao);

        return new ResponseEntity<>(strPSFEData, HttpStatus.OK);
    }
}
