package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.repository.DimCidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

@Service
public class DimCidadaoService {
    private final DimCidadaoRepository dimCidadaoRepository;

    @Autowired
    public DimCidadaoService(DimCidadaoRepository dimCidadaoRepository) {
        this.dimCidadaoRepository = dimCidadaoRepository;
    }

    public DimCidadao findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
            (BigInteger nrCpf, BigInteger cdNis, String nmCidadao, String nmMae, Date dtNasc){

        DimCidadao Response;
        Response = dimCidadaoRepository.findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByNrCpf(nrCpf);

        if(Response != null){
            return Response;
        }
        else{
            Response = dimCidadaoRepository.findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByCdNis(cdNis);
            if(Response != null){
                return Response;
            }
            else{
                Response = dimCidadaoRepository.findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByNmCidadaoAndNmMaeAndDtNasc(nmCidadao, nmMae, dtNasc);
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
