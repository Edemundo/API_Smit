package com.smads.covs.trajetoria_cidadao.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.smads.covs.trajetoria_cidadao.models.info_pessoal.DimCidadao;
import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatPreAtendimento;
import com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua.FatPreAtendimentoService;
import org.json.JSONException;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SISCRDataController {

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();

    private final FatPreAtendimentoService fatPreAtendimentoService;

    public SISCRDataController(FatPreAtendimentoService fatPreAtendimentoService) {
        this.fatPreAtendimentoService = fatPreAtendimentoService;
    }


    public Map<String, Object> SISCRData(DimCidadao dimCidadao) throws JsonProcessingException, JSONException{

        List<FatPreAtendimento> lstPreAtend = fatPreAtendimentoService.findFatPA(dimCidadao.getCiCidadao());

        String strPreAtendimentos = objectWriter.writeValueAsString(lstPreAtend);
        System.out.println(strPreAtendimentos);
        Map<String, Object> mapStrPreAtendimentos = mapper.readValue(strPreAtendimentos, Map.class);
        Map<String, Object> hashSISCRData = new HashMap<String, Object>(mapStrPreAtendimentos);

        return hashSISCRData;
    }
}
