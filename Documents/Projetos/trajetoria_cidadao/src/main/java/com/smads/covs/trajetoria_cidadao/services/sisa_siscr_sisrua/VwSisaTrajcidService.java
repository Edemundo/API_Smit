package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.VwSisaTrajcid;
import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.VwSisaTrajcidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VwSisaTrajcidService {

    private final VwSisaTrajcidRepository vwSisaTrajcidRepository;

    @Autowired
    public VwSisaTrajcidService(VwSisaTrajcidRepository vwPainel7ShRepository) {
        this.vwSisaTrajcidRepository = vwPainel7ShRepository;
    }

    public List<VwSisaTrajcid> findDadosSisa(BigInteger ciCidadao){
        List<VwSisaTrajcid> Service;
        Service = vwSisaTrajcidRepository.findAllByCiCidadao(ciCidadao);
        return Service;
    }
}
