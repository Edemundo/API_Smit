package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.VwSisaTrajcid;
import com.smads.covs.trajetoria_cidadao.repository.VwSisaTrajcidRepository;
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
        System.out.println(Service);
        return Service;
    }
}
