package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatMovimentacaoHospedagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface FatMovimentacaoHospedagemRepository extends JpaRepository<FatMovimentacaoHospedagem, Integer> {

    List<FatMovimentacaoHospedagem> findAllByCiCidadao(BigInteger ciCidadao);
}
