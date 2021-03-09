package com.smads.covs.trajetoria_cidadao.repository;


import com.smads.covs.trajetoria_cidadao.model.DimTipoSexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimTipoSexoRepository extends JpaRepository<DimTipoSexo, Integer> {

    DimTipoSexo findByCiTipoSexo(Integer ciTipoSexo);

}
