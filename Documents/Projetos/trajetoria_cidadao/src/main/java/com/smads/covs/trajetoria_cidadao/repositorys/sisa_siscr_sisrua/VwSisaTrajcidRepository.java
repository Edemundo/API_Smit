package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.VwSisaTrajcid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface VwSisaTrajcidRepository extends JpaRepository<VwSisaTrajcid, Integer> {

    List<VwSisaTrajcid> findAllByCiCidadao(BigInteger ciCidadao);
}
