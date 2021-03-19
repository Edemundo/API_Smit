package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatPreAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface FatPreAtendimentoRepository extends JpaRepository<FatPreAtendimento, Integer> {

    List<FatPreAtendimento> findAllByCiCidadao(BigInteger ciCidadao);
}
