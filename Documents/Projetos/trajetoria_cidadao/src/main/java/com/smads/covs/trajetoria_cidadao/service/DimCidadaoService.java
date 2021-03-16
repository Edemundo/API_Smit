package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.repository.DimCidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
            (BigInteger nrCpf, BigInteger cdNis, String nmCidadao, String nmMae, Date dtNasc){

        Response = dimCidadaoRepository.findAllByNrCpf(nrCpf);
        if(Response != null){
            return Response;
        }
        else{
            Response = dimCidadaoRepository.findAllByCdNis(cdNis);
            if(Response != null){
                return Response;
            }
            else{
                Response = dimCidadaoRepository.findAllByNmCidadaoAndNmMaeAndDtNasc(nmCidadao, nmMae, dtNasc);
                if(Response != null){
                    return Response;
                }
                else{
                    return null;
                }
            }
        }
    }

}
