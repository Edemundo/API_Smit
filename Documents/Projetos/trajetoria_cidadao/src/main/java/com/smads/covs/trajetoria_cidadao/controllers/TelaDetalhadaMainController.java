package com.smads.covs.trajetoria_cidadao.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


import com.smads.covs.trajetoria_cidadao.models.json_formatter.DataReturn;
import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.VwSisaTrajcid;
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

    private PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController;
    private SISADataController sisaDataController;
    private SISCRDataController siscrDataController;
//    private SISRUADataController sisruaDataController;

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();

    public TelaDetalhadaMainController(PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController,
                                       SISADataController sisaDataController,
                                       SISCRDataController siscrDataController/*,
                                       SISRUADataController sisruaDataController*/) {
        this.pessoalSaudeFinancasEducacaoDataController = pessoalSaudeFinancasEducacaoDataController;
        this.sisaDataController = sisaDataController;
        this.siscrDataController = siscrDataController;
//        this.sisruaDataController = sisruaDataController;
    }

    @PostMapping("/cidadao/detalhes")
    @ResponseBody
    public ResponseEntity<DataReturn> detalhesCidadao(@RequestBody DimCidadao dimCidadao) throws IOException, JSONException {
//        Map<String, Object> strPSFEData = pessoalSaudeFinancasEducacaoDataController.PSFEDataController(dimCidadao);
        Map<String, Object> strCidadaoDetalhado = new HashMap<>(/*strPSFEData*/);

        List<VwSisaTrajcid> strSisaData = sisaDataController.SISAData(dimCidadao);
//        if(strSisaData != null){
//            strCidadaoDetalhado.putAll(strSisaData);
//        }
//        Map<String, Object> strSiscrData = siscrDataController.SISCRData(dimCidadao);
//        strCidadaoDetalhado.putAll(strSiscrData);

        DataReturn dataReturn = new DataReturn();

        return new ResponseEntity<DataReturn>(dataReturn, HttpStatus.OK);
    }
}
