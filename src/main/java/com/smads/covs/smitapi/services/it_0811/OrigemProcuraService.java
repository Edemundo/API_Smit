package com.smads.covs.smitapi.services.it_0811;

import com.smads.covs.smitapi.models.it_0811.OrigemProcura;
import com.smads.covs.smitapi.repositorys.it_0811.OrigemProcuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrigemProcuraService {

  private final OrigemProcuraRepository origemProcuraRepository;

  @Autowired
  public OrigemProcuraService(OrigemProcuraRepository origemProcuraRepository) {
    this.origemProcuraRepository = origemProcuraRepository;
  }

  public OrigemProcura findOrigemProcura(Integer cdOrigemProcura){
    return origemProcuraRepository.findByCdOrigemProcura(cdOrigemProcura);
  }
}
