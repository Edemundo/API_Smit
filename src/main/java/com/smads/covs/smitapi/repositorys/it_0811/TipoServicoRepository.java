package com.smads.covs.smitapi.repositorys.it_0811;

import com.smads.covs.smitapi.models.it_0811.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Integer> {

  TipoServico findByCdTipoServico(Integer cdTipoServico);
}
