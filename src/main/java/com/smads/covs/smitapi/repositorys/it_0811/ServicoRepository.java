package com.smads.covs.smitapi.repositorys.it_0811;

import com.smads.covs.smitapi.models.it_0811.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

  Servico findByCdServico(Integer cdServico);
}
