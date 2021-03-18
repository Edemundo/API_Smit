package com.smads.covs.trajetoria_cidadao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.model.VwSisaTrajcid;
import com.smads.covs.trajetoria_cidadao.service.VwSisaTrajcidService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SISADataController {

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();

    private final VwSisaTrajcidService vwSisaTrajcidService;

    public SISADataController(VwSisaTrajcidService vwPainel7ShService) {
        this.vwSisaTrajcidService = vwPainel7ShService;
    }


    public Map<String, Object> SISAData(DimCidadao dimCidadao) throws JsonProcessingException {


        VwSisaTrajcid sisaData = vwSisaTrajcidService.findDadosSisa(dimCidadao.getCiCidadao());
        if(sisaData != null){
            String strSisaData = objectWriter.writeValueAsString(sisaData);

            Map<String, Object> mapStrSisaData = mapper.readValue(strSisaData, Map.class);
            Map<String, Object> hashStrSisaData = new HashMap<String, Object>(mapStrSisaData);

            JSONObject jsonObjStrSisaData = new JSONObject(hashStrSisaData);
            jsonObjStrSisaData.remove("id");

            hashStrSisaData = mapper.readValue(jsonObjStrSisaData.toString(), HashMap.class);
            return hashStrSisaData;
        }
        else{
            return null;
        }

    }
}
