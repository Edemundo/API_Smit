package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.DimTipoProvidencia;
import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.DimPreAtendimentoProvidenciaRepository;
import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.DimTipoProvidenciaRepository;

import java.util.List;

public class DimTipoProvidenciaService {

    private final DimTipoProvidenciaRepository dimTipoProvidenciaRepository;

    public DimTipoProvidenciaService (DimTipoProvidenciaRepository dimTipoProvidenciaRepository) {
        this.dimTipoProvidenciaRepository = dimTipoProvidenciaRepository;
    }

    public List<DimTipoProvidencia> findciTipoProvidencia(Integer ciTipoProvidencia){
        return dimTipoProvidenciaRepository.findAllByCiTipoProvidencia(ciTipoProvidencia);
    }

}
