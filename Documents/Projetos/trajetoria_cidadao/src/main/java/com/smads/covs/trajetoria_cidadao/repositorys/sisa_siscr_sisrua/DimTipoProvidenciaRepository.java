package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.DimTipoProvidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DimTipoProvidenciaRepository extends JpaRepository<DimTipoProvidencia, Integer> {

    List<DimTipoProvidencia> findAllByCiTipoProvidencia(Integer ciTipoProvidencia);

}
