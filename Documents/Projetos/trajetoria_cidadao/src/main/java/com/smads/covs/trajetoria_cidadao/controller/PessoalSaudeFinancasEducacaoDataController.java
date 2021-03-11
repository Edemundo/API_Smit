package com.smads.covs.trajetoria_cidadao.controller;

import com.smads.covs.trajetoria_cidadao.model.*;
import com.smads.covs.trajetoria_cidadao.service.*;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;



@Controller
public class PessoalSaudeFinancasEducacaoDataController {

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();
    private SimpleDateFormat formatadorDatas = new SimpleDateFormat("dd-MM-yyyy");

    private final DimRacaService dimRacaService;
    private final DimTipoSexoService dimTipoSexoService;
    private final DimPaisOrigemService dimPaisOrigemService;
    private final DimSituacaoCidadaoService dimSituacaoCidadaoService;
    private final TabPessoaCadunicoService tabPessoaCadunicoService;

    public PessoalSaudeFinancasEducacaoDataController(DimRacaService dimRacaService, DimTipoSexoService dimTipoSexoService,
                                                      DimPaisOrigemService dimPaisOrigemService, DimSituacaoCidadaoService dimSituacaoCidadaoService,
                                                      TabPessoaCadunicoService tabPessoaCadunicoService) {
        this.dimRacaService = dimRacaService;
        this.dimTipoSexoService = dimTipoSexoService;
        this.dimPaisOrigemService = dimPaisOrigemService;
        this.dimSituacaoCidadaoService = dimSituacaoCidadaoService;
        this.tabPessoaCadunicoService = tabPessoaCadunicoService;
    }

    public Map<String, Object> PSFEDataController(DimCidadao dimCidadao) throws JsonProcessingException, JSONException {

        Map<String, Object> strPersonalData = PersonalData(dimCidadao);
        Map<String, Object> strHealthData = HealthData(dimCidadao);
        //Map<String, Object> strFinantialData = FinantialData(strHealthData);
        Map<String, Object> strPSFEData = new HashMap<>(strPersonalData);
        strPSFEData.putAll(strHealthData);

        return strPSFEData;
    }

    public Map<String, Object> PersonalData(DimCidadao dimCidadao) throws JsonProcessingException, JSONException {

        String strDimCidadao = objectWriter.writeValueAsString(dimCidadao);

        DimRaca racaCidadao = findRacaCidadao(dimCidadao.getCiRacaObservada());
        String strRacaCidadao = objectWriter.writeValueAsString(racaCidadao);

        DimTipoSexo sexoCidadao = findTipoSexo(dimCidadao.getCiTipoSexo());
        String strSexoCidadao = objectWriter.writeValueAsString(sexoCidadao);

        DimPaisOrigem paisOrigem = findPaisOrigem(dimCidadao.getCiPaisOrigem());
        String strPaisOrigem = objectWriter.writeValueAsString(paisOrigem);

        Map<String, Object> mapStrDimCidadao = mapper.readValue(strDimCidadao, Map.class);
        Map<String, Object> mapStrRacaCidadao = mapper.readValue(strRacaCidadao, Map.class);
        Map<String, Object> mapStrSexoCidadao = mapper.readValue(strSexoCidadao, Map.class);
        Map<String, Object> mapStrPaisOrigem = mapper.readValue(strPaisOrigem, Map.class);
        Map<String, Object> strPersonalData = new HashMap<String, Object>(mapStrDimCidadao);
        strPersonalData.putAll(mapStrRacaCidadao);
        strPersonalData.putAll(mapStrSexoCidadao);
        strPersonalData.putAll(mapStrPaisOrigem);

        // Formatando a data para dd/mm/aaaa
        JSONObject jsonObjCidadaoDetalhado = new JSONObject(strPersonalData);
        Long resultDtNasc = jsonObjCidadaoDetalhado.getLong("dtNasc");
        Date dtResultDtNasc = new Date(resultDtNasc);
        String strDtResultDtNasc = formatadorDatas.format(dtResultDtNasc);

        // Calculando a idade
        LocalDate dtHoje = LocalDate.now();
        LocalDate ldDtNasc = dtResultDtNasc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Integer ageCidadao = Period.between(ldDtNasc, dtHoje).getYears();
        jsonObjCidadaoDetalhado.put("dtNasc", strDtResultDtNasc);
        jsonObjCidadaoDetalhado.put("ageCidadao",ageCidadao);

        strPersonalData = mapper.readValue(jsonObjCidadaoDetalhado.toString(), HashMap.class);
        return strPersonalData;
    }

