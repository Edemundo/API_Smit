package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.DimPaisOrigem;
import com.smads.covs.trajetoria_cidadao.repository.DimPaisOrigemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DimPaisOrigemService {

    private final DimPaisOrigemRepository dimPaisOrigemRepository;

    @Autowired
    public DimPaisOrigemService(DimPaisOrigemRepository dimPaisOrigemRepository) {
        this.dimPaisOrigemRepository = dimPaisOrigemRepository;
    }
    public DimPaisOrigem findCiPaisOrigem(Integer ciPaisOrigem){
        return dimPaisOrigemRepository.findByCiPaisOrigem(ciPaisOrigem);
    }
}
