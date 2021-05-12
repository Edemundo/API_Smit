package com.smads.covs.smitapi.services.it_0811;

import com.smads.covs.smitapi.models.it_0811.MotivoDesligamento;
import com.smads.covs.smitapi.repositorys.it_0811.MotivoDesligamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotivoDesligamentoService {

private final MotivoDesligamentoRepository motivoDesligamentoRepository;

  @Autowired
  public MotivoDesligamentoService(MotivoDesligamentoRepository motivoDesligamentoRepository) {
    this.motivoDesligamentoRepository = motivoDesligamentoRepository;
  }

  public MotivoDesligamento findMotivoDesligamento(Integer cdMotivoDesligamento){
    return motivoDesligamentoRepository.findByCdMotivoDesligamento(cdMotivoDesligamento);
  }
}
