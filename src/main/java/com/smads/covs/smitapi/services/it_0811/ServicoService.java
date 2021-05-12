package com.smads.covs.smitapi.services.it_0811;

import com.smads.covs.smitapi.models.it_0811.Servico;
import com.smads.covs.smitapi.repositorys.it_0811.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

  private final ServicoRepository servicoRepository;

  @Autowired
  public ServicoService(ServicoRepository servicoRepository) {
    this.servicoRepository = servicoRepository;
  }

  public Servico findServico(Integer cdServico){
    return servicoRepository.findByCdServico(cdServico);
  }
}
