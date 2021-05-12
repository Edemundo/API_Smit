package com.smads.covs.smitapi.services.it_0811;

import com.smads.covs.smitapi.models.it_0811.TipoServico;
import com.smads.covs.smitapi.repositorys.it_0811.TipoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoServicoService {

  private final TipoServicoRepository tipoServicoRepository;

  @Autowired
  public TipoServicoService(TipoServicoRepository tipoServicoRepository) {
    this.tipoServicoRepository = tipoServicoRepository;
  }

  public TipoServico findTipoServico(Integer cdTipoServico){
    return tipoServicoRepository.findByCdTipoServico(cdTipoServico);
  }
}
