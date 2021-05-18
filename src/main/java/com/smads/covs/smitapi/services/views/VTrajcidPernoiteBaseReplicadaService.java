package com.smads.covs.smitapi.services.views;

import com.smads.covs.smitapi.models.views.VTrajcidPernoiteBaseReplicada;
import com.smads.covs.smitapi.repositorys.views.VTrajcidPernoiteBaseReplicadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VTrajcidPernoiteBaseReplicadaService {

  private final VTrajcidPernoiteBaseReplicadaRepository vTrajcidPernoiteBaseReplicadaRepository;
  private List<VTrajcidPernoiteBaseReplicada> Response;

  @Autowired
  public VTrajcidPernoiteBaseReplicadaService(VTrajcidPernoiteBaseReplicadaRepository vTrajcidPernoiteBaseReplicadaRepository) {
    this.vTrajcidPernoiteBaseReplicadaRepository = vTrajcidPernoiteBaseReplicadaRepository;
  }

  public List<VTrajcidPernoiteBaseReplicada> findByVTrajcidPernoiteBaseReplicada(BigInteger ciCidadao){
    Response = vTrajcidPernoiteBaseReplicadaRepository.findAllByCiCidadaoOrderByDtHospedagemDesc(ciCidadao);
    return Response;
  }
}
