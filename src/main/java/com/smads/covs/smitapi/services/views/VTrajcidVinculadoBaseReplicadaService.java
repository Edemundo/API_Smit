package com.smads.covs.smitapi.services.views;

import com.smads.covs.smitapi.models.views.VTrajcidVinculadoBaseReplicada;
import com.smads.covs.smitapi.repositorys.views.VTrajcidVinculadoBaseReplicadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VTrajcidVinculadoBaseReplicadaService {

  private final VTrajcidVinculadoBaseReplicadaRepository vTrajcidVinculadoBaseReplicadaRepository;
  private List<VTrajcidVinculadoBaseReplicada> Response;

  @Autowired
  public VTrajcidVinculadoBaseReplicadaService(VTrajcidVinculadoBaseReplicadaRepository vTrajcidVinculadoBaseReplicadaRepository) {
    this.vTrajcidVinculadoBaseReplicadaRepository = vTrajcidVinculadoBaseReplicadaRepository;
  }

  public List<VTrajcidVinculadoBaseReplicada> findAllByVTrajcidVinculadoBaseReplicada(BigInteger ciCidadao){
    Response = vTrajcidVinculadoBaseReplicadaRepository.findAllByCiCidadaoOrderByDtVinculacaoAsc(ciCidadao);
    return Response;
  }
}
