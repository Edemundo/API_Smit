package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.DimRaca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimRacaRepository extends JpaRepository<DimRaca, Integer> {

    DimRaca findByCiRaca(Integer ciRaca);
}
