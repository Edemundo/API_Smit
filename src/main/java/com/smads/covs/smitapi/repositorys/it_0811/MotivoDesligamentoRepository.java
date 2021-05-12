package com.smads.covs.smitapi.repositorys.it_0811;

import com.smads.covs.smitapi.models.it_0811.MotivoDesligamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoDesligamentoRepository extends JpaRepository<MotivoDesligamento, Integer> {

  MotivoDesligamento findByCdMotivoDesligamento(Integer cdMotivoDesligamento);
}
