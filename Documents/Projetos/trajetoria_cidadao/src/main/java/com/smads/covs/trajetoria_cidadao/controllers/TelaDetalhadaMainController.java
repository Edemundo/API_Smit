package com.smads.covs.trajetoria_cidadao.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatServicoHospedagemCidadao;
import com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua.FatServicoHospedagemCidadaoService;
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

    private final SISADataController sisaDataController;
    private final FatServicoHospedagemCidadaoService fatServicoHospedagemCidadaoService;
    //private PessoalSaudeFinancasEducacaoDataController pessoalSaudeFinancasEducacaoDataController;

    public TelaDetalhadaMainController(SISADataController sisaDataController, FatServicoHospedagemCidadaoService fatServicoHospedagemCidadaoService) {
        this.sisaDataController = sisaDataController;
        this.fatServicoHospedagemCidadaoService = fatServicoHospedagemCidadaoService;
    }


    @PostMapping("/cidadao/detalhes")
    @ResponseBody
    public ResponseEntity<List<FatServicoHospedagemCidadao>> detalhesCidadao(@RequestBody DimCidadao dimCidadao) throws IOException, JSONException {
//        Map<String, Object> strPSFEData = pessoalSaudeFinancasEducacaoDataController.PSFEDataController(dimCidadao);
        Map<String, Object> strCidadaoDetalhado = new HashMap<>(/*strPSFEData*/);

        //List<> strSisaData = sisaDataController.SISAData(dimCidadao);
//        if(strSisaData != null){
//            strCidadaoDetalhado.putAll((Map<? extends String, ?>) strSisaData);
//        }

        List<FatServicoHospedagemCidadao> sisaData = sisaDataController.SISAData(dimCidadao);
        return new ResponseEntity<>(sisaData, HttpStatus.OK);
    }
}
