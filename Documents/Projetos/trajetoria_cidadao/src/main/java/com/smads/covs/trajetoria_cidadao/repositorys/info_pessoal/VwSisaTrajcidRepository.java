package com.smads.covs.trajetoria_cidadao.repositorys.info_pessoal;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.VwSisaTrajcid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface VwSisaTrajcidRepository extends JpaRepository<VwSisaTrajcid, Integer> {

    VwSisaTrajcid findAllByCiCidadao(BigInteger ciCidadao);
}
