package com.smads.covs.smitapi.services.it_0811;

import com.smads.covs.smitapi.models.it_0811.MotivoProcura;
import com.smads.covs.smitapi.repositorys.it_0811.MotivoProcuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotivoProcuraService {

  private final MotivoProcuraRepository motivoProcuraRepository;

  @Autowired
  public MotivoProcuraService(MotivoProcuraRepository motivoProcuraRepository) {
    this.motivoProcuraRepository = motivoProcuraRepository;
  }

  public MotivoProcura findMotivoProcura(Integer cdMotivoProcura){
    return motivoProcuraRepository.findByCdMotivoProcura(cdMotivoProcura);
  }
}
