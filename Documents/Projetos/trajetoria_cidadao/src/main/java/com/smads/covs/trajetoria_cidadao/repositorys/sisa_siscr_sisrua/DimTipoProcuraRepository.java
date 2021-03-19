package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.DimTipoProcura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DimTipoProcuraRepository  extends JpaRepository<DimTipoProcura, Integer> {

    List<DimTipoProcura> findAllByCiTipoProcura(Integer ciTipoProcura);
}
