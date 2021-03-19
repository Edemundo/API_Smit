package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.DimPreAtendimentoProvidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DimPreAtendimentoProvidenciaRepository extends JpaRepository<DimPreAtendimentoProvidencia, Integer> {

    List<DimPreAtendimentoProvidencia> findAllByCiPreAtendimentoProvidencia(Integer ciPreAtendimentoProvidencia);

}
