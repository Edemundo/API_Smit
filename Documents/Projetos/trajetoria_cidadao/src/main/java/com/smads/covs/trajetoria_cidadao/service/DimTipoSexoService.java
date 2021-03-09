package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.DimTipoSexo;
import com.smads.covs.trajetoria_cidadao.repository.DimTipoSexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DimTipoSexoService {

    private final DimTipoSexoRepository dimTipoSexoRepository;

    @Autowired
    public DimTipoSexoService(DimTipoSexoRepository dimTipoSexoRepository) {
        this.dimTipoSexoRepository = dimTipoSexoRepository;
    }

    public DimTipoSexo findByCiTipoSexo(Integer ciTipoSexo){

        return dimTipoSexoRepository.findByCiTipoSexo(ciTipoSexo);
    }
}
