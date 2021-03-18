package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.repository.DimCidadaoRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DimCidadaoService {
    private final DimCidadaoRepository dimCidadaoRepository;
    private List<DimCidadao> Response;

    @Autowired
    public DimCidadaoService(DimCidadaoRepository dimCidadaoRepository) {
        this.dimCidadaoRepository = dimCidadaoRepository;
    }

    public List<DimCidadao> findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
            (BigInteger nrCpf, BigInteger cdNis, String nmCidadao, String nmMae, Date dtNasc) throws JSONException {

        if(nrCpf != null){
        System.out.println("fez com cpf");
        Response = dimCidadaoRepository.findAllByNrCpf(nrCpf);
    } else if(cdNis != null){
        System.out.println("fez com o NIS");
        Response = dimCidadaoRepository.findAllByCdNis(cdNis);
    }else if(nmCidadao != null && nmMae != null && dtNasc != null){
        Response = dimCidadaoRepository.findAllByNmCidadaoAndNmMaeAndDtNasc(nmCidadao, nmMae, dtNasc);
    } else {
            /* Retornará codigo 404 quando não encontrar pessoa */
        return Response;
    }
        return Response;
    }

}
