package com.smads.covs.trajetoria_cidadao.services.info_pessoal;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.VwSisaTrajcid;
import com.smads.covs.trajetoria_cidadao.repositorys.info_pessoal.VwSisaTrajcidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class VwSisaTrajcidService {

    private final VwSisaTrajcidRepository vwSisaTrajcidRepository;

    @Autowired
    public VwSisaTrajcidService(VwSisaTrajcidRepository vwPainel7ShRepository) {
        this.vwSisaTrajcidRepository = vwPainel7ShRepository;
    }

    public VwSisaTrajcid findDadosSisa(BigInteger ciCidadao){
        VwSisaTrajcid Service;
        Service = vwSisaTrajcidRepository.findAllByCiCidadao(ciCidadao);
        return Service;
    }
}
