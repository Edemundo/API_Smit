package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.DimSituacaoCidadao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimSituacaoCidadaoRepository extends JpaRepository<DimSituacaoCidadao, Integer> {

    DimSituacaoCidadao findByCiSitCidadao(Integer ciSitCidadao);
}
