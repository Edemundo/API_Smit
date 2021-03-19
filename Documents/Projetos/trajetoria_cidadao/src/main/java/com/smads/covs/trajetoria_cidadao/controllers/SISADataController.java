package com.smads.covs.trajetoria_cidadao.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.smads.covs.trajetoria_cidadao.models.info_pessoal.DimCidadao;
import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatMovimentacaoHospedagem;
import com.smads.covs.trajetoria_cidadao.services.info_pessoal.VwSisaTrajcidService;
import com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua.FatMovimentacaoHospedagemService;
import org.json.JSONException;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SISADataController {

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private ObjectMapper mapper = new ObjectMapper();

    private final VwSisaTrajcidService vwSisaTrajcidService;
    private final FatMovimentacaoHospedagemService fatMovimentacaoHospedagemService;

    public SISADataController(VwSisaTrajcidService vwPainel7ShService, FatMovimentacaoHospedagemService fatMovimentacaoHospedagemService) {
        this.vwSisaTrajcidService = vwPainel7ShService;
        this.fatMovimentacaoHospedagemService = fatMovimentacaoHospedagemService;
    }


    public Map<String, Object> SISAData(DimCidadao dimCidadao) throws JsonProcessingException, JSONException {

//        VwSisaTrajcid sisaData = vwSisaTrajcidService.findDadosSisa(dimCidadao.getCiCidadao());
//        if(sisaData != null){
//            String strSisaData = objectWriter.writeValueAsString(sisaData);
//
//            Map<String, Object> mapStrSisaData = mapper.readValue(strSisaData, Map.class);
//            Map<String, Object> hashStrSisaData = new HashMap<String, Object>(mapStrSisaData);
//
//            JSONObject jsonObjStrSisaData = new JSONObject(hashStrSisaData);
//            jsonObjStrSisaData.put("nmDistritoSisa",jsonObjStrSisaData.get("nmDistrito"));
//            jsonObjStrSisaData.put("dcTipoServicoSisa",jsonObjStrSisaData.get("dcTipoServico"));
//            jsonObjStrSisaData.put("nmSubprefeituraSisa",jsonObjStrSisaData.get("nmSubprefeitura"));
//            jsonObjStrSisaData.put("nmServicoSisa",jsonObjStrSisaData.get("nmServico"));
//            jsonObjStrSisaData.put("dcMotivoProcuraSisa",jsonObjStrSisaData.get("dcMotivoProcura"));
//            jsonObjStrSisaData.put("dcMotivoDesligamentoSisa",jsonObjStrSisaData.get("dcMotivoDesligamento"));
//            jsonObjStrSisaData.put("dtDesligamentoSisa",jsonObjStrSisaData.get("dtDesligamento"));
//            jsonObjStrSisaData.put("tempoVinculacaoSisa",jsonObjStrSisaData.get("tempoVinculacao"));
//            jsonObjStrSisaData.put("dtVinculacaoSisa",jsonObjStrSisaData.get("dtVinculacao"));
//
//            jsonObjStrSisaData.remove("nmDistrito");
//            jsonObjStrSisaData.remove("dcTipoServico");
//            jsonObjStrSisaData.remove("nmSubprefeitura");
//            jsonObjStrSisaData.remove("nmServico");
//            jsonObjStrSisaData.remove("dcMotivoProcura");
//            jsonObjStrSisaData.remove("dcMotivoDesligamento");
//            jsonObjStrSisaData.remove("dtDesligamento");
//            jsonObjStrSisaData.remove("tempoVinculacao");
//            jsonObjStrSisaData.remove("dtVinculacao");
//            jsonObjStrSisaData.remove("id");
//
//            hashStrSisaData = mapper.readValue(jsonObjStrSisaData.toString(), HashMap.class);
//            return hashStrSisaData;
//        }
//        else{
//            return null;
//        }

        // Cidadao não vinculado:
        List<FatMovimentacaoHospedagem> movimentacaoHospedagens = fatMovimentacaoHospedagemService.findMovHosp(dimCidadao.getCiCidadao());
        String strMovimentacaoHospedagens = objectWriter.writeValueAsString(movimentacaoHospedagens);
        System.out.println(strMovimentacaoHospedagens);
        Map<String, Object> mapStrMovimentacaoHospedagens = mapper.readValue(strMovimentacaoHospedagens, Map.class);
        Map<String, Object> hashMovimentacaoHospedagens = new HashMap<String, Object>(mapStrMovimentacaoHospedagens);

        return hashMovimentacaoHospedagens;

    }
}