    public Map<String, Object> HealthData(DimCidadao dimCidadao) throws JsonProcessingException {

        DimSituacaoCidadao dimSituacaoCidadao = findSituacaoCidadao(dimCidadao.getCiSitCidadao());
        String strSituacaoCidadao = objectWriter.writeValueAsString(dimSituacaoCidadao);

        String strCdNis = dimCidadao.getCdNis().toString();
        TabPessoaCadunico tabPessoaCadunico = findPessoaCadunico(strCdNis);
        String strTabPessoaCadunico = objectWriter.writeValueAsString(tabPessoaCadunico);

        Map<String, Object> mapStrSituacaoCidadao = mapper.readValue(strSituacaoCidadao, Map.class);
        Map<String, Object> mapStrTabPessoaCadunico = mapper.readValue(strTabPessoaCadunico, Map.class);
        Map<String, Object> strHealthData = new HashMap<String, Object>(mapStrSituacaoCidadao);
        strHealthData.putAll(mapStrTabPessoaCadunico);

        return strHealthData;
    }

    public Map<String, Object> FinantialData(String codFamiliar){

        return null;
    }

    // Todos atributos necessários já foram retornados pelo Health
//    public String EducationData(DimCidadao dimCidadao){ return null; }

    // Utilização do método findRacaCidadao
    // Controller(s) que utilizam: PessoalSaudeFinancasEducacaoDataController
    // Método que chama: PersonalData
    public DimRaca findRacaCidadao(Integer racaCidadao){
        DimRaca Response;

        Response = dimRacaService.findByCiRaca(racaCidadao);
        return Response;
    }

    // Utilização do método findTipoSexo
    // Controller(s) que utilizam: PessoalSaudeFinancasEducacaoDataController
    // Método que chama: PersonalData
    public DimTipoSexo findTipoSexo(Integer tipoSexoCidadao){
        DimTipoSexo Response;

        Response = dimTipoSexoService.findByCiTipoSexo(tipoSexoCidadao);
        return Response;
    }

    // Utilização do método findPaisOrigem
    // Controller(s) que utilizam: PessoalSaudeFinancasEducacaoDataController
    // Método que chama: PersonalData
    public DimPaisOrigem findPaisOrigem(Integer paisOrigemCidadao){
        DimPaisOrigem Response;

        Response = dimPaisOrigemService.findCiPaisOrigem(paisOrigemCidadao);
        return Response;
    }

    // Utilização do método findSituacaoCidadao
    // Controller(s) que utilizam: PessoalSaudeFinancasEducacaoDataController
    // Método que chama: HealthData
    private DimSituacaoCidadao findSituacaoCidadao(Integer ciSitCidadao) {
        DimSituacaoCidadao Response;

        Response = dimSituacaoCidadaoService.findByCiSitCidadao(ciSitCidadao);
        return Response;
    }

    // Utilização do método findSituacaoCidadao
    // Controller(s) que utilizam: PessoalSaudeFinancasEducacaoDataController
    // Método que utilizam dele: HealthData, FinantialData, EducationData
    private TabPessoaCadunico findPessoaCadunico(String cdNis){
        TabPessoaCadunico Response;

        Response = tabPessoaCadunicoService.findByNumNisPessoaAtual(cdNis);
        return Response;
    }

    private TabFamiliaCadunico findFamiliaCadunico(){
        TabFamiliaCadunico Response;

        return null;
    }
}
