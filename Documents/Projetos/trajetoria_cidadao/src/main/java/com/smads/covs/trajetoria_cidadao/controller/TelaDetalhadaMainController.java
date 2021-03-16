package com.smads.covs.trajetoria_cidadao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


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

    public TelaDetalhadaMainController(PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController,
                                       SISADataController sisaDataController/*,
                                       SISCRDataController siscrDataController,
                                       SISRUADataController sisruaDataController*/) {
        this.pessoalSaudeFinancasEducacaoDataController = pessoalSaudeFinancasEducacaoDataController;
        this.sisaDataController = sisaDataController;
//        this.siscrDataController = siscrDataController;
//        this.sisruaDataController = sisruaDataController;
    }

    @PostMapping("/cidadao/detalhes")
    @ResponseBody
    public ResponseEntity<?> detalhesCidadao(@RequestBody DimCidadao dimCidadao) throws IOException, JSONException {
        Map<String, Object> strPSFEData = pessoalSaudeFinancasEducacaoDataController.PSFEDataController(dimCidadao);
        // Remover o que não será utilizado no frontend
        JSONObject jsonObjStrPSFEData = new JSONObject(strPSFEData);
        // Dados Escolares
        jsonObjStrPSFEData.remove("indFrequentaEscolaMemb");
        jsonObjStrPSFEData.remove("codAnoSerieFrequentaMemb");
        jsonObjStrPSFEData.remove("codCursoFrequentaMemb");
        jsonObjStrPSFEData.remove("codAnoSerieFrequentouMemb");
        jsonObjStrPSFEData.remove("codCursoFrequentouPessoaMemb");
        jsonObjStrPSFEData.remove("nomTipLogradouroFam");
        // Dados Pessoais
        jsonObjStrPSFEData.remove("ciCidadao");
        jsonObjStrPSFEData.remove("ciTipoSexo");
        jsonObjStrPSFEData.remove("ciRaca");
        jsonObjStrPSFEData.remove("ciRacaObservada");
        jsonObjStrPSFEData.remove("ciSitCidadao");
        jsonObjStrPSFEData.remove("ciPaisOrigem");
        jsonObjStrPSFEData.remove("indTrabalhoInfantilFam");
        jsonObjStrPSFEData.remove("codPrincipalTrabMemb");
        jsonObjStrPSFEData.remove("codParentescoRfPessoa");
        // Endereço
        jsonObjStrPSFEData.remove("nomLogradouroFam");
        jsonObjStrPSFEData.remove("nomLocalidadeFam");
        jsonObjStrPSFEData.remove("nomTituloLogradouroFam");
        jsonObjStrPSFEData.remove("numLogradouroFam");
        strPSFEData = mapper.readValue(jsonObjStrPSFEData.toString(), HashMap.class);

        Map<String, Object> strSisaData = sisaDataController.SISAData(dimCidadao);

        Map<String, Object> strCidadaoDetalhado = new HashMap<>(strPSFEData);
        strCidadaoDetalhado.putAll(strSisaData);

        return new ResponseEntity<>(strCidadaoDetalhado, HttpStatus.OK);
    }
}
