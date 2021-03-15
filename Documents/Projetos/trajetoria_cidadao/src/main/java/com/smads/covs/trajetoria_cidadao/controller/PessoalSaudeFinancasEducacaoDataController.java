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
    private final TabFamiliaCadunicoService tabFamiliaCadunicoService;

    public PessoalSaudeFinancasEducacaoDataController(DimRacaService dimRacaService, DimTipoSexoService dimTipoSexoService,
                                                      DimPaisOrigemService dimPaisOrigemService, DimSituacaoCidadaoService dimSituacaoCidadaoService,
                                                      TabPessoaCadunicoService tabPessoaCadunicoService, TabFamiliaCadunicoService tabFamiliaCadunicoService) {
        this.dimRacaService = dimRacaService;
        this.dimTipoSexoService = dimTipoSexoService;
        this.dimPaisOrigemService = dimPaisOrigemService;
        this.dimSituacaoCidadaoService = dimSituacaoCidadaoService;
        this.tabPessoaCadunicoService = tabPessoaCadunicoService;
        this.tabFamiliaCadunicoService = tabFamiliaCadunicoService;
    }

    public Map<String, Object> PSFEDataController(DimCidadao dimCidadao) throws JsonProcessingException, JSONException {

        Map<String, Object> strPersonalData = PersonalData(dimCidadao);
        Map<String, Object> strHealthData = HealthData(dimCidadao);
        Map<String, Object> strFinantialData = FinantialData(strHealthData);
        Map<String, Object> strPSFEData = new HashMap<>(strPersonalData);
        strPSFEData.putAll(strHealthData);
        strPSFEData.putAll(strFinantialData);

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

        JSONObject jsonObjCidadaoDetalhado = new JSONObject(strPersonalData);

        // Formatando a data para dd/mm/aaaa
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

    public Map<String, Object> HealthData(DimCidadao dimCidadao) throws JsonProcessingException, JSONException {

        DimSituacaoCidadao dimSituacaoCidadao = findSituacaoCidadao(dimCidadao.getCiSitCidadao());
        String strSituacaoCidadao = objectWriter.writeValueAsString(dimSituacaoCidadao);

        String strCdNis = dimCidadao.getCdNis().toString();
        TabPessoaCadunico tabPessoaCadunico = findPessoaCadunico(strCdNis);
        String strTabPessoaCadunico = objectWriter.writeValueAsString(tabPessoaCadunico);

        Map<String, Object> mapStrSituacaoCidadao = mapper.readValue(strSituacaoCidadao, Map.class);
        Map<String, Object> mapStrTabPessoaCadunico = mapper.readValue(strTabPessoaCadunico, Map.class);
        Map<String, Object> strHealthData = new HashMap<String, Object>(mapStrSituacaoCidadao);
        strHealthData.putAll(mapStrTabPessoaCadunico);

        JSONObject jsonObjHealthData = new JSONObject(strHealthData);

        // Calculando trabalho do cidadão
        String strCodTrabMemb = jsonObjHealthData.getString("codPrincipalTrabMemb");
        String descTrabMemb;
        if(strCodTrabMemb != null && strCodTrabMemb != "null"){
            Integer codTrabMemb = Integer.parseInt(strCodTrabMemb);

            if(codTrabMemb == 1)
                descTrabMemb = "TRABALHADOR POR CONTA PROPRIA (BICO, AUTONOMO)";
            else if(codTrabMemb == 2)
                descTrabMemb = "TRABALHADOR TEMPORARIO EM AREA RURAL";
            else if(codTrabMemb == 3)
                descTrabMemb = "EMPREGADO SEM CARTEIRA DE TRABALHO ASSINADA";
            else if(codTrabMemb == 4)
                descTrabMemb = "EMPREGADO COM CARTEIRA DE TRABALHO ASSINADA";
            else if(codTrabMemb == 5)
                descTrabMemb = "TRABALHADOR DOMESTICO SEM CARTEIRA DE TRABALHO ASSINADA";
            else if(codTrabMemb == 6)
                descTrabMemb = "TRABALHADOR DOMESTICO COM CARTEIRA DE TRABALHO ASSINADA";
            else if(codTrabMemb == 7)
                descTrabMemb = "TRABALHADOR NAO-REMUNERADO";
            else if(codTrabMemb == 8)
                descTrabMemb = "MILITAR OU SERVIDOR PUBLICO";
            else if(codTrabMemb == 9)
                descTrabMemb = "EMPREGADOR";
            else if(codTrabMemb == 10)
                descTrabMemb = "ESTAGIARIO";
            else if(codTrabMemb == 11)
                descTrabMemb = "APRENDIZ";
            else
                descTrabMemb = "DESEMPREGADO / NÃO INFORMADO";

        }
        else{
            descTrabMemb = "DESEMPREGADO / NÃO INFORMADO";
        }

        jsonObjHealthData.put("descTrabMembro", descTrabMemb);


        // Calculando se o cidadão já frequentou a escola
        String strCodFrequentaEscolaMemb = jsonObjHealthData.getString("indFrequentaEscolaMemb");
        String descFrequentaEscolaMemb;
        if(strCodFrequentaEscolaMemb != null && strCodFrequentaEscolaMemb != "null"){
                        Integer codFrequentaEscolaMemb = Integer.parseInt(strCodFrequentaEscolaMemb);
            if(codFrequentaEscolaMemb == 1)
                descFrequentaEscolaMemb = "Sim, rede pública";
            else if(codFrequentaEscolaMemb == 2)
                descFrequentaEscolaMemb = "Não, rede particular";
            else if(codFrequentaEscolaMemb == 3)
                descFrequentaEscolaMemb = "Não, já frequentou";
            else if(codFrequentaEscolaMemb == 4)
                descFrequentaEscolaMemb = "Nunca frequentou";
            else
                descFrequentaEscolaMemb = "Não informado";
        }
        else{
            descFrequentaEscolaMemb = "Não informado";
        }

        jsonObjHealthData.put("descFrequentaEscolaMemb", descFrequentaEscolaMemb);

        // Calculando o curso que frequenta o membro
        String strCodCursoFrequentaMemb = jsonObjHealthData.getString("codCursoFrequentaMemb");
        String descCursoFrequentaMemb;
        if(strCodCursoFrequentaMemb != "null" && strCodCursoFrequentaMemb != null){
            Integer codCursoFrequentaMemb = Integer.parseInt(strCodCursoFrequentaMemb);

            if(codCursoFrequentaMemb == 1)
                descCursoFrequentaMemb = "Creche";
            else if(codCursoFrequentaMemb == 2)
                descCursoFrequentaMemb = "Pré-escola (exceto CA)";
            else if(codCursoFrequentaMemb == 3)
                descCursoFrequentaMemb = "Classe de Alfabetização - CA";
            else if(codCursoFrequentaMemb == 4)
                descCursoFrequentaMemb = "Ensino Fundamental regular (duração 8 anos)";
            else if(codCursoFrequentaMemb == 5)
                descCursoFrequentaMemb = "Ensino Fundamental regular (duração 9 anos)";
            else if(codCursoFrequentaMemb == 6)
                descCursoFrequentaMemb = "Ensino Fundamental especial";
            else if(codCursoFrequentaMemb == 7)
                descCursoFrequentaMemb = "Ensino Médio regular";
            else if(codCursoFrequentaMemb == 8)
                descCursoFrequentaMemb = "Ensino Médio especial";
            else if(codCursoFrequentaMemb == 9)
                descCursoFrequentaMemb = "Ensino Fundamental EJA - séries iniciais (Supletivo - 1ª a 4ª)";
            else if(codCursoFrequentaMemb == 10)
                descCursoFrequentaMemb = "Ensino Fundamental EJA - séries finais (Supletivo - 5ª a 8ª)";
            else if(codCursoFrequentaMemb == 11)
                descCursoFrequentaMemb = "Ensino Médio EJA (Supletivo)";
            else if(codCursoFrequentaMemb == 12)
                descCursoFrequentaMemb = "Alfabetização para adultos";
            else if(codCursoFrequentaMemb == 13)
                descCursoFrequentaMemb = "Superior, Aperfeiçoamento, Especialização, Mestrado, Doutorado";
            else if(codCursoFrequentaMemb == 14)
                descCursoFrequentaMemb = "Pré-vestibular";
            else
                descCursoFrequentaMemb = "Não frequenta / Não informado";

        }
        else{
            descCursoFrequentaMemb = "Não frequenta / Não informado";
        }

        jsonObjHealthData.put("descCursoFrequentaMemb", descCursoFrequentaMemb);

        // Calculando o ano/série que frequenta
        String strCodAnoSerieFrequenta = jsonObjHealthData.getString("codAnoSerieFrequentaMemb");
        String descAnoSerieFrequenta;
        if(strCodAnoSerieFrequenta != null && strCodAnoSerieFrequenta != "null"){
            Integer codAnoSerieFrequenta = Integer.parseInt(strCodAnoSerieFrequenta);

            if(codAnoSerieFrequenta == 1)
                descAnoSerieFrequenta = "Primeiro(a)";
            else if(codAnoSerieFrequenta == 2)
                descAnoSerieFrequenta = "Segundo(a)";
            else if(codAnoSerieFrequenta == 3)
                descAnoSerieFrequenta = "Terceiro(a)";
            else if(codAnoSerieFrequenta == 4)
                descAnoSerieFrequenta = "Quarto(a)";
            else if(codAnoSerieFrequenta == 5)
                descAnoSerieFrequenta = "Quinto(a)";
            else if(codAnoSerieFrequenta == 6)
                descAnoSerieFrequenta = "Sexto(a)";
            else if(codAnoSerieFrequenta == 7)
                descAnoSerieFrequenta = "Sétimo(a)";
            else if(codAnoSerieFrequenta == 8)
                descAnoSerieFrequenta = "Oitavo(a)";
            else if(codAnoSerieFrequenta == 9)
                descAnoSerieFrequenta = "Nono(a)";
            else if(codAnoSerieFrequenta == 10)
                descAnoSerieFrequenta = "Curso não-seriado";
            else
                descAnoSerieFrequenta = "Não frequenta / Não informado";
        }
        else{
            descAnoSerieFrequenta = "Não frequenta / Não informado";
        }

        jsonObjHealthData.put("descAnoSerieFrequentaMemb", descAnoSerieFrequenta);

        // Calculando o curso que o cidadão já frequentou
        String strCodCursoFrequentou = jsonObjHealthData.getString("codCursoFrequentouPessoaMemb");
        String descCursoFrequentou;
        if(strCodCursoFrequentou != null && strCodCursoFrequentou != "null"){
            Integer codCursoFrequentou = Integer.parseInt(strCodCursoFrequentou);


            if(codCursoFrequentou == 1)
                descCursoFrequentou = "Creche";
            else if(codCursoFrequentou == 2)
                descCursoFrequentou = "Pré-escola (exceto CA)";
            else if(codCursoFrequentou == 3)
                descCursoFrequentou = "Classe de Alfabetização - CA";
            else if(codCursoFrequentou == 4)
                descCursoFrequentou = "Ensino Fundamental 1ª a 4ª séries, Elementar (Primário), Primeira fase do 1º grau";
            else if(codCursoFrequentou == 5)
                descCursoFrequentou = "Ensino Fundamental 5ª a 8ª séries, Médio 1º ciclo (Ginasial), Segunda fase do 1º grau";
            else if(codCursoFrequentou == 6)
                descCursoFrequentou = "Ensino Fundamental regular (duração 9 anos)";
            else if(codCursoFrequentou == 7)
                descCursoFrequentou = "Ensino Fundamental especial";
            else if(codCursoFrequentou == 8)
                descCursoFrequentou = "Ensino Médio, 2ºgrau, Médio 2º ciclo (Científico, Clássico, Técnico, Normal)";
            else if(codCursoFrequentou == 9)
                descCursoFrequentou = "Ensino Médio especial";
            else if(codCursoFrequentou == 10)
                descCursoFrequentou = "Ensino Fundamental EJA - séries iniciais (Supletivo - 1ª a 4ª)";
            else if(codCursoFrequentou == 11)
                descCursoFrequentou = "Ensino Fundamental EJA - séries finais (Supletivo - 5ª a 8ª)";
            else if(codCursoFrequentou == 12)
                descCursoFrequentou = "Ensino Médio EJA (Supletivo)";
            else if(codCursoFrequentou == 13)
                descCursoFrequentou = "Superior, Aperfeiçoamento, Especialização, Mestrado, Doutorado";
            else if(codCursoFrequentou == 14)
                descCursoFrequentou = "Alfabetização para Adultos (Mobral, etc.)";
            else if(codCursoFrequentou == 15)
                descCursoFrequentou = "Nenhum";
            else
                descCursoFrequentou = "Não informado";

        }
        else{
            descCursoFrequentou = "Não informado";
        }

        jsonObjHealthData.put("descCursoFrequentouPessoaMemb", descCursoFrequentou);

        // Calculando o ano/série que frequenta
        String strCodAnoSerieFrequentou = jsonObjHealthData.getString("codAnoSerieFrequentouMemb");
        String descAnoSerieFrequentou;
        if(strCodAnoSerieFrequentou != null && strCodAnoSerieFrequentou != "null"){
            Integer codAnoSerieFrequentou = Integer.parseInt(strCodAnoSerieFrequentou);

            if(codAnoSerieFrequentou == 1)
                descAnoSerieFrequentou = "Primeiro(a)";
            else if(codAnoSerieFrequentou == 2)
                descAnoSerieFrequentou = "Segundo(a)";
            else if(codAnoSerieFrequentou == 3)
                descAnoSerieFrequentou = "Terceiro(a)";
            else if(codAnoSerieFrequentou == 4)
                descAnoSerieFrequentou = "Quarto(a)";
            else if(codAnoSerieFrequentou == 5)
                descAnoSerieFrequentou = "Quinto(a)";
            else if(codAnoSerieFrequentou == 6)
                descAnoSerieFrequentou = "Sexto(a)";
            else if(codAnoSerieFrequentou == 7)
                descAnoSerieFrequentou = "Sétimo(a)";
            else if(codAnoSerieFrequentou == 8)
                descAnoSerieFrequentou = "Oitavo(a)";
            else if(codAnoSerieFrequentou == 9)
                descAnoSerieFrequentou = "Nono(a)";
            else if(codAnoSerieFrequentou == 10)
                descAnoSerieFrequentou = "Curso não-seriado";
            else
                descAnoSerieFrequentou = "Não frequentou / Não informado";
        }
        else{
            descAnoSerieFrequentou = "Não frequentou / Não informado";
        }

        // Responsável Familiar
        String strResponsavel = jsonObjHealthData.getString("codParentescoRfPessoa");
        Integer intResponsavel = Integer.parseInt(strResponsavel);
        String descResponsavel;
        if(intResponsavel == 1){
            descResponsavel = "Sim";
        }
        else{
            descResponsavel = "Não";
        }
        jsonObjHealthData.put("descResponsavel", descResponsavel);

        jsonObjHealthData.put("descAnoSerieFrequentouMemb", descAnoSerieFrequentou);
        strHealthData = mapper.readValue(jsonObjHealthData.toString(), HashMap.class);

        return strHealthData;
    }

    public Map<String, Object> FinantialData(Map<String, Object> strHealthData) throws JSONException, JsonProcessingException {

        JSONObject jsonFinantialData = new JSONObject(strHealthData);
        String codFamiliarFam = jsonFinantialData.getString("codFamiliarFam");
        TabFamiliaCadunico tabFamiliaCadunico = findFamiliaCadunico(codFamiliarFam);
        String strTabFamiliaCadunico = objectWriter.writeValueAsString(tabFamiliaCadunico);

        Map<String, Object> mapStrTabFamiliaCadunico = mapper.readValue(strTabFamiliaCadunico, Map.class);
        Map<String, Object> strFinantialData = new HashMap<String, Object>(mapStrTabFamiliaCadunico);

        jsonFinantialData = new JSONObject(strFinantialData);
        // Concatenando o endereço do cidadão
        Integer numEndereco = Integer.parseInt(jsonFinantialData.getString("numLogradouroFam").trim());
        String endTipLog = jsonFinantialData.getString("nomTipLogradouroFam").trim();
        String endNomLog = jsonFinantialData.getString("nomTituloLogradouroFam").trim();
        String endLog = jsonFinantialData.getString("nomLogradouroFam").trim();
        String endNomLoc = jsonFinantialData.getString("nomLocalidadeFam").trim();

        if(endTipLog == "null"){
            endTipLog = "";
        }
        if(endNomLog == "null"){
            endNomLog = "";
        }
        if(endLog == "null"){
            endLog = "";
        }
        if(endNomLoc == "null"){
            endNomLoc = "";
        }
        String strFullAddress = endTipLog + " "
                + endNomLog + " "
                + endLog  + ", nº"
                + numEndereco + ", "
                + endNomLoc + ", "
                + "SÃO PAULO - SP - BRASIL";
        jsonFinantialData.put("descEndereco", strFullAddress);

        // Mudando o formato da renda familiar para float
        String strVlrRendaFamiliar = jsonFinantialData.getString("vlrRendaMediaFam");
        StringBuilder stringBuilder = new StringBuilder(strVlrRendaFamiliar);
        stringBuilder.insert(strVlrRendaFamiliar.length()-2,".");
        String dotStrVlrRendaFamiliar = stringBuilder.toString();
        Float vlrRendaFamiliar = Float.parseFloat(dotStrVlrRendaFamiliar);
        jsonFinantialData.put("RendaMediaFam", vlrRendaFamiliar);

        strFinantialData = mapper.readValue(jsonFinantialData.toString(), HashMap.class);

        return strFinantialData;
    }

    // Todos atributos necessários já foram retornados pelo Health
    // public String EducationData(DimCidadao dimCidadao){ return null; }

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

    // Utilização do método findFamiliaCadunico
    // Controller(s) que utilizam: PessoalSaudeFinancasEducacaoDataController
    // Método que utilizam dele: FinantialData, PersonalData
    private TabFamiliaCadunico findFamiliaCadunico(String cdFamiliarFam){
        TabFamiliaCadunico Response;

        Response = tabFamiliaCadunicoService.findByTabFamiliaCadunico(cdFamiliarFam);
        return Response;
    }
}
