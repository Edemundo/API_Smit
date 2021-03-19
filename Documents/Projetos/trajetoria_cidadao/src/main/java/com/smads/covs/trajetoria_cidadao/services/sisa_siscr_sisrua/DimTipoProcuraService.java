package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.DimTipoProcuraRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DimTipoProcuraService {

    private final DimTipoProcuraRepository dimTipoProcuraRepository;

    @Autowired
    public DimTipoProcuraService(DimTipoProcuraRepository dimTipoProcuraRepository) {
        this.dimTipoProcuraRepository = dimTipoProcuraRepository;
    }
}
