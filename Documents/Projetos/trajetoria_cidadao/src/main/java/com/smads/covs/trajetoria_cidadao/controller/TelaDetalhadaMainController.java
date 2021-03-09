package com.smads.covs.trajetoria_cidadao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import com.smads.covs.trajetoria_cidadao.model.DimPaisOrigem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.model.DimRaca;
import com.smads.covs.trajetoria_cidadao.model.DimTipoSexo;

@Controller
public class TelaDetalhadaMainController {

    private PersonalDataController personalDataController;
    private SISADataController sisaDataController;
    private SISCRDataController siscrDataController;
    private SISRUADataController sisruaDataController;

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    public TelaDetalhadaMainController(PersonalDataController personalDataController/*,
                                       SISADataController sisaDataController,
                                       SISCRDataController siscrDataController,
                                       SISRUADataController sisruaDataController*/) {
        this.personalDataController = personalDataController;
//        this.sisaDataController = sisaDataController;
//        this.siscrDataController = siscrDataController;
//        this.sisruaDataController = sisruaDataController;
    }

    @PostMapping("/cidadao/detalhes")
    @ResponseBody
    public ResponseEntity<?> detalhesCidadao(@RequestBody DimCidadao dimCidadao) throws JsonProcessingException {

        String strDimCidadao = objectWriter.writeValueAsString(dimCidadao);

        DimRaca racaCidadao = personalDataController.findRacaCidadao(dimCidadao.getCiRacaObservada());
        String strRacaCidadao = objectWriter.writeValueAsString(racaCidadao);

        DimTipoSexo sexoCidadao = personalDataController.findTipoSexo(dimCidadao.getCiTipoSexo());
        String strSexoCidadao = objectWriter.writeValueAsString(sexoCidadao);

        DimPaisOrigem paisOrigem = personalDataController.findPaisOrigem((dimCidadao.getCiPaisOrigem()));
        String strPaisOrigem = objectWriter.writeValueAsString(paisOrigem);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapStrDimCidadao = mapper.readValue(strDimCidadao, Map.class);
        Map<String, Object> mapStrRacaCidadao = mapper.readValue(strRacaCidadao, Map.class);
        Map<String, Object> mapStrSexoCidadao = mapper.readValue(strSexoCidadao, Map.class);
        Map<String, Object> mapStrPaisOrigem = mapper.readValue(strPaisOrigem, Map.class);
        Map<String, Object> strCidadaoDetalhado = new HashMap<String, Object>(mapStrDimCidadao);
        strCidadaoDetalhado.putAll(mapStrRacaCidadao);
        strCidadaoDetalhado.putAll(mapStrSexoCidadao);
        strCidadaoDetalhado.putAll(mapStrPaisOrigem);
        System.out.println(mapper.writeValueAsString(strCidadaoDetalhado));

        return new ResponseEntity<>(strCidadaoDetalhado, HttpStatus.OK);
    }
}
