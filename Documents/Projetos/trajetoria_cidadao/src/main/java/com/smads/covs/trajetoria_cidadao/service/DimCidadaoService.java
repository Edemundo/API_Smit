package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.exception.UserNotFoundException;
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

//    public DimCidadao findDimCidadaoByNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
//            (BigInteger nrCpf, BigInteger cdNis, String nmCidadao, String nmMae, Date dtNasc){
//
//        return dimCidadaoRepository.findDimCidadaoByNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
//                (nrCpf, cdNis, nmCidadao, nmMae, dtNasc)
//                .orElseThrow(() -> new UserNotFoundException("Usuário com o CPF: " + nrCpf + " não foi encontrado"));
//    }

    public DimCidadao findDimCidadaoByNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
            (BigInteger nrCpf, BigInteger cdNis, String nmCidadao, String nmMae, Date dtNasc){

        return dimCidadaoRepository.findDimCidadaoByNrCpf(nrCpf)
                .orElse(dimCidadaoRepository.findDimCidadaoByCdNis(cdNis))
                .orElse(dimCidadaoRepository.findDimCidadaoByNmCidadaoAndNmMaeAndDtNasc(nmCidadao, nmMae, dtNasc))
                .orElseThrow(() -> new UserNotFoundException("O cidadão não foi encontrado"));
    }

}
