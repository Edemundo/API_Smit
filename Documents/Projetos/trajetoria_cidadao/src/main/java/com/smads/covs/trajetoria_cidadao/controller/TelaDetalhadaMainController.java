package com.smads.covs.trajetoria_cidadao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;

@Controller
public class TelaDetalhadaMainController {

    private PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController;
    private SISADataController sisaDataController;
    private SISCRDataController siscrDataController;
    private SISRUADataController sisruaDataController;

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();

    public TelaDetalhadaMainController(PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController/*,
                                       SISADataController sisaDataController,
                                       SISCRDataController siscrDataController,
                                       SISRUADataController sisruaDataController*/) {
        this.pessoalSaudeFinancasEducacaoDataController = pessoalSaudeFinancasEducacaoDataController;
//        this.sisaDataController = sisaDataController;
//        this.siscrDataController = siscrDataController;
//        this.sisruaDataController = sisruaDataController;
    }

    @PostMapping("/cidadao/detalhes")
    @ResponseBody
    public ResponseEntity<?> detalhesCidadao(@RequestBody DimCidadao dimCidadao) throws IOException, JSONException {

        Map<String, Object> strCidadaoDetalhado = pessoalSaudeFinancasEducacaoDataController.PSFEDataController(dimCidadao);

        // Remover o que não será utilizado no frontend
        JSONObject jsonObjStrCidadaoDetalhado = new JSONObject(strCidadaoDetalhado);

        // Dados Escolares
        jsonObjStrCidadaoDetalhado.remove("indFrequentaEscolaMemb");
        jsonObjStrCidadaoDetalhado.remove("codAnoSerieFrequentaMemb");
        jsonObjStrCidadaoDetalhado.remove("codCursoFrequentaMemb");
        jsonObjStrCidadaoDetalhado.remove("codAnoSerieFrequentouMemb");
        jsonObjStrCidadaoDetalhado.remove("codCursoFrequentouPessoaMemb");
        jsonObjStrCidadaoDetalhado.remove("nomTipLogradouroFam");

        // Dados Pessoais
        jsonObjStrCidadaoDetalhado.remove("ciCidadao");
        jsonObjStrCidadaoDetalhado.remove("ciTipoSexo");
        jsonObjStrCidadaoDetalhado.remove("ciRaca");
        jsonObjStrCidadaoDetalhado.remove("ciRacaObservada");
        jsonObjStrCidadaoDetalhado.remove("ciSitCidadao");
        jsonObjStrCidadaoDetalhado.remove("ciPaisOrigem");
        jsonObjStrCidadaoDetalhado.remove("indTrabalhoInfantilFam");
        jsonObjStrCidadaoDetalhado.remove("codPrincipalTrabMemb");

        // Endereço
        jsonObjStrCidadaoDetalhado.remove("nomLogradouroFam");
        jsonObjStrCidadaoDetalhado.remove("nomLocalidadeFam");
        jsonObjStrCidadaoDetalhado.remove("nomTituloLogradouroFam");
        jsonObjStrCidadaoDetalhado.remove("numLogradouroFam");

        return new ResponseEntity<>(strCidadaoDetalhado, HttpStatus.OK);
    }
}
