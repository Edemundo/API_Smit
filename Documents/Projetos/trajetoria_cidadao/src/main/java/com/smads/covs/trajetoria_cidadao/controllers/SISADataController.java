package com.smads.covs.trajetoria_cidadao.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smads.covs.trajetoria_cidadao.models.info_pessoal.DimCidadao;
import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatServicoHospedagemCidadao;
import com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua.FatServicoHospedagemCidadaoService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Type;
import java.util.List;

@Controller
public class SISADataController {

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();

    private final FatServicoHospedagemCidadaoService fatServicoHospedagemCidadaoService;

    public SISADataController(FatServicoHospedagemCidadaoService fatServicoHospedagemCidadaoService) {
        this.fatServicoHospedagemCidadaoService = fatServicoHospedagemCidadaoService;
    }

    public List<FatServicoHospedagemCidadao> SISAData(DimCidadao dimCidadao) throws JsonProcessingException, JSONException {

        List<FatServicoHospedagemCidadao> sisaData = fatServicoHospedagemCidadaoService
                .findFatServicoHospedagemCidadao(dimCidadao.getCiCidadao());
        if(sisaData != null){
            return sisaData;
        }
        else{
            return null;
        }
    }
}
