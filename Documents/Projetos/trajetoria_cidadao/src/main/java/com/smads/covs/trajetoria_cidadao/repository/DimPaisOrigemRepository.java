package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.DimPaisOrigem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimPaisOrigemRepository extends JpaRepository <DimPaisOrigem, Integer> {

    DimPaisOrigem findByCiPaisOrigem(Integer ciPaisOrigem);
}
