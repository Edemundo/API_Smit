package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.VwSisaTrajcid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface VwSisaTrajcidRepository extends JpaRepository<VwSisaTrajcid, Integer> {

    VwSisaTrajcid findAllByCiCidadao(BigInteger ciCidadao);
}
