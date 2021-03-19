package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.DimPreAtendimentoProvidencia;
import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.DimPreAtendimentoProvidenciaRepository;

import java.util.List;

public class DimPreAtendimentoProvidenciaService {

    private final DimPreAtendimentoProvidenciaRepository dimPreAtendimentoProvidenciaRepository;

    public DimPreAtendimentoProvidenciaService (DimPreAtendimentoProvidenciaRepository dimPreAtendimentoProvidenciaRepository) {
        this.dimPreAtendimentoProvidenciaRepository = dimPreAtendimentoProvidenciaRepository;
    }

    public List<DimPreAtendimentoProvidencia> findPreAtendimentoProvidencia(Integer ciPreAtendimentoProvidencia){
        return dimPreAtendimentoProvidenciaRepository.findAllByCiPreAtendimentoProvidencia(ciPreAtendimentoProvidencia);
    }


}
