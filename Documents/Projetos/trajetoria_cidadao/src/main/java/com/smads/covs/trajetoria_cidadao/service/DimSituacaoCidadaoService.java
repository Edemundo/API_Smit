package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.DimSituacaoCidadao;
import com.smads.covs.trajetoria_cidadao.repository.DimSituacaoCidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DimSituacaoCidadaoService {

    private final DimSituacaoCidadaoRepository dimSituacaoCidadaoRepository;

    @Autowired
    public DimSituacaoCidadaoService(DimSituacaoCidadaoRepository dimSituacaoCidadaoRepository) {
        this.dimSituacaoCidadaoRepository = dimSituacaoCidadaoRepository;
    }

    public DimSituacaoCidadao findByCiSitCidadao(Integer ciSitCidadao){
        return dimSituacaoCidadaoRepository.findByCiSitCidadao(ciSitCidadao);
    }
}
