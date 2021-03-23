package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatServicoHospedagemCidadao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface FatServicoHospedagemCidadaoRepository
        extends JpaRepository<FatServicoHospedagemCidadao, Integer> {

    List<FatServicoHospedagemCidadao> findAllByCiCidadao(BigInteger ciCidadao);
}
